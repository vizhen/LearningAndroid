package com.example.testdatabase.data;

public class DataModel {

	public  class StudentTable{
		
		public static final String TABLE_NAME = "students";
		
		public static final String ID = "_id";
		
		public static final String NAME = "student_name";
		
		public static final String STATE = "student_state";
		
		public static final String GRADE = "student_grade";
		
	}
	
	public  class CourseTable{
		
		public static final String TABLE_NAME = "courses";
		
		public static final String ID = "_id";
		
		public static final String NAME ="course_name";
	}
	
	public  class ClassTable{
		
		public static final String TABLE_NAME = "classes";
		
		public static final String ID = "_id";
		
		public static final String STUDENT_ID = "student_id";
		
		public static final String COURSE_ID = "course_id";
	}
	
	
}
