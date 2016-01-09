package br.com.bluesoft.restaurante.utils;

public class Match {

	private int sideA;
	private int sideB;

	public Match(int sideA, int sideB) {
		this.setSideA(sideA);
		this.setSideB(sideB);
	}

	public int getSideA() {
		return sideA;
	}

	public void setSideA(int sideA) {
		this.sideA = sideA;
	}

	public int getSideB() {
		return sideB;
	}

	public void setSideB(int sideB) {
		this.sideB = sideB;
	}

}
