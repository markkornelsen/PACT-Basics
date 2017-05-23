package com.example.pactprovider;

public class PactProviderSong {
	private String title;
	private int number;

	public PactProviderSong() {
	}

	public PactProviderSong(String title, int number) {
		this.title = title;
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public String getTitle() {
		return this.title;
	}

	public void setNumber(int year) {
		this.number = year;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
