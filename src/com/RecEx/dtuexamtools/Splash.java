package com.RecEx.dtuexamtools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	
	@TargetApi(11)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB){
			getActionBar().hide();			
		}
		setContentView(R.layout.splash_layout);
		Thread timer= new Thread (){
			public void run(){
				try{
					sleep(2000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
					
				}finally{
					Intent OpenStartingPoint = null;
					OpenStartingPoint = new Intent( Splash.this , Groups.class);
					startActivity(OpenStartingPoint);
					
				}
			}
			
		};
		
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}

