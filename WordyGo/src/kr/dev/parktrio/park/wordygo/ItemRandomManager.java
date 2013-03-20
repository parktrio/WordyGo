package kr.dev.parktrio.park.wordygo;

import java.util.Random;

public class ItemRandomManager {
	
	private final int ITEM_TYPES = 3;
	private final int ITEM_INDEX_LENGHT_4 = 7;
	private final int ITEM_INDEX_LENGHT_5 = 6;
	private final int ITEM_INDEX_LENGHT_6 = 5;
	private final int ITEM_INDEX_LENGHT_7 = 4;
	private final int ITEM_INDEX_LENGHT_8 = 3;
	private final int ITEM_INDEX_LENGHT_9 = 2;
	private Random rand;
	
	ItemRandomManager() {
		rand = new Random();
	}

	public RandomGameItem getItem( int characterLength ) {
		RandomGameItem item = null;

		if ( rand.nextInt( 5 ) == 0 ) {
			item  = new RandomGameItem( getRandomType(), getRandomIndex( characterLength ) );
		}

		return item;
	}

	private GameItemType getRandomType() {
		GameItemType type = GameItemType.GAME_ITEM_TYPE_NONE;
		switch ( rand.nextInt( ITEM_TYPES ) ) {
		case 0:
			type = GameItemType.GAME_ITEM_TYPE_SELECT_AGAIN;
			break;
		case 1:
			type = GameItemType.GAME_ITEM_TYPE_TIEM_STOP;
			break;
		case 2:
			type = GameItemType.GAME_ITEM_TYPE_WORD_PASS;
			break;
		}
		return type;
	}

	private int getRandomIndex( int characterLength ) {
		int result = -1;
		int[] buttonState = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int length = 0;

		switch( characterLength ) {
		case 4:
			buttonState = ButtonState.character4;
			length = ITEM_INDEX_LENGHT_4;
			break;
		case 5:
			buttonState = ButtonState.character5;
			length = ITEM_INDEX_LENGHT_5;
			break;
		case 6:
			buttonState = ButtonState.character6;
			length = ITEM_INDEX_LENGHT_6;
			break;
		case 7:
			buttonState = ButtonState.character7;
			length = ITEM_INDEX_LENGHT_7;
			break;
		case 8:
			buttonState = ButtonState.character8;
			length = ITEM_INDEX_LENGHT_8;
			break;
		case 9:
			buttonState = ButtonState.character9;
			length = ITEM_INDEX_LENGHT_9;
			break;
		}
		
		int index = rand.nextInt( length );
		int check = 0;
		for ( int i = 0; i < buttonState.length; i++ ) {
			if ( buttonState[ i ] == 0 ) {
				if ( index == check ) {
					result = i;
					break;
				}
				check++;
			}
		}
		
		return result;
	}
}
