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

	public void initialize() {
		wordOfLevel1 = wordFactory.makeWordsForLevel1();
		// TODO
	}

	public void start() {
		// TODO
		//int index = rand.nextInt( wordOfLevel1.length );
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
	}

	public void restart() {
	
	}

	public void end() {
		// TODO
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

	public GameResultManager getResultManager() {
		return gameResultMgr;
	}

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
}
