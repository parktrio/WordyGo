package kr.dev.parktrio.park.wordygo;

public class Word {
	private String[] characters = null; // { "ㅌ", "ㅔ", "ㅅ", "ㅡ", "ㅌ", "ㅡ" }
	private String expression = null; // "테스트"
	private int numberOfCharacters = 0;

	Word( String expr, String[] chars ) {
		expression = expr;
		characters = new String[ chars.length ];
		characters = chars;
		numberOfCharacters = chars.length;
	}

	public String getExpression() {
		return expression;
	}

	public String[] getWordUnit() {
		return characters;
	}
	
	public int getNumberOfCharacters() {
		return numberOfCharacters;
	}
}
