package kr.dev.parktrio.park.wordygo;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

public class TimeManager {
	private final int MAXTIME = 60;
	
	private final int SET_TIME = 5;
	
	private GameActivity gameActivity;
	private ProgressBar progressBar;
	private Handler activityHandler;
	private Timer timer;

	private int currentTime = 60;

	class Task extends TimerTask {
		public void run() {
			currentTime--;
			//progressBar.setProgress( currentTime );
			Message msg = activityHandler.obtainMessage();
			msg.what = SET_TIME;
			msg.arg1 = currentTime;
			activityHandler.sendMessage( msg );
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

	TimeManager( Handler handler ) {
		activityHandler = handler;
		timer = new Timer();
	}

	public void start() {
		currentTime = MAXTIME;
		//progressBar.setProgress( currentTime );
		Message msg = activityHandler.obtainMessage();
		msg.what = SET_TIME;
		msg.arg1 = currentTime;
		activityHandler.sendMessage( msg );
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
