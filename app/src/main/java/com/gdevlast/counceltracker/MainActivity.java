package com.gdevlast.counceltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button)findViewById(R.id.new_customer);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//setContentView(R.layout.activity_register);
				Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(intent);
			}
		});

		ListView listView = (ListView)findViewById(R.id.customer_list);

		final ArrayList<Customer> list = Customer.getCustomers();
		final ArrayList<String> customerList = new ArrayList<>();
		for(Customer c: list)
		{
			customerList.add(c.getName());
		}

		ArrayAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				customerList);

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				TextView textView = (TextView)view;
				String customerName = (String)textView.getText();
				Intent intent = new Intent(getApplicationContext(), CustomerDetails.class);
				intent.putExtra("CustomerName", customerName);
				startActivity(intent);
			}
		});
	}
}
