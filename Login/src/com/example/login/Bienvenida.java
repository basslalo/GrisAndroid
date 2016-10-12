package com.example.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Bienvenida extends Activity {
	
	Bundle a;
	String usuario;
	TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bienvenida);
		tv1=(TextView)findViewById(R.id.tv1);
		a = getIntent().getExtras();
		usuario = a.getString("Usuario");
		tv1.setText("Bienvenido"+" "+usuario);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bienvenida, menu);
		return true;
	}

}
