//Graham Giles
public class CourseList
{
	private Course[] courses;
	private int length;
	private int capacity;
	private String name;
	
	//constructor for an initially empty CourseList
	public CourseList(int newCapacity, String newName)
	{
		length = 0;
		capacity = newCapacity;
		name = newName;
		
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

	public Course[] courseArray()
	{
		return courses;
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
	
	//adds a new course to the list with a default grade of C
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
	
	//adds a new course to the list with a specified grade
	public void addCourseGrade(String subject, String level, String grade)
	{
		Course newCourse = new Course(subject, level, grade);
		
		if(this.isFull())
			enlarge();
		
		for (int i = length-1; i>=0; i--)
		{
			courses[i+1] = courses[i];
		}
		courses[0] = newCourse;
		length++;
	}

	//adds a new course to the list with a default grade of C
	public void addCoursePrereq(String subject, String level, PrereqList prereqs)
	{
		Course newCourse = new Course(subject, level, prereqs);

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
	
	//returns the course titles as a lengthy string
	public String getCourseTitles()
	{
		String temp;
		String name = "";
		for(int i = 0; i < length; i++)
		{
			if (i < length-1)
			{
				temp = courses[i].title() + " " + courses[i].grade();
				name = name + temp + ",";
			}else{
				temp = courses[i].title() + " " + courses[i].grade();
				name = name + temp;
			}
		}
		return name;
	}
	public String getCourseTitlesWithWeight()
	{
		String temp;
		String name = "";
		for(int i = 0; i < length; i++)
		{
			if (i < length-1)
			{
				temp = courses[i].title() + " " + courses[i].grade() + " weight:" + courses[i].getWeight();
				name = name + temp + ", ";
			}else{
				temp = courses[i].title() + " " + courses[i].grade() + " weight:" + courses[i].getWeight();
				name = name + temp;
			}
		}
		return name;
	}
	//compares the course title to a specified course at a specified location 
	public boolean compareCourseTitle(Course newCourse, int location)
	{
		return courses[location].title().equals(newCourse.title());
	}
	
	//compares the course grade at a specified location to a standard grading system 
	//this is probably temporary but it might not be idk
	public boolean checkGrade(int location)
	{
		String grade = courses[location].grade();
		//I was going to use a switch statement here but apparently you cannot use the || operator in case
		if(grade == "A" || grade == "B" || grade == "C" || grade == "K")
		{
			return true;
		}
		else if(grade == "D" || grade == "F")
		{
			return false;
		}
		else
		{
			return false;
		}

	}
	
	//checks the courseList for any failed classes and removes them
	public void removeFailures()
	{
		for(int i = 0; i < length; i++)
		{
			if(this.checkGrade(i))
			{
				removeFrom(i);
				i--;
			}
		}
	}

	//returns a list of the courses that the given courselist is missing
	//as compared to the current courselist
	//e.g. if the list contains "A, B, C"
	//and you give it a list containing "A, C"
	//it would return "B"
	public CourseList getMissing(CourseList givenList)
	{
		CourseList tempCourseList;
		tempCourseList = this;

		Course tempCourse;

		for(int j = 0; j < givenList.length(); j++)
		{
			tempCourse = givenList.courseAt(j);
			for(int i = 0; i < length; i++)
			{
				if(compareCourseTitle(tempCourse,i))
					tempCourseList.removeFrom(i);
			}
		}
		return tempCourseList;
	}

	//attempts to sort the CourseList based on the weight of its contents
	//uses bubblesort
	public CourseList sortWeights(CourseList cl)
	{
		Course[] givenList = cl.courseArray();
		boolean swap = true;
		Course temp;

		while(swap)
		{
			swap = false;
			for(int i = 0; i < cl.length() - 1; i++)
			{
				if(givenList[i].getWeight() < givenList[i + 1].getWeight())
				{
					temp = givenList[i];
					givenList[i]=givenList[i+1];
					givenList[i + 1] = temp;
					swap = true;
				}
			}
		}

		CourseList sortedList = new CourseList(givenList);
		return sortedList;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String s)
	{
		name = s;
	}
}