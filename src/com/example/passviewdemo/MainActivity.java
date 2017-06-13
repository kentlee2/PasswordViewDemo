package com.example.passviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity implements OnPasswordInputFinish {

	private PassView passView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 passView = new PassView(this);
		setContentView(passView);
		passView.setOnFinishInput(this);
	        
	}
	@Override
	public void inputFinish() {
		Toast.makeText(getApplicationContext(), passView.getStrPassword(), Toast.LENGTH_SHORT).show();
		
	}
	
}
