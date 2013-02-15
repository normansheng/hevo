package com.hevo.app;

import java.util.List;

import com.google.api.services.herevoice.model.Voice;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VoiceAdapter extends ArrayAdapter<Voice> {
	Context mContext;
	public VoiceAdapter(Context context, int textViewResourceId,List<Voice> objects) {
		super(context, textViewResourceId, objects);
		mContext = context;
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
	        row = inflater.inflate(R.layout.voiceitem, parent, false);
	        holder.tvVoiceDate = (TextView) row.findViewById(R.id.voiceDate);
	        holder.tvVoiceText = (TextView) row.findViewById(R.id.voiceText);
	        row.setTag(holder);
	    }
	    else
	    {
	        holder = (ViewHolder) row.getTag();
	    }
	    holder.tvVoiceDate.setText(getItem(position).getVoiceDate().toString());
	    holder.tvVoiceText.setText(getItem(position).getVoiceText());
	    return row;
	}
	
	public static class ViewHolder
	{
	    TextView tvVoiceDate;
	    TextView tvVoiceText;
	}

}
