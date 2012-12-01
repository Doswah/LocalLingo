package com.locallingo;

import java.net.URI;
import com.locallingo.R;
import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;
import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("NewApi")
public class add_lingo extends Activity {

	// Initializing variables
	EditText inputName;
	EditText inputDictionaryWord;
	EditText inputLingoWord;
	String name;
	String definition;
	String word;
	TextView gpsLoc;
	Object i;
	Object wow;
	Double x,y;
	// Client Declare
	private XMLRPCClient client;
	private URI myuri;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_lingo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
		// Variables
		inputName = (EditText) findViewById(R.id.name);
		inputDictionaryWord = (EditText) findViewById(R.id.dictionaryWord);
		inputLingoWord = (EditText) findViewById(R.id.lingoWord);
		gpsLoc = (TextView) findViewById(R.id.gpsLoc);

		myuri = URI.create("http://76.88.182.148:8000");
		client = new XMLRPCClient(myuri);

		
		// Buttons
		final Button btnNextScreen = (Button) findViewById(R.id.btnNextScreen);
		Button btnLingoList = (Button) findViewById(R.id.btnLingoList);
		Button btnShowLocation = (Button) findViewById(R.id.btnShowLocation);

		/* Button to display current location */
		btnShowLocation.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				LocationManager mlocManager = null;
				LocationListener mlocListener;
				mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				mlocListener = new lingo_location_listener();
				mlocManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

				if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					if (lingo_location_listener.latitude != 0) {
						gpsLoc.setText("Latitude:=>  "
								+ lingo_location_listener.latitude
								+ "    Longitude:=>  "
								+ lingo_location_listener.longitude);
					} else {

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
				Intent nextScreen = new Intent(getApplicationContext(),
						add_lingo_confirm.class);

				// Create Intent to lingo_list screen
				// Intent listScreen = new Intent(getApplicationContext(),
				// lingo_list.class);

				// Sending data to confirm screen
				try {
					LocationManager mlocManager = null;
					LocationListener mlocListener;
					mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
					mlocListener = new lingo_location_listener();
					mlocManager.requestLocationUpdates(
							LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
					x = lingo_location_listener.latitude;
					y = lingo_location_listener.longitude;
					name = inputName.getText().toString();
					definition = inputDictionaryWord.getText().toString();
					word = inputLingoWord.getText().toString();
					client.call("put_word",x,y,word,definition,name);
				} catch (XMLRPCException ex) {

				}
				
				nextScreen.putExtra("Username", name);
				nextScreen.putExtra("DictionaryWord", definition);
				nextScreen.putExtra("LingoWord", word);

				// Send data to list screen
				// listScreen.putExtra("Username",
				// inputName.getText().toString());
				// listScreen.putExtra("DictionaryWord",
				// inputDictionaryWord.getText().toString());
				// listScreen.putExtra("LingoWord",
				// inputLingoWord.getText().toString());

				// Debug Statement
				Log.e("n",
						inputName.getText() + "."
								+ inputDictionaryWord.getText() + "."
								+ inputLingoWord.getText());

				startActivity(nextScreen);
				// startActivity(listScreen);
			}
		});

		/* Button to visit Lingo List */
		btnLingoList.setOnClickListener(new View.OnClickListener() {

			public void onClick(View btnLingoList) {
				Intent lingoList = new Intent(getApplicationContext(),
						lingo_list.class);
				startActivity(lingoList);
			}
		});

	}
}

// jimmywashere

