package kr.dev.parktrio.park.wordygo;

import java.util.Random;

import android.os.Handler;
import android.os.Message;

public class GameContext {

	private VerdictManager verdictMgr;
	private GameResultManager gameResultMgr;
	private ItemRandomManager itemRandomMgr;
	private WordFactory wordFactory;
	private Random rand;
	private Handler activityHandler;
	private GameMain main;

	private Word[] wordOfLevel1;

	private int index;

	GameContext( Handler handler ) {
		activityHandler = handler;
		verdictMgr = new VerdictManager();
		gameResultMgr = new GameResultManager();
		itemRandomMgr = new ItemRandomManager();
		wordFactory = new WordFactory();
		rand = new Random();
		index = 0;
	}

	GameContext( GameMain gameMain) {
		activityHandler = null;
		main = gameMain;
		verdictMgr = new VerdictManager();
		gameResultMgr = new GameResultManager();
		itemRandomMgr = new ItemRandomManager();
		wordFactory = new WordFactory();
		rand = new Random();
		index = 0;
	}

	public void initialize() {
		wordOfLevel1 = wordFactory.makeWordsForLevel1();
		// TODO
	}

	public void start() {
		// TODO
		// test
		if ( activityHandler == null ) {
			main.setButton();
			return;
		}
		//int index = rand.nextInt( wordOfLevel1.length );
		/*
		Message msg1 = activityHandler.obtainMessage();
		msg1.what = MessageWhat.SET_WORD_TEXT;
		msg1.obj = wordOfLevel1[ index ].getExpression();
		activityHandler.sendMessage( msg1 );

		verdictMgr.setWord( wordOfLevel1[ index ].getWordUnit() );
		String[] shuffledStr = Utility.shuffleStrings( wordOfLevel1[ index ].getWordUnit() );

		Message msg2 = activityHandler.obtainMessage();
		msg2.what = MessageWhat.SET_BUTTON_TEXT;
		msg2.obj = shuffledStr;
		activityHandler.sendMessage( msg2 );

		RandomGameItem item = itemRandomMgr.getItem( wordOfLevel1[ index ].getWordUnit().length );
		if ( item != null ) {
			Message msg3 = activityHandler.obtainMessage();
			msg3.what = MessageWhat.RANDOM_ITEM;
			msg3.obj = item;
			activityHandler.sendMessage( msg3 );
		}
		*/
	}

	public void restart() {
	
	}

	public void end() {
		// TODO
	}
	
	public String getString() {
		return wordOfLevel1[ index ].getExpression();
	}
	
	public String[] getButtonString() {
		verdictMgr.setWord( wordOfLevel1[ index ].getWordUnit() );
		return Utility.shuffleStrings( wordOfLevel1[ index ].getWordUnit() );
	}
	
	public RandomGameItem getRandomItem() {
		return itemRandomMgr.getItem( wordOfLevel1[ index ].getWordUnit().length );
	}

	public int getMps() {
		return gameResultMgr.getMps();
	}

	public int getDistance() {
		return gameResultMgr.getDistance();
	}

	public void setDistance( int distance ) {
		gameResultMgr.setDistance( distance );
	}
	
	public int getCombo() {
		return gameResultMgr.getCombo();
	}

	public GameResultManager getResultManager() {
		return gameResultMgr;
	}
	
	public void selectCharacter( String character ) {
		VerdictState verdictState = verdictMgr.doVerdict( character );

		switch ( verdictState ) {
		case VERDICT_STATE_IN_PROCESS:
			break;
		case VERDICT_STATE_INCORRECT_FINISH:
			gameResultMgr.adjustGameResult( GameResultState.GAME_RESULT_STATE_INCORRECT );
			main.resetButton();
			main.currentCombo = 0;
			main.speed = 0.2f;
			break;
		case VERDICT_STATE_CORRECT_FINISH:
			this.index++;
			gameResultMgr.adjustGameResult( GameResultState.GAME_RESULT_STATE_CORRECT );
			main.currentCombo = gameResultMgr.getCombo();
			main.currentDistance += gameResultMgr.getCombo() * gameResultMgr.getMps();
			if ( main.speed < 2.5f ) main.speed += 0.1f;
			
			start();
			/*
			Message msg2 = activityHandler.obtainMessage();
			msg2.what = MessageWhat.CORRECT;
			msg2.arg1 = gameResultMgr.getCombo();
			msg2.arg2 = gameResultMgr.getCombo() * gameResultMgr.getMps();
			activityHandler.sendMessage( msg2 );
			*/
			break;
		}
	}
/*
	public void selectCharacter( String character ) {
		// TODO
		VerdictState verdictState = verdictMgr.doVerdict( character );

		switch ( verdictState ) {
		case VERDICT_STATE_IN_PROCESS:
			break;
		case VERDICT_STATE_INCORRECT_FINISH:
			gameResultMgr.adjustGameResult( GameResultState.GAME_RESULT_STATE_INCORRECT );

			Message msg1 = activityHandler.obtainMessage();
			msg1.what = MessageWhat.INCORRECT;
			activityHandler.sendMessage( msg1 );
			break;
		case VERDICT_STATE_CORRECT_FINISH:
			this.index++;
			gameResultMgr.adjustGameResult( GameResultState.GAME_RESULT_STATE_CORRECT );

			Message msg2 = activityHandler.obtainMessage();
			msg2.what = MessageWhat.CORRECT;
			msg2.arg1 = gameResultMgr.getCombo();
			msg2.arg2 = gameResultMgr.getCombo() * gameResultMgr.getMps();
			activityHandler.sendMessage( msg2 );
			break;
		}
	}
*/
}
