package kr.dev.parktrio.park.wordygo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameActivity extends Activity implements OnClickListener {

	private final int MAX_BUTTON_COUNT = 25;
	
	private TimeManager timeMgr;
	private Button[] arrayBtn;
	private int[] btnIDs;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_game );

		btnIDs = getButtonIDs();
		arrayBtn = getButtons();

		addEventListener();
		startTimeProgress();
		
		//test
		DatabaseManager dbMgr = new DatabaseManager( getApplicationContext() );
		dbMgr.checkDB();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		overridePendingTransition( R.anim.fade, R.anim.hold );
	}

	private void startTimeProgress() {
		timeMgr = new TimeManager( this );
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
		result[ 9 ] = R.id.b10;
		result[ 10 ] = R.id.b11;
		result[ 11 ] = R.id.b12;
		result[ 12 ] = R.id.b13;
		result[ 13 ] = R.id.b14;
		result[ 14 ] = R.id.b15;
		result[ 15 ] = R.id.b16;
		result[ 16 ] = R.id.b17;
		result[ 17 ] = R.id.b18;
		result[ 18 ] = R.id.b19;
		result[ 19 ] = R.id.b20;
		result[ 20 ] = R.id.b21;
		result[ 21 ] = R.id.b22;
		result[ 22 ] = R.id.b23;
		result[ 23 ] = R.id.b24;
		result[ 24 ] = R.id.b25;
		
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
		for ( int i = 0; i < MAX_BUTTON_COUNT; i++ ) {
			if ( v.equals( arrayBtn[ i ] ) ) {
				arrayBtn[ i ].setEnabled( false );
				break;
			}
		}
	}
}
