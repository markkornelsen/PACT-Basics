package com.example.pactprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PactProviderController {

	@RequestMapping("/Greeting")
	public String greeting() {
		return "You've found the Songs and Albums service";
	}
	
	@RequestMapping("/Song")
	public PactProviderSong Song() {
		return new PactProviderSong("Mysterious Ways", 4);
	}

	@RequestMapping("/Songs")
	public List<PactProviderSong> Songs() {
		List<PactProviderSong> songs = new ArrayList<PactProviderSong>();
		songs.add(new PactProviderSong("Prologue (If I Ever Lose My Faith in You)", 1));
		songs.add(new PactProviderSong("Fields of Gold", 2));
		songs.add(new PactProviderSong("One", 3));
		songs.add(new PactProviderSong("Mysterious Ways", 4));
		return songs;
	}

	@RequestMapping("/Album")
	public PactProviderAlbum Album() {

		PactProviderAlbum u2Album = new PactProviderAlbum("Achtung Baby", 1991);

		u2Album.addSong(new PactProviderSong("One", 3));
		u2Album.addSong(new PactProviderSong("Mysterious Ways", 8));

		return u2Album;
	}
	
	@RequestMapping("/Albums")
	public List<PactProviderAlbum> Albums() {

		PactProviderAlbum stingAlbum = new PactProviderAlbum("Ten Summoner's Tales", 1993);
		PactProviderAlbum u2Album = new PactProviderAlbum("Achtung Baby", 1991);
		PactProviderAlbum joeAlbum = new PactProviderAlbum("Ain't got no songs", 1984);

		stingAlbum.addSong(new PactProviderSong("Prologue (If I Ever Lose My Faith in You)", 1));
		stingAlbum.addSong(new PactProviderSong("Fields of Gold", 3));
		u2Album.addSong(new PactProviderSong("One", 3));
		u2Album.addSong(new PactProviderSong("Mysterious Ways", 8));

		List<PactProviderAlbum> albums = new ArrayList<PactProviderAlbum>();
		albums.add(stingAlbum);
		albums.add(u2Album);
		albums.add(joeAlbum);
		return albums;
	}
}
