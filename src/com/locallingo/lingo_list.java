package com.locallingo;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class lingo_list extends ListActivity {

	private ProgressDialog m_ProgressDialog = null;
	private ArrayList<Lingo> s_lingos = null;
	private LingoAdapter m_adapter;
	Runnable viewLingos;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lingo_list);
		s_lingos = new ArrayList<Lingo>();
		this.m_adapter = new LingoAdapter(this, R.layout.row, s_lingos);
		setListAdapter(this.m_adapter);
	
		//ListView listView1 = (ListView) findViewById(R.id.listView1);
		//Lingo[] items = { 
		//      new Lingo("Damo", "Sprinkles", "Jimmys", 6,25), 
		//        new Lingo("Funboat", "Kauaian", "Kauai Native", 15, 29),
		//};
		//ArrayAdapter<Lingo> adapter = new ArrayAdapter<Lingo>(this,
		//            android.R.layout.simple_list_item_1, items);
		// 
		//listView1.setAdapter(adapter);
      
	
		/* 
		 * FUNCTIONS TO DOWNLOAD SERVER INFO 
		 */
			
			viewLingos = new Runnable() {
				public void run() {
					getLingos();				
				}
			};
		
			Thread thread = new Thread(null, viewLingos, "MagnetoBackground");
				thread.start();
				m_ProgressDialog = ProgressDialog.show(lingo_list.this, 
						"Hold your horses...", "PG did not code this...", true);
	}

	
	private Runnable returnRes = new Runnable() {
		
		public void run() {
			if(s_lingos != null && s_lingos.size() > 0) {
				m_adapter.notifyDataSetChanged();	
				for(int i=0; i < s_lingos.size(); i++) 
				m_adapter.add(s_lingos.get(i));
			}
				m_ProgressDialog.dismiss();
				m_adapter.notifyDataSetChanged();
		}
	};	
		
	private void getLingos(){
		try{
			s_lingos = new ArrayList<Lingo>();
			
			Lingo L1 = new Lingo();
			L1.setName("Damo");
			L1.setDLingo("Sprinkles");
			L1.setLLingo("Jimmys");
			L1.setLong(6);
			L1.setLatt(25);
			
			Lingo L2 = new Lingo();
			L2.setName("Josh");
			L2.setDLingo("Time And Relative Dimension In Space");
			L2.setLLingo("TARDIS");
			L2.setLong(8);
			L2.setLatt(20);
			
			Lingo L3 = new Lingo("Karlo", "Programming God aka Christian Damo", "PG", 12,45);
			Lingo L4 = new Lingo("Josh", "Bolo King aka Karlo Andrada", "BK", 12,45);
			Lingo L5 = new Lingo("Karlo", "Probability God aka Ryan Kim", "Prob G", 3,43);
			Lingo L6 = new Lingo("Damo", "The Real Brian, Brian Oshiro", "TRB", 4,29);
			Lingo L7 = new Lingo("Damo", "The Fake Brian, Aaron Ohta", "TFB", 5,21);
			
			s_lingos.add(L1);
			s_lingos.add(L2);
			s_lingos.add(L3);
			s_lingos.add(L4);
			s_lingos.add(L5);
			s_lingos.add(L6);
			s_lingos.add(L7);
			
			Thread.sleep(2000);
			Log.i("ARRAY", "" + s_lingos.size());
			}
		catch(Exception e) {
			Log.e("BACKGROUND_PROC", e.getMessage());
		}
		runOnUiThread(returnRes);
	}
	
	public class LingoAdapter extends ArrayAdapter<Lingo> {
		
		public LingoAdapter(Context context, int textViewResourceId, ArrayList<Lingo> items) {
			super(context, textViewResourceId, items);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if(v == null) {
				LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.row, null);
			}
			Lingo o = getItem(position);
			if(o != null) {
				TextView tt = (TextView) v.findViewById(R.id.toptext);
				TextView mt = (TextView) v.findViewById(R.id.midtext);
				TextView bt = (TextView) v.findViewById(R.id.bottomtext);
				
				if(tt != null) {
					tt.setText(o.getLLingo() ); 
				}
				if(mt != null) { 
					mt.setText("'" + o.getDLingo() + "'");
				}
				if(bt != null) { 
					bt.setText("Submitted by " + o.getName() + " at location [" + o.getLong() + "," + o.getLatt() + "]");
				}
		
				}
			return v;
		}
	}
	
	
	
      
	
	
    }
