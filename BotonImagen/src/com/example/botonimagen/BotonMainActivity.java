package com.example.botonimagen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class BotonMainActivity extends Activity {
	private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_main);
        
        tv1 = (TextView)findViewById(R.id.tv1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.boton_main, menu);
        return true;
    }
    
    public void llamar (View view)
    {
    	tv1.setText("Has presionado el botón");
    }
    
    
}
