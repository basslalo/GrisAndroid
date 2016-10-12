package com.example.tarea2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class RadioMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.radio_main, menu);
		return true;
	}

}
