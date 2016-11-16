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
		
		testCourses.addCourseGrade("CSCI", "1301", "A");
		testCourses.addCourseGrade("CSCI", "1302", "A");
		testCourses.printCourses();
		
		courses.printMissing(testCourses);
		
		CourseList testFailures = new CourseList(1);
		
		testFailures.addCourseGrade("CSCI", "1301", "A");
		testFailures.addCourseGrade("CSCI", "1302", "K");
		testFailures.addCourseGrade("CSCI", "1303", "D");
		testFailures.addCourseGrade("CSCI", "1304", "F");
		testFailures.addCourseGrade("CSCI", "1305", "C");
		
		testFailures.printCourses();
		testFailures.removeFailures();
		testFailures.printCourses();
		
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