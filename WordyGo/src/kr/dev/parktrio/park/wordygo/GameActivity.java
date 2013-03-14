package kr.dev.parktrio.park.wordygo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends Activity implements OnClickListener {

	private final int MAX_BUTTON_COUNT = 9;
	private final String EMPTY_STRING = "";
	
	private final int SET_WORD_TEXT = 1;
	private final int SET_BUTTON_TEXT = 2;
	private final int INCORRECT = 3;
	private final int CORRECT = 4;
	private final int SET_TIME = 5;
	private final int SET_DISTANCE = 6;
	
	private TimeManager timeMgr;
	private Button[] arrayBtn;
	private int[] btnIDs;
	private GameContext gameContext;
	private TextView currentWord;
	private TextView combo;
	private TextView mps;
	private TextView distance;
	private ProgressBar progressBar;
	private ActivityHandler activityHandler;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_game );
		
		activityHandler = new ActivityHandler();

		gameContext = new GameContext( activityHandler );
		gameContext.initialize();
		gameContext.start();
		
		btnIDs = getButtonIDs();
		arrayBtn = getButtons();
		currentWord = ( TextView )findViewById( R.id.word );
		combo = ( TextView )findViewById( R.id.combo );
		mps = ( TextView )findViewById( R.id.mps );
		distance = ( TextView )findViewById( R.id.distance );
		progressBar = ( ProgressBar )findViewById( R.id.time );

		addEventListener();
		startTimeProgress();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		overridePendingTransition( R.anim.fade, R.anim.hold );
	}

	private void setWordForGame( String word ) {
		currentWord.setText( word );
	}
	
	private void setButtonText( String[] characters ) {
		switch ( characters.length ) {
		case 4:
			button4( characters );
			break;
		case 5:
			button5( characters );
			break;
		case 6:
			button6( characters );
			break;
		case 7:
			button7( characters );
			break;
		case 8:
			button8( characters );
			break;
		case 9:
			button9( characters );
			break;
		}
	}
	
	private void button4( String[] characters ) {
		int index = 0;
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			switch ( i ) {
			case 4:
			case 6:
			case 7:
			case 8:
				arrayBtn[ i ].setText( characters[ index ] );
				arrayBtn[ i ].setEnabled( true );
				index++;
				break;
			default:
				arrayBtn[ i ].setEnabled( false );
				arrayBtn[ i ].setText( EMPTY_STRING );
				break;
			}
		}
	}
	
	private void button5( String[] characters ) {
		int index = 0;
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			switch ( i ) {
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				arrayBtn[ i ].setText( characters[ index ] );
				arrayBtn[ i ].setEnabled( true );
				index++;
				break;
			default:
				arrayBtn[ i ].setEnabled( false );
				arrayBtn[ i ].setText( EMPTY_STRING );
				break;
			}
		}
	}
	
	private void button6( String[] characters ) {
		int index = 0;
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			switch ( i ) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 6:
				arrayBtn[ i ].setText( characters[ index ] );
				arrayBtn[ i ].setEnabled( true );
				index++;
				break;
			default:
				arrayBtn[ i ].setEnabled( false );
				arrayBtn[ i ].setText( EMPTY_STRING );
				break;
			}
		}
	}
	
	private void button7( String[] characters ) {
		int index = 0;
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			switch ( i ) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				arrayBtn[ i ].setText( characters[ index ] );
				arrayBtn[ i ].setEnabled( true );
				index++;
				break;
			default:
				arrayBtn[ i ].setEnabled( false );
				arrayBtn[ i ].setText( EMPTY_STRING );
				break;
			}
		}
	}
	
	private void button8( String[] characters ) {
		int index = 0;
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			switch ( i ) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 8:
				arrayBtn[ i ].setText( characters[ index ] );
				arrayBtn[ i ].setEnabled( true );
				index++;
				break;
			default:
				arrayBtn[ i ].setEnabled( false );
				arrayBtn[ i ].setText( EMPTY_STRING );
				break;
			}
		}
	}
	
	private void button9( String[] characters ) {
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			arrayBtn[ i ].setText( characters[ i ] );
			arrayBtn[ i ].setEnabled( true );
		}
	}

	private void startTimeProgress() {
		//timeMgr = new TimeManager( this );
		timeMgr = new TimeManager( activityHandler );
		timeMgr.start();
	}

	private int[] getButtonIDs() {
		int[] result = new int[ MAX_BUTTON_COUNT ];

		result[ 0 ] = R.id.b1;
		result[ 1 ] = R.id.b2;
		result[ 2 ] = R.id.b3;
		result[ 3 ] = R.id.b4;
		result[ 4 ] = R.id.b5;
		result[ 5 ] = R.id.b6;
		result[ 6 ] = R.id.b7;
		result[ 7 ] = R.id.b8;
		result[ 8 ] = R.id.b9;

		return result;
	}

	private Button[] getButtons() {
		Button[] result = new Button[ MAX_BUTTON_COUNT ];
		
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			result[ i ] = ( Button )findViewById( btnIDs[ i ] );
		}
		
		return result;
	}

	private void addEventListener() {
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			arrayBtn[ i ].setOnClickListener( this );
		}
	}

	public void onClick( View v ) {
		Vibrator vibe = ( Vibrator )getSystemService( Context.VIBRATOR_SERVICE );
	    vibe.vibrate( 30 );

		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			if ( v.equals( arrayBtn[ i ] ) ) {
				gameContext.selectCharacter( arrayBtn[ i ].getText().toString() );
				arrayBtn[ i ].setEnabled( false );
				arrayBtn[ i ].setText( EMPTY_STRING );
				break;
			}
		}
	}
	
	@SuppressLint("HandlerLeak")
	private class ActivityHandler extends Handler {
		
		private String word;
		private String[] characters;
		private int currentDistance;
		
		@Override
		public void handleMessage(Message msg) {
			StringBuilder sb;

			switch ( msg.what ) {
			case SET_WORD_TEXT:
				word = ( String )msg.obj;
				setWordForGame( word );
				break;
			case SET_BUTTON_TEXT:
				characters = ( String[] )msg.obj;
				setButtonText( characters );
				break;
			case INCORRECT:
				setButtonText( characters );
				combo.setText( EMPTY_STRING );
				break;
			case CORRECT:
				sb = new StringBuilder();
				sb.append( msg.arg1 );
				sb.append( getResources().getString( R.string.combo ) );
				combo.setText( sb.toString() );

				currentDistance += msg.arg1;
				sb.delete( 0, sb.length() );
				sb.append( currentDistance );
				sb.append( getResources().getString( R.string.distance ) );
				distance.setText( sb.toString() );

				gameContext.start();
				break;
			case SET_TIME:
				if ( msg.arg1 <= 10 ) {
					progressBar.setProgressDrawable( getResources().getDrawable( R.drawable.progressbar_red ) );
				} else {
					progressBar.setProgressDrawable( getResources().getDrawable( R.drawable.progressbar_custom ) );
				}
				progressBar.setProgress(  msg.arg1 );

				sb = new StringBuilder();
				sb.append( gameContext.getMps() );
				sb.append( getResources().getString( R.string.mps ) );
				mps.setText( sb.toString() );

				sb.delete( 0, sb.length() );
				sb.append( currentDistance );
				sb.append( getResources().getString( R.string.distance ) );
				distance.setText( sb.toString() );

				currentDistance += gameContext.getMps();
				break;
			case SET_DISTANCE:
				break;
			}
		}
		
	}

}
