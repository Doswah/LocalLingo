package com.locallingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
 
public class add_lingo_confirm extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lingo_confirm);
 
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtDictionaryWord = (TextView) findViewById(R.id.txtDictionaryWord);
        TextView txtLingoWord = (TextView) findViewById(R.id.txtLingoWord);
        
        Button btnClose = (Button) findViewById(R.id.btnClose);
        
        Intent i = getIntent();
        
        // Receiving the Data
        String name = i.getStringExtra("Username");
        String DictionaryWord = i.getStringExtra("DictionaryWord");
        String LingoWord = i.getStringExtra("LingoWord");
        
        Log.e("Second Screen", name + "." + DictionaryWord + "." + LingoWord);
 
        // Displaying Received data
        txtName.setText(name);
        txtDictionaryWord.setText(DictionaryWord);
        txtLingoWord.setText(LingoWord);
 
        // Binding Click event to Button
        btnClose.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View btnClose) {
                //Closing SecondScreen Activity
                finish();
            }
        });
 
    }
}