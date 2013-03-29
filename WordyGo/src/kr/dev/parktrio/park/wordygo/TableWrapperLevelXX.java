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
		insertData(db, "����", "���Ӥ���" );
		insertData(db, "����", "���̤���" );
		insertData(db, "����", "���Ǥ���" );
		insertData(db, "����", "���̤���" );
		insertData(db, "ȸ��", "���ʤ���" );
		insertData(db, "�ܾ�", "���ʤ���" );
		insertData(db, "���", "���Ӥ���" );
		insertData(db, "����", "���Ĥ���" );
		insertData(db, "����", "���Ӥ�����" );
		insertData(db, "�߰�", "���Ť�����" );
		insertData(db, "����", "���ä��̤�" );
		insertData(db, "����", "���ä�����" );
		insertData(db, "���", "���Ť�����" );
		insertData(db, "�ǹ�", "���Ӥ�����" );
		insertData(db, "����", "�������Ǥ�" );
		insertData(db, "ȥ��", "���Ǥ�����" );
		insertData(db, "����", "���Ǥ�������" );
		insertData(db, "����", "���Ť�������" );
		insertData(db, "����", "���Ť�������" );
		insertData(db, "�ǰ�", "���ä�������" );
		insertData(db, "����", "���Ǥ�������" );
		insertData(db, "����", "���Ǥ�������" );
		insertData(db, "�ѱ�", "���������̤�" );
		insertData(db, "�д�", "���̤�������" );
		insertData(db, "������", "���̤��ä�����" );
		insertData(db, "���ö�", "���Ǥ��Ӥ�����" );
		insertData(db, "������", "���ä����Ǥ���" );
		insertData(db, "ȭ����", "���Ȥ���������" );
		insertData(db, "��ǻ��", "���ä����Ф���" );
		insertData(db, "�繫��", "�������̤��Ӥ�" );
		insertData(db, "������", "���Ť����Ǥ���" );
		insertData(db, "������", "���ˤ��̤��Ť�" );
		insertData(db, "������", "���ä����ä�����" );
		insertData(db, "�̼���", "���Ӥ��̤����Ӥ�" );
		insertData(db, "�����", "���Ť����Ӥ�����" );
		insertData(db, "�����", "���ä����̤�����" );
		insertData(db, "������", "���Ǥ����Ѥ�����" );
		insertData(db, "������", "���ä����ä�����" );
		insertData(db, "������", "���Ǥ����ä��Ӥ�" );
		insertData(db, "û��ȸ", "���ä����̤�����" );
		insertData(db, "���ǻ�", "���ä�������������" );
		insertData(db, "�Ѱ���", "���������������Ӥ�" );
		insertData(db, "������", "���������������Ǥ�" );
		insertData(db, "���ܹ�", "���Ǥ����Ǥ�������" );
		insertData(db, "�긲��", "���������Ӥ����ˤ�" );
		insertData(db, "������", "���ä����ä����Ѥ�" );
		insertData(db, "���ǻ�", "���Ȥ�������������" );
		insertData(db, "������", "������������������" );
		insertData(db, "�����", "������������������" );
		insertData(db, "������", "���Ť����������Ȥ�" );
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
