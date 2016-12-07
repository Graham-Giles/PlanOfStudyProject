//Graham Giles
import java.util.*;

public class CourseRunner
{
	public static void main(String args[])
	{
		//initializes a courselist with capacity 1
		CourseList courses = new CourseList(1);
		CourseList test = new CourseList(1);
		CourseList test_2 = new CourseList(1);
		test.addCourse("CSCI", "1301");
		test.addCourse("MATH", "1101");

		test_2.addCourse("CSCI", "1302");
		test_2.addCourse("CSCI", "1301");

		Scanner s = new Scanner(System.in);

		PrereqList prerequisites_csci_1302 = new PrereqList();
		PrereqList prerequisites_csci_2400 = new PrereqList();

		prerequisites_csci_1302.addTo(test);
		prerequisites_csci_2400.addTo(test_2);

		courses.addCoursePrereq("CSCI", "1302", prerequisites_csci_1302);
		courses.addCoursePrereq("CSCI", "2400", prerequisites_csci_2400);

		System.out.println(courses.getCourseTitles());
		System.out.println(courses.courseAt(0).prereqs().getPrereqTitles());
		System.out.println(courses.courseAt(1).prereqs().getPrereqTitles());

		System.out.println("Weight of CSCI 1301: " + weigh(courses, "CSCI 1301"));
		System.out.println("Weight of CSCI 1302: " + weigh(courses, "CSCI 1302"));
		System.out.println("Weight of CSCI 2400: " + weigh(courses, "CSCI 2400"));
		System.out.println("Weight of MATH 1101: " + weigh(courses, "MATH 1101"));

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

	//attempts to weigh the course by counting the number of times it shows up as a prerequisite
	//get ready for loop hell
	private static int weigh(CourseList cl, String t)
	{
		int w = 0;
		for(int i = 0; i < cl.length(); i++)
		{
			for(int j = 0; j < cl.courseAt(i).prereqs().length(); j++)
			{
				for(int k =0; k < cl.courseAt(i).prereqs().courseListAt(j).length(); k++)
				{
					if (t.equals(cl.courseAt(i).prereqs().courseListAt(j).courseAt(k).title()))
					{
						w++;
					}
				}
			}
		}
		return w;
	}

}