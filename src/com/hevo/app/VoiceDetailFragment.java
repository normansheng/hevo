package com.hevo.app;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.api.services.herevoice.model.Voice;
import com.hevo.app.dummy.DummyContent;

/**
 * A fragment representing a single voice detail screen. This fragment is either
 * contained in a {@link VoiceListActivity} in two-pane mode (on tablets) or a
 * {@link VoiceDetailActivity} on handsets.
 */

public class VoiceDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";
	private VoiceApplication va;
	
	/**
	 * The dummy content this fragment is presenting.
	 */
	private Voice voice;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public VoiceDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		va = (VoiceApplication)getActivity().getApplication();
		
		
		List<Voice> vl = va.getVoiceList();
	    for(int i=0;i<vl.size();i++){
        	if(vl.get(i).getVoiceID().equals(getArguments().get("voiceID"))){
        		voice = vl.get(i);
				vl.get(i).getVoiceText();
				Log.d("","$$:" + vl.get(i).getVoiceText());
				
				break;
			}
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_voice_detail,
				container, false);
		

		
		
		// Show the dummy content as text in a TextView.
		if (voice != null) {
			((TextView) rootView.findViewById(R.id.voice_detail))
					.setText(voice.getVoiceText());
		}

		return rootView;
	}
}
