package kr.dev.parktrio.wordproto;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button startBtn;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		startBtn = ( Button ) findViewById( R.id.startBtn );
		startBtn.setOnClickListener( this );
	}

	@Override
	public void onClick( View v ) {
		if ( v.equals( startBtn ) )
		{
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

}
