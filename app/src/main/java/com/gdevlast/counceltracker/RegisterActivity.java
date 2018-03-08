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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		Button btn = (Button)findViewById(R.id.register_customer);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				EditText text = (EditText)findViewById(R.id.customer_name);
				String customerName = text.getText().toString();
				if(customerName == null || customerName.length() == 0)
				{
					Toast.makeText(getApplicationContext(), "Please enter a valid customer name", Toast.LENGTH_SHORT).show();
				}

				Customer.addCustomer(new Customer(customerName));

				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
