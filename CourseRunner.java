//Graham Giles
import java.util.*;

public class CourseRunner
{
	public static void main(String args[])
	{
		//initializes a courselist with capacity 1
		CourseList courses = new CourseList(1);
		CourseList test = new CourseList(1);
		test.addCourse("CSCI", "1301");
		test.addCourse("MATH", "1101");
		Scanner s = new Scanner(System.in);

		PrereqList prerequisites = new PrereqList();
		prerequisites.addTo(test);

		courses.addCoursePrereq("CSCI", "1302", prerequisites);
		System.out.println(courses.getCourseTitles());
		System.out.println(courses.courseAt(0).prereqs().getPrereqTitles());

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