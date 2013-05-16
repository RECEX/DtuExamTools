package com.RecEx.dtuexamtools;


import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class Groups extends FragmentActivity implements OnClickListener {
	
	private ArrayList<Button> mButtons = new ArrayList<Button>();
	 private Tracker mGaTracker;
	  private GoogleAnalytics mGaInstance;
	
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mGaInstance = GoogleAnalytics.getInstance(this);
        mGaTracker = mGaInstance.getTracker("UA-40877184-1"); // Placeholder tracking ID.


       
        
        createButton("Group A");
        createButton("Group B");
        
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
	
	public void databaseBrowser(View v){
		DialogFragment database = new databaseDialog();
        database.show(getSupportFragmentManager(), "missiles");
	}
	
	@Override
	 public void onStart() {
		    super.onStart();
		     // The rest of your onStart() code.
		    EasyTracker.getInstance().activityStart(this); // Add this method.
		    mGaTracker.sendView("/HomeScreen");

		  }
	 
	  @Override
	  public void onStop() {
	    super.onStop();
	    // The rest of your onStop() code.
	    EasyTracker.getInstance().activityStop(this); // Add this method.
	  }
	  
	@Override
	public void onClick(View v) {
		Button selection = (Button)v;
		Toast.makeText(getBaseContext(),  selection.getText()+ " was pressed!", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(getApplicationContext(), NotesAndPapers.class);
		i.putExtra("Group",selection.getText());
		startActivity(i);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.aboutUs : 
	        	DialogFragment aboutDialog = new AboutUs();
	            aboutDialog.show(getSupportFragmentManager(), "missiles");
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}

