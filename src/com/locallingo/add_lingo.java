package com.locallingo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.location.LocationListener;
import android.location.LocationManager;
 
public class add_lingo extends Activity {
	
    // Initializing variables
    EditText inputName;
    EditText inputDictionaryWord;
    EditText inputLingoWord;
    TextView gpsLoc;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lingo);
 
        // Variables
        inputName = (EditText) findViewById(R.id.name);
        inputDictionaryWord = (EditText) findViewById(R.id.dictionaryWord);
        inputLingoWord = (EditText) findViewById(R.id.lingoWord);
        gpsLoc = (TextView) findViewById(R.id.gpsLoc);
        
        // Buttons
        Button btnNextScreen = (Button) findViewById(R.id.btnNextScreen);
        //Button btnHomeScreen = (Button) findViewById(R.id.btnHomeScreen);
        Button btnLingoList = (Button) findViewById(R.id.btnLingoList);
        Button btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        
        
        /* Button to display current location */
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view) {
        		LocationManager mlocManager = null;
        		LocationListener mlocListener;
        		mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        		mlocListener = new lingo_location_listener();
        		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
        		
        		if(mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
        			if(lingo_location_listener.latitude>0) {
        				gpsLoc.setText("Latitude:- " + lingo_location_listener.latitude +
        								"    Longitude:- " + lingo_location_listener.longitude);
        			}
        			else
        			{
        				
        			}
        		} else {
        			gpsLoc.setText("GPS is not turned on...");
        			}
        	}
        });
        
        /* Button to submit Lingo entry */
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View btnNextScreen) {
            	
                // Create Intent to confirm screen
                Intent nextScreen = new Intent(getApplicationContext(), add_lingo_confirm.class);
                
                // Create Intent to lingo_list screen
                //Intent listScreen = new Intent(getApplicationContext(), lingo_list.class);
                
                // Sending data to confirm screen
                nextScreen.putExtra("Username", inputName.getText().toString());
                nextScreen.putExtra("DictionaryWord", inputDictionaryWord.getText().toString());
                nextScreen.putExtra("LingoWord", inputLingoWord.getText().toString());
                
                // Send data to list screen
                //listScreen.putExtra("Username", inputName.getText().toString());
                //listScreen.putExtra("DictionaryWord", inputDictionaryWord.getText().toString());
                //listScreen.putExtra("LingoWord", inputLingoWord.getText().toString());
 
                //Debug Statement
                Log.e("n", inputName.getText()+"."+ inputDictionaryWord.getText()+"."+ inputLingoWord.getText());
 
                startActivity(nextScreen);
                //startActivity(listScreen);
            }
        });
        
        
        /* Button to visit Lingo List */
        btnLingoList.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View btnLingoList) {
        		Intent lingoList = new Intent(getApplicationContext(), lingo_list.class);
        		startActivity(lingoList);
        	}
        });
        

        
    }
}