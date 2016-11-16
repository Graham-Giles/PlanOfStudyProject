//Graham Giles
public class Course
{
	private String subject; //e.g. CSCI
	private String level; //e.g. 1301
	private String grade; //e.g. F
	
	//constructor for student course
	public Course(String newSubject, String newLevel, String newGrade)
	{
		subject = newSubject;
		level = newLevel;
		grade = newGrade;
	}
	
	//constructor for plan of study course
	public Course(String newSubject, String newLevel)
	{
		subject = newSubject;
		level = newLevel;
		grade = "C";
	}
	
	//returns the title of the course
	public String title()
	{
		return subject + " " + level;
	}
	
	//returns the grade attained by the course
	//in the case of the student's courses, this is the grade the student achieves
	//in the case of the plan of study, this is the minimum required grade
	//I'm not exactly sure if this is going to be useful or not
	//I want to be able to compare the grades directly but the method I am currently useing compares the grades
	//with a hard-coded if statement
	public String grade()
	{
		return grade;
	}
}