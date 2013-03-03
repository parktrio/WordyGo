package kr.dev.parktrio.wordproto;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class GameActivity extends Activity {

	private ProgressBar progressBar;
	private int progress = 60;
	private Thread timeThread;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_game );
		startTimeProgress();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		overridePendingTransition( R.anim.fade, R.anim.hold );
	}

	private void startTimeProgress() {
		progressBar = ( ProgressBar )findViewById( R.id.time );
		progressBar.setProgress( progress );

		timeThread = new Thread() {
			@Override
			public void run() {
				while ( progress > 0 ) {
					try {
						Thread.sleep( 1000 );
						progress = progress - 1;
						progressBar.setProgress( progress );
					} catch ( Throwable e ) {
						e.printStackTrace();
						break;
					}
				}
				if ( progress == 0 ) {
					endTimeProgress();
				}
				super.run();
			}
		};
		timeThread.start();
	}

	private void endTimeProgress() {
		Log.d( "Hwi", "Time End");
		if (timeThread != null && timeThread.isAlive())
		{
			timeThread.interrupt();
		}
	}
}
