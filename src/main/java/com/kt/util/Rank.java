package com.kt.util;

public enum Rank {
	TRAINEE(1), 
	JUNIOR(2), 
	SENIOR(3), 
	INSPECTOR(4), 
	CHIEF_INSPECTOR(5);

	Rank(int code) {
		this.code = code;
	}
	private int code;
	
	public int getCode() {
		return code;
	}

}
