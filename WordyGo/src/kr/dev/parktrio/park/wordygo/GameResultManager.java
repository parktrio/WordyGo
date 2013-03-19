package kr.dev.parktrio.park.wordygo;

import android.os.Parcel;
import android.os.Parcelable;

public class GameResultManager implements Parcelable {
	
	private int combo = 0;
	private int maxCombo = 0;
	private int defaultMps = 10;
	private int currentMps = 10;
	private int maxMps = 1;
	private int distance = 0;
	//private ScoreManager scoreMgr;
	
	GameResultManager() {
		//scoreMgr = new ScoreManager();
	}

	GameResultManager( Parcel in ) {
		readFromParcel( in );
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt( combo );
		dest.writeInt( maxCombo );
		dest.writeInt( defaultMps );
		dest.writeInt( currentMps );
		dest.writeInt( maxMps );
		dest.writeInt( distance );
	}

	private void readFromParcel( Parcel in ) {
		combo = in.readInt();
		maxCombo = in.readInt();
		defaultMps = in.readInt();
		currentMps = in.readInt();
		maxMps = in.readInt();
		distance = in.readInt();
	}

	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public GameResultManager createFromParcel( Parcel in ) {
			return new GameResultManager( in );
		}
		public GameResultManager[] newArray( int size ) {
			return new GameResultManager[ size ];
		}
	};

	public void adjustGameResult( GameResultState result ) {
		switch ( result ) {
		case GAME_RESULT_STATE_CORRECT:
			combo++;
			currentMps = defaultMps + ( ( combo / 5 ) * 10 );
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

	public int getMaxMps() {
		return maxMps;
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

	//public int getScore() {
	//	return scoreMgr.getTotalScore();
	//}

	public void setDistance( int distance ) {
		this.distance = distance;
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
