package com.example.pactconsumer;

import java.util.ArrayList;
import java.util.List;

public class PactConsumerAlbum {
	private List<PactConsumerSong> songs;
	private String title;
	private int year;

	public PactConsumerAlbum() {
	}

	public PactConsumerAlbum(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public String getTitle() {
		return this.title;
	}

	public List<PactConsumerSong> getSongs() {
		return this.songs;
	}

	public PactConsumerSong getSong(int songNumber) {
		for (PactConsumerSong song : this.songs) {
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

	public void addSong(PactConsumerSong song) {
		if (this.songs == null) {
			this.songs = new ArrayList<PactConsumerSong>();
		}
		this.songs.add(song);
	}
}