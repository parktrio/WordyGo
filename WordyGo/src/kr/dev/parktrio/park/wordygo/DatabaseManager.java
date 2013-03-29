package kr.dev.parktrio.park.wordygo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class DatabaseManager {
	private final Context context;
	private SQLiteDatabase db;
	private final DatabaseHelper dbHelper;

	private static final class SingletonHolder {
		static final DatabaseManager singleton = new DatabaseManager();
	}

	private class DatabaseHelper extends SQLiteOpenHelper{
		private static final String DB_NAME = "words";
		private static final int DB_VER = 1;

		public DatabaseHelper(Context context) {
			super(context, DB_NAME, null, DB_VER);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			TableWrapperLevelXX tableLebel01 = new TableWrapperLevelXX(1);
			tableLebel01.createTable(db);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXIST LEVEL01");
			onCreate( db );
		}
	}

	public static DatabaseManager getInstance() {
		return SingletonHolder.singleton;
	}

	private DatabaseManager() {
		this.context = MainActivity.mainActivity.getApplicationContext();
		this.dbHelper = new DatabaseHelper( context );
	}

	@Override
	protected void finalize() throws Throwable {
		if (this.db != null)
		{
			db.close();
		}

		super.finalize();
	}

	public SQLiteDatabase getDatabase() {
		if (this.db == null)
		{
			this.db = dbHelper.getWritableDatabase();
		}

		return db;
	}
}
