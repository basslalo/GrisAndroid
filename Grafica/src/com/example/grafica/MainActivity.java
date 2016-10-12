package com.example.grafica;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;

import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

public class MainActivity extends Activity {
	private XYPlot plot;
	ArrayList <Double> Vector = new ArrayList<Double>();
	public double DatoX, DatoY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Empiezan los parametros de la gráfica
        plot = (XYPlot) findViewById(R.id.grafica);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL,0.5 );
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL,1 );
        plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.rgb(255,255,255));
        plot.getGraphWidget().getDomainGridLinePaint().setColor(Color.rgb(255, 0, 0));
        plot.getGraphWidget().getRangeGridLinePaint().setColor(Color.rgb(255, 0, 0));
        plot.setRangeBoundaries(0, 5, BoundaryMode.FIXED);
        //Terminan los parametros de la gráfica
       
        //Empieza la graficación
        for (int i = 0; i <=20; i++) {
			DatoX = DatoX + 0.5;
			Vector.add(DatoX);
			DatoY = Math.random()*5;
			Vector.add(DatoY);
		}
        
        //Determina el tiempo de transicion
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask(){
        	public void run(){
        		Refrescar();
        	}
        }, 0, 150);
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void Refrescar(){
    	this.runOnUiThread(Graf);
    }
    
    private Runnable Graf = new Runnable()
    {
    	public void run()
    	{
    		DatoX = DatoX + 0.5;
    		Vector.remove(0);
			Vector.add(DatoX);
			DatoY = Math.random()*5;
			Vector.remove(0);
			Vector.add(DatoY);
			
			
    		
    		
    		XYSeries series = new SimpleXYSeries(Vector,SimpleXYSeries.ArrayFormat.XY_VALS_INTERLEAVED,"señal");
            //Para agregar el formato a la linea 
            LineAndPointFormatter seriesFormat = new LineAndPointFormatter(Color.rgb(127, 255, 0),0x0000000,0X000000,null);
            plot.clear();
            plot.addSeries(series, seriesFormat);	
            plot.redraw();
    	}
    };
    
}
