package kr.dev.parktrio.park.wordygo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity implements OnClickListener {

	private Button okBtn;
	private TextView totalDistance;
	private TextView maxCombo;
	private TextView maxSpeed;
	private GameResultManager gameResultMgr;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_result );

		Bundle bundle = getIntent().getExtras();
		gameResultMgr = bundle.getParcelable( "GameResultManager" );

		totalDistance = ( TextView )findViewById( R.id.total_distance );
		maxCombo = ( TextView )findViewById( R.id.maxCombo );
		maxSpeed = ( TextView )findViewById( R.id.maxSpeed );

		okBtn = ( Button ) findViewById( R.id.okBtn );
		okBtn.setOnClickListener( this );

		presentResult();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if ( v.equals( okBtn ) ) {
			finish();
		}
	}

	private void presentResult() {
		StringBuilder sb;
		sb = new StringBuilder();
		sb.append( getResources().getString( R.string.total ) );
		sb.append( gameResultMgr.getDistance() );
		sb.append( getResources().getString( R.string.distance ) );
		totalDistance.setText( sb.toString() );

		sb.delete( 0, sb.length() );
		sb.append( gameResultMgr.getMaxCombo() );
		sb.append( " Combo" );
		maxCombo.setText( sb.toString() );

		sb.delete( 0, sb.length() );
		sb.append( gameResultMgr.getMaxMps() );
		sb.append( " m/s" );
		maxSpeed.setText( sb.toString() );
	}

}
