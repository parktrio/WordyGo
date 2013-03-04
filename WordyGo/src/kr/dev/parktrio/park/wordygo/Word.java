package kr.dev.parktrio.park.wordygo;

public class Word {
	private String[] characters = null; // { "¤¼", "¤Ä", "¤µ", "¤Ñ", "¤¼", "¤Ñ" }
	private String expression = null; // "Å×½ºÆ®"

	
	
	Word( String expr, String[] chars ) {
		expression = expr;
		characters = new String[ chars.length ];
		characters = chars;
	}

	public String getExpression() {
		return expression;
	}

	public String[] getWordUnit() {
		return characters;
	}
}
