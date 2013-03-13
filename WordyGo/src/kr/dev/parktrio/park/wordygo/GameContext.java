package kr.dev.parktrio.park.wordygo;

import java.util.Random;

import android.os.Handler;
import android.os.Message;

public class GameContext {
	
	private final int SET_WORD_TEXT = 1;
	private final int SET_BUTTON_TEXT = 2;
	private final int INCORRECT = 3;
	private final int CORRECT = 4;

	private VerdictManager verdictMgr;
	private GameResultManager gameResultMgr;
	private WordFactory wordFactory;
	private Random rand;
	private Handler activityHandler;

	private Word[] wordOfLevel1;

	private int index;

	GameContext( Handler handler ) {
		activityHandler = handler;
		verdictMgr = new VerdictManager();
		gameResultMgr = new GameResultManager();
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
		msg1.what = SET_WORD_TEXT;
		msg1.obj = wordOfLevel1[ index ].getExpression();

		activityHandler.sendMessage( msg1 );

		verdictMgr.setWord( wordOfLevel1[ index ].getWordUnit() );
		String[] shuffledStr = Utility.shuffleStrings( wordOfLevel1[ index ].getWordUnit() );
		
		Message msg2 = activityHandler.obtainMessage();
		msg2.what = SET_BUTTON_TEXT;
		msg2.obj = shuffledStr;

		activityHandler.sendMessage( msg2 );
	}
	
	public void restart() {
		
	}

	public void end() {
		// TODO
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
			msg1.what = INCORRECT;
			msg1.arg1 = 6;
			activityHandler.sendMessage( msg1 );
			break;
		case VERDICT_STATE_CORRECT_FINISH:
			this.index++;
			gameResultMgr.adjustGameResult( GameResultState.GAME_RESULT_STATE_CORRECT );

			Message msg2 = activityHandler.obtainMessage();
			msg2.what = CORRECT;
			msg2.arg1 = gameResultMgr.getCombo();
			activityHandler.sendMessage( msg2 );
			break;
		}
	}
}
