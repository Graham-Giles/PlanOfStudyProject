//Graham Giles
import java.util.*;

public class CourseRunner
{
	public static void main(String args[])
	{
		//initializes a courselist with capacity 1
		CourseList courses = new CourseList(1);
		
		Scanner s = new Scanner(System.in);

		CourseList prerequisites = new CourseList(1);
		prerequisites.addCourse("CSCI", "6669");

		courses.addCourse("CSCI", "1301");
		courses.addCourse("CSCI", "1302");
		courses.addCourse("CSCI", "2400");
		courses.addCoursePrereq("CSCI", "2500", prerequisites);
		System.out.println("Degree Requirements:");
		courses.printCourses();
		System.out.println("");

		CourseList testCourses = new CourseList(1);
		testCourses.addCourseGrade("CSCI", "1301", "A");
		testCourses.addCourseGrade("CSCI", "1302", "A");
		testCourses.addCourseGrade("CSCI", "1320", "A");
		System.out.println("User's Grades:");
		testCourses.printCourses();
		System.out.println("");
		System.out.println("Courses Missing for Degree:");
		courses.printMissing(testCourses);
		System.out.println("");

		CourseList testFailures = new CourseList(1);
		testFailures.addCourseGrade("CSCI", "1301", "A");
		testFailures.addCourseGrade("CSCI", "1302", "K");
		testFailures.addCourseGrade("CSCI", "1303", "D");
		testFailures.addCourseGrade("CSCI", "1304", "F");
		testFailures.addCourseGrade("CSCI", "1305", "C");
		System.out.println("User's Grades:");
		testFailures.printCourses();
		System.out.println("");
		System.out.println("User's valid courses:");
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