package kr.dev.parktrio.park.wordygo;

import java.util.Random;

public class Shuffle {

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
	
}
