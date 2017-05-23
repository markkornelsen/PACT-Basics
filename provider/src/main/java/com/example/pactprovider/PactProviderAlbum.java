package com.example.pactprovider;

import java.util.ArrayList;
import java.util.List;

public class PactProviderAlbum {
	private List<PactProviderSong> songs;
	private String title;
	private int year;

	public PactProviderAlbum() {
	}

	public PactProviderAlbum(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public String getTitle() {
		return this.title;
	}

	public List<PactProviderSong> getSongs() {
		return this.songs;
	}

	public PactProviderSong getSong(int songNumber) {
		for (PactProviderSong song : this.songs) {
			if (song != null && song.getNumber() == songNumber) {
				return song;
			}
		}
		return null;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addSong(PactProviderSong song) {
		if (this.songs == null) {
			this.songs = new ArrayList<PactProviderSong>();
		}
		this.songs.add(song);
	}
}