package kr.dev.parktrio.park.wordygo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class DatabaseManager {
	private Context context;
	//private String dbDirPath;
	//private String dbFilePath;
	//private String dbRemotePath = "http://parktrio-wordygo-test.googlecode.com/files/words.db";
	private SQLiteDatabase db;
	private DatabaseHelper dbHelper;
	
	private static final class SingletonHolder {
		static final DatabaseManager singleton = new DatabaseManager();
	}

	private class DatabaseHelper extends SQLiteOpenHelper{
	    private static final String DB_NAME = "words";  
	    private static final int    DB_VER = 1;
	      
	    public DatabaseHelper(Context context) {  
	        super(context, DB_NAME, null, DB_VER);  
	    }  

	    @Override  
	    public void onCreate(SQLiteDatabase db) {
	    	String sql = "create table level1(" +
	 				"expression text primary key," +
	 	            "characters text not null)";
	 		db.execSQL(sql);
	 		insertForTest( db );
	    }  

	    @Override  
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    
	        db.execSQL("drop table if exist level1");  
	        onCreate( db );
	    }
	    
	    //test
	    private void insertColumn( SQLiteDatabase db, String table, String expression, String characters ) {
	    	ContentValues values = new ContentValues();  
	        values.put( "expression", expression );  
	        values.put( "characters", characters );  
	        db.insert( table, null, values );
	    }
	    
		//test
		private void insertForTest( SQLiteDatabase db ) {
			insertLevel1( db );
		}

		//test
		private void insertLevel1( SQLiteDatabase db ) {
			//test
			insertColumn( db, "level1", "서현", "ㅅㅓㅎㅕㄴ" );
			insertColumn( db, "level1", "수내", "ㅅㅜㄴㅐ" );
			insertColumn( db, "level1", "정자", "ㅈㅓㅇㅈㅏ" );
			insertColumn( db, "level1", "오리", "ㅇㅗㄹㅣ" );
			insertColumn( db, "level1", "죽전", "ㅈㅜㄱㅈㅓㄴ" );
			insertColumn( db, "level1", "야탑", "ㅇㅑㅌㅏㅂ" );
			insertColumn( db, "level1", "서울", "ㅅㅓㅇㅜㄹ" );
			insertColumn( db, "level1", "대전", "ㄷㅐㅈㅓㄴ" );
			insertColumn( db, "level1", "대구", "ㄷㅐㄱㅜ" );
			insertColumn( db, "level1", "부산", "ㅂㅜㅅㅏㄴ" );
			insertColumn( db, "level1", "광주", "ㄱㅘㅇㅈㅜ" );
			insertColumn( db, "level1", "울산", "ㅇㅜㄹㅅㅏㄴ" );
			insertColumn( db, "level1", "제주", "ㅈㅔㅈㅜ" );
			insertColumn( db, "level1", "미지", "ㅁㅣㅈㅣ" );
			insertColumn( db, "level1", "한국", "ㅎㅏㄴㄱㅜㄱ" );
			insertColumn( db, "level1", "귀성", "ㄱㅟㅅㅓㅇ" );
			insertColumn( db, "level1", "예의", "ㅇㅖㅇㅢ" );
			insertColumn( db, "level1", "혼례", "ㅎㅗㄴㄹㅖ" );
			insertColumn( db, "level1", "가정", "ㄱㅏㅈㅓㅇ" );
			insertColumn( db, "level1", "가족", "ㄱㅏㅈㅗㄱ" );
			insertColumn( db, "level1", "휘장", "ㅎㅟㅈㅏㅇ" );
			insertColumn( db, "level1", "공간", "ㄱㅗㅇㄱㅏㄴ" );
			insertColumn( db, "level1", "책상", "ㅊㅐㄱㅅㅏㅇ" );
			insertColumn( db, "level1", "전력", "ㅈㅓㄴㄹㅕㄱ" );
			insertColumn( db, "level1", "일반", "ㅇㅣㄹㅂㅏㄴ" );
			insertColumn( db, "level1", "수식", "ㅅㅜㅅㅣㄱ" );
			insertColumn( db, "level1", "검토", "ㄱㅓㅁㅌㅗ" );
			insertColumn( db, "level1", "보기", "ㅂㅗㄱㅣ" );
			insertColumn( db, "level1", "삽입", "ㅅㅏㅂㅇㅣㅂ" );
			insertColumn( db, "level1", "동맹", "ㄷㅗㅇㅁㅐㅇ" );
			insertColumn( db, "level1", "복사", "ㅂㅗㄱㅅㅏ" );
			insertColumn( db, "level1", "바꿈", "ㅂㅏㄲㅜㅁ" );
			insertColumn( db, "level1", "경고", "ㄱㅕㅇㄱㅗ" );
			insertColumn( db, "level1", "환율", "ㅎㅘㄴㅇㅠㄹ" );
			insertColumn( db, "level1", "회의", "ㅎㅚㅇㅢ" );
			insertColumn( db, "level1", "판금", "ㅍㅏㄴㄱㅡㅁ" );
			insertColumn( db, "level1", "진리", "ㅈㅣㄴㄹㅣ" );
			insertColumn( db, "level1", "호의", "ㅎㅗㅇㅢ" );
			insertColumn( db, "level1", "왜곡", "ㅇㅙㄱㅗㄱ" );
			insertColumn( db, "level1", "외야", "ㅇㅚㅇㅑ" );
			insertColumn( db, "level1", "병합", "ㅂㅕㅇㅎㅏㅂ" );
			insertColumn( db, "level1", "물통", "ㅁㅜㄹㅌㅗㅇ" );
			insertColumn( db, "level1", "영상", "ㅇㅕㅇㅅㅏㅇ" );
			insertColumn( db, "level1", "실무", "ㅅㅣㄹㅁㅜ" );
			insertColumn( db, "level1", "젊음", "ㅈㅓㄻㅇㅡㅁ" );
			insertColumn( db, "level1", "동향", "ㄷㅗㅇㅎㅑㅇ" );
			insertColumn( db, "level1", "기슭", "ㄱㅣㅅㅡㄺ" );
			insertColumn( db, "level1", "혼돈", "ㅎㅗㄴㄷㅗㄴ" );
			insertColumn( db, "level1", "지휘", "ㅈㅣㅎㅟ" );
			insertColumn( db, "level1", "건강", "ㄱㅓㄴㄱㅏㅇ" );
		}
	}

	public static DatabaseManager getInstance() {
		return SingletonHolder.singleton;
	}

	private DatabaseManager() {
		this.context = MainActivity.mainActivity.getApplicationContext();
		//this.dbDirPath = Environment.getDataDirectory().getAbsolutePath() + "/data/" + context.getPackageName();
		//this.dbFilePath = Environment.getDataDirectory().getAbsolutePath() + "/data/" + context.getPackageName() + "/words.db";
		this.dbHelper = new DatabaseHelper( context );
		db = dbHelper.getWritableDatabase();
	}

	public long insert( String table, String expression, String characters ){  
        ContentValues values = new ContentValues();  
        values.put( "expression", expression );  
        values.put( "characters", characters );  
        long result = db.insert( table, null, values );

        return result;  
    }

	public Word[] selectAll( String tableName ) {
 		Cursor cursor = db.query(tableName, null, null, null, null, null, null);

 		Word[] result = new Word[ cursor.getCount() ];

 		int index = 0;
 		while ( cursor.moveToNext() ) {
            String expression = cursor.getString( 0 );
            String characters = cursor.getString( 1 );
            
            result[ index ] = new Word( expression, Utility.stringToStringArray( characters ) );
            
            index++;
 		}
 		
 		return result;
 	}
