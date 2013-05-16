package com.RecEx.dtuexamtools;


import java.util.ArrayList;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;


import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MidSemEndSem extends Activity implements OnClickListener {
	
	private ArrayList<Button> mButtons = new ArrayList<Button>();
	Intent i=null;
	private Tracker mGaTracker;
	  private GoogleAnalytics mGaInstance;
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        createButton("Mid Sem");
        createButton("End Sem");
        
        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-40877184-1"); // Placeholder tracking ID.

        
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new CustomAdapter(mButtons));
        
    }

	private void createButton(String string) {
		// TODO Auto-generated method stub
        Button cb = null;
        cb = new Button(this);
    	cb.setText(string);
    	cb.setBackgroundResource(R.drawable.fancy_button_selector);
    	cb.setOnClickListener(this);
    	registerForContextMenu(cb);
    	mButtons.add(cb);
	}

	@Override
	public void onClick(View v) {
		Button selection = (Button)v;
		Toast.makeText(getBaseContext(),  selection.getText()+ " was pressed!", Toast.LENGTH_SHORT).show();
		if(selection.getText()=="Mid Sem"){
		 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/examPapers/midSem.zip"));
		}
		if(selection.getText()=="End Sem"){
		 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/examPapers/endSem.zip"));
		}
		startActivity(i);
	}
	@Override
	 public void onStart() {
		    super.onStart();
		     // The rest of your onStart() code.
		    EasyTracker.getInstance().activityStart(this); // Add this method.
		  }
	 
	  @Override
	  public void onStop() {
	    super.onStop();
	    // The rest of your onStop() code.
	    EasyTracker.getInstance().activityStop(this); // Add this method.
	  }
	  
}
