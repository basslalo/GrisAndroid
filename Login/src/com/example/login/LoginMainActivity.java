package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginMainActivity extends Activity {
	private EditText et1,et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_main);
		et1=(EditText)findViewById(R.id.et1);
		et2=(EditText)findViewById(R.id.et2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_main, menu);
		return true;
	}
	
	public void verificar (View v)
	{
		String nombre = et1.getText().toString();
		String clave = et2.getText().toString();
		if (clave.equals("eldonasesputo") && nombre.equals("eduardo")) {
			Intent i = new Intent (this,Bienvenida.class);
			i.putExtra("Usuario", et1.getText().toString());//El put nos sirve para mandar una variable al otro activity			
			startActivity(i);
			
		}
	}

}
