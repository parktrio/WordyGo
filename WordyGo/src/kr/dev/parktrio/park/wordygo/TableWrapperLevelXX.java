package kr.dev.parktrio.park.wordygo;

import java.text.DecimalFormat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TableWrapperLevelXX {
	private int level = 1;

	private final DatabaseManager dbManager;

	private String name = "LEVELXX";
	public enum Columns
	{
		// PRIMARY KEY
		EXPRESSION {
			@Override
			public String getName()
			{
				return "expression";
			}
		},
		CHARACTERS {
			@Override
			public String getName()
			{
				return "characters";
			}
		};

		public abstract String getName();
	}

	public TableWrapperLevelXX(int level)
	{
		this.setLevel(level);
		dbManager = DatabaseManager.getInstance();
	}

	public boolean createTable(SQLiteDatabase db)
	{
		db.execSQL(this.getCreateStatement(level));
		// init data for test
		this.insertInitialData(db);

		return true;
	}

	public Cursor selectData()
	{
		SQLiteDatabase db = dbManager.getDatabase();
		return db.query(this.getName(), null, null, null, null, null, null);
	}

	public long insertData(String expression, String characters)
	{
		return this.insertData(dbManager.getDatabase(), expression, characters);
	}

	private long insertData(SQLiteDatabase db, String expression, String characters)
	{
		ContentValues value = new ContentValues();
		value.put(Columns.EXPRESSION.getName(), expression);
		value.put(Columns.CHARACTERS.getName(), characters);

		return db.insert(this.getName(), null, value);
	}

	private String getCreateStatement(int level)
	{
		DecimalFormat df00 = new DecimalFormat("00");
		String tableName = "LEVEL" + df00.format(level);

		StringBuilder sb = new StringBuilder("CREATE TABLE ");
		sb.append(tableName);
		sb.append("(").append(Columns.EXPRESSION.getName()).append(" TEXT PRIMARY KEY,");
		sb.append(Columns.CHARACTERS.getName()).append(" TEXT NOT NULL)");

		return sb.toString();
	}

	// for test
	private void insertInitialData(SQLiteDatabase db) {
		insertData(db, "미지", "ㅁㅣㅈㅣ" );
		insertData(db, "수내", "ㅅㅜㄴㅐ" );
		insertData(db, "보기", "ㅂㅗㄱㅣ" );
		insertData(db, "수리", "ㅅㅜㄹㅣ" );
		insertData(db, "회의", "ㅎㅚㅇㅢ" );
		insertData(db, "외야", "ㅇㅚㅇㅑ" );
		insertData(db, "기사", "ㄱㅣㅅㅏ" );
		insertData(db, "제주", "ㅈㅔㅈㅜ" );
		insertData(db, "진리", "ㅈㅣㄴㄹㅣ" );
		insertData(db, "견고", "ㄱㅕㄴㄱㅗ" );
		insertData(db, "서울", "ㅅㅓㅇㅜㄹ" );
		insertData(db, "정자", "ㅈㅓㅇㅈㅏ" );
		insertData(db, "경고", "ㄱㅕㅇㄱㅗ" );
		insertData(db, "실무", "ㅅㅣㄹㅁㅜ" );
		insertData(db, "가족", "ㄱㅏㅈㅗㄱ" );
		insertData(db, "혼례", "ㅎㅗㄴㄹㅖ" );
		insertData(db, "동산", "ㄷㅗㅇㅅㅏㄴ" );
		insertData(db, "병합", "ㅂㅕㅇㅎㅏㅂ" );
		insertData(db, "영상", "ㅇㅕㅇㅅㅏㅇ" );
		insertData(db, "건강", "ㄱㅓㄴㄱㅏㅇ" );
		insertData(db, "동향", "ㄷㅗㅇㅎㅑㅇ" );
		insertData(db, "공간", "ㄱㅗㅇㄱㅏㄴ" );
		insertData(db, "한국", "ㅎㅏㄴㄱㅜㄱ" );
		insertData(db, "분당", "ㅂㅜㄴㄷㅏㅇ" );
		insertData(db, "주전자", "ㅈㅜㅈㅓㄴㅈㅏ" );
		insertData(db, "도시락", "ㄷㅗㅅㅣㄹㅏㄱ" );
		insertData(db, "건포도", "ㄱㅓㄴㅍㅗㄷㅗ" );
		insertData(db, "화랑도", "ㅎㅘㄹㅏㅇㄷㅗ" );
		insertData(db, "컴퓨터", "ㅋㅓㅁㅍㅠㅌㅓ" );
		insertData(db, "사무실", "ㅅㅏㅁㅜㅅㅣㄹ" );
		insertData(db, "경포대", "ㄱㅕㅇㅍㅗㄷㅐ" );
		insertData(db, "교수형", "ㄱㅛㅅㅜㅎㅕㅇ" );
		insertData(db, "건전지", "ㄱㅓㄴㅈㅓㄴㅈㅣ" );
		insertData(db, "미술실", "ㅁㅣㅅㅜㄹㅅㅣㄹ" );
		insertData(db, "경기장", "ㄱㅕㅇㄱㅣㅈㅏㅇ" );
		insertData(db, "건축과", "ㄱㅓㄴㅊㅜㄱㄱㅘ" );
		insertData(db, "동승자", "ㄷㅗㅇㅅㅡㅇㅈㅏ" );
		insertData(db, "정거장", "ㅈㅓㅇㄱㅓㅈㅏㅇ" );
		insertData(db, "독서실", "ㄷㅗㄱㅅㅓㅅㅣㄹ" );
		insertData(db, "청문회", "ㅊㅓㅇㅁㅜㄴㅎㅚ" );
		insertData(db, "설악산", "ㅅㅓㄹㅇㅏㄱㅅㅏㄴ" );
		insertData(db, "한강진", "ㅎㅏㄴㄱㅏㅇㅈㅣㄴ" );
		insertData(db, "강낭콩", "ㄱㅏㅇㄴㅏㅇㅋㅗㅇ" );
		insertData(db, "돌솥밥", "ㄷㅗㄹㅅㅗㅌㅂㅏㅂ" );
		insertData(db, "산림욕", "ㅅㅏㄴㄹㅣㅁㅇㅛㄱ" );
		insertData(db, "선정릉", "ㅅㅓㄴㅈㅓㅇㄹㅡㅇ" );
		insertData(db, "관악산", "ㄱㅘㄴㅇㅏㄱㅅㅏㄴ" );
		insertData(db, "강감찬", "ㄱㅏㅇㄱㅏㅁㅊㅏㄴ" );
		insertData(db, "장발장", "ㅈㅏㅇㅂㅏㄹㅈㅏㅇ" );
		insertData(db, "경찰관", "ㄱㅕㅇㅊㅏㄹㄱㅘㄴ" );
	}

	public int getLevel() {
		return level;
	}

	private void setLevel(int level) {
		this.level = level;
		DecimalFormat df00 = new DecimalFormat("00");
		this.name = "LEVEL" + df00.format(this.level);
	}

	public String getName() {
		return name;
	}

}
