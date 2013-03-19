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
		
		switch( characterLength ) {
		case 4:
			result = getIndexFor4();
			break;
		case 5:
			result = getIndexFor5();
			break;
		case 6:
			result = getIndexFor6();
			break;
		case 7:
			result = getIndexFor7();
			break;
		case 8:
			result = getIndexFor8();
			break;
		case 9:
			result = getIndexFor9();
			break;
		}
		
		return result;
	}

	private int getIndexFor4() {
		int index = rand.nextInt( ITEM_INDEX_LENGHT_4 );
		
		switch ( index ) {
		case 4:
			index = 5;
			break;
		case 5:
			index = 7;
			break;
		case 6:
			index = 10;
			break;
		}
		
		return index;
	}

	private int getIndexFor5() {
		int index = rand.nextInt( ITEM_INDEX_LENGHT_5 );
		
		switch ( index ) {
		case 4:
			index = 7;
			break;
		case 5:
			index = 10;
			break;
		}
		
		return index;
	}
	
	private int getIndexFor6() {
		int index = rand.nextInt( ITEM_INDEX_LENGHT_6 );
		
		switch ( index ) {
		case 0:
			index = 5;
			break;
		case 1:
			index = 7;
			break;
		case 2:
			index = 8;
			break;
		case 3:
			index = 9;
			break;
		case 4:
			index = 10;
			break;
		}
		
		return index;
	}
	
	private int getIndexFor7() {
		int index = rand.nextInt( ITEM_INDEX_LENGHT_7 );
		
		switch ( index ) {
		case 0:
			index = 7;
			break;
		case 1:
			index = 8;
			break;
		case 2:
			index = 9;
			break;
		case 3:
			index = 10;
			break;
		}

		return index;
	}
	
	private int getIndexFor8() {
		int index = rand.nextInt( ITEM_INDEX_LENGHT_8 );
		
		switch ( index ) {
		case 0:
			index = 7;
			break;
		case 1:
			index = 8;
			break;
		case 2:
			index = 10;
			break;
		}

		return index;
	}
	
	private int getIndexFor9() {
		int index = rand.nextInt( ITEM_INDEX_LENGHT_9 );
		
		switch ( index ) {
		case 0:
			index = 7;
			break;
		case 1:
			index = 10;
			break;
		}

		return index;
	}
}
