package com.example.pactconsumer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class PactConsumerControllerTests {

	private String url = "http://localhost:8005";
	Logger log = Logger.getLogger(PactConsumerApplication.class.getName());

	@Test
	public void testGetForObjectString() {
		String entity = new RestTemplate().getForObject(url + "/Song", String.class);
		log.info("getForObjectString() Returned: " + entity);
		assertTrue("getForObjectString()", entity.contains("Mysterious Ways"));
	}

	@Test
	public void testGetForObjectSong() {

		PactConsumerSong song = new RestTemplate().getForObject(url + "/Song", PactConsumerSong.class);
		log.info("getForObjectSong() Returned: " + song.getTitle());
		assertTrue("getForObjectSong()", song.getTitle().equals("Mysterious Ways"));
	}

	@Test
	public void testGetForObjectSongList() {
		PactConsumerSong[] songs = new RestTemplate().getForObject(url + "/Songs", PactConsumerSong[].class);
		log.info("GetForObjectSongList() Returned: " + songs[0].getTitle());
		assertTrue("GetForObjectSongList()", songs[0].getTitle().equals("Prologue (If I Ever Lose My Faith in You)"));
	}

	@Test
	public void testGetForObjectAlbum() {
		PactConsumerAlbum album = new RestTemplate().getForObject(url + "/Album", PactConsumerAlbum.class);
		log.info("GetForObjectAlbum() Returned: " + album.getSong(8).getTitle());
		assertTrue("", album.getSong(8).getTitle().equals("Mysterious Ways"));
	}

	@Test
	public void testGetForObjectAlbumList() {
		PactConsumerAlbum[] albums = new RestTemplate().getForObject(url + "/Albums", PactConsumerAlbum[].class);
		log.info("GetForObjectAlbumList() Returned: " + albums[1].getSong(8).getTitle());
		assertTrue("GetForObjectAlbumList()", albums[1].getSong(8).getTitle().equals("Mysterious Ways"));
	}

	@Test
	public void testGetForObjectNull() {
		PactConsumerAlbum[] albums = new RestTemplate().getForObject(url + "/Albums", PactConsumerAlbum[].class);
		assertNull("GetForObjectAlbumList()", albums[2].getSongs());
	}
}