package kr.dev.parktrio.park.wordygo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	public static Activity mainActivity;
	private Button startBtn;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		Intent loadingIntent = new Intent( this, LoadingActivity.class );
		startActivity( loadingIntent );

		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		mainActivity = this;

		startBtn = ( Button ) findViewById( R.id.startBtn );
		startBtn.setOnClickListener( this );

		initialize();
	}

	@Override
	public void onClick( View v ) {
		if ( v.equals( startBtn ) ) {
			Intent gameIntent = new Intent( this, GameActivity.class );
			startActivity( gameIntent );
			overridePendingTransition( R.anim.fade, R.anim.hold );
		}
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate( R.menu.main, menu );
		return true;
	}
	
	private void initialize() {
		Log.d("Hwi", "initialize");
		InitializationRunnable init = new InitializationRunnable();
        new Thread( init ).start();
	}
	
	private void initializeDB() {
		DatabaseManager.getInstance();
		// TODO
	}

	class InitializationRunnable implements Runnable {
        public void run() {
        	initializeDB();
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LoadingActivity.loadingActivity.finish();
        }
    }

}
