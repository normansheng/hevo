package com.hevo.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.herevoice.Herevoice;
import com.google.api.services.herevoice.model.Voice;
import com.hevo.app.VoiceContent.VoiceItem;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/**
 * An activity representing a single voice detail screen. This activity is only
 * used on handset devices. On tablet-size devices, item details are presented
 * side-by-side with a list of items in a {@link VoiceListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link VoiceDetailFragment}.
 */
public class VoiceDetailActivity extends FragmentActivity implements
	VoiceListFragment.Callbacks{
	private EditText sendText;
	private Button sendButton;
	private TextView voiceText;
	private VoiceApplication va;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		va = (VoiceApplication)getApplication();
		setContentView(R.layout.activity_voice_detail);
		voiceText = (TextView) findViewById(R.id.voiceText);
		
		sendText = (EditText)findViewById(R.id.sendText);
		sendButton = (Button) findViewById(R.id.sendButton);
		sendButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Create a new HttpClient and Post Header
				GPSTracker gps = va.getGPSTracker();
				if(gps.canGetLocation()){
					Location location = gps.getLocation();
					Log.d("","Your Location is - \nLat: " + location.getLatitude() + "\nLng: " + location.getLongitude());
					MakeCommentTask makecomment = new MakeCommentTask();
					makecomment.execute(getIntent().getStringExtra("voiceID"),
									    sendText.getText().toString());
					sendText.getText().clear();
					
					InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE); 
					inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                       InputMethodManager.HIDE_NOT_ALWAYS);
				}
				
			}
		});
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);

		// savedInstanceState is non-null when there is fragment state
		// saved from previous configurations of this activity
		// (e.g. when rotating the screen from portrait to landscape).
		// In this case, the fragment will automatically be re-added
		// to its container so we don't need to manually add it.
		// For more information, see the Fragments API guide at:
		//
		// http://developer.android.com/guide/components/fragments.html
		//
		if (savedInstanceState == null) {
			// Create the detail fragment and add it to the activity
			// using a fragment transaction.
			String id = getIntent().getStringExtra("voiceID");
			List<Voice> vl = va.getVoiceList();
		    for(int i=0;i<vl.size();i++){
	        	if(vl.get(i).getVoiceID().equals(id)){
	        		String dateString = (String) DateUtils.getRelativeTimeSpanString(vl.get(i).getVoiceDate().getValue(),
							    		 											 new Date().getTime(),0);
	        		voiceText.setText(vl.get(i).getVoiceText() + " -" + dateString);
	        		listComments(vl.get(i).getComments());
					break;
				}
			}
			/*
			Bundle arguments = new Bundle();
			arguments.putString("voiceID", id);
			VoiceDetailFragment fragment = new VoiceDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.voice_detail_container, fragment).commit();
					*/
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpTo(this, new Intent(this,
					VoiceListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(String id) {
		
	}

	public VoiceAdapter listAdapter;
	public List<Voice> voicelist = new ArrayList<Voice>();
	@Override
	public void onAttachVoiceListFragment(VoiceListFragment fragment) {
		this.listAdapter = new VoiceAdapter(this,R.layout.voice_item ,voicelist);
		fragment.setListAdapter(this.listAdapter);
	}
	
	@Override
	public void onVoiceListFragmentCreated(VoiceListFragment fragment) {
		fragment.getListView().setStackFromBottom(false);
		fragment.getListView().setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
	}
	
	private void listComments(List<Voice> vl){
		voicelist.clear();
		if(vl!=null){
		voicelist.addAll(vl);
		listAdapter.notifyDataSetChanged();
		}
	}

	
private class MakeCommentTask extends AsyncTask<String, Void, Void> {
		
		protected Void doInBackground(String... params) {
			
			Herevoice.Builder builder = new Herevoice.Builder(
					AndroidHttp.newCompatibleTransport(),
					new JacksonFactory(),
					va.getGoogleAccountCredential());
			Herevoice endpoint = builder.build();
			
			try {
				endpoint.comment(params[0], 
								 params[1],
								 String.valueOf(va.getGPSTracker().getLatitude()),
								 String.valueOf(va.getGPSTracker().getLongitude())).execute();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(Void result) {
			Log.d("","posted");
		}

	}
}
