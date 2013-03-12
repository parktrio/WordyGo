package kr.dev.parktrio.park.wordygo;

public class WordFactory {

	private final int MAX_LENGTH = 50;
	
	public Word[] makeWordsForLevel1() {
		DatabaseManager dbMgr = DatabaseManager.getInstance();
		Word[] wordList = dbMgr.selectAll( "level1" );

		//Word[] wordList = new Word[ MAX_LENGTH ];
		
		for ( int i = 0; i < MAX_LENGTH; i++ ) {
		}

		return wordList;
	}

	public Word[] makeWordsForLevel2() {
		Word[] wordList = new Word[ MAX_LENGTH ];
		
		for ( int i = 0; i < MAX_LENGTH; i++ ) {
		}

		return wordList;
	}

	public Word[] makeWordsForLevel3() {
		Word[] wordList = new Word[ MAX_LENGTH ];
		
		for ( int i = 0; i < MAX_LENGTH; i++ ) {
		}

		return wordList;
	}

	public Word[] makeWordsForLevel4() {
		Word[] wordList = new Word[ MAX_LENGTH ];
		
		for ( int i = 0; i < MAX_LENGTH; i++ ) {
		}

		return wordList;
	}

	public Word[] makeWordsForLevel5() {
		Word[] wordList = new Word[ MAX_LENGTH ];
		
		for ( int i = 0; i < MAX_LENGTH; i++ ) {
		}

		return wordList;
	}
}
