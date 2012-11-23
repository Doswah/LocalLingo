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
		return this.L_Lingo + " - " + this.D_Lingo + " (submitted by " + this.Name + ") ";
	}
}
