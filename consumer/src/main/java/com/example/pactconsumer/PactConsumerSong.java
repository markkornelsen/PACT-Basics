package com.example.pactconsumer;

public class PactConsumerSong {
	private String title;
	private int number;

	public PactConsumerSong() {
	}

	public PactConsumerSong(String title, int number) {
		this.title = title;
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public String getTitle() {
		return this.title;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PactConsumerSong pactConsumerSong = (PactConsumerSong) o;

		if (number != pactConsumerSong.number)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return number;
	}
}
