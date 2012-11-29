package com.locallingo;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class lingo_location_listener implements LocationListener{

	public static double latitude;
    public static double longitude;
    
    public void onLocationChanged(Location loc) {
    	loc.getLatitude();
    	loc.getLongitude();
    	latitude=loc.getLatitude();
    	longitude=loc.getLongitude();
    }
    
    public void onProviderDisabled(String provider){
    	// GPS is Disabled, create toast
    }
    
    public void onStatusChanged(String provider, int status, Bundle extras) {
    	// TO-DO
    }

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}
}
