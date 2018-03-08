package com.gdevlast.counceltracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by gsharma on 08/03/18.
 */

public class CustomerInteractionAdapter extends ArrayAdapter<CustomerInteraction>
{
	public CustomerInteractionAdapter(Context context, ArrayList<CustomerInteraction> interactions) {
		super(context, 0, interactions);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		CustomerInteraction interaction = getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.customer_interaction_item, parent, false);
		}
		// Lookup view for data population
		TextView dateView = (TextView) convertView.findViewById(R.id.interaction_date);
		TextView textView = (TextView) convertView.findViewById(R.id.interaction_text);
		// Populate the data into the template view using the data object
		String myFormat = "dd/MM/yy"; //In which you need put here
		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
		dateView.setText(sdf.format(interaction.date.getTime()));
		textView.setText(interaction.notes);
		// Return the completed view to render on screen
		return convertView;
	}
}
