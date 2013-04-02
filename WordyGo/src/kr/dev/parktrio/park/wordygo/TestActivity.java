package kr.dev.parktrio.park.wordygo;

import bayaba.engine.lib.GameInfo;
import android.graphics.Point;
import android.media.AudioManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class TestActivity extends Activity {

	private GLView play;
	private GameMain sImg;
	public GameInfo gInfo;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setVolumeControlStream( AudioManager.STREAM_MUSIC );

        setContentView(R.layout.activity_test);
        
        RelativeLayout mLayout = (RelativeLayout)findViewById(R.id.drawarea);
        Point size = new Point();

        gInfo = new GameInfo( 480, 800 );
        super.getWindowManager().getDefaultDisplay().getSize( size );
        gInfo.ScreenXsize = size.x;
        gInfo.ScreenYsize = size.y;
        gInfo.SetScale();

        sImg = new GameMain( this, gInfo );
        play = new GLView( this, sImg );
        play.setRenderer( new SurfaceClass(sImg) );

        mLayout.addView( play );
        //setContentView( play );
	}
}
