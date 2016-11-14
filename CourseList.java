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
	public void addCourse(Course newCourse)
	{
		if(this.isFull())
			enlarge();
		
		for (int i = length-1; i>=0; i--)
		{
			courses[i+1] = courses[i];
		}
		courses[0] = newCourse;
		length++;
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
}