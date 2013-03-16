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
			insertColumn( db, "level1", "미지", "ㅁㅣㅈㅣ" );
			insertColumn( db, "level1", "수내", "ㅅㅜㄴㅐ" );
			insertColumn( db, "level1", "보기", "ㅂㅗㄱㅣ" );
			insertColumn( db, "level1", "수리", "ㅅㅜㄹㅣ" );
			insertColumn( db, "level1", "회의", "ㅎㅚㅇㅢ" );
			insertColumn( db, "level1", "외야", "ㅇㅚㅇㅑ" );
			insertColumn( db, "level1", "기사", "ㄱㅣㅅㅏ" );
			insertColumn( db, "level1", "제주", "ㅈㅔㅈㅜ" );
			insertColumn( db, "level1", "진리", "ㅈㅣㄴㄹㅣ" );
			insertColumn( db, "level1", "견고", "ㄱㅕㄴㄱㅗ" );
			insertColumn( db, "level1", "서울", "ㅅㅓㅇㅜㄹ" );
			insertColumn( db, "level1", "정자", "ㅈㅓㅇㅈㅏ" );
			insertColumn( db, "level1", "경고", "ㄱㅕㅇㄱㅗ" );
			insertColumn( db, "level1", "실무", "ㅅㅣㄹㅁㅜ" );
			insertColumn( db, "level1", "가족", "ㄱㅏㅈㅗㄱ" );
			insertColumn( db, "level1", "혼례", "ㅎㅗㄴㄹㅖ" );
			insertColumn( db, "level1", "동산", "ㄷㅗㅇㅅㅏㄴ" );
			insertColumn( db, "level1", "병합", "ㅂㅕㅇㅎㅏㅂ" );
			insertColumn( db, "level1", "영상", "ㅇㅕㅇㅅㅏㅇ" );
			insertColumn( db, "level1", "건강", "ㄱㅓㄴㄱㅏㅇ" );
			insertColumn( db, "level1", "동향", "ㄷㅗㅇㅎㅑㅇ" );
			insertColumn( db, "level1", "공간", "ㄱㅗㅇㄱㅏㄴ" );
			insertColumn( db, "level1", "한국", "ㅎㅏㄴㄱㅜㄱ" );
			insertColumn( db, "level1", "분당", "ㅂㅜㄴㄷㅏㅇ" );
			insertColumn( db, "level1", "주전자", "ㅈㅜㅈㅓㄴㅈㅏ" );
			insertColumn( db, "level1", "도시락", "ㄷㅗㅅㅣㄹㅏㄱ" );
			insertColumn( db, "level1", "건포도", "ㄱㅓㄴㅍㅗㄷㅗ" );
			insertColumn( db, "level1", "화랑도", "ㅎㅘㄹㅏㅇㄷㅗ" );
			insertColumn( db, "level1", "컴퓨터", "ㅋㅓㅁㅍㅠㅌㅓ" );
			insertColumn( db, "level1", "사무실", "ㅅㅏㅁㅜㅅㅣㄹ" );
			insertColumn( db, "level1", "경포대", "ㄱㅕㅇㅍㅗㄷㅐ" );
			insertColumn( db, "level1", "교수형", "ㄱㅛㅅㅜㅎㅕㅇ" );
			insertColumn( db, "level1", "건전지", "ㄱㅓㄴㅈㅓㄴㅈㅣ" );
			insertColumn( db, "level1", "미술실", "ㅁㅣㅅㅜㄹㅅㅣㄹ" );
			insertColumn( db, "level1", "경기장", "ㄱㅕㅇㄱㅣㅈㅏㅇ" );
			insertColumn( db, "level1", "건축과", "ㄱㅓㄴㅊㅜㄱㄱㅘ" );
			insertColumn( db, "level1", "동승자", "ㄷㅗㅇㅅㅡㅇㅈㅏ" );
			insertColumn( db, "level1", "정거장", "ㅈㅓㅇㄱㅓㅈㅏㅇ" );
			insertColumn( db, "level1", "독서실", "ㄷㅗㄱㅅㅓㅅㅣㄹ" );
			insertColumn( db, "level1", "청문회", "ㅊㅓㅇㅁㅜㄴㅎㅚ" );
			insertColumn( db, "level1", "설악산", "ㅅㅓㄹㅇㅏㄱㅅㅏㄴ" );
			insertColumn( db, "level1", "한강진", "ㅎㅏㄴㄱㅏㅇㅈㅣㄴ" );
			insertColumn( db, "level1", "강낭콩", "ㄱㅏㅇㄴㅏㅇㅋㅗㅇ" );
			insertColumn( db, "level1", "돌솥밥", "ㄷㅗㄹㅅㅗㅌㅂㅏㅂ" );
			insertColumn( db, "level1", "산림욕", "ㅅㅏㄴㄹㅣㅁㅇㅛㄱ" );
			insertColumn( db, "level1", "선정릉", "ㅅㅓㄴㅈㅓㅇㄹㅡㅇ" );
			insertColumn( db, "level1", "관악산", "ㄱㅘㄴㅇㅏㄱㅅㅏㄴ" );
			insertColumn( db, "level1", "강감찬", "ㄱㅏㅇㄱㅏㅁㅊㅏㄴ" );
			insertColumn( db, "level1", "장발장", "ㅈㅏㅇㅂㅏㄹㅈㅏㅇ" );
			insertColumn( db, "level1", "경찰관", "ㄱㅕㅇㅊㅏㄹㄱㅘㄴ" );
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
