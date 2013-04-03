package kr.dev.parktrio.park.wordygo;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Button;
import bayaba.engine.lib.ButtonObject;
import bayaba.engine.lib.ButtonType;
import bayaba.engine.lib.Font;
import bayaba.engine.lib.GameInfo;
import bayaba.engine.lib.GameObject;
import bayaba.engine.lib.Sprite;

public class GameMain
{
	public GL10 mGL = null;
	private Context MainContext;
	private GameContext gameContext;
	public GameInfo gInfo;
	public float TouchX, TouchY;
	public int CurLayer = 0;
	public ButtonObject Button[] = new ButtonObject[11];
	public Boolean BtnDisabled[] = new Boolean[11];
	
	private Sprite buttonSpr = new Sprite();
	
	private Sprite normalGomSpr = new Sprite();
	private GameObject normalGom = new GameObject();
	
	private Sprite flyingGomSpr = new Sprite();
	private GameObject flyingGom = new GameObject();

	private Sprite spaceSpr = new Sprite();
	private GameObject space[] = new GameObject[9];
	
	private Sprite numberSpr = new Sprite();
	private Sprite comboSpr = new Sprite();
	private Sprite mpsSpr = new Sprite();
	private Sprite distanceSpr = new Sprite();
	
	private GameObject distanceNum[] = new GameObject[10];
	private GameObject comboNum[] = new GameObject[10];
	private GameObject mpsNum[] = new GameObject[10];
	
	private GameObject distanceText = new GameObject();
	private GameObject comboText = new GameObject();
	private GameObject mpsText = new GameObject();
	
	private Font title = new Font();
	private Font combo = new Font();
	private Font mps = new Font();
	private Font distance = new Font();
	
	public float currentDistance = 0;
	public int currentCombo = 0;
	public int currentMps = 1;
	
	public float speed = 0.1f;
	public float scroll = 3.0f;

	public GameMain( Context context, GameInfo info ) {
		MainContext = context;
		gInfo = info;
		
		for ( int i = 0; i < Button.length; i++ ) Button[i] = new ButtonObject();
		for ( int i = 0; i < space.length; i++ ) space[i] = new GameObject();
		for ( int i = 0; i < BtnDisabled.length; i++ ) BtnDisabled[i] = new Boolean( false );
		for ( int i = 0; i < distanceNum.length; i++ ) distanceNum[i] = new GameObject();
		for ( int i = 0; i < comboNum.length; i++ ) comboNum[i] = new GameObject();
		for ( int i = 0; i < mpsNum.length; i++ ) mpsNum[i] = new GameObject();
	}

	public void LoadButtons() {
		buttonSpr.LoadSprite( mGL, MainContext, R.drawable.buttons, "buttons.spr" );
		
		Button[ 0 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 90, 530, 0 );
		Button[ 1 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 190, 530, 0 );
		Button[ 2 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 290, 530, 0 );
		Button[ 3 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 390, 530, 0 );
		
		Button[ 4 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 140, 630, 0 );
		Button[ 5 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 240, 630, 0 );
		Button[ 6 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 340, 630, 0 );
		
		Button[ 7 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 90, 730, 0 );
		Button[ 8 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 190, 730, 0 );
		Button[ 9 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 290, 730, 0 );
		Button[ 10 ].SetButton( buttonSpr, ButtonType.TYPE_ONE_CLICK, 0, 390, 730, 0 );

		for ( int i = 0; i < Button.length; i++ ) Button[i].SetZoom( gInfo, 0.8f, 0.8f );
	}
	
	public void LoadGom() {
		normalGomSpr.LoadSprite( mGL, MainContext, R.drawable.gom01, "normal.spr" );
		normalGom.SetObject( normalGomSpr, 0, 0, 240, 350, 0, 0 );
		normalGom.scroll = false;

		flyingGomSpr.LoadSprite( mGL, MainContext, R.drawable.gom01, "flying.spr" );
		flyingGom.SetObject( flyingGomSpr, 0, 0, 240, 350, 0, 0 );
		flyingGom.scroll = false;
	}
	
