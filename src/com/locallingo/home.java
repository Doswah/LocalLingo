package com.locallingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        Button btnHomeLingoList = (Button) findViewById(R.id.btnHomeLingoList);
        Button btnHomeAddLingo = (Button) findViewById(R.id.btnHomeAddLingo);
        
        btnHomeLingoList.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View btnLingoList) {
        		Intent lingoList = new Intent(getApplicationContext(), lingo_list.class);
        		startActivity(lingoList);
        	}
        });

        btnHomeAddLingo.setOnClickListener(new View.OnClickListener() {
	
        	public void onClick(View btnLingoList) {
        		Intent add_lingo = new Intent(getApplicationContext(), add_lingo.class);
        		startActivity(add_lingo);
        	}
        });

    }
}
