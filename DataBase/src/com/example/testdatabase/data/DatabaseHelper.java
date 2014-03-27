package com.example.testdatabase.data;

import com.example.testdatabase.data.DataModel.ClassTable;
import com.example.testdatabase.data.DataModel.CourseTable;
import com.example.testdatabase.data.DataModel.StudentTable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "adv_test.db";
	private static final int DATABSE_VERSION = 1;
	
	
	private static final String CREATE_STUDENTTABLE = "CREATE TABLE " + StudentTable.TABLE_NAME
			+ " (" + StudentTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ StudentTable.NAME + " TEXT,"
			+ StudentTable.STATE + " TEXT,"
			+ StudentTable.GRADE + " INTEGER)";
	
	private static final String CREATE_COURSETABLE = "CREATE TABLE " + CourseTable.TABLE_NAME
			+" (" + CourseTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+CourseTable.NAME + " TEXT)";
	
	private static final String CREATE_CLASSTABLE = "CREATE TABLE " + ClassTable.TABLE_NAME
			+ " (" + ClassTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ ClassTable.STUDENT_ID + " INTEGER,"
			+ ClassTable.COURSE_ID + " INTEGER)";
	
	private static final String DROP_STUDENTTABLE = "DROP TABLE IF EXITS " + StudentTable.TABLE_NAME;
	
	private static final String DROP_COURSETABLE = "DROP TABLE IF EXITS " + CourseTable.TABLE_NAME;
	
	private static final String DROP_CLASSTABLE = "DROP TABLE IF EXITS " + ClassTable.TABLE_NAME;
	
	public DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABSE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
        
		sqLiteDatabase.execSQL(CREATE_STUDENTTABLE);
        sqLiteDatabase.execSQL(CREATE_COURSETABLE);
        sqLiteDatabase.execSQL(CREATE_CLASSTABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int arg1, int arg2) {

		sqLiteDatabase.execSQL(DROP_STUDENTTABLE);
		sqLiteDatabase.execSQL(DROP_COURSETABLE);
		sqLiteDatabase.execSQL(DROP_CLASSTABLE);
		
		//reCreate new table
		onCreate(sqLiteDatabase);
	}
	
	public long addStudent(String name, String state, int grade){
		
		ContentValues cValues = new ContentValues();
		cValues.put(StudentTable.NAME, name);
		cValues.put(StudentTable.STATE, state);
		cValues.put(StudentTable.GRADE, grade);
		
		SQLiteDatabase sqLiteDatabase = getWritableDatabase();
		
		return sqLiteDatabase.insert(StudentTable.TABLE_NAME, StudentTable.NAME, cValues);
	}
	
	public long addCourse(String name){
		
		ContentValues cValues = new ContentValues();
		cValues.put(CourseTable.NAME, name);
		
		return getWritableDatabase().insert(CourseTable.TABLE_NAME, CourseTable.NAME, cValues);
	}
	
	public long enrollStudentCourse(long studentId, long courseId){
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(ClassTable.STUDENT_ID, studentId);
		contentValues.put(ClassTable.COURSE_ID, courseId);
		
		return getWritableDatabase().insert(ClassTable.TABLE_NAME, ClassTable.STUDENT_ID, contentValues);
	}

}
