package kr.dev.parktrio.park.wordygo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

	private final int MAX_BUTTON_COUNT = 11;
	private final String EMPTY_STRING = "";

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

		startTimeProgress();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		timeMgr.stop();
		finish();
		overridePendingTransition( R.anim.fade, R.anim.hold );
	}

	private void endGame() {
		Intent resultIntent = new Intent( this, ResultActivity.class );
		resultIntent.putExtra("GameResultManager", getResultManager() );
		startActivity( resultIntent );
		finish();
	}
	
	private GameResultManager getResultManager() {
		return gameContext.getResultManager();
	}

	private void setWordForGame( String word ) {
		currentWord.setText( word );
	}

	private void setButtonText( String[] characters ) {
		int[] buttonState = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		switch ( characters.length ) {
		case 4:
			buttonState = ButtonState.character4;
			break;
		case 5:
			buttonState = ButtonState.character5;
			break;
		case 6:
			buttonState = ButtonState.character6;
			break;
		case 7:
			buttonState = ButtonState.character7;
			break;
		case 8:
			buttonState = ButtonState.character8;
			break;
		case 9:
			buttonState = ButtonState.character9;
			break;
		}

		int index = 0;
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			if ( buttonState[ i ] == 1 ) {
				enabledButtonSet( arrayBtn[ i ], characters[ index ] );
				index++;
			} else {
				disabledButtonSet( arrayBtn[ i ] );
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void enabledButtonSet( Button btn, String character ) {
		btn.setText( character );
		btn.setEnabled( true );
		btn.setTextColor( getResources().getColor( R.color.button_text ) );
		btn.setBackgroundDrawable( getResources().getDrawable( R.drawable.button ) );

		btn.setOnClickListener( this );
	}

	@SuppressWarnings("deprecation")
	private void disabledButtonSet( Button btn ) {
		btn.setEnabled( false );
		btn.setText( EMPTY_STRING );
		btn.setBackgroundDrawable( getResources().getDrawable( R.drawable.button_disable ) );

		btn.setOnClickListener( null );
	}

	@SuppressWarnings("deprecation")
	private void itemButtonSet( Button btn ) {
		btn.setEnabled( true );
		btn.setBackgroundDrawable( getResources().getDrawable( R.drawable.button_item ) );
	}

	private void startTimeProgress() {
		timeMgr = new TimeManager( activityHandler );
		timeMgr.start();
	}

	private int[] getButtonIDs() {
		int[] result = new int[ MAX_BUTTON_COUNT ];

		result[ 0 ] = R.id.b0;
		result[ 1 ] = R.id.b1;
		result[ 2 ] = R.id.b2;
		result[ 3 ] = R.id.b3;
		result[ 4 ] = R.id.b4;
		result[ 5 ] = R.id.b5;
		result[ 6 ] = R.id.b6;
		result[ 7 ] = R.id.b7;
		result[ 8 ] = R.id.b8;
		result[ 9 ] = R.id.b9;
		result[ 10 ] = R.id.b10;

		return result;
	}

	private Button[] getButtons() {
		Button[] result = new Button[ MAX_BUTTON_COUNT ];

		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			result[ i ] = ( Button )findViewById( btnIDs[ i ] );
		}

		return result;
	}

	public void onClick( View v ) {
		Vibrator vibe = ( Vibrator )getSystemService( Context.VIBRATOR_SERVICE );
	    vibe.vibrate( 30 );

		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			if ( v.equals( arrayBtn[ i ] ) ) {
				gameContext.selectCharacter( arrayBtn[ i ].getText().toString() );
				//arrayBtn[ i ].setEnabled( false );
				//arrayBtn[ i ].setText( EMPTY_STRING );
				arrayBtn[ i ].setEnabled( false );
				arrayBtn[ i ].setTextColor( getResources().getColor( R.color.selected_button_text ) );
				break;
			}
		}
	}

	@SuppressLint("HandlerLeak")
	private class ActivityHandler extends Handler {

		private String word;
		private String[] characters;
		private int currentDistance = 0;

		@Override
		public void handleMessage(Message msg) {
			StringBuilder sb;

			switch ( msg.what ) {
			case MessageWhat.SET_WORD_TEXT:
				word = ( String )msg.obj;
				setWordForGame( word );
				break;
			case MessageWhat.SET_BUTTON_TEXT:
				characters = ( String[] )msg.obj;
				setButtonText( characters );
				break;
			case MessageWhat.INCORRECT:
				setButtonText( characters );
				combo.setText( EMPTY_STRING );

				sb = new StringBuilder();
				sb.append( gameContext.getMps() );
				sb.append( getResources().getString( R.string.mps ) );
				mps.setText( sb.toString() );
				break;
			case MessageWhat.CORRECT:
				sb = new StringBuilder();
				sb.append( msg.arg1 );
				sb.append( getResources().getString( R.string.combo ) );
				combo.setText( sb.toString() );

				currentDistance += msg.arg1;
				sb.delete( 0, sb.length() );
				sb.append( currentDistance );
				sb.append( getResources().getString( R.string.distance ) );
				distance.setText( sb.toString() );

				sb.delete( 0, sb.length() );
				sb.append( gameContext.getMps() );
				sb.append( getResources().getString( R.string.mps ) );
				mps.setText( sb.toString() );

				gameContext.start();
				break;
			case MessageWhat.SET_TIME:
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
			case MessageWhat.TIME_END:
				gameContext.setDistance( currentDistance );
				endGame();
				break;
			case MessageWhat.RANDOM_ITEM:
				RandomGameItem item = ( RandomGameItem )msg.obj;
				itemButtonSet( arrayBtn[ item.getItemIndex() ] );
				break;
			}
		}

	}

}