	public void LoadSpace() {
		spaceSpr.LoadSprite( mGL, MainContext, R.drawable.space, "space.spr" );
		
		int count = 0;
		
		for ( int y = 0; y < 3; y++ )
		{
			for ( int x = 0; x < 3; x++ )
			{
				space[count].SetObject( spaceSpr, 0, 0, x * 320, y * 480, 0, 0 );
				space[count++].SetZoom( gInfo, 1.01f, 1.01f );
			}
		}
	}
	
	public void LoadScore() {
		numberSpr.LoadSprite( mGL, MainContext, R.drawable.number, "number.spr" );
		distanceSpr.LoadSprite( mGL, MainContext, R.drawable.number, "distance.spr" );
		comboSpr.LoadSprite( mGL, MainContext, R.drawable.number, "combo.spr" );
		mpsSpr.LoadSprite( mGL, MainContext, R.drawable.number, "mps.spr" );

		//distance
		distanceText.SetObject( distanceSpr, 0, 0, 240, 50, 0, 0 );
		distanceText.SetZoom( gInfo, 1.5f, 1.5f );
		distanceText.scroll = false;
		for ( int i = 0; i < distanceNum.length; i++ ) {
			distanceNum[i].SetObject( numberSpr, 0, 0, 0, 50, 0, 0);
			distanceNum[i].scroll = false;
			distanceNum[i].SetZoom( gInfo, 1.5f, 1.5f );
		}
		
		//combo
		comboText.SetObject( comboSpr, 0, 0, 430, 120, 0, 0 );
		comboText.scroll = false;
		for ( int i = 0; i < comboNum.length; i++ ) {
			comboNum[i].SetObject( numberSpr, 0, 0, 0, 120, 0, 0);
			comboNum[i].scroll = false;
		}
		
		//mps
		mpsText.SetObject( mpsSpr, 0, 0, 25, 120, 0, 0 );
		mpsText.scroll = false;
		for ( int i = 0; i < mpsNum.length; i++ ) {
			mpsNum[i].SetObject( numberSpr, 0, 0, 0, 120, 0, 0);
			mpsNum[i].scroll = false;
		}
	}

	public void LoadGameData() {
		LoadSpace();
		LoadGom();
		LoadButtons();
		LoadScore();

		gameContext = new GameContext( this );
		gameContext.initialize();
		gameContext.start();
	}

	public void resetButton() {
		for ( int i = 0; i < Button.length; i++ ) {
			if ( Button[i].motion > 0 && Button[i].motion < 52 ) {
				Button[i].ResetButton();
				Button[i].frame = 0;
				BtnDisabled[i] = false;
			}
		}
	}
	
	public void setButton() {
		String[] characters = gameContext.getButtonString();
		
		int[] buttonState = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		switch ( characters.length ) {
		case 4:
			buttonState = ButtonState.character4;
			break;
		case 5:
			buttonState = ButtonState.character5;
			break;
		case 6:
			buttonState = ButtonState.character6;
			break;
		case 7:
			buttonState = ButtonState.character7;
			break;
		case 8:
			buttonState = ButtonState.character8;
			break;
		case 9:
			buttonState = ButtonState.character9;
			break;
		}
		
		int index = 0;
		for ( int i = 0; i < Button.length; i++ ) {
			if ( buttonState[ i ] == 1 ) {
				enabledButtonSet( Button[ i ], characters[ index ] );
				BtnDisabled[i] = false;
				index++;
			} else {
				disabledButtonSet( Button[ i ] );
				BtnDisabled[i] = true;
			}
		}
		
		RandomGameItem randomItem = gameContext.getRandomItem();
		if ( randomItem != null ) {
			itemButtonSet( randomItem );
		}
	}
	
	private void enabledButtonSet( ButtonObject btn, String character ) {
		btn.ResetButton();
		btn.motion = Utility.stringToMotion(character);
		btn.frame = 0;
	}
	
	private void disabledButtonSet( ButtonObject btn ) {
		btn.ResetButton();
		btn.motion = 0;
		btn.frame = 0;
	}
	
