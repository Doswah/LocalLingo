package com.locallingo;

public class Lingo {
	private String Name;
	private String D_Lingo;
	private String L_Lingo;
	private int longitude;
	private int lattitude;
	
	public Lingo() {
		super();
	}

	public Lingo(String Name, String D_Lingo, String L_Lingo, int lattitude, int longitude) {
		super();
		this.Name = Name;
		this.D_Lingo = D_Lingo;
		this.L_Lingo = L_Lingo;
		this.longitude = longitude;
		this.lattitude = lattitude;
	}
	
	@Override
	public String toString() {
		return this.L_Lingo + " - " + this.D_Lingo + "  (submitted by " + this.Name + ")";
	}
	
	
	// Accessors
	public String getName() {
		return Name;
	}
	
	public String getDLingo() {
		return D_Lingo;
	}
	
	public String getLLingo() {
		return L_Lingo;
	}
	
	public int getLong() {
		return longitude;
	}
	
	public int getLatt() {
		return lattitude;
	}
	
	// Mutators
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setDLingo(String D_Lingo) {
		this.D_Lingo = D_Lingo;
	}
	
	public void setLLingo(String L_Lingo) {
		this.L_Lingo = L_Lingo;
	}
	
	public void setLong(int longitude) {
		this.longitude = longitude;
	}
	
	public void setLatt(int lattitude) {
		this.lattitude = lattitude;
	}
	
	
	
	
}
