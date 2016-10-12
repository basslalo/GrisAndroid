package com.example.listadespegable;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ListaMainActivity extends Activity {
	private Spinner sp1;
	private EditText et1, et2;
	private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_main);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv3 = (TextView)findViewById(R.id.tv3);
        sp1 = (Spinner)findViewById(R.id.sp1);
        String [] opciones = {"sumar","restar","multiplicar","dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        sp1.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lista_main, menu);
        return true;
    }
    
    public void operar (View view)
    {
    	String valor1 = et1.getText().toString();
    	String valor2 = et2.getText().toString();
    	int nr1 = Integer.parseInt(valor1);
    	int nr2 = Integer.parseInt(valor2);
    	String selec = sp1.getSelectedItem().toString();
    	if (selec.equals("sumar")){
			int suma = nr1 + nr2;
			String resu = String.valueOf(suma);
			tv3.setText(resu);
		}else
			if (selec.equals("restar")){
				int resta = nr1 - nr2;
				String resu = String.valueOf(resta);
				tv3.setText(resu);
			}else
				if (selec.equals("multiplicar")){
					int multi = nr1 * nr2;
					String resu = String.valueOf(multi);
					tv3.setText(resu);
				}else
					if (selec.equals("dividir")){
						int div = nr1 / nr2;
						String resu = String.valueOf(div);
						tv3.setText(resu);
					}
    }
    
}
