//Graham Giles
public class Course
{
	private String subject; //e.g. CSCI
	private String level; //e.g. 1301
	private String grade; //e.g. F
	private PrereqList prereqs; //e.g. CSCI 3200
	private int weight = 0;
	
	//constructor for student course
	public Course(String newSubject, String newLevel, String newGrade)
	{
		subject = newSubject;
		level = newLevel;
		grade = newGrade;
	}
	
	//constructor for plan of study course with a prerequisite
	public Course(String newSubject, String newLevel, PrereqList newPrereq)
	{
		subject = newSubject;
		level = newLevel;
		grade = "C";
		prereqs = newPrereq;
	}

	//constructor for plan of study course without a prerequisite
	public Course(String newSubject, String newLevel)
	{
		subject = newSubject;
		level = newLevel;
		grade = "C";
		prereqs = null;
	}

	public Course(String newSubject, String newLevel, String newGrade, PrereqList newPrereq)
	{
		subject = newSubject;
		level = newLevel;
		grade = newGrade;
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

	public PrereqList prereqs()
	{
		return prereqs;
	}

	public void setPrereqs(PrereqList p)
	{
		prereqs = p;
	}

	//returns the weight of the course
	public int getWeight()
	{
		return weight;
	}

	//sets the weight of the course
	public void setWeight(int w)
	{
		weight = w;
	}
}