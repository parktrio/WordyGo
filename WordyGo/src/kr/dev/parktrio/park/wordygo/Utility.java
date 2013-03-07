package kr.dev.parktrio.park.wordygo;

public class Utility {
	public static String[] stringToStringArray( String str ) {
		String[] result = new String[ str.length() ];

		for ( int i = 0; i < str.length(); i++ ) {
			result[ i ] = Character.toString( str.charAt( i ) );
		}
		
		return result;
	}
}
