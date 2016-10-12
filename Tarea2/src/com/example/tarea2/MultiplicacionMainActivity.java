package com.example.tarea2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MultiplicacionMainActivity extends Activity {
	private EditText et1,et2;
	private TextView tv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiplicacion_main);
		et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tv3=(TextView)findViewById(R.id.tv3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multiplicacion_main, menu);
		return true;
	}
	
	public void multiplicar (View view){
    	String valor1=et1.getText().toString();
    	String valor2=et2.getText().toString();
    	int nro1 = Integer.parseInt(valor1);
    	int nro2 = Integer.parseInt(valor2);
    	int suma = nro1*nro2;
    	String resu = String.valueOf(suma);
    	tv3.setText(resu);
    }

}
