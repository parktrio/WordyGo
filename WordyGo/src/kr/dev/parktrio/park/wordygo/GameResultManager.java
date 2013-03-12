package kr.dev.parktrio.park.wordygo;

public class GameResultManager {
	
	private int combo = 0;
	private int maxCombo = 0;
	private ScoreManager scoreMgr;
	
	GameResultManager() {
		scoreMgr = new ScoreManager();
	}

	public void adjustGameResult( GameResultState result ) {
		switch ( result ) {
		case GAME_RESULT_STATE_CORRECT:
			combo++;
			break;
		case GAME_RESULT_STATE_INCORRECT:
			maxCombo = combo > maxCombo ? combo : maxCombo;
			combo = 0;
			break;
		}
	}

	public int getCombo() {
		return combo;
	}

	public int getMaxCombo() {
		return maxCombo;
	}

	public int getScore() {
		return scoreMgr.getTotalScore();
	}

}

class ScoreManager {

	private final int UNIT_SCORE = 100;
	private int totalScore = 0;

	public void adjustGameResult( int combo ) {
		int score = UNIT_SCORE * combo;
		
		totalScore += score;
	}
	
	public int getTotalScore() {
		return totalScore;
	}

}
