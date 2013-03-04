package kr.dev.parktrio.park.wordygo;

import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;
import android.widget.ProgressBar;

public class TimeManager {
	private final int MAXTIME = 60;
	
	private GameActivity gameActivity;
	private ProgressBar progressBar;
	private Timer timer;

	private int currentTime = 60;

	class Task extends TimerTask {
		public void run() {
			currentTime--;
			progressBar.setProgress( currentTime );
			if ( currentTime == 0 ) {
				timer.cancel();
				Log.d( "Hwi", "Time End");
			}
		}
	}

	TimeManager( GameActivity view ) {
		gameActivity = view;
		progressBar = ( ProgressBar )( gameActivity.findViewById( R.id.time ) );
		timer = new Timer();
	}

	public void start() {
		currentTime = MAXTIME;
		progressBar.setProgress( currentTime );
		timer.schedule( new Task(), 1000, 1000 );
	}

	public void stop() {
		timer.cancel();
	}

	public void pause() {
		try {
			timer.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void resume() {
		timer.schedule( new Task(), 0, 1000 );
	}
}
