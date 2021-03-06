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
		switch (level) {
		case 1:
			insertData(db, "가래", "ㄱㅏㄹㅐ");
			insertData(db, "가로", "ㄱㅏㄹㅗ");
			insertData(db, "가루", "ㄱㅏㄹㅜ");
			insertData(db, "가수", "ㄱㅏㅅㅜ");
			insertData(db, "가시", "ㄱㅏㅅㅣ");
			insertData(db, "가요", "ㄱㅏㅇㅛ");
			insertData(db, "가치", "ㄱㅏㅊㅣ");
			insertData(db, "개화", "ㄱㅐㅎㅘ");
			insertData(db, "거래", "ㄱㅓㄹㅐ");
			insertData(db, "거리", "ㄱㅓㄹㅣ");
			insertData(db, "거지", "ㄱㅓㅈㅣ");
			insertData(db, "고기", "ㄱㅗㄱㅣ");
			insertData(db, "고래", "ㄱㅗㄹㅐ");
			insertData(db, "고리", "ㄱㅗㄹㅣ");
			insertData(db, "과제", "ㄱㅘㅈㅔ");
			insertData(db, "교회", "ㄱㅛㅎㅚ");
			insertData(db, "구리", "ㄱㅜㄹㅣ");
			insertData(db, "구미", "ㄱㅜㅁㅣ");
			insertData(db, "기계", "ㄱㅣㄱㅖ");
			insertData(db, "기사", "ㄱㅣㅅㅏ");
			insertData(db, "기아", "ㄱㅣㅇㅏ");
			insertData(db, "기지", "ㄱㅣㅈㅣ");
			insertData(db, "기타", "ㄱㅣㅌㅏ");
			insertData(db, "꼬리", "ㄲㅗㄹㅣ");
			insertData(db, "꼬치", "ㄲㅗㅊㅣ");
			insertData(db, "나무", "ㄴㅏㅁㅜ");
			insertData(db, "나치", "ㄴㅏㅊㅣ");
			insertData(db, "내야", "ㄴㅐㅇㅑ");
			insertData(db, "네모", "ㄴㅔㅁㅗ");
			insertData(db, "뉴스", "ㄴㅠㅅㅡ");
			insertData(db, "다리", "ㄷㅏㄹㅣ");
			insertData(db, "대구", "ㄷㅐㄱㅜ");
			insertData(db, "대타", "ㄷㅐㅌㅏ");
			insertData(db, "대파", "ㄷㅐㅍㅏ");
			insertData(db, "대포", "ㄷㅐㅍㅗ");
			insertData(db, "도로", "ㄷㅗㄹㅗ");
			insertData(db, "돼지", "ㄷㅙㅈㅣ");
			insertData(db, "마루", "ㅁㅏㄹㅜ");
			insertData(db, "마트", "ㅁㅏㅌㅡ");
			insertData(db, "머리", "ㅁㅓㄹㅣ");
			insertData(db, "미로", "ㅁㅣㄹㅗ");
			insertData(db, "미사", "ㅁㅣㅅㅏ");
			insertData(db, "미소", "ㅁㅣㅅㅗ");
			insertData(db, "미지", "ㅁㅣㅈㅣ");
			insertData(db, "바지", "ㅂㅏㅈㅣ");
			insertData(db, "배구", "ㅂㅐㄱㅜ");
			insertData(db, "버스", "ㅂㅓㅅㅡ");
			insertData(db, "보기", "ㅂㅗㄱㅣ");
			insertData(db, "보드", "ㅂㅗㄷㅡ");
			insertData(db, "사고", "ㅅㅏㄱㅗ");
			insertData(db, "사과", "ㅅㅏㄱㅘ");
			insertData(db, "사례", "ㅅㅏㄹㅖ");
			insertData(db, "사자", "ㅅㅏㅈㅏ");
			insertData(db, "사치", "ㅅㅏㅊㅣ");
			insertData(db, "사회", "ㅅㅏㅎㅚ");
			insertData(db, "새우", "ㅅㅐㅇㅜ");
			insertData(db, "세로", "ㅅㅔㄹㅗ");
			insertData(db, "세모", "ㅅㅔㅁㅗ");
			insertData(db, "소바", "ㅅㅗㅂㅏ");
			insertData(db, "소주", "ㅅㅗㅈㅜ");
			insertData(db, "수내", "ㅅㅜㄴㅐ");
			insertData(db, "수리", "ㅅㅜㄹㅣ");
			insertData(db, "수서", "ㅅㅜㅅㅓ");
			insertData(db, "스타", "ㅅㅡㅌㅏ");
			insertData(db, "시계", "ㅅㅣㄱㅖ");
			insertData(db, "시구", "ㅅㅣㄱㅜ");
			insertData(db, "시소", "ㅅㅣㅅㅗ");
			insertData(db, "아가", "ㅇㅏㄱㅏ");
			insertData(db, "아래", "ㅇㅏㄹㅐ");
			insertData(db, "야구", "ㅇㅑㄱㅜ");
			insertData(db, "야유", "ㅇㅑㅇㅠ");
			insertData(db, "야후", "ㅇㅑㅎㅜ");
			insertData(db, "여우", "ㅇㅕㅇㅜ");
			insertData(db, "여자", "ㅇㅕㅈㅏ");
			insertData(db, "오리", "ㅇㅗㄹㅣ");
			insertData(db, "오후", "ㅇㅗㅎㅜ");
			insertData(db, "외교", "ㅇㅚㄱㅛ");
			insertData(db, "외야", "ㅇㅚㅇㅑ");
			insertData(db, "요리", "ㅇㅛㄹㅣ");
			insertData(db, "우유", "ㅇㅜㅇㅠ");
			insertData(db, "우주", "ㅇㅜㅈㅜ");
			insertData(db, "의사", "ㅇㅢㅅㅏ");
			insertData(db, "의자", "ㅇㅢㅈㅏ");
			insertData(db, "자리", "ㅈㅏㄹㅣ");
			insertData(db, "자수", "ㅈㅏㅅㅜ");
			insertData(db, "재료", "ㅈㅐㄹㅛ");
			insertData(db, "제주", "ㅈㅔㅈㅜ");
			insertData(db, "조류", "ㅈㅗㄹㅠ");
			insertData(db, "지구", "ㅈㅣㄱㅜ");
			insertData(db, "지리", "ㅈㅣㄹㅣ");
			insertData(db, "지하", "ㅈㅣㅎㅏ");
			insertData(db, "추가", "ㅊㅜㄱㅏ");
			insertData(db, "커피", "ㅋㅓㅍㅣ");
			insertData(db, "코치", "ㅋㅗㅊㅣ");
			insertData(db, "타자", "ㅌㅏㅈㅏ");
			insertData(db, "토끼", "ㅌㅗㄲㅣ");
			insertData(db, "파리", "ㅍㅏㄹㅣ");
			insertData(db, "패배", "ㅍㅐㅂㅐ");
			insertData(db, "피구", "ㅍㅣㄱㅜ");
			insertData(db, "하계", "ㅎㅏㄱㅖ");
			insertData(db, "하마", "ㅎㅏㅁㅏ");
			insertData(db, "해태", "ㅎㅐㅌㅐ");
			insertData(db, "허리", "ㅎㅓㄹㅣ");
			insertData(db, "호수", "ㅎㅗㅅㅜ");
			insertData(db, "호피", "ㅎㅗㅍㅣ");
			insertData(db, "화보", "ㅎㅘㅂㅗ");
			insertData(db, "화폐", "ㅎㅘㅍㅖ");
			insertData(db, "회의", "ㅎㅚㅇㅢ");
			insertData(db, "후추", "ㅎㅜㅊㅜ");
			insertData(db, "후회", "ㅎㅜㅎㅚ");
			break;
		case 2:
			insertData(db, "가람", "ㄱㅏㄹㅏㅁ");
			insertData(db, "가방", "ㄱㅏㅂㅏㅇ");
			insertData(db, "가슴", "ㄱㅏㅅㅡㅁ");
			insertData(db, "가족", "ㄱㅏㅈㅗㄱ");
			insertData(db, "감사", "ㄱㅏㅁㅅㅏ");
			insertData(db, "감자", "ㄱㅏㅁㅈㅏ");
			insertData(db, "게임", "ㄱㅔㅇㅣㅁ");
			insertData(db, "견고", "ㄱㅕㄴㄱㅗ");
			insertData(db, "경기", "ㄱㅕㅇㄱㅣ");
			insertData(db, "경유", "ㄱㅕㅇㅇㅠ");
			insertData(db, "고철", "ㄱㅗㅊㅓㄹ");
			insertData(db, "골프", "ㄱㅗㄹㅍㅡ");
			insertData(db, "공기", "ㄱㅗㅇㄱㅣ");
			insertData(db, "과학", "ㄱㅘㅎㅏㄱ");
			insertData(db, "광주", "ㄱㅘㅇㅈㅜ");
			insertData(db, "교실", "ㄱㅛㅅㅣㄹ");
			insertData(db, "구글", "ㄱㅜㄱㅡㄹ");
			insertData(db, "구독", "ㄱㅜㄷㅗㄱ");
			insertData(db, "구름", "ㄱㅜㄹㅡㅁ");
			insertData(db, "구출", "ㄱㅜㅊㅜㄹ");
			insertData(db, "국회", "ㄱㅜㄱㅎㅚ");
			insertData(db, "군대", "ㄱㅜㄴㄷㅐ");
			insertData(db, "그늘", "ㄱㅡㄴㅡㄹ");
			insertData(db, "그림", "ㄱㅡㄹㅣㅁ");
			insertData(db, "금리", "ㄱㅡㅁㄹㅣ");
			insertData(db, "기린", "ㄱㅣㄹㅣㄴ");
			insertData(db, "남자", "ㄴㅏㅁㅈㅏ");
			insertData(db, "냄새", "ㄴㅐㅁㅅㅐ");
			insertData(db, "노동", "ㄴㅗㄷㅗㅇ");
			insertData(db, "녹차", "ㄴㅗㄱㅊㅏ");
			insertData(db, "농구", "ㄴㅗㅇㄱㅜ");
			insertData(db, "뇌물", "ㄴㅚㅁㅜㄹ");
			insertData(db, "누락", "ㄴㅜㄹㅏㄱ");
			insertData(db, "뉴욕", "ㄴㅠㅇㅛㄱ");
			insertData(db, "다락", "ㄷㅏㄹㅏㄱ");
			insertData(db, "다음", "ㄷㅏㅇㅡㅁ");
			insertData(db, "당구", "ㄷㅏㅇㄱㅜ");
			insertData(db, "대만", "ㄷㅐㅁㅏㄴ");
			insertData(db, "대문", "ㄷㅐㅁㅜㄴ");
			insertData(db, "대전", "ㄷㅐㅈㅓㄴ");
			insertData(db, "더덕", "ㄷㅓㄷㅓㄱ");
			insertData(db, "덜미", "ㄷㅓㄹㅁㅣ");
			insertData(db, "도덕", "ㄷㅗㄷㅓㄱ");
			insertData(db, "독도", "ㄷㅗㄱㄷㅗ");
			insertData(db, "독사", "ㄷㅗㄱㅅㅏ");
			insertData(db, "동계", "ㄷㅗㅇㄱㅖ");
			insertData(db, "드럼", "ㄷㅡㄹㅓㅁ");
			insertData(db, "라면", "ㄹㅏㅁㅕㄴ");
			insertData(db, "마늘", "ㅁㅏㄴㅡㄹ");
			insertData(db, "마님", "ㅁㅏㄴㅣㅁ");
			insertData(db, "만두", "ㅁㅏㄴㄷㅜ");
			insertData(db, "만루", "ㅁㅏㄴㄹㅜ");
			insertData(db, "만화", "ㅁㅏㄴㅎㅘ");
			insertData(db, "맥주", "ㅁㅐㄱㅈㅜ");
			insertData(db, "모순", "ㅁㅗㅅㅜㄴ");
			insertData(db, "목포", "ㅁㅗㄱㅍㅗ");
			insertData(db, "문제", "ㅁㅜㄴㅈㅔ");
			insertData(db, "문화", "ㅁㅜㄴㅎㅘ");
			insertData(db, "미국", "ㅁㅣㄱㅜㄱ");
			insertData(db, "미술", "ㅁㅣㅅㅜㄹ");
			insertData(db, "밍크", "ㅁㅣㅇㅋㅡ");
			insertData(db, "바람", "ㅂㅏㄹㅏㅁ");
			insertData(db, "반지", "ㅂㅏㄴㅈㅣ");
			insertData(db, "방패", "ㅂㅏㅇㅍㅐ");
			insertData(db, "보험", "ㅂㅗㅎㅓㅁ");
			insertData(db, "부산", "ㅂㅜㅅㅏㄴ");
			insertData(db, "비밀", "ㅂㅣㅁㅣㄹ");
			insertData(db, "빨래", "ㅃㅏㄹㄹㅐ");
			insertData(db, "사람", "ㅅㅏㄹㅏㅁ");
			insertData(db, "사슴", "ㅅㅏㅅㅡㅁ");
			insertData(db, "사진", "ㅅㅏㅈㅣㄴ");
			insertData(db, "산타", "ㅅㅏㄴㅌㅏ");
			insertData(db, "서랍", "ㅅㅓㄹㅏㅂ");
			insertData(db, "서울", "ㅅㅓㅇㅜㄹ");
			insertData(db, "석류", "ㅅㅓㄱㄹㅠ");
			insertData(db, "석유", "ㅅㅓㄱㅇㅠ");
			insertData(db, "소금", "ㅅㅗㄱㅡㅁ");
			insertData(db, "속도", "ㅅㅗㄱㄷㅗ");
			insertData(db, "쇼핑", "ㅅㅛㅍㅣㅇ");
			insertData(db, "수술", "ㅅㅜㅅㅜㄹ");
			insertData(db, "수영", "ㅅㅜㅇㅕㅇ");
			insertData(db, "수출", "ㅅㅜㅊㅜㄹ");
			insertData(db, "수학", "ㅅㅜㅎㅏㄱ");
			insertData(db, "숙제", "ㅅㅜㄱㅈㅔ");
			insertData(db, "순위", "ㅅㅜㄴㅇㅟ");
			insertData(db, "스님", "ㅅㅡㄴㅣㅁ");
			insertData(db, "시식", "ㅅㅣㅅㅣㄱ");
			insertData(db, "시험", "ㅅㅣㅎㅓㅁ");
			insertData(db, "식사", "ㅅㅣㄱㅅㅏ");
			insertData(db, "신고", "ㅅㅣㄴㄱㅗ");
			insertData(db, "신사", "ㅅㅣㄴㅅㅏ");
			insertData(db, "실무", "ㅅㅣㄹㅁㅜ");
			insertData(db, "실수", "ㅅㅣㄹㅅㅜ");
			insertData(db, "썰매", "ㅆㅓㄹㅁㅐ");
			insertData(db, "아랍", "ㅇㅏㄹㅏㅂ");
			insertData(db, "아침", "ㅇㅏㅊㅣㅁ");
			insertData(db, "안타", "ㅇㅏㄴㅌㅏ");
			insertData(db, "양주", "ㅇㅑㅇㅈㅜ");
			insertData(db, "어른", "ㅇㅓㄹㅡㄴ");
			insertData(db, "엘지", "ㅇㅔㄹㅈㅣ");
			insertData(db, "역사", "ㅇㅕㄱㅅㅏ");
			insertData(db, "연주", "ㅇㅕㄴㅈㅜ");
			insertData(db, "예금", "ㅇㅖㄱㅡㅁ");
			insertData(db, "예능", "ㅇㅖㄴㅡㅇ");
			insertData(db, "예술", "ㅇㅖㅅㅜㄹ");
			insertData(db, "오락", "ㅇㅗㄹㅏㄱ");
			insertData(db, "오전", "ㅇㅗㅈㅓㄴ");
			insertData(db, "왕자", "ㅇㅘㅇㅈㅏ");
			insertData(db, "외국", "ㅇㅚㄱㅜㄱ");
			insertData(db, "요청", "ㅇㅛㅊㅓㅇ");
			insertData(db, "우연", "ㅇㅜㅇㅕㄴ");
			insertData(db, "육류", "ㅇㅠㄱㄹㅠ");
			insertData(db, "이름", "ㅇㅣㄹㅡㅁ");
			insertData(db, "이상", "ㅇㅣㅅㅏㅇ");
			insertData(db, "이슬", "ㅇㅣㅅㅡㄹ");
			insertData(db, "이웃", "ㅇㅣㅇㅜㅅ");
			insertData(db, "인쇄", "ㅇㅣㄴㅅㅙ");
			insertData(db, "잔치", "ㅈㅏㄴㅊㅣ");
			insertData(db, "잡지", "ㅈㅏㅂㅈㅣ");
			insertData(db, "전기", "ㅈㅓㄴㄱㅣ");
			insertData(db, "전주", "ㅈㅓㄴㅈㅜ");
			insertData(db, "전화", "ㅈㅓㄴㅎㅘ");
			insertData(db, "정자", "ㅈㅓㅇㅈㅏ");
			insertData(db, "정치", "ㅈㅓㅇㅊㅣ");
			insertData(db, "조합", "ㅈㅗㅎㅏㅂ");
			insertData(db, "족구", "ㅈㅗㄱㄱㅜ");
			insertData(db, "종로", "ㅈㅗㅇㄹㅗ");
			insertData(db, "주산", "ㅈㅜㅅㅏㄴ");
			insertData(db, "주식", "ㅈㅜㅅㅣㄱ");
			insertData(db, "지방", "ㅈㅣㅂㅏㅇ");
			insertData(db, "진리", "ㅈㅣㄴㄹㅣ");
			insertData(db, "척추", "ㅊㅓㄱㅊㅜ");
			insertData(db, "철새", "ㅊㅓㄹㅅㅐ");
			insertData(db, "청주", "ㅊㅓㅇㅈㅜ");
			insertData(db, "체험", "ㅊㅔㅎㅓㅁ");
			insertData(db, "축구", "ㅊㅜㄱㄱㅜ");
			insertData(db, "춘추", "ㅊㅜㄴㅊㅜ");
			insertData(db, "충주", "ㅊㅜㅇㅈㅜ");
			insertData(db, "친구", "ㅊㅣㄴㄱㅜ");
			insertData(db, "카톡", "ㅋㅏㅌㅗㄱ");
			insertData(db, "케잌", "ㅋㅔㅇㅣㅋ");
			insertData(db, "콜라", "ㅋㅗㄹㄹㅏ");
			insertData(db, "타락", "ㅌㅏㄹㅏㄱ");
			insertData(db, "태양", "ㅌㅐㅇㅑㅇ");
			insertData(db, "택시", "ㅌㅐㄱㅅㅣ");
			insertData(db, "특허", "ㅌㅡㄱㅎㅓ");
			insertData(db, "파전", "ㅍㅏㅈㅓㄴ");
			insertData(db, "패션", "ㅍㅐㅅㅕㄴ");
			insertData(db, "표범", "ㅍㅛㅂㅓㅁ");
			insertData(db, "하락", "ㅎㅏㄹㅏㄱ");
			insertData(db, "학교", "ㅎㅏㄱㄱㅛ");
			insertData(db, "한화", "ㅎㅏㄴㅎㅘ");
			insertData(db, "혼례", "ㅎㅗㄴㄹㅖ");
			insertData(db, "홍차", "ㅎㅗㅇㅊㅏ");
			insertData(db, "화곡", "ㅎㅘㄱㅗㄱ");
			insertData(db, "화면", "ㅎㅘㅁㅕㄴ");
			insertData(db, "화성", "ㅎㅘㅅㅓㅇ");
			insertData(db, "회원", "ㅎㅚㅇㅝㄴ");
			insertData(db, "후식", "ㅎㅜㅅㅣㄱ");
			break;
		case 3:
			insertData(db, "가로수", "ㄱㅏㄹㅗㅅㅜ");
			insertData(db, "가리비", "ㄱㅏㄹㅣㅂㅣ");
			insertData(db, "감독", "ㄱㅏㅁㄷㅗㄱ");
			insertData(db, "강남", "ㄱㅏㅇㄴㅏㅁ");
			insertData(db, "강원", "ㄱㅏㅇㅇㅝㄴ");
			insertData(db, "거래처", "ㄱㅓㄹㅐㅊㅓ");
			insertData(db, "거머리", "ㄱㅓㅁㅓㄹㅣ");
			insertData(db, "건강", "ㄱㅓㄴㄱㅏㅇ");
			insertData(db, "결혼", "ㄱㅕㄹㅎㅗㄴ");
			insertData(db, "고구마", "ㄱㅗㄱㅜㅁㅏ");
			insertData(db, "고도리", "ㄱㅗㄷㅗㄹㅣ");
			insertData(db, "공간", "ㄱㅗㅇㄱㅏㄴ");
			insertData(db, "공원", "ㄱㅗㅇㅇㅝㄴ");
			insertData(db, "공학", "ㄱㅗㅇㅎㅏㄱ");
			insertData(db, "공항", "ㄱㅗㅇㅎㅏㅇ");
			insertData(db, "권총", "ㄱㅝㄴㅊㅗㅇ");
			insertData(db, "그리스", "ㄱㅡㄹㅣㅅㅡ");
			insertData(db, "금융", "ㄱㅡㅁㅇㅠㅇ");
			insertData(db, "김밥", "ㄱㅣㅁㅂㅏㅂ");
			insertData(db, "까마귀", "ㄲㅏㅁㅏㄱㅟ");
			insertData(db, "깡통", "ㄲㅏㅇㅌㅗㅇ");
			insertData(db, "꾸러기", "ㄲㅜㄹㅓㄱㅣ");
			insertData(db, "남극", "ㄴㅏㅁㄱㅡㄱ");
			insertData(db, "남남", "ㄴㅏㅁㄴㅏㅁ");
			insertData(db, "남산", "ㄴㅏㅁㅅㅏㄴ");
			insertData(db, "네이버", "ㄴㅔㅇㅣㅂㅓ");
			insertData(db, "농장", "ㄴㅗㅇㅈㅏㅇ");
			insertData(db, "독립", "ㄷㅗㄱㄹㅣㅂ");
			insertData(db, "돌솥", "ㄷㅗㄹㅅㅗㅌ");
			insertData(db, "동물", "ㄷㅗㅇㅁㅜㄹ");
			insertData(db, "동산", "ㄷㅗㅇㅅㅏㄴ");
			insertData(db, "동향", "ㄷㅗㅇㅎㅑㅇ");
			insertData(db, "뒷면", "ㄷㅟㅅㅁㅕㄴ");
			insertData(db, "라이타", "ㄹㅏㅇㅣㅌㅏ");
			insertData(db, "런던", "ㄹㅓㄴㄷㅓㄴ");
			insertData(db, "명동", "ㅁㅕㅇㄷㅗㅇ");
			insertData(db, "명령", "ㅁㅕㅇㄹㅕㅇ");
			insertData(db, "명함", "ㅁㅕㅇㅎㅏㅁ");
			insertData(db, "모니터", "ㅁㅗㄴㅣㅌㅓ");
			insertData(db, "목성", "ㅁㅗㄱㅅㅓㅇ");
			insertData(db, "무리수", "ㅁㅜㄹㅣㅅㅜ");
			insertData(db, "무지개", "ㅁㅜㅈㅣㄱㅐ");
			insertData(db, "물컵", "ㅁㅜㄹㅋㅓㅂ");
			insertData(db, "미나리", "ㅁㅣㄴㅏㄹㅣ");
			insertData(db, "바구니", "ㅂㅏㄱㅜㄴㅣ");
			insertData(db, "바나나", "ㅂㅏㄴㅏㄴㅏ");
			insertData(db, "밥솥", "ㅂㅏㅂㅅㅗㅌ");
			insertData(db, "배터리", "ㅂㅐㅌㅓㄹㅣ");
			insertData(db, "벌집", "ㅂㅓㄹㅈㅣㅂ");
			insertData(db, "법원", "ㅂㅓㅂㅇㅝㄴ");
			insertData(db, "벗꽃", "ㅂㅓㅅㄲㅗㅊ");
			insertData(db, "별빛", "ㅂㅕㄹㅂㅣㅊ");
			insertData(db, "병원", "ㅂㅕㅇㅇㅝㄴ");
			insertData(db, "병장", "ㅂㅕㅇㅈㅏㅇ");
			insertData(db, "병합", "ㅂㅕㅇㅎㅏㅂ");
			insertData(db, "볶음", "ㅂㅗㄲㅇㅡㅁ");
			insertData(db, "볼펜", "ㅂㅗㄹㅍㅔㄴ");
			insertData(db, "북극", "ㅂㅜㄱㄱㅡㄱ");
			insertData(db, "분당", "ㅂㅜㄴㄷㅏㅇ");
			insertData(db, "빌딩", "ㅂㅣㄹㄷㅣㅇ");
			insertData(db, "빵집", "ㅃㅏㅇㅈㅣㅂ");
			insertData(db, "뽀로로", "ㅃㅗㄹㅗㄹㅗ");
			insertData(db, "사이다", "ㅅㅏㅇㅣㄷㅏ");
			insertData(db, "산삼", "ㅅㅏㄴㅅㅏㅁ");
			insertData(db, "산장", "ㅅㅏㄴㅈㅏㅇ");
			insertData(db, "상병", "ㅅㅏㅇㅂㅕㅇ");
			insertData(db, "상상", "ㅅㅏㅇㅅㅏㅇ");
			insertData(db, "상승", "ㅅㅏㅇㅅㅡㅇ");
			insertData(db, "샛별", "ㅅㅐㅅㅂㅕㄹ");
			insertData(db, "생선", "ㅅㅐㅇㅅㅓㄴ");
			insertData(db, "설탕", "ㅅㅓㄹㅌㅏㅇ");
			insertData(db, "성당", "ㅅㅓㅇㄷㅏㅇ");
			insertData(db, "세계사", "ㅅㅔㄱㅖㅅㅏ");
			insertData(db, "수채화", "ㅅㅜㅊㅐㅎㅘ");
			insertData(db, "식물", "ㅅㅣㄱㅁㅜㄹ");
			insertData(db, "신림", "ㅅㅣㄴㄹㅣㅁ");
			insertData(db, "신문", "ㅅㅣㄴㅁㅜㄴ");
			insertData(db, "심장", "ㅅㅣㅁㅈㅏㅇ");
			insertData(db, "쓰레기", "ㅆㅡㄹㅔㄱㅣ");
			insertData(db, "아버지", "ㅇㅏㅂㅓㅈㅣ");
			insertData(db, "안경", "ㅇㅏㄴㄱㅕㅇ");
			insertData(db, "앞면", "ㅇㅏㅍㅁㅕㄴ");
			insertData(db, "양궁", "ㅇㅑㅇㄱㅜㅇ");
			insertData(db, "양념", "ㅇㅑㅇㄴㅕㅁ");
			insertData(db, "어머니", "ㅇㅓㅁㅓㄴㅣ");
			insertData(db, "에너지", "ㅇㅔㄴㅓㅈㅣ");
			insertData(db, "여의도", "ㅇㅕㅇㅢㄷㅗ");
			insertData(db, "연결", "ㅇㅕㄴㄱㅕㄹ");
			insertData(db, "연속", "ㅇㅕㄴㅅㅗㄱ");
			insertData(db, "연습", "ㅇㅕㄴㅅㅡㅂ");
			insertData(db, "연필", "ㅇㅕㄴㅍㅣㄹ");
			insertData(db, "영동", "ㅇㅕㅇㄷㅗㅇ");
			insertData(db, "영상", "ㅇㅕㅇㅅㅏㅇ");
			insertData(db, "옥상", "ㅇㅗㄱㅅㅏㅇ");
			insertData(db, "왼손", "ㅇㅚㄴㅅㅗㄴ");
			insertData(db, "운동", "ㅇㅜㄴㄷㅗㅇ");
			insertData(db, "월급", "ㅇㅝㄹㄱㅡㅂ");
			insertData(db, "육상", "ㅇㅠㄱㅅㅏㅇ");
			insertData(db, "은행", "ㅇㅡㄴㅎㅐㅇ");
			insertData(db, "이야기", "ㅇㅣㅇㅑㄱㅣ");
			insertData(db, "인천", "ㅇㅣㄴㅊㅓㄴ");
			insertData(db, "일꾼", "ㅇㅣㄹㄲㅜㄴ");
			insertData(db, "일본", "ㅇㅣㄹㅂㅗㄴ");
			insertData(db, "작전", "ㅈㅏㄱㅈㅓㄴ");
			insertData(db, "장군", "ㅈㅏㅇㄱㅜㄴ");
			insertData(db, "전북", "ㅈㅓㄴㅂㅜㄱ");
			insertData(db, "점심", "ㅈㅓㅁㅅㅣㅁ");
			insertData(db, "정답", "ㅈㅓㅇㄷㅏㅂ");
			insertData(db, "족발", "ㅈㅗㄱㅂㅏㄹ");
			insertData(db, "중국", "ㅈㅜㅇㄱㅜㄱ");
			insertData(db, "직업", "ㅈㅣㄱㅇㅓㅂ");
			insertData(db, "직장", "ㅈㅣㄱㅈㅏㅇ");
			insertData(db, "참석", "ㅊㅏㅁㅅㅓㄱ");
			insertData(db, "책상", "ㅊㅐㄱㅅㅏㅇ");
			insertData(db, "철인", "ㅊㅓㄹㅇㅣㄴ");
			insertData(db, "춘천", "ㅊㅜㄴㅊㅓㄴ");
			insertData(db, "출입", "ㅊㅜㄹㅇㅣㅂ");
			insertData(db, "충남", "ㅊㅜㅇㄴㅏㅁ");
			insertData(db, "충북", "ㅊㅜㅇㅂㅜㄱ");
			insertData(db, "칠판", "ㅊㅣㄹㅍㅏㄴ");
			insertData(db, "카메라", "ㅋㅏㅁㅔㄹㅏ");
			insertData(db, "코끼리", "ㅋㅗㄲㅣㄹㅣ");
			insertData(db, "코리아", "ㅋㅗㄹㅣㅇㅏ");
			insertData(db, "키보드", "ㅋㅣㅂㅗㄷㅡ");
			insertData(db, "통닭", "ㅌㅗㅇㄷㅏㄺ");
			insertData(db, "평균", "ㅍㅕㅇㄱㅠㄴ");
			insertData(db, "풍경", "ㅍㅜㅇㄱㅕㅇ");
			insertData(db, "필름", "ㅍㅣㄹㄹㅡㅁ");
			insertData(db, "한국", "ㅎㅏㄴㄱㅜㄱ");
			insertData(db, "한글", "ㅎㅏㄴㄱㅡㄹ");
			insertData(db, "해우소", "ㅎㅐㅇㅜㅅㅗ");
			insertData(db, "홈런", "ㅎㅗㅁㄹㅓㄴ");
			insertData(db, "홍삼", "ㅎㅗㅇㅅㅏㅁ");
			break;
		case 4:
			insertData(db, "간호사", "ㄱㅏㄴㅎㅗㅅㅏ");
			insertData(db, "갈매기", "ㄱㅏㄹㅁㅐㄱㅣ");
			insertData(db, "강아지", "ㄱㅏㅇㅇㅏㅈㅣ");
			insertData(db, "개발자", "ㄱㅐㅂㅏㄹㅈㅏ");
			insertData(db, "건포도", "ㄱㅓㄴㅍㅗㄷㅗ");
			insertData(db, "결사대", "ㄱㅕㄹㅅㅏㄷㅐ");
			insertData(db, "경포대", "ㄱㅕㅇㅍㅗㄷㅐ");
			insertData(db, "계산대", "ㄱㅖㅅㅏㄴㄷㅐ");
			insertData(db, "고교생", "ㄱㅗㄱㅛㅅㅐㅇ");
			insertData(db, "고드름", "ㄱㅗㄷㅡㄹㅡㅁ");
			insertData(db, "고등어", "ㄱㅗㄷㅡㅇㅇㅓ");
			insertData(db, "고추장", "ㄱㅗㅊㅜㅈㅏㅇ");
			insertData(db, "교수형", "ㄱㅛㅅㅜㅎㅕㅇ");
			insertData(db, "구급차", "ㄱㅜㄱㅡㅂㅊㅏ");
			insertData(db, "구세군", "ㄱㅜㅅㅔㄱㅜㄴ");
			insertData(db, "굴다리", "ㄱㅜㄹㄷㅏㄹㅣ");
			insertData(db, "귀걸이", "ㄱㅟㄱㅓㄹㅇㅣ");
			insertData(db, "그림자", "ㄱㅡㄹㅣㅁㅈㅏ");
			insertData(db, "기획자", "ㄱㅣㅎㅚㄱㅈㅏ");
			insertData(db, "노트북", "ㄴㅗㅌㅡㅂㅜㄱ");
			insertData(db, "놀이터", "ㄴㅗㄹㅇㅣㅌㅓ");
			insertData(db, "다람쥐", "ㄷㅏㄹㅏㅁㅈㅟ");
			insertData(db, "달리기", "ㄷㅏㄹㄹㅣㄱㅣ");
			insertData(db, "닭꼬치", "ㄷㅏㄺㄲㅗㅊㅣ");
			insertData(db, "대구탕", "ㄷㅐㄱㅜㅌㅏㅇ");
			insertData(db, "대리님", "ㄷㅐㄹㅣㄴㅣㅁ");
			insertData(db, "대비책", "ㄷㅐㅂㅣㅊㅐㄱ");
			insertData(db, "대학로", "ㄷㅐㅎㅏㄱㄹㅗ");
			insertData(db, "도시락", "ㄷㅗㅅㅣㄹㅏㄱ");
			insertData(db, "독수리", "ㄷㅗㄱㅅㅜㄹㅣ");
			insertData(db, "뚝배기", "ㄸㅜㄱㅂㅐㄱㅣ");
			insertData(db, "뜨개질", "ㄸㅡㄱㅐㅈㅣㄹ");
			insertData(db, "랍스터", "ㄹㅏㅂㅅㅡㅌㅓ");
			insertData(db, "루돌프", "ㄹㅜㄷㅗㄹㅍㅡ");
			insertData(db, "마구간", "ㅁㅏㄱㅜㄱㅏㄴ");
			insertData(db, "마라톤", "ㅁㅏㄹㅏㅌㅗㄴ");
			insertData(db, "말리브", "ㅁㅏㄹㄹㅣㅂㅡ");
			insertData(db, "말타기", "ㅁㅏㄹㅌㅏㄱㅣ");
			insertData(db, "망아지", "ㅁㅏㅇㅇㅏㅈㅣ");
			insertData(db, "먹거리", "ㅁㅓㄱㄱㅓㄹㅣ");
			insertData(db, "멧돼지", "ㅁㅔㅅㄷㅙㅈㅣ");
			insertData(db, "명사수", "ㅁㅕㅇㅅㅏㅅㅜ");
			insertData(db, "모바일", "ㅁㅗㅂㅏㅇㅣㄹ");
			insertData(db, "무협지", "ㅁㅜㅎㅕㅂㅈㅣ");
			insertData(db, "밀가루", "ㅁㅣㄹㄱㅏㄹㅜ");
			insertData(db, "반도체", "ㅂㅏㄴㄷㅗㅊㅔ");
			insertData(db, "발야구", "ㅂㅏㄹㅇㅑㄱㅜ");
			insertData(db, "배구공", "ㅂㅐㄱㅜㄱㅗㅇ");
			insertData(db, "북마크", "ㅂㅜㄱㅁㅏㅋㅡ");
			insertData(db, "분리대", "ㅂㅜㄴㄹㅣㄷㅐ");
			insertData(db, "불고기", "ㅂㅜㄹㄱㅗㄱㅣ");
			insertData(db, "불사조", "ㅂㅜㄹㅅㅏㅈㅗ");
			insertData(db, "브라질", "ㅂㅡㄹㅏㅈㅣㄹ");
			insertData(db, "비행기", "ㅂㅣㅎㅐㅇㄱㅣ");
			insertData(db, "빗자루", "ㅂㅣㅅㅈㅏㄹㅜ");
			insertData(db, "사무실", "ㅅㅏㅁㅜㅅㅣㄹ");
			insertData(db, "산토끼", "ㅅㅏㄴㅌㅗㄲㅣ");
			insertData(db, "서울대", "ㅅㅓㅇㅜㄹㄷㅐ");
			insertData(db, "세탁기", "ㅅㅔㅌㅏㄱㄱㅣ");
			insertData(db, "소방서", "ㅅㅗㅂㅏㅇㅅㅓ");
			insertData(db, "수류탄", "ㅅㅜㄹㅠㅌㅏㄴ");
			insertData(db, "수묵화", "ㅅㅜㅁㅜㄱㅎㅘ");
			insertData(db, "수요일", "ㅅㅜㅇㅛㅇㅣㄹ");
			insertData(db, "시험지", "ㅅㅣㅎㅓㅁㅈㅣ");
			insertData(db, "아이돌", "ㅇㅏㅇㅣㄷㅗㄹ");
			insertData(db, "아이템", "ㅇㅏㅇㅣㅌㅔㅁ");
			insertData(db, "아이폰", "ㅇㅏㅇㅣㅍㅗㄴ");
			insertData(db, "애벌레", "ㅇㅐㅂㅓㄹㄹㅔ");
			insertData(db, "에밀레", "ㅇㅔㅁㅣㄹㄹㅔ");
			insertData(db, "연구소", "ㅇㅕㄴㄱㅜㅅㅗ");
			insertData(db, "올가미", "ㅇㅗㄹㄱㅏㅁㅣ");
			insertData(db, "외계인", "ㅇㅚㄱㅖㅇㅣㄴ");
			insertData(db, "우주선", "ㅇㅜㅈㅜㅅㅓㄴ");
			insertData(db, "우주인", "ㅇㅜㅈㅜㅇㅣㄴ");
			insertData(db, "월계수", "ㅇㅝㄹㄱㅖㅅㅜ");
			insertData(db, "유니콘", "ㅇㅠㄴㅣㅋㅗㄴ");
			insertData(db, "유리창", "ㅇㅠㄹㅣㅊㅏㅇ");
			insertData(db, "유치원", "ㅇㅠㅊㅣㅇㅝㄴ");
			insertData(db, "유행가", "ㅇㅠㅎㅐㅇㄱㅏ");
			insertData(db, "은하계", "ㅇㅡㄴㅎㅏㄱㅖ");
			insertData(db, "을지로", "ㅇㅡㄹㅈㅣㄹㅗ");
			insertData(db, "음료수", "ㅇㅡㅁㄹㅛㅅㅜ");
			insertData(db, "이름표", "ㅇㅣㄹㅡㅁㅍㅛ");
			insertData(db, "이메일", "ㅇㅣㅁㅔㅇㅣㄹ");
			insertData(db, "자동차", "ㅈㅏㄷㅗㅇㅊㅏ");
			insertData(db, "자전거", "ㅈㅏㅈㅓㄴㄱㅓ");
			insertData(db, "장거리", "ㅈㅏㅇㄱㅓㄹㅣ");
			insertData(db, "저격수", "ㅈㅓㄱㅕㄱㅅㅜ");
			insertData(db, "주전자", "ㅈㅜㅈㅓㄴㅈㅏ");
			insertData(db, "중고차", "ㅈㅜㅇㄱㅗㅊㅏ");
			insertData(db, "지하철", "ㅈㅣㅎㅏㅊㅓㄹ");
			insertData(db, "초여름", "ㅊㅗㅇㅕㄹㅡㅁ");
			insertData(db, "추상화", "ㅊㅜㅅㅏㅇㅎㅘ");
			insertData(db, "캬라멜", "ㅋㅑㄹㅏㅁㅔㄹ");
			insertData(db, "컴퓨터", "ㅋㅓㅁㅍㅠㅌㅓ");
			insertData(db, "타악기", "ㅌㅏㅇㅏㄱㄱㅣ");
			insertData(db, "타이젠", "ㅌㅏㅇㅣㅈㅔㄴ");
			insertData(db, "태극기", "ㅌㅐㄱㅡㄱㄱㅣ");
			insertData(db, "토요일", "ㅌㅗㅇㅛㅇㅣㄹ");
			insertData(db, "파출소", "ㅍㅏㅊㅜㄹㅅㅗ");
			insertData(db, "할머니", "ㅎㅏㄹㅁㅓㄴㅣ");
			insertData(db, "해병대", "ㅎㅐㅂㅕㅇㄷㅐ");
			insertData(db, "호랑이", "ㅎㅗㄹㅏㅇㅇㅣ");
			insertData(db, "화랑도", "ㅎㅘㄹㅏㅇㄷㅗ");
			insertData(db, "화요일", "ㅎㅘㅇㅛㅇㅣㄹ");
			insertData(db, "휘발유", "ㅎㅟㅂㅏㄹㅇㅠ");
			break;
		case 5:
			insertData(db, "갈비찜", "ㄱㅏㄹㅂㅣㅉㅣㅁ");
			insertData(db, "갤럭시", "ㄱㅐㄹㄹㅓㄱㅅㅣ");
			insertData(db, "건전지", "ㄱㅓㄴㅈㅓㄴㅈㅣ");
			insertData(db, "건축과", "ㄱㅓㄴㅊㅜㄱㄱㅘ");
			insertData(db, "경기장", "ㄱㅕㅇㄱㅣㅈㅏㅇ");
			insertData(db, "계룡산", "ㄱㅖㄹㅛㅇㅅㅏㄴ");
			insertData(db, "골뱅이", "ㄱㅗㄹㅂㅐㅇㅇㅣ");
			insertData(db, "골프공", "ㄱㅗㄹㅍㅡㄱㅗㅇ");
			insertData(db, "공격수", "ㄱㅗㅇㄱㅕㄱㅅㅜ");
			insertData(db, "공기밥", "ㄱㅗㅇㄱㅣㅂㅏㅂ");
			insertData(db, "과장님", "ㄱㅘㅈㅏㅇㄴㅣㅁ");
			insertData(db, "국세청", "ㄱㅜㄱㅅㅔㅊㅓㅇ");
			insertData(db, "굼뱅이", "ㄱㅜㅁㅂㅐㅇㅇㅣ");
			insertData(db, "그림책", "ㄱㅡㄹㅣㅁㅊㅐㄱ");
			insertData(db, "금요일", "ㄱㅡㅁㅇㅛㅇㅣㄹ");
			insertData(db, "껌딱지", "ㄲㅓㅁㄸㅏㄱㅈㅣ");
			insertData(db, "껌종이", "ㄲㅓㅁㅈㅗㅇㅇㅣ");
			insertData(db, "남성미", "ㄴㅏㅁㅅㅓㅇㅁㅣ");
			insertData(db, "냉장고", "ㄴㅐㅇㅈㅏㅇㄱㅗ");
			insertData(db, "농구공", "ㄴㅗㅇㄱㅜㄱㅗㅇ");
			insertData(db, "눈사람", "ㄴㅜㄴㅅㅏㄹㅏㅁ");
			insertData(db, "다이어리", "ㄷㅏㅇㅣㅇㅓㄹㅣ");
			insertData(db, "다이어트", "ㄷㅏㅇㅣㅇㅓㅌㅡ");
			insertData(db, "단축키", "ㄷㅏㄴㅊㅜㄱㅋㅣ");
			insertData(db, "닭튀김", "ㄷㅏㄺㅌㅟㄱㅣㅁ");
			insertData(db, "대통령", "ㄷㅐㅌㅗㅇㄹㅕㅇ");
			insertData(db, "대학생", "ㄷㅐㅎㅏㄱㅅㅐㅇ");
			insertData(db, "독서실", "ㄷㅗㄱㅅㅓㅅㅣㄹ");
			insertData(db, "동문회", "ㄷㅗㅇㅁㅜㄴㅎㅚ");
			insertData(db, "동승자", "ㄷㅗㅇㅅㅡㅇㅈㅏ");
			insertData(db, "동창회", "ㄷㅗㅇㅊㅏㅇㅎㅚ");
			insertData(db, "두루치기", "ㄷㅜㄹㅜㅊㅣㄱㅣ");
			insertData(db, "럭비공", "ㄹㅓㄱㅂㅣㄱㅗㅇ");
			insertData(db, "마끼야또", "ㅁㅏㄲㅣㅇㅑㄸㅗ");
			insertData(db, "막국수", "ㅁㅏㄱㄱㅜㄱㅅㅜ");
			insertData(db, "메밀묵", "ㅁㅔㅁㅣㄹㅁㅜㄱ");
			insertData(db, "명령어", "ㅁㅕㅇㄹㅕㅇㅇㅓ");
			insertData(db, "목걸이", "ㅁㅗㄱㄱㅓㄹㅇㅣ");
			insertData(db, "목사님", "ㅁㅗㄱㅅㅏㄴㅣㅁ");
			insertData(db, "목요일", "ㅁㅗㄱㅇㅛㅇㅣㄹ");
			insertData(db, "물놀이", "ㅁㅜㄹㄴㅗㄹㅇㅣ");
			insertData(db, "미술관", "ㅁㅣㅅㅜㄹㄱㅘㄴ");
			insertData(db, "미술실", "ㅁㅣㅅㅜㄹㅅㅣㄹ");
			insertData(db, "발가락", "ㅂㅏㄹㄱㅏㄹㅏㄱ");
			insertData(db, "발바닥", "ㅂㅏㄹㅂㅏㄷㅏㄱ");
			insertData(db, "발연기", "ㅂㅏㄹㅇㅕㄴㄱㅣ");
			insertData(db, "발전소", "ㅂㅏㄹㅈㅓㄴㅅㅗ");
			insertData(db, "백사장", "ㅂㅐㄱㅅㅏㅈㅏㅇ");
			insertData(db, "백화점", "ㅂㅐㄱㅎㅘㅈㅓㅁ");
			insertData(db, "베네치아", "ㅂㅔㄴㅔㅊㅣㅇㅏ");
			insertData(db, "보라카이", "ㅂㅗㄹㅏㅋㅏㅇㅣ");
			insertData(db, "부동산", "ㅂㅜㄷㅗㅇㅅㅏㄴ");
			insertData(db, "부장님", "ㅂㅜㅈㅏㅇㄴㅣㅁ");
			insertData(db, "사냥꾼", "ㅅㅏㄴㅑㅇㄲㅜㄴ");
			insertData(db, "사발면", "ㅅㅏㅂㅏㄹㅁㅕㄴ");
			insertData(db, "사진첩", "ㅅㅏㅈㅣㄴㅊㅓㅂ");
			insertData(db, "산나물", "ㅅㅏㄴㄴㅏㅁㅜㄹ");
			insertData(db, "서랍장", "ㅅㅓㄹㅏㅂㅈㅏㅇ");
			insertData(db, "세수대야", "ㅅㅔㅅㅜㄷㅐㅇㅑ");
			insertData(db, "소녀시대", "ㅅㅗㄴㅕㅅㅣㄷㅐ");
			insertData(db, "소설책", "ㅅㅗㅅㅓㄹㅊㅐㄱ");
			insertData(db, "손가락", "ㅅㅗㄴㄱㅏㄹㅏㄱ");
			insertData(db, "손잡이", "ㅅㅗㄴㅈㅏㅂㅇㅣ");
			insertData(db, "시시비비", "ㅅㅣㅅㅣㅂㅣㅂㅣ");
			insertData(db, "신부님", "ㅅㅣㄴㅂㅜㄴㅣㅁ");
			insertData(db, "아메리카", "ㅇㅏㅁㅔㄹㅣㅋㅏ");
			insertData(db, "아프리카", "ㅇㅏㅍㅡㄹㅣㅋㅏ");
			insertData(db, "여객선", "ㅇㅕㄱㅐㄱㅅㅓㄴ");
			insertData(db, "연신내", "ㅇㅕㄴㅅㅣㄴㄴㅐ");
			insertData(db, "영화관", "ㅇㅕㅇㅎㅘㄱㅘㄴ");
			insertData(db, "오락실", "ㅇㅗㄹㅏㄱㅅㅣㄹ");
			insertData(db, "오른손", "ㅇㅗㄹㅡㄴㅅㅗㄴ");
			insertData(db, "오토바이", "ㅇㅗㅌㅗㅂㅏㅇㅣ");
			insertData(db, "우리나라", "ㅇㅜㄹㅣㄴㅏㄹㅏ");
			insertData(db, "워싱턴", "ㅇㅝㅅㅣㅇㅌㅓㄴ");
			insertData(db, "원숭이", "ㅇㅝㄴㅅㅜㅇㅇㅣ");
			insertData(db, "원자력", "ㅇㅝㄴㅈㅏㄹㅕㄱ");
			insertData(db, "월드컵", "ㅇㅝㄹㄷㅡㅋㅓㅂ");
			insertData(db, "월요일", "ㅇㅝㄹㅇㅛㅇㅣㄹ");
			insertData(db, "유람선", "ㅇㅠㄹㅏㅁㅅㅓㄴ");
			insertData(db, "유리구두", "ㅇㅠㄹㅣㄱㅜㄷㅜ");
			insertData(db, "이등병", "ㅇㅣㄷㅡㅇㅂㅕㅇ");
			insertData(db, "일요일", "ㅇㅣㄹㅇㅛㅇㅣㄹ");
			insertData(db, "잔디밭", "ㅈㅏㄴㄷㅣㅂㅏㅌ");
			insertData(db, "잠수함", "ㅈㅏㅁㅅㅜㅎㅏㅁ");
			insertData(db, "장독대", "ㅈㅏㅇㄷㅗㄱㄷㅐ");
			insertData(db, "저금통", "ㅈㅓㄱㅡㅁㅌㅗㅇ");
			insertData(db, "정거장", "ㅈㅓㅇㄱㅓㅈㅏㅇ");
			insertData(db, "종이컵", "ㅈㅗㅇㅇㅣㅋㅓㅂ");
			insertData(db, "줄넘기", "ㅈㅜㄹㄴㅓㅁㄱㅣ");
			insertData(db, "차장님", "ㅊㅏㅈㅏㅇㄴㅣㅁ");
			insertData(db, "책가방", "ㅊㅐㄱㄱㅏㅂㅏㅇ");
			insertData(db, "책꽂이", "ㅊㅐㄱㄲㅗㅈㅇㅣ");
			insertData(db, "철가방", "ㅊㅓㄹㄱㅏㅂㅏㅇ");
			insertData(db, "철도청", "ㅊㅓㄹㄷㅗㅊㅓㅇ");
			insertData(db, "청문회", "ㅊㅓㅇㅁㅜㄴㅎㅚ");
			insertData(db, "체육관", "ㅊㅔㅇㅠㄱㄱㅘㄴ");
			insertData(db, "초콜렛", "ㅊㅗㅋㅗㄹㄹㅔㅅ");
			insertData(db, "축구공", "ㅊㅜㄱㄱㅜㄱㅗㅇ");
			insertData(db, "충전기", "ㅊㅜㅇㅈㅓㄴㄱㅣ");
			insertData(db, "치악산", "ㅊㅣㅇㅏㄱㅅㅏㄴ");
			insertData(db, "카레이서", "ㅋㅏㄹㅔㅇㅣㅅㅓ");
			insertData(db, "칼국수", "ㅋㅏㄹㄱㅜㄱㅅㅜ");
			insertData(db, "코스프레", "ㅋㅗㅅㅡㅍㅡㄹㅔ");
			insertData(db, "콩나물", "ㅋㅗㅇㄴㅏㅁㅜㄹ");
			insertData(db, "타이거즈", "ㅌㅏㅇㅣㄱㅓㅈㅡ");
			insertData(db, "탁구공", "ㅌㅏㄱㄱㅜㄱㅗㅇ");
			insertData(db, "태평양", "ㅌㅐㅍㅕㅇㅇㅑㅇ");
			insertData(db, "탬버린", "ㅌㅐㅁㅂㅓㄹㅣㄴ");
			insertData(db, "텀블러", "ㅌㅓㅁㅂㅡㄹㄹㅓ");
			insertData(db, "통통배", "ㅌㅗㅇㅌㅗㅇㅂㅐ");
			insertData(db, "파파라치", "ㅍㅏㅍㅏㄹㅏㅊㅣ");
			insertData(db, "편의점", "ㅍㅕㄴㅇㅢㅈㅓㅁ");
			insertData(db, "풍경화", "ㅍㅜㅇㄱㅕㅇㅎㅘ");
			insertData(db, "필리핀", "ㅍㅣㄹㄹㅣㅍㅣㄴ");
			insertData(db, "핸드폰", "ㅎㅐㄴㄷㅡㅍㅗㄴ");
			insertData(db, "호루라기", "ㅎㅗㄹㅜㄹㅏㄱㅣ");
			insertData(db, "화물선", "ㅎㅘㅁㅜㄹㅅㅓㄴ");
			insertData(db, "화장품", "ㅎㅘㅈㅏㅇㅍㅜㅁ");
			insertData(db, "활력소", "ㅎㅘㄹㄹㅕㄱㅅㅗ");
			insertData(db, "후라이드", "ㅎㅜㄹㅏㅇㅣㄷㅡ");
			insertData(db, "후반전", "ㅎㅜㅂㅏㄴㅈㅓㄴ");
			break;
		case 6:
			insertData(db, "가다랑어", "ㄱㅏㄷㅏㄹㅏㅇㅇㅓ");
			insertData(db, "강감찬", "ㄱㅏㅇㄱㅏㅁㅊㅏㄴ");
			insertData(db, "강낭콩", "ㄱㅏㅇㄴㅏㅇㅋㅗㅇ");
			insertData(db, "개구쟁이", "ㄱㅐㄱㅜㅈㅐㅇㅇㅣ");
			insertData(db, "개마고원", "ㄱㅐㅁㅏㄱㅗㅇㅝㄴ");
			insertData(db, "겨드랑이", "ㄱㅕㄷㅡㄹㅏㅇㅇㅣ");
			insertData(db, "경찰관", "ㄱㅕㅇㅊㅏㄹㄱㅘㄴ");
			insertData(db, "고속도로", "ㄱㅗㅅㅗㄱㄷㅗㄹㅗ");
			insertData(db, "곰인형", "ㄱㅗㅁㅇㅣㄴㅎㅕㅇ");
			insertData(db, "관광객", "ㄱㅘㄴㄱㅘㅇㄱㅐㄱ");
			insertData(db, "관악산", "ㄱㅘㄴㅇㅏㄱㅅㅏㄴ");
			insertData(db, "구렛나루", "ㄱㅜㄹㅔㅅㄴㅏㄹㅜ");
			insertData(db, "구름다리", "ㄱㅜㄹㅡㅁㄷㅏㄹㅣ");
			insertData(db, "그라운드", "ㄱㅡㄹㅏㅇㅜㄴㄷㅡ");
			insertData(db, "김장독", "ㄱㅣㅁㅈㅏㅇㄷㅗㄱ");
			insertData(db, "나라사랑", "ㄴㅏㄹㅏㅅㅏㄹㅏㅇ");
			insertData(db, "단백질", "ㄷㅏㄴㅂㅐㄱㅈㅣㄹ");
			insertData(db, "대청마루", "ㄷㅐㅊㅓㅇㅁㅏㄹㅜ");
			insertData(db, "도로교통", "ㄷㅗㄹㅗㄱㅛㅌㅗㅇ");
			insertData(db, "돌솥밥", "ㄷㅗㄹㅅㅗㅌㅂㅏㅂ");
			insertData(db, "동영상", "ㄷㅗㅇㅇㅕㅇㅅㅏㅇ");
			insertData(db, "딱지치기", "ㄸㅏㄱㅈㅣㅊㅣㄱㅣ");
			insertData(db, "맨체스터", "ㅁㅐㄴㅊㅔㅅㅡㅌㅓ");
			insertData(db, "미치광이", "ㅁㅣㅊㅣㄱㅘㅇㅇㅣ");
			insertData(db, "볽음탕", "ㅂㅗㄺㅇㅡㅁㅌㅏㅇ");
			insertData(db, "북극성", "ㅂㅜㄱㄱㅡㄱㅅㅓㅇ");
			insertData(db, "북한산", "ㅂㅜㄱㅎㅏㄴㅅㅏㄴ");
			insertData(db, "산림욕", "ㅅㅏㄴㄹㅣㅁㅇㅛㄱ");
			insertData(db, "상상력", "ㅅㅏㅇㅅㅏㅇㄹㅕㄱ");
			insertData(db, "새우튀김", "ㅅㅐㅇㅜㅌㅟㄱㅣㅁ");
			insertData(db, "샌드위치", "ㅅㅐㄴㄷㅡㅇㅟㅊㅣ");
			insertData(db, "선정릉", "ㅅㅓㄴㅈㅓㅇㄹㅡㅇ");
			insertData(db, "설악산", "ㅅㅓㄹㅇㅏㄱㅅㅏㄴ");
			insertData(db, "성공률", "ㅅㅓㅇㄱㅗㅇㄹㅠㄹ");
			insertData(db, "세계대전", "ㅅㅔㄱㅖㄷㅐㅈㅓㄴ");
			insertData(db, "스마트폰", "ㅅㅡㅁㅏㅌㅡㅍㅗㄴ");
			insertData(db, "슭곰발", "ㅅㅡㄺㄱㅗㅁㅂㅏㄹ");
			insertData(db, "아스팔트", "ㅇㅏㅅㅡㅍㅏㄹㅌㅡ");
			insertData(db, "안경집", "ㅇㅏㄴㄱㅕㅇㅈㅣㅂ");
			insertData(db, "앱스토어", "ㅇㅐㅂㅅㅡㅌㅗㅇㅓ");
			insertData(db, "어버이날", "ㅇㅓㅂㅓㅇㅣㄴㅏㄹ");
			insertData(db, "얼룩말", "ㅇㅓㄹㄹㅜㄱㅁㅏㄹ");
			insertData(db, "영어회화", "ㅇㅕㅇㅇㅓㅎㅚㅎㅘ");
			insertData(db, "올림픽", "ㅇㅗㄹㄹㅣㅁㅍㅣㄱ");
			insertData(db, "원효대사", "ㅇㅝㄴㅎㅛㄷㅐㅅㅏ");
			insertData(db, "월악산", "ㅇㅝㄹㅇㅏㄱㅅㅏㄴ");
			insertData(db, "이탈리아", "ㅇㅣㅌㅏㄹㄹㅣㅇㅏ");
			insertData(db, "일광욕", "ㅇㅣㄹㄱㅘㅇㅇㅛㄱ");
			insertData(db, "일등병", "ㅇㅣㄹㄷㅡㅇㅂㅕㅇ");
			insertData(db, "자기계발", "ㅈㅏㄱㅣㄱㅖㅂㅏㄹ");
			insertData(db, "장충동", "ㅈㅏㅇㅊㅜㅇㄷㅗㅇ");
			insertData(db, "전광판", "ㅈㅓㄴㄱㅘㅇㅍㅏㄴ");
			insertData(db, "전반전", "ㅈㅓㄴㅂㅏㄴㅈㅓㄴ");
			insertData(db, "주차딱지", "ㅈㅜㅊㅏㄸㅏㄱㅈㅣ");
			insertData(db, "줄다리기", "ㅈㅜㄹㄷㅏㄹㅣㄱㅣ");
			insertData(db, "중앙선", "ㅈㅜㅇㅇㅏㅇㅅㅓㄴ");
			insertData(db, "천안함", "ㅊㅓㄴㅇㅏㄴㅎㅏㅁ");
			insertData(db, "천왕성", "ㅊㅓㄴㅇㅘㅇㅅㅓㅇ");
			insertData(db, "청국장", "ㅊㅓㅇㄱㅜㄱㅈㅏㅇ");
			insertData(db, "카카오톡", "ㅋㅏㅋㅏㅇㅗㅌㅗㄱ");
			insertData(db, "타자게임", "ㅌㅏㅈㅏㄱㅔㅇㅣㅁ");
			insertData(db, "태극마크", "ㅌㅐㄱㅡㄱㅁㅏㅋㅡ");
			insertData(db, "팀장님", "ㅌㅣㅁㅈㅏㅇㄴㅣㅁ");
			insertData(db, "포르투갈", "ㅍㅗㄹㅡㅌㅜㄱㅏㄹ");
			insertData(db, "풍선껌", "ㅍㅜㅇㅅㅓㄴㄲㅓㅁ");
			insertData(db, "한강진", "ㅎㅏㄴㄱㅏㅇㅈㅣㄴ");
			insertData(db, "할아버지", "ㅎㅏㄹㅇㅏㅂㅓㅈㅣ");
			insertData(db, "해외여행", "ㅎㅐㅇㅚㅇㅕㅎㅐㅇ");
			insertData(db, "형광등", "ㅎㅕㅇㄱㅘㅇㄷㅡㅇ");
			insertData(db, "형광펜", "ㅎㅕㅇㄱㅘㅇㅍㅔㄴ");
			break;
		default:
			break;
		}
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
