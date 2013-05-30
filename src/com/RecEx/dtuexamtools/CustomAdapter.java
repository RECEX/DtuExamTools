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


import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class CustomAdapter extends BaseAdapter {
	
	private ArrayList<Button> mButtons = null;
	 
    public CustomAdapter(ArrayList<Button> b) 
    {
        mButtons = b;
    }

	@Override
	public int getCount() {
		return mButtons.size();
	}

	@Override
	public Object getItem(int position) {
		return (Object) mButtons.get(position);
	}

	@Override
	public long getItemId(int position) {
		//in our case position and id are synonymous
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Button button;
        if (convertView == null) {
            button = mButtons.get(position);
        } else {
            button = (Button) convertView;
        }
        return button;
	}

}

