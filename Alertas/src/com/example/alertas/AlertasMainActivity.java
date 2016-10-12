package com.example.alertas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class AlertasMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alertas_main);
	}
	
	public void simple (View v) {
		mensaje("Se ha pulsado el mensaje de Toast tipo alerta");
	}
	public void dialog (View v)
	{
		alerta("Mensaje con Dialog builder");
	}
	public void alert (View v)
	{
		eleccion("mensaje de alertbox elige opción");
	}
	public void mensaje (String cadena)
	{
		Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show();
	}
	public void alerta (String cadena)
	{
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setMessage(cadena);
		dialog.setTitle("Alerta con Dialog");
		dialog.setCancelable(true);
		dialog.create().show();			
	}
	public void eleccion (String cadena)
	{
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setMessage(cadena);
		alert.setPositiveButton("si", new DialogInterface.OnClickListener(){
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				//TODO Auto-generated method stub
				mensaje("Pulsando el boton si");
			}
		});
		
		alert.setPositiveButton("no", new DialogInterface.OnClickListener(){
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				//TODO Auto-generated method stub
				mensaje("Pulsando el boton si");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alertas_main, menu);
		return true;
	}

}
