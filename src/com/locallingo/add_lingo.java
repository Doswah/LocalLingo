package com.locallingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 
public class add_lingo extends Activity {
	
    // Initializing variables
    EditText inputName;
    EditText inputDictionaryWord;
    EditText inputLingoWord;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lingo);
 
        inputName = (EditText) findViewById(R.id.name);
        inputDictionaryWord = (EditText) findViewById(R.id.dictionaryWord);
        inputLingoWord = (EditText) findViewById(R.id.lingoWord);
        Button btnNextScreen = (Button) findViewById(R.id.btnNextScreen);
        //Button btnHomeScreen = (Button) findViewById(R.id.btnHomeScreen);
        Button btnLingoList = (Button) findViewById(R.id.btnLingoList);

        //Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View btnNextScreen) {
            	
                //Starting an Intent to confirm screen
                Intent nextScreen = new Intent(getApplicationContext(), add_lingo_confirm.class);
 
                //Sending data to confirm screen
                nextScreen.putExtra("Username", inputName.getText().toString());
                nextScreen.putExtra("DictionaryWord", inputDictionaryWord.getText().toString());
                nextScreen.putExtra("LingoWord", inputLingoWord.getText().toString());
 
                //Debug Statement
                Log.e("n", inputName.getText()+"."+ inputDictionaryWord.getText()+"."+ inputLingoWord.getText());
 
                startActivity(nextScreen);
            }
        });
        
        btnLingoList.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View btnLingoList) {
        		Intent lingoList = new Intent(getApplicationContext(), lingo_list.class);
        		startActivity(lingoList);
        	}
        });
        

        
    }
}