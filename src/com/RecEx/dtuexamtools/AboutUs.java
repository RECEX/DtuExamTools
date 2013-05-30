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

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AboutUs extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	String about = "Rec Ex is a small team of developers present to provide you with all the facilities for a convinient college life! The main contributors for the app are:\n\nAshutosh Dwivedi\nAditya Rastogi\nKashish Gupta\nShubham Desale\nUmair Khan";
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(about)
               .setTitle("About RecEx")
               .setPositiveButton("Our Facebook Page", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // FIRE ZE MISSILES!
                	   Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/RecEx.DTU"));
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
