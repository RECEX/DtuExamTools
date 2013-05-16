package com.RecEx.dtuexamtools;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class databaseDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	String about = "You can browse our entire database on your web browser by going to \n\nhttp://www.recex.co.in/examtoolsdata";
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(about)
               .setTitle("Online Database Browser")
               .setPositiveButton("Browse database", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // FIRE ZE MISSILES!
                	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.recex.co.in/examtoolsdata"));
                	   startActivity(browserIntent);
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
