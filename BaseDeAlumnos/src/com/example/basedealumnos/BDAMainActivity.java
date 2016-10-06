package com.example.basedealumnos;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BDAMainActivity extends Activity {
	private EditText et1, et2, et3, et4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bdamain);
		et1 = (EditText) findViewById (R.id.et1);
		et2 = (EditText) findViewById (R.id.et2);
		et3 = (EditText) findViewById (R.id.et3);
		et4 = (EditText) findViewById (R.id.et4);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bdamain, menu);
		return true;
	}
	
	public void alta (View v){
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String n_empleado = et1.getText().toString();
		String nombre = et2.getText().toString();
		String direccion = et3.getText().toString();
		String telefono = et4.getText().toString();
		ContentValues registro = new ContentValues();
		registro.put("n_empleado", n_empleado);
		registro.put("nombre", nombre);
		registro.put("direccion", direccion);
		registro.put("telefono", telefono);
		bd.insert("empleados", null, registro);
		bd.close();
		et1.setText("");
		et2.setText("");
		et3.setText("");
		et4.setText("");
		Toast.makeText(this, "Se cargaron los datos del alumno", Toast.LENGTH_SHORT).show();
	}
	
	public void consulta (View v)
	{
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		String n_empleado = et1.getText().toString();
		Cursor fila = bd.rawQuery("select nombre, direccion, telefono from empleados where n_empleado=" + n_empleado + " ", null);
		if (fila.moveToFirst()) {
			et2.setText(fila.getString(0));
			et3.setText(fila.getString(1));
			et4.setText(fila.getString(2));
			
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
		et3.setText("");
		et4.setText("");
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
		String direccion = et3.getText().toString();
		String telefono = et4.getText().toString();
		ContentValues registro = new ContentValues();
		registro.put("nombre", nombre);
		registro.put("direccion", direccion);
		registro.put("telefono", telefono);
		int cant = bd.update("empleados", registro, "n_empleado=" + n_empleado, null);
		bd.close();
		if (cant == 1) {
			Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(this, "El empleado no esta registrado", Toast.LENGTH_SHORT).show();
		}
	}

}
