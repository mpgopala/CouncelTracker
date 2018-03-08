package com.gdevlast.counceltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CustomerDetails extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_details);

		final String customerName = getIntent().getStringExtra("CustomerName");
		TextView customerNameView = (TextView)findViewById(R.id.customer_name);
		customerNameView.setText(customerName);

		ArrayAdapter<CustomerInteraction> adapter = new CustomerInteractionAdapter(getApplicationContext(),
				Customer.getCustomer(customerName).getInteractions());
		ListView lstView = (ListView)findViewById(R.id.customer_interaction_details);
		lstView.setAdapter(adapter);

		Button btnAddInteraction = (Button)findViewById(R.id.add_interaction);
		btnAddInteraction.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(getApplicationContext(), AddInteraction.class);
				intent.putExtra("CustomerName", customerName);
				startActivity(intent);
			}
		});
	}

}
