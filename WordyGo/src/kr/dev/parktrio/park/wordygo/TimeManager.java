package kr.dev.parktrio.park.wordygo;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.os.Message;

public class TimeManager {
	private final int MAXTIME = 10;

	private Handler activityHandler;
	private Timer timer;

	private int currentTime;

	class Task extends TimerTask {
		public void run() {
			currentTime--;
			if ( currentTime == 0 ) {
				timer.cancel();
				Message endMsg = activityHandler.obtainMessage();
				endMsg.what = MessageWhat.TIME_END;
				activityHandler.sendMessage( endMsg );
			} else {
				Message msg = activityHandler.obtainMessage();
				msg.what = MessageWhat.SET_TIME;
				msg.arg1 = currentTime;
				activityHandler.sendMessage( msg );
			}
		}
	}

	TimeManager( Handler handler ) {
		activityHandler = handler;
		timer = new Timer();
		currentTime = MAXTIME;
	}

	public void start() {
		currentTime = MAXTIME;
		Message msg = activityHandler.obtainMessage();
		msg.what = MessageWhat.SET_TIME;
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
