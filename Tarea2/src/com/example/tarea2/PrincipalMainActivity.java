package com.example.tarea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class PrincipalMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal_main, menu);
        return true;
    }
    
    public void sigOp(View view){
    	Intent x = new Intent(this, OperacionesMainActivity.class);
    	startActivity(x);
    }
	public void sigRa(View view){
    	Intent x = new Intent(this, RadioMainActivity.class);
    	startActivity(x);
    }
    
}
