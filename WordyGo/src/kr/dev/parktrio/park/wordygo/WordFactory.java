package kr.dev.parktrio.park.wordygo;

import java.util.ArrayList;
import java.util.Random;

import android.database.Cursor;



public class WordFactory {

	private final int MAX_LENGTH = 50;

	public Word[] makeWordsForLevel1() {
		TableWrapperLevelXX tableLevel01 = new TableWrapperLevelXX(1);
		Cursor tableLevelCursor = tableLevel01.selectData();
		Word[] originWordList = this.tableLevelCursorToWordArray(tableLevelCursor);
		tableLevelCursor.close();

		Word[] wordList = this.getRandomWords(originWordList);

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

	private Word[] tableLevelCursorToWordArray(Cursor tableLevelCursor) {
		ArrayList<Word> result = new ArrayList<Word>();

		if (tableLevelCursor.moveToFirst())
		{
			do
			{
				String expression = tableLevelCursor.getString(tableLevelCursor.getColumnIndex(TableWrapperLevelXX.Columns.EXPRESSION.getName()));
				String characters = tableLevelCursor.getString(tableLevelCursor.getColumnIndex(TableWrapperLevelXX.Columns.CHARACTERS.getName()));

				result.add(new Word(expression, Utility.stringToStringArray(characters)));
			} while (tableLevelCursor.moveToNext());
		}

		Word[] returnType = new Word[0];
		return result.toArray(returnType);
	}

	private Word[] getRandomWords(Word[] originWordList) {
		Random random = new Random();
		ArrayList<Word> result = new ArrayList<Word>();
		for ( int i = 0; i < MAX_LENGTH && i < originWordList.length ; i++ ) {
			int randomIndex = random.nextInt(originWordList.length);
			if (originWordList[randomIndex] == null)
			{
				i--;
				continue;
			}

			result.add(originWordList[randomIndex]);
			originWordList[randomIndex] = null;
		}

		Word[] returnType = new Word[0];
		return result.toArray(returnType);
	}


}
