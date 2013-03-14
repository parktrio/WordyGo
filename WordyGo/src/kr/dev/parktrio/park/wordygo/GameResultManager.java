package kr.dev.parktrio.park.wordygo;

public class GameResultManager {
	
	private int combo = 0;
	private int maxCombo = 0;
	private int defaultMps = 1;
	private int currentMps = 1;
	private int maxMps = 1;
	private int distance = 0;
	private ScoreManager scoreMgr;
	
	GameResultManager() {
		scoreMgr = new ScoreManager();
	}

	public void adjustGameResult( GameResultState result ) {
		switch ( result ) {
		case GAME_RESULT_STATE_CORRECT:
			combo++;
			currentMps = defaultMps + ( combo / 5 );
			maxCombo = combo > maxCombo ? combo : maxCombo;
			maxMps = currentMps > maxMps ? currentMps : maxMps;
			break;
		case GAME_RESULT_STATE_INCORRECT:
			maxCombo = combo > maxCombo ? combo : maxCombo;
			maxMps = currentMps > maxMps ? currentMps : maxMps;
			combo = 0;
			currentMps = defaultMps;
			break;
		}
	}
	
	public int getMps() {
		return currentMps;
	}
	
	public int getDistance() {
		return distance;
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
