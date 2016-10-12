package com.example.cambiaractividad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivityCambio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_cambio);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_cambio, menu);
        return true;
    }
    
    public void sig(View view){
    	Intent x = new Intent(this, SegundoMainActivity.class);
    	startActivity(x);
    }
    
}
