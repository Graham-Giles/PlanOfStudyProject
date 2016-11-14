//Graham Giles
public class CourseRunner
{
	public static void main(String args[])
	{
		//initializes a courselist with capacity 1
		CourseList courses = new CourseList(1);
		
		Course csci1302 = new Course("CSCI","1302");
		
		courses.addCourse(csci1302);
		courses.printCourses();
	}
}