package com.example.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CheckboxMainActivity extends Activity {
	private EditText et1, et2;
	private TextView tv3;
	private CheckBox cb1, cb2,cb3,cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox_main);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv3 = (TextView)findViewById(R.id.tv3);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        cb4 = (CheckBox)findViewById(R.id.cb4);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.checkbox_main, menu);
        return true;
    }
    
    public void operar (View view)
    {
    	String valor1 = et1.getText().toString();
    	String valor2 = et2.getText().toString();
    	int nro1 = Integer.parseInt(valor1);
    	int nro2 = Integer.parseInt(valor2);
    	String resu = "";
    	if (cb1.isChecked()== true) {
			int suma = nro1 + nro2;
			resu = "La suma es: " + suma;
		}
    	if (cb2.isChecked()== true) {
			int resta = nro1 - nro2;
			resu = resu + " La resta es: " + resta;
		}
    	if (cb3.isChecked()== true) {
			int mult = nro1 * nro2;
			resu = resu + " La multiplicación es: " + mult;
		}
    	if (cb4.isChecked()== true) {
			int resta = nro1 / nro2;
			resu = resu + " La división es: " + resta;
		}
    	
    	tv3.setText(resu);
    	
    	
    	
    }
    
}
