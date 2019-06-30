package com.spring.model;

public enum Genero {
	H('h'),
	M('m');
	
	private static final long serialVersionUID = 1L;
	private final Character charGenero;
	
	private Genero(Character charGenero) {
       this.charGenero = charGenero;
	}

	public Character getCharGenero() {
		return charGenero;
	}
}
