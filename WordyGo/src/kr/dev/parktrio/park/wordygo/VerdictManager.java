package kr.dev.parktrio.park.wordygo;

public class VerdictManager {

	private int currentIndex = 0;
	private int maxIndex = 0;
	private VerdictState currentState = VerdictState.VERDICT_STATE_NONE;
	private String[] characters = null;

	public void setWord( String[] characters ) {
		reset();
		this.characters = characters;
		maxIndex = characters.length - 1;
	}

	public void reset() {
		characters = null;
		currentIndex = 0;
		maxIndex = 0;
		currentState = VerdictState.VERDICT_STATE_IN_PROCESS;
	}

	public VerdictState doVerdict( String selected ) {
		if ( characters == null ||
				currentState == VerdictState.VERDICT_STATE_CORRECT_FINISH ||
				currentState == VerdictState.VERDICT_STATE_NONE ) {
			return VerdictState.VERDICT_STATE_ERROR;
		}

		if ( !characters[ currentIndex ].equals( selected ) ) {
			currentState = VerdictState.VERDICT_STATE_IN_PROCESS;
			currentIndex = 0;

			return VerdictState.VERDICT_STATE_INCORRECT_FINISH;
		}

		if ( currentIndex == maxIndex )	{
			currentState = VerdictState.VERDICT_STATE_CORRECT_FINISH;
		}
		
		currentIndex++;

		return currentState;
	}
}
