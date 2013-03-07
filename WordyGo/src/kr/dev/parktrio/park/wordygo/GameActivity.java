package kr.dev.parktrio.park.wordygo;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity implements OnClickListener {

	private final int MAX_BUTTON_COUNT = 30;
	
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
		test();
	}
	
	//test
	private void insertForTest( DatabaseManager dbMgr ) {
		dbMgr.insert( "level1", "서울", "ㅅㅓㅇㅜㄹ" );
		dbMgr.insert( "level1", "부산", "ㅂㅜㅅㅏㄴ" );
		dbMgr.insert( "level1", "대전", "ㄷㅐㅈㅓㄴ" );
		dbMgr.insert( "level1", "대구", "ㄷㅐㄱㅜ" );
		dbMgr.insert( "level1", "광주", "ㄱㅘㅇㅈㅜ" );
		dbMgr.insert( "level1", "제주", "ㅈㅔㅈㅜ" );
	}
	
	//test
	private void test() {
		DatabaseManager dbMgr = new DatabaseManager( getApplicationContext() );
		insertForTest( dbMgr );
		Word[] words = dbMgr.selectAll( "level1" );

		Random rand = new Random();
		int index = rand.nextInt( 6 );
		
		TextView textView = ( TextView )findViewById( R.id.word );
		textView.setText( words[ index ].getExpression() );
		
		for ( int i = 0; i <  words[ index ].getWordUnit().length; i++ ) {
			arrayBtn[ i ].setText( words[ index ].getWordUnit()[ i ] );
		}
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
		result[ 25 ] = R.id.b26;
		result[ 26 ] = R.id.b27;
		result[ 27 ] = R.id.b28;
		result[ 28 ] = R.id.b29;
		result[ 29 ] = R.id.b30;
		
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
