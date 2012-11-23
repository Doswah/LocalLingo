package com.locallingo;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class lingo_list extends Activity {


public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_lingo_list);
	ListView listView1 = (ListView) findViewById(R.id.listView1);

	Lingo[] items = { 
            new Lingo("Damo", "Sprinkles", "Jimmys", 6,25), 
            new Lingo("Funboat", "Kauaian", "Kauai Native", 15, 29),  
        };
        
        ArrayAdapter<Lingo> adapter = new ArrayAdapter<Lingo>(this,
                    android.R.layout.simple_list_item_1, items);
        
        listView1.setAdapter(adapter);
    }
}