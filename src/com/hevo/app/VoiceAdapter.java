package com.hevo.app;

import java.util.Date;
import java.util.List;

import com.google.api.services.herevoice.model.Voice;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VoiceAdapter extends ArrayAdapter<Voice> {
	private Context mContext;
	private int mLayoutResourceId; 
	private List<Voice> mVoicelist;
	public VoiceAdapter(Context context, int layoutResourceId,List<Voice> objects) {
		super(context, layoutResourceId, objects);
		mContext = context;
		mLayoutResourceId = layoutResourceId;
		mVoicelist = objects;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
	    ViewHolder holder = new ViewHolder();

	    if(row == null)
	    {
	        LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
	        row = inflater.inflate(mLayoutResourceId, parent, false);
	        holder.tvVoiceDate = (TextView) row.findViewById(R.id.voiceDate);
	        holder.tvVoiceText = (TextView) row.findViewById(R.id.voiceText);
	        row.setTag(holder);
	    }
	    else
	    {
	        holder = (ViewHolder) row.getTag();
	    }
	    String dateString = "-" + (String) DateUtils.getRelativeTimeSpanString(getItem(position).getVoiceDate().getValue(),
				    new Date().getTime(),0);
	    holder.tvVoiceDate.setText(dateString);
	    holder.tvVoiceText.setText(getItem(position).getVoiceText());
	    return row;
	}
	
	public static class ViewHolder
	{
	    TextView tvVoiceDate;
	    TextView tvVoiceText;
	}

}
