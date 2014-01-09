package com.yahoo.example.tipcalculator;

import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tipcalc extends Activity {

	EditText etOrder;
	TextView tvTips;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipcalc);
        etOrder = (EditText) findViewById(R.id.etTotal);
        tvTips = (TextView) findViewById(R.id.tvTip);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tipcalc, menu);
        return true;
    }
    
    private void calcShowTips(float rate) {
    	if (etOrder.getText().toString().length() > 0) {
			float amount = Float.valueOf(etOrder.getText().toString());
			if (amount > 0) {
				amount *= rate;
				tvTips.setText(getString(R.string.tip_is) + " " + NumberFormat.getCurrencyInstance().format(amount));
			}
    	}
	}
    
    public void btn10OnClick(View v) {
    	calcShowTips((float) 0.1);
	}
    
    public void btn15OnClick(View v) {
    	calcShowTips((float) 0.15);
	}
    
    public void btn20OnClick(View v) {
    	calcShowTips((float) 0.2);
	}
    
}
