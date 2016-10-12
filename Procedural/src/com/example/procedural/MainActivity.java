package com.example.procedural;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = new TextView(this);//Creamos un objeto
        tv.setText("Educar con responsabilidad"); //Asignamos el texto a la variable  
        this.setTitle("MISION");//CAMBIA EL TITULO DEL LAYOUT
        setContentView(tv);//Mostrams el cotenido 
        //Comentario 
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
