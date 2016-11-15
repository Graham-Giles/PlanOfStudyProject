//Graham Giles
import java.util.*;

public class CourseRunner
{
	public static void main(String args[])
	{
		//initializes a courselist with capacity 1
		CourseList courses = new CourseList(1);
		
		Scanner s = new Scanner(System.in);	
		
		courses.addCourse("CSCI", "1301");
		courses.addCourse("CSCI", "1302");
		courses.addCourse("CSCI", "2400");
		courses.addCourse("CSCI", "2500");
		courses.printCourses();
		
		CourseList testCourses = new CourseList(1);
		
		testCourses.addCourse("CSCI", "1301");
		testCourses.addCourse("CSCI", "1302");
		testCourses.printCourses();
		
		courses.printMissing(testCourses);
		
		//added the following while loop to test things 
		//repeatedly without recompiling
		boolean escape = false;
			
		while(!escape)
		{
			//insert looping test code here
			
			System.out.println("Exit? Type \"yes\"");
			//"Q" looks awesome in notepad++
			String exitQuery = s.next();
			if (exitQuery.equals("yes"))
				escape = true;
		}
		
	}
}