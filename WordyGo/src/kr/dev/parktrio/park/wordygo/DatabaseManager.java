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

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class DatabaseManager {
	private Context context;
	private String dbDirPath;
	private String dbFilePath;

	DatabaseManager( Context context ) {
		this.context = context;
		this.dbDirPath = Environment.getDataDirectory().getAbsolutePath() + "/data/" + context.getPackageName();
		this.dbFilePath = Environment.getDataDirectory().getAbsolutePath() + "/data/" + context.getPackageName() + "/words.db";
	}
	
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
					url = new URL( "http://parktrio-wordygo-test.googlecode.com/files/words.db" );
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
}
