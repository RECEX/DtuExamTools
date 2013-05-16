package com.RecEx.dtuexamtools;


import java.util.ArrayList;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class Subjects extends Activity implements OnClickListener {
	
	private ArrayList<Button> mButtons = new ArrayList<Button>();
	String group;

	 private Tracker mGaTracker;
	  private GoogleAnalytics mGaInstance;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-40877184-1"); // Placeholder tracking ID.

             
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            group = extras.getString("Group");
        }
        if(group.equals("Group A")){
        createButton("AP");
        createButton("AM");
        createButton("AC");
        createButton("HU");
        createButton("IT");
        createButton("IT lab");
        createButton("EE");
        }
        
        if(group.equals("Group B")){
        createButton("AP");
        createButton("AM");
        createButton("AP/AC");
        createButton("ENE");
        createButton("COE");
        createButton("BME");
        createButton("BME lab");

        
        }
        
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
		Intent i = new Intent(getApplicationContext(), NotesAndBooks.class);
		i.putExtra("Subject",selection.getText());
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
