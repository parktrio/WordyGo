package kr.dev.parktrio.park.wordygo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class LoadingActivity extends Activity {

	public static Activity loadingActivity;
	
	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_loading );

		loadingActivity = this;
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate( R.menu.main, menu );
		return true;
	}

	@Override
	public void onBackPressed() {}

}