/*	
	public void checkDB() {
		Log.d("Hwi", dbFilePath );
		File dbFile = new File( dbFilePath );

		if (dbFile.exists()) {
			Log.d("Hwi", "DB file exists");
		} else {
			Log.d("Hwi", "not exists");
			downloadDB();
		}
	}

	public void downloadDB() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				InputStream is = null;
				FileOutputStream fos = null;
				BufferedOutputStream bos = null;
				URL url;
				HttpURLConnection conn;

				try {
					url = new URL( dbRemotePath );
					conn = ( HttpURLConnection )url.openConnection();

					int lengthOnServer = conn.getContentLength();

					if ( lengthOnServer > 0 ) {
					} else {
						// error
						Log.d("Hwi", "error1");
						return;
					}

					is = conn.getInputStream();

					File dir = new File( dbDirPath );
					if ( !dir.exists() ) {
						dir.mkdir();
					}

					File target = new File( dbFilePath );
					if ( target.exists() ) {
						target.delete();
					}
					target.createNewFile();

					fos = new FileOutputStream( target );
					bos = new BufferedOutputStream( fos );

					int bufferLength = 0;
					int totalLength = 0;
					byte[] buffer = new byte[ 1024 ];
					while( ( bufferLength = is.read( buffer ) ) > 0) {
						bos.write( buffer, 0, bufferLength );
						totalLength += bufferLength;
					}

					if ( totalLength != lengthOnServer ) {
						//error
						Log.d("Hwi", "error2");
						return;
					}
					Log.d("Hwi", "download complete!");
					// test
					openDB();
					Word[] words = selectAll( "Level1" );
					Log.d("Hwi", words[0].getExpression() );
					
				} catch ( MalformedURLException e ) {
					e.printStackTrace();
					Log.d("Hwi", "error3");
				} catch ( IOException e ) {
					e.printStackTrace();
					Log.d("Hwi", "error4");
				} finally {
					try {
						if ( bos != null ) bos.close();
						if ( fos != null ) fos.close();
						if ( is != null ) is.close();
					} catch ( IOException e ) {
						e.printStackTrace();
						Log.d("Hwi", "error5");
					}
				}
			}
		});
		thread.start();
	}
	
	public void openDB() {
		openDB( SQLiteDatabase.OPEN_READONLY );
	}
 	
 	public void openDB( int accessFlags ) {
 		File dbCopy = new File( dbFilePath );
 		
 		if( dbCopy.exists() ){
 			SQLiteDatabase db = SQLiteDatabase.openDatabase(dbCopy.getAbsolutePath(), null, accessFlags);
 			this.db = db;
 		}
 	}

 	public void closeDB(){
 		this.db.close();
 	}
*/
}
