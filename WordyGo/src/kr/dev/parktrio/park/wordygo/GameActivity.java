package kr.dev.parktrio.park.wordygo;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameActivity extends Activity implements OnClickListener {
	
	private TimeManager timeMgr;
	private Button btn1;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_game );
		addEventListener();
		startTimeProgress();
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

	private void addEventListener() {
		btn1 = ( Button )findViewById( R.id.b1 );
		btn1.setText( "ㄹ" );
		btn1.setOnClickListener( this );
	}

	public void onClick( View v ) {
		if ( v.equals( btn1 ) ) {
			btn1.setTextColor( Color.RED );
		}
	}
}
