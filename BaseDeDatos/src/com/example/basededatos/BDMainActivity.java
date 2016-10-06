package com.example.basededatos;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BDMainActivity extends Activity {
	private EditText et1, et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bdmain);
		et1 = (EditText) findViewById (R.id.et1);
		et2 = (EditText) findViewById (R.id.et2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bdmain, menu);
		return true;
	}
	
	public void alta (View v){
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String n_empleado = et1.getText().toString();
		String nombre = et2.getText().toString();
		ContentValues registro = new ContentValues();
		registro.put("n_empleado", n_empleado);
		registro.put("nombre", nombre);
		bd.insert("empleados", null, registro);
		bd.close();
		et1.setText("");
		et2.setText("");
		Toast.makeText(this, "Se cargaron los datos del empleado", Toast.LENGTH_SHORT).show();
	}
	
	public void consulta (View v)
	{
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String n_empleado = et1.getText().toString();
		Cursor fila = bd.rawQuery("select nombre from empleados where n_empleado=" + n_empleado + " ", null);
		if (fila.moveToFirst()) {
			et2.setText(fila.getString(0));
		}else {
			Toast.makeText(this, "El empleado no esta registrado", Toast.LENGTH_SHORT).show();
			bd.close();
		}
	}
	
	public void baja (View v){
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String n_empleado = et1.getText().toString();
		int cant = bd.delete("empleados", "n_empleado=" + n_empleado + "", null);
		bd.close();
		et1.setText("");
		et2.setText("");
		if (cant == 1) {
			Toast.makeText(this, "Se borro al empleado", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "El empleado no esta registrado", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void modificacion (View v)
	{
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String n_empleado = et1.getText().toString();
		String nombre = et2.getText().toString();
		ContentValues registro = new ContentValues();
		registro.put("nombre", nombre);
		int cant = bd.update("empleados", registro, "n_empleado=" + n_empleado, null);
		bd.close();
		if (cant == 1) {
			Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(this, "El empleado no esta registrado", Toast.LENGTH_SHORT).show();
		}
	}
	
	
}
