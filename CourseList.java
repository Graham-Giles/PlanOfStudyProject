//Graham Giles
public class CourseList
{
	private Course[] courses;
	private int length;
	private int capacity;
	
	//constructor for an initially empty CourseList
	public CourseList(int newCapacity)
	{
		length = 0;
		capacity = newCapacity;
		
		courses = new Course[capacity];
	}
	
	//constructor for a CourseList with a given Course[] array
	public CourseList(Course[] newCourses)
	{
		length = newCourses.length;
		capacity = length+1;
		
		courses = newCourses;
	}
	
	//returns true if empty
	public boolean isEmpty()
	{
		return length==0;
	}
	
	//returns true if full
	public boolean isFull()
	{
		return length==capacity;
	}
	
	//returns length, duh...
	public int length()
	{
		return length;
	}
	
	//increases the size of the list
	public void enlarge()
	{
		Course[] temp = new Course[capacity + 1];
		for(int i = 0; i < length; i++)
		{
			temp[i] = courses[i];
		}
		courses = temp;
		capacity = courses.length;
	}
	
	//adds a new course to the list
	public void addCourse(String subject, String level)
	{
		Course newCourse = new Course(subject, level);
		
		if(this.isFull())
			enlarge();
		
		for (int i = length-1; i>=0; i--)
		{
			courses[i+1] = courses[i];
		}
		courses[0] = newCourse;
		length++;
	}
	
	//removes a course from a location
	public void removeFrom(int location)
	{
		Course[] tempCourses = new Course[capacity-1];
		for(int i = 0; i < location; i++)
		{
			tempCourses[i]=courses[i]; 
		}
		for(int i = location; i < tempCourses.length; i++)
		{
			tempCourses[i]=courses[i + 1]; 
		}
		courses = tempCourses;
		length--;
		capacity--;
	}
	
	//returns the course at a location of the list
	public Course courseAt(int location)
	{
		return courses[location];
	} 
	
	//prints the courses via S.o.P
	public void printCourses()
	{
		String name;
		for(int i = 0; i < length; i++)
		{
			if (i < length-1)
			{
				name = courses[i].title();
				System.out.print(name + ", ");
			}else{
				name = courses[i].title();
				System.out.print(name);
			}
		}
		System.out.println();
	}
	
	//compares the course to a specified course at a specified location 
	public boolean compareCourse(Course newCourse, int location)
	{
		return courses[location].title().equals(newCourse.title());
	}
	
	//attempts to print the courses that the given courselist is missing
	//as compared to the current courselist
	//e.g. if the list contains "A, B, C"
	//and you give it a list containing "A, C"
	//it would print "B"
	public void printMissing(CourseList givenList)
	{
		CourseList tempCourseList;
		tempCourseList = this;
		
		Course tempCourse;
		
		for(int j = 0; j < givenList.length(); j++)
		{
			tempCourse = givenList.courseAt(j);
			for(int i = 0; i < length; i++)
			{
				if(compareCourse(tempCourse,i))
					tempCourseList.removeFrom(i);
			}
		}

		tempCourseList.printCourses();
		System.out.println();
	}
}