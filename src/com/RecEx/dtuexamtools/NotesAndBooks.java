package com.RecEx.dtuexamtools;


import java.util.ArrayList;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class NotesAndBooks extends Activity implements OnClickListener {
	
	private ArrayList<Button> mButtons = new ArrayList<Button>();
	String subject;
	Intent i = null;
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
            subject = extras.getString("Subject");
        }
        
        if(subject.equals("AP")){
        	createButton("Assignments");
            createButton("Textbooks and Referrals");
            createButton("Class Notes");

        }
        
        if(subject.equals("AC")){
        	createButton("Complete class notes");
            createButton("Textbooks and Referrals");
        }
        
        if(subject.equals("EE")){
            createButton("Textbooks and Referrals & IIT notes");
        }
        
        if(subject.equals("HU")){
            createButton("Textbooks and Referrals");
            createButton("Class Notes");
        }
        
        if(subject.equals("IT lab")){
        	createButton("CSS Programs");
            createButton("HTML Programs");
        }
        
        if(subject.equals("IT")){
            createButton("Textbooks and Referrals");
            createButton("Class Notes");
       }
        if(subject.equals("AM")){
        	createButton("Assignments");
            createButton("Textbooks and Referrals");
        }
        if(subject.equals("AP/AC")){
        	createButton("AC Class Notes");
            createButton("AC Topic Wise Complete Notes");
            createButton("AP assignments");
            createButton("AP books and reference");
            createButton("AP class notes");
        }
        
        if(subject.equals("BME")){
        	createButton("Part I-class notes");
            createButton("Part I-books and reference");
            createButton("Part II-Books and reference");
            createButton("Part II-Rooplal sir's notes");
        }
        if(subject.equals("COE")){
        	createButton("Books and References");
            createButton("COE Practicals");
            createButton("Complete class notes");
        }
        if(subject.equals("ED")){
        	createButton("Assignment and viva questions");
            createButton("Notes");
            createButton("Sheets");
        }
        if(subject.equals("BME lab")){
        	createButton("Books and References");
            createButton("Class notes");
        }
        if(subject.equals("ENE")){
        	createButton("Books and references");
            createButton("class Notes");
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
		
		//AP/AC
		if(subject.equals("AP/AC")&& selection.getText()=="AC Class Notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/APACAC/classNotes.zip"));
			}
		if(subject.equals("AP/AC")&& selection.getText()=="AC Topic Wise Complete Notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/APACAC/fullTopicwiseCompleteNotes.zip "));
			}
		if(subject.equals("AP/AC")&& selection.getText()=="AP assignments"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/APACAP/assignments.zip "));
			}
		if(subject.equals("AP/AC")&& selection.getText()=="AP books and reference"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/APACAP/booksReferals.zip "));
			}
		if(subject.equals("AP/AC")&& selection.getText()=="AP class notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("   http://www.recex.co.in/examtoolsdata/groupB/APACAP/classNotes.zip "));
			}
		
		
		//BME
		if(subject.equals("BME")&& selection.getText()=="Part I-class notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/BME-A/classNotes.zip"));
			}
		if(subject.equals("BME")&& selection.getText()=="Part I-books and reference"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/BME-A/booksAndReferals.zip"));
			}
		if(subject.equals("BME")&& selection.getText()=="Part II-Books and reference"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/BME-B/booksAndReferals.zip"));
			}
		if(subject.equals("BME")&& selection.getText()=="Part II-Rooplal sir's notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/BME-B/rooplalLectures.zip"));
			}
		
		
		//COE
		if(subject.equals("COE")&& selection.getText()=="Books and References"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/COE/booksAndReferalsCompilers.zip"));
			}
		if(subject.equals("COE")&& selection.getText()=="COE Practicals"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/COE/coePracticals.zip"));
			}
		if(subject.equals("COE")&& selection.getText()=="Complete class notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/COE/completeClassNotes.zip"));
			}
		
		
		//ED
		if(subject.equals("ED")&& selection.getText()=="Assignment and viva questions"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/ED/assignmentsAndVivaQuestions.zip "));
			}
		if(subject.equals("ED")&& selection.getText()=="Notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/ED/notes.zip"));
			}
		if(subject.equals("ED")&& selection.getText()=="Sheets"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/ED/sheets.zip "));
			}
		
		
		//ENE
		if(subject.equals("ENE")&& selection.getText()=="Books and references"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/ENE/textBookAndReferals.zip  "));
			}
		if(subject.equals("ENE")&& selection.getText()=="class Notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/ENE/classNotes.zip "));
			}
		
		//BME lab
		if(subject.equals("BME lab")&& selection.getText()=="Books and References"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/BMElab/booksAndreferals.zip"));
			}
		if(subject.equals("BME lab")&& selection.getText()=="Class notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupB/BMELab/classNotes.zip"));
			}
		
		//AC
		if(subject.equals("AC")&& selection.getText()=="Complete class notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/AC/completeClasssNotes.zip"));
			}
		if(subject.equals("AC")&& selection.getText()=="Textbooks and Referrals"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/AC/textBooksAndReferrals.zip"));
			}
		
		//AP
		if(subject.equals("AP")&& selection.getText()=="Assignments"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/AP/assignments.zip "));
			}
		if(subject.equals("AP")&& selection.getText()=="Textbooks and Referrals"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/AP/booksAndReferrals.zip "));
			}
		if(subject.equals("AP")&& selection.getText()=="Class Notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/AP/classNotes.zip"));
			}
		
		
		//EE
		if(subject.equals("EE")&& selection.getText()=="Textbooks and Referrals & IIT notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/EE/booksReferals.zip"));
			}
		
		
		//HU
		if(subject.equals("HU")&& selection.getText()=="Textbooks and Referrals"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/HU/booksAndReferrals.zip"));
			}
		if(subject.equals("HU")&& selection.getText()=="Class Notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/HU/classNotes.zip"));
			}
		
		//IT
		if(subject.equals("IT")&& selection.getText()=="Textbooks and Referrals"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/IT/textbookAndReferrals.zip"));
			}
		if(subject.equals("IT")&& selection.getText()=="Class Notes"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/IT/classnotes.zip"));
			}
		
		//IT lab
		if(subject.equals("IT lab")&& selection.getText()=="CSS Programs"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/ITLab/cssProgram.zip"));
			}
		if(subject.equals("IT lab")&& selection.getText()=="HTML Programs"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/ITLab/HTMLprograms.zip"));
			}
		
		//AM
		if(subject.equals("AM")&& selection.getText()=="Assignments"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/AM/assignment.zip"));
			}
		if(subject.equals("AM")&& selection.getText()=="Textbooks and Referrals"){
			 i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata/groupA/AM/booksAndReferrals.zip"));
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