	private void itemButtonSet( RandomGameItem item ) {
		if ( item.getItemType() == GameItemType.GAME_ITEM_TYPE_SELECT_AGAIN ) return;
		int index = item.getItemIndex();
		BtnDisabled[index] = false;
		ButtonObject btn = Button[index];
		switch ( item.getItemType() ) {
		case GAME_ITEM_TYPE_TIEM_STOP:
			btn.motion = 52;
			break;
		case GAME_ITEM_TYPE_WORD_PASS:
			btn.motion = 53;
			break;
		}
		btn.frame = 0;
	}
	
	public void PushButton( boolean flag, float x, float y ) {
		for ( int i = 0; i < Button.length; i++ ) {
			if ( Button[i].motion == 0 ) continue;
			Button[i].CheckButton( gInfo, flag, x, y );
			if ( BtnDisabled[i] == false && Button[i].click == ButtonType.STATE_CLK_BUTTON ) {
				BtnDisabled[i] = true;
				Vibrator vibe = ( Vibrator )MainContext.getSystemService( Context.VIBRATOR_SERVICE );
			    vibe.vibrate( 25 );
				Button[i].frame = 1;
				if ( Button[i].motion > 51 ) {
				} else {
					gameContext.selectCharacter( Utility.motionToString( Button[i].motion ) );
				}
			}
		}
		/*
		plusBtn.CheckButton( gInfo, flag, x, y );
		if ( plusBtn.click == ButtonType.STATE_DOWN_BUTTON ) {
			if ( speed < 2.5f ) speed += 0.1f;
		}
		
		minusBtn.CheckButton( gInfo, flag, x, y );
		if ( minusBtn.click == ButtonType.STATE_DOWN_BUTTON ) {
			if ( speed > 0.2f ) speed -= 0.1f;
		}
		*/

	}
	
	public void UpdateGame() {
		for ( int i = 0; i < 9; i++ ) {
			space[i].DrawSprite( gInfo );
		
			if ( space[i].x2-gInfo.ScrollX < 0 ) space[i].x += 960;
			if ( space[i].x1-gInfo.ScrollX >= gInfo.ScreenX ) space[i].x -= 960;
		}
		
		if ( speed < 1.5f ) {
			normalGom.AddFrameLoop( speed );
			normalGom.DrawSprite( gInfo );
		} else {
			flyingGom.AddFrameLoop( speed - 1.3f );
			flyingGom.DrawSprite( gInfo );
		}
		
		for ( int i = 0; i < Button.length; i++ ) Button[i].DrawSprite(mGL, gInfo, null);
	}
	
	public void UpdateFont() {
		//Word Title
		title.BeginFont();
		title.SetArea( 120, 150, 360, 250 );
		String str = gameContext.getString();
		title.DrawFont( mGL, 240 - ( str.length() * 40 ), 150, 80, str );
		title.EndFont();
	}
	
	public void UpdateDistance() {
		int numOfDec = Utility.getNumberOfDecimal( (int)currentDistance );
		float startX = 240 - ( (( numOfDec * 30 ) + 37.5f ) / 2 ) + 15;
		
		for ( int i = numOfDec; i > 0; i-- ) {
			distanceNum[i-1].frame = Utility.getNumber( (int)currentDistance, i );
			distanceNum[i-1].x = startX;
			distanceNum[i-1].DrawSprite( gInfo );
			startX += 30;
		}

		distanceText.x = startX;
		distanceText.DrawSprite( gInfo );
		
		//test
		currentDistance += speed;
	}
	
	public void UpdateCombo() {
		if ( currentCombo == 0 ) return;
		
		int numOfDec = Utility.getNumberOfDecimal( currentCombo );
		float startX = 480 - ( (( numOfDec * 20 ) + 100 )) + 10;
		
		for ( int i = numOfDec; i > 0; i-- ) {
			comboNum[i-1].frame = Utility.getNumber( currentCombo, i );
			comboNum[i-1].x = startX;
			comboNum[i-1].DrawSprite( gInfo );
			startX += 20;
		}

		comboText.DrawSprite( gInfo );
	}
	
	public void UpdateMps() {
		mpsText.DrawSprite( gInfo );
	}
	
	public void UpdateScore() {
		UpdateDistance();
		UpdateCombo();
		//UpdateMps();
	}

	public void DoGame() {
		UpdateGame();
		UpdateFont();
		UpdateScore();

		gInfo.ScrollX += ( scroll * ( speed + 0.3f ) );
	}
}
