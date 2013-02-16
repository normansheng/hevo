package com.hevo.app;

import java.util.ArrayList;
import java.util.List;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.services.herevoice.model.Voice;

import android.app.Application;

public class VoiceApplication extends Application {
	private List<Voice> voicelist = new ArrayList<Voice>();
	private GoogleAccountCredential credential;
	private GPSTracker gps;
	
	public List<Voice> setVoiceList(List<Voice> vlist){
		this.voicelist = vlist;
		return this.voicelist;
	}
	
	public List<Voice> getVoiceList(){
		return this.voicelist;
	}
	
	public GoogleAccountCredential setGoogleAccountCredential(GoogleAccountCredential credential){
		this.credential = credential;
		return this.credential;
	}
	
	public GoogleAccountCredential getGoogleAccountCredential(){
		return this.credential;
	}
	
	public GPSTracker setGPSTracker(GPSTracker gps){
		this.gps = gps;
		return this.gps;
	}
	
	public GPSTracker getGPSTracker(){
		return this.gps;
	}
	
}
