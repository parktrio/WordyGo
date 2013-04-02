package kr.dev.parktrio.park.wordygo;

import java.util.Random;

public final class Utility {
	
	private static String characterSet = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎㄲㄸㅃㅆㅉㄳㄵㄶㄺㄻㄼㄽㄾㄿㅀㅄㅏㅑㅓㅕㅗㅛㅜㅠㅡㅣㅐㅒㅔㅖㅘㅙㅚㅝㅞㅟㅢ";

	public static int stringToMotion( String str ) {
		int result;

		result = characterSet.indexOf( str ) + 1;
		
		return result;
	}
	
	public static String[] stringToStringArray( String str ) {
		String[] result = new String[ str.length() ];

		for ( int i = 0; i < str.length(); i++ ) {
			result[ i ] = Character.toString( str.charAt( i ) );
		}
		
		return result;
	}
	
	public static String[] shuffleStrings( String[] str ) {
		int MAX_SIZE = str.length;
		int[] randomIndex = getRandomIndex( MAX_SIZE );
		String[] arrayString = new String[ MAX_SIZE ];

		for ( int i = 0; i < MAX_SIZE; i++ ) {
			arrayString[ i ] = str[ randomIndex[i] ];
		}

		return arrayString;
	}

	private static int[] getRandomIndex( int size ) {
		int[] result = new int[ size ];
		int index = 0;
		
		for (int i = 0; i < size; i++) {
			result[ i ]=i;
		}
		
		while( index != size ){
			int rnd = rangeRandom( index, size - 1 );
			int tmp = result[ index ];
			result[ index ] = result[ rnd ];
			result[ rnd ] = tmp;
			index++;
		}
		
		return result;
	}

	private static int rangeRandom( int n1, int n2 ) {
		Random rand = new Random();
		int result = rand.nextInt( ( n2 - n1 ) + 1 );
		return result + n1;
	}
/*
	public static String[] shuffleStrings( String[] str ) {
		int MAX_SIZE = str.length;
		String[] arrayString = new String[ MAX_SIZE ];
		arrayString = str;

		Random rand = new Random();
		String tmp;

		for ( int i = 0; i < MAX_SIZE; i++ ) {
			int index = rand.nextInt( MAX_SIZE );
			if ( i != index ) {
				tmp = arrayString[ index ];
				arrayString[ index ] = arrayString[ i ];
				arrayString[ i ] = tmp;
			}
		}

		return arrayString;
	}
*/
}
