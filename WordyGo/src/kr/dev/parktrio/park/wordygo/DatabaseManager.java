package kr.dev.parktrio.park.wordygo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class DatabaseManager {
	private Context context;
	private String dbDirPath;
	private String dbFilePath;
	private String dbRemotePath = "http://parktrio-wordygo-test.googlecode.com/files/words.db";
	private SQLiteDatabase db;
	private DatabaseHelper dbHelper;

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
	    }  

	    @Override  
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    
	        db.execSQL("drop table if exist level1");  
	        onCreate(db);
	    }  
	}

	DatabaseManager( Context context ) {
		this.context = context;
		this.dbDirPath = Environment.getDataDirectory().getAbsolutePath() + "/data/" + context.getPackageName();
		this.dbFilePath = Environment.getDataDirectory().getAbsolutePath() + "/data/" + context.getPackageName() + "/words.db";
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
