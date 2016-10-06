package com.example.basedealumnos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLite extends SQLiteOpenHelper{
	public AdminSQLite(Context context, String nombre, CursorFactory factory, int version){
		super(context, nombre, factory, version);
	}
	public void onCreate (SQLiteDatabase db)
	{
		db.execSQL("create table empleados(n_empleado integer primary key, nombre text, telefono text, direccion text )");
	}

	@Override
	public void onUpgrade (SQLiteDatabase db, int versionAnte, int versionNue)
	{
		db.execSQL("drop table if exists empleados");
		db.execSQL("create table empleados (n_empleado integer primary key, nombre text, telefono text, direccion text)");
	}
}
