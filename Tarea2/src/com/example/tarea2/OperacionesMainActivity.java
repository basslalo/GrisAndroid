package com.example.tarea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class OperacionesMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_operaciones_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.operaciones_main, menu);
		return true;
	}
	public void sigSum(View view){
    	Intent x = new Intent(this, SumaMainActivity.class);
    	startActivity(x);
    }
	public void sigRes(View view){
    	Intent x = new Intent(this, RestaMainActivity.class);
    	startActivity(x);
    }
	public void sigMul(View view){
    	Intent x = new Intent(this, MultiplicacionMainActivity.class);
    	startActivity(x);
    }
	public void sigDiv(View view){
    	Intent x = new Intent(this, DivisionMainActivity.class);
    	startActivity(x);
    }

}
