/**********************************************************************
    RecEX DTU Exam  Tools
    Copyright (C) 2013  RecEx

The source code of this program is shared under the RECEX
SHARED SOURCE LICENSE (version 1.0).

The source code is shared for referrence and academic purposes
with the hope that people can read and learn from it. This is not
Free and Open Source software, and code is not redistributable
without permission of the author. Read the RECEX SHARED
SOURCE LICENSE for details 

The source codes does not come with any warranty including
the implied warranty of merchandise. 

You should have received a copy of the RECEX SHARED SOURCE
LICENSE in the form of a License.txt file in the root of the source
directory. If not, please refer to 
<https://raw.github.com/Recex/Licenses/master/SharedSourceLicense/LICENSE.txt>
**********************************************************************/
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

