package com.xoriant.companymanagementapp;

public enum Band {

	LEVEL1(2, 30), LEVEL2(4, 40), LEVEL3(6, 50), LEVEL4(8, 65);

	private int band;
	private int percentage;

	Band(int band, int percentage) {
		this.band = band;
		this.percentage = percentage;
	}

	public int getBand() {
		return band;
	}

	public void setBand(int band) {
		this.band = band;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	

	public static double getPercentage(int band) {

		for (Band eBand : Band.values()) {
			if (band <= eBand.band) {
				return eBand.percentage;
			}
		}

		return LEVEL4.percentage;
	}

	public static void main(String[] args) {
		
		System.out.println(getPercentage(1));
	}
}