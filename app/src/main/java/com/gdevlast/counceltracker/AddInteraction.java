package com.gdevlast.counceltracker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddInteraction extends AppCompatActivity
{
	Calendar myCalendar = Calendar.getInstance();
	DatePickerDialog.OnDateSetListener date = null;
	String customerName;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_interaction);

		TextView dateView = (TextView)findViewById(R.id.date);
		customerName = getIntent().getStringExtra("CustomerName");
		date = new DatePickerDialog.OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
			                      int dayOfMonth) {
				// TODO Auto-generated method stub
				myCalendar.set(Calendar.YEAR, year);
				myCalendar.set(Calendar.MONTH, monthOfYear);
				myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
				updateLabel();
			}

		};

		final Context ctx = this;

		dateView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new DatePickerDialog(ctx, date, myCalendar
						.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
						myCalendar.get(Calendar.DAY_OF_MONTH)).show();
			}
		});

		Button btnSubmit = (Button)findViewById(R.id.submit);
		btnSubmit.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Customer c = Customer.getCustomer(customerName);
				if(c != null)
				{
					String notes = "";
					EditText notesText = (EditText)findViewById(R.id.notes);
					notes = notesText.getText().toString();
					c.addInteraction(new CustomerInteraction(myCalendar.getTime(), notes));

					onBackPressed();
				}
			}
		});
	}

	private void updateLabel() {
		String myFormat = "dd/MM/yy"; //In which you need put here
		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
		TextView dateView = (TextView)findViewById(R.id.date);
		dateView.setText("Date: " + sdf.format(myCalendar.getTime()));
	}

}
