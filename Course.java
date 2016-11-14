//Graham Giles
public class Course
{
	private String subject; //e.g. CSCI
	private String level; //e.g. 1301
	
	//constructor for new course
	public Course(String newSubject, String newLevel)
	{
		subject = newSubject;
		level = newLevel;
	}
	
	//returns the title of the course
	public String title()
	{
		return subject + " " + level;
	}
}