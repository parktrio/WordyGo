package kr.dev.parktrio.park.wordygo;

public class Word {
	private String[] characters = null; // { "��", "��", "��", "��", "��", "��" }
	private String expression = null; // "�׽�Ʈ"

	
	
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
