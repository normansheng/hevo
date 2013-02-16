package com.hevo.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.auth.GoogleAuthUtil;

import android.accounts.Account;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.herevoice.*;
import com.google.api.services.herevoice.model.*;
import com.hevo.app.VoiceContent.VoiceItem;



/**
 * An activity representing a list of voices. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link VoiceDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link VoiceListFragment} and the item details (if present) is a
 * {@link VoiceDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link VoiceListFragment.Callbacks} interface to listen for item selections.
 */
public class VoiceListActivity extends FragmentActivity implements
		VoiceListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;
	private EditText sendText;
	private Button sendButton;
	private ImageButton refreshButton;
	private VoiceApplication va;
	private TextView addressText;
	private Geocoder geocoder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		va = (VoiceApplication)getApplication();
		geocoder = new Geocoder(this);
		setContentView(R.layout.activity_voice_list);
		
		login();
		initGPSTracker();
		
		if (findViewById(R.id.voice_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((VoiceListFragment) getSupportFragmentManager().findFragmentById(
					R.id.voice_list)).setActivateOnItemClick(true);
		}
		sendText = (EditText) findViewById(R.id.sendText);
		addressText = (TextView)findViewById(R.id.addressText);
		sendButton = (Button) findViewById(R.id.sendButton);
		sendButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Create a new HttpClient and Post Header
				GPSTracker gps = va.getGPSTracker();
				if(gps.canGetLocation()){
					MakeVoiceTask makevoice = new MakeVoiceTask();
					makevoice.execute(sendText.getText().toString());
					sendText.getText().clear();
					
					InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE); 
					inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                       InputMethodManager.HIDE_NOT_ALWAYS);
				}
				
			}
		});
		
		refreshButton = (ImageButton) findViewById(R.id.refreshButton);
		refreshButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Create a new HttpClient and Post Header
				ListVoiceTask lvt = new ListVoiceTask();
				lvt.execute();
			}
		});
	}

	public VoiceAdapter listAdapter; 
	@Override
	public void onAttachVoiceListFragment(VoiceListFragment fragment) {
		// TODO Auto-generated method stub
		va.setVoiceList(new ArrayList<Voice>());
		this.listAdapter = new VoiceAdapter(this,R.layout.voice_item ,va.getVoiceList());
		fragment.setListAdapter(this.listAdapter);
	}
	
	@Override
	public void onVoiceListFragmentCreated(VoiceListFragment fragment) {
		// TODO Auto-generated method stub
		fragment.getListView().setStackFromBottom(true);
		fragment.getListView().setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
	}
	
	/**
	 * Callback method from {@link VoiceListFragment.Callbacks} indicating that
	 * the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(VoiceDetailFragment.ARG_ITEM_ID, id);
			VoiceDetailFragment fragment = new VoiceDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.voice_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			//Log.d("","voiceid:" + id);
			Intent detailIntent = new Intent(this, VoiceDetailActivity.class);
			detailIntent.putExtra("voiceID", id);
			startActivity(detailIntent);
		}
	}
	
	private void initGPSTracker(){
		GPSTracker gps = new GPSTracker(VoiceListActivity.this);
		gps = va.setGPSTracker(gps);
		// check if GPS enabled
		if(gps.canGetLocation()){
			Location location = gps.getLocation();
			ListVoiceTask lvt = new ListVoiceTask();
			lvt.execute();

		}else{
			gps.showSettingsAlert();
		}
	}
	
	private void login(){
		int connectionStatusCode =
            GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        System.out.println("google play status " + connectionStatusCode);
       // SharedPreferences settings = getSharedPreferences("herevoice", 0);
        GoogleAccountCredential credential = GoogleAccountCredential.usingAudience(this,
        "server:client_id:204072562742-e99p8bekv527gvrm7iqks7qsb2d34ibv.apps.googleusercontent.com");
        credential = va.setGoogleAccountCredential(credential);
        Account acc = credential.getAllAccounts()[0];
        credential.setSelectedAccountName(acc.name);
        System.out.println("selected account name: " + credential.getSelectedAccountName());
        //setAccountName(settings.getString(PREF_ACCOUNT_NAME, null));
	}
	
	private class ListVoiceTask extends AsyncTask<Void,VoiceCollection,VoiceCollection> {
		
		protected VoiceCollection doInBackground(Void...params) {
			GPSTracker gps = va.getGPSTracker();
			Location location = gps.getLocation();
			Herevoice.Builder builder = new Herevoice.Builder(
					AndroidHttp.newCompatibleTransport(),
					new JacksonFactory(),
					new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }
					});
			Herevoice endpoint = builder.build();
			
			try {
				return endpoint.list(String.valueOf(location.getLatitude()), 
						      String.valueOf(location.getLongitude())).execute();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			
		}
		
		 @Override
		   protected void onPostExecute(VoiceCollection result) {
			 //System.out.println("result returned!");
			 GPSTracker gps = va.getGPSTracker();
			 Location location = gps.getLocation();
				
			 va.getVoiceList().clear();
			 va.getVoiceList().addAll(result.getItems());
			 listAdapter.notifyDataSetChanged();
			 
			 try {
				List<Address> addr = geocoder.getFromLocation(location.getLatitude(), 
						 				  location.getLongitude(),1);
				if(addr.size()>0){
					addressText.setText("message around " + addr.get(0).getAddressLine(0));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		 
	}
	
	private class MakeVoiceTask extends AsyncTask<String, Void, Void> {
		
		protected Void doInBackground(String... params) {
			GPSTracker gps = va.getGPSTracker();
			Location location = gps.getLocation();
			
			Herevoice.Builder builder = new Herevoice.Builder(
					AndroidHttp.newCompatibleTransport(),
					new JacksonFactory(),
					va.getGoogleAccountCredential());
			Herevoice endpoint = builder.build();
			
			try {
				endpoint.make(params[0],
						      String.valueOf(location.getLatitude()), 
						      String.valueOf(location.getLongitude())).execute();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(Void result) {
			Log.d("","posted");
			ListVoiceTask lvt = new ListVoiceTask();
			lvt.execute();
		}

	}
	
    

	

	
	
}
