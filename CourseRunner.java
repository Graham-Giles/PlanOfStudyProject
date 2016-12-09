//Graham Giles
import java.util.*;

public class CourseRunner
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		boolean escape = false;
		ArrayList<CourseList> majors = new ArrayList<>();
		CourseList studentMajor = new CourseList(1, "Default Major");
		boolean majorSelected = false;
		CourseList studentCourses = new CourseList(1, "Student Courses");

		CourseList cs = new CourseList(1, "CS");

		CourseList nullprqcl = new CourseList(1, "Null Prerequisite");
		nullprqcl.addCourse("NO", "PRQ");
		PrereqList nullprq = new PrereqList();
		nullprq.addTo(nullprqcl);

		CourseList csci1301prqcl = new CourseList(1, "CSCI 1301 Prerequisites");
		csci1301prqcl.addCourseGrade("MATH", "1101", "C");
		PrereqList csci1301prq = new PrereqList();
		csci1301prq.addTo(csci1301prqcl);

		CourseList csci1302prqcl = new CourseList(1, "CSCI 1302 Prerequisites");
		csci1302prqcl.addCourseGrade("MATH", "1101", "C");
		csci1302prqcl.addCourseGrade("CSCI", "1301", "C");
		PrereqList csci1302prq = new PrereqList();
		csci1302prq.addTo(csci1302prqcl);

		CourseList csci2000prqcl = new CourseList(1, "CSCI 2000 Prerequisites");
		csci2000prqcl.addCourseGrade("CSCI", "1301", "C");
		csci2000prqcl.addCourseGrade("CSCI", "1302", "C");
		PrereqList csci2000prq = new PrereqList();
		csci2000prq.addTo(csci2000prqcl);

		cs.addCoursePrereq("CSCI", "1301", csci1301prq);
		cs.addCoursePrereq("CSCI", "1302", csci1302prq);
		cs.addCoursePrereq("CSCI", "2400", csci2000prq);
		cs.addCoursePrereq("MATH", "1101", nullprq);
		cs.addCoursePrereq("ENGL", "1101", nullprq);

		majors.add(cs);

		while(!escape)
		{

			System.out.println("Main Menu Selection:");
			System.out.println("	1. Student's Menu");
			System.out.println("	2. Administration");
			System.out.println("	3. Exit This Menu");
			int selection = Integer.parseInt(s.nextLine());

			switch(selection)
			{

				// Student Menu
				case 1:
					boolean studentMenuEscape = false;
					loop: while(!studentMenuEscape)
					{
						if(!majorSelected)
						{
							String majorName;
							System.out.println("Please Select a Major:");
							//select a major
							//if majors is empty
							//    break
							if(majors.isEmpty())
							{
								System.out.println("There are currently no majors offered. Please contact administration.");
								break loop;
							}
							for(int i = 0; i < majors.size(); i++)
							{
								System.out.println(majors.get(i).getName());
							}
							boolean majorEscape = false;
							while(!majorEscape)
							{
								System.out.println("Type Major Name:");
								majorName = s.nextLine();
								for(int i = 0; i < majors.size(); i++)
								{
									if(majorName.equals(majors.get(i).getName()))
									{
										studentMajor = majors.get(i);
										System.out.println("Your Major Is:");
										System.out.println(studentMajor.getName());
										majorSelected = true;
										majorEscape = true;
									}
								}

							}
						}

						System.out.println("Student Menu Selection:");
						System.out.println("	1. Input Previous Courses");
						System.out.println("	2. Generate List of Courses to Take");
						System.out.println("	3. Change Major");
						System.out.println("	4. Back to main menu.");

						int studentSelection = Integer.parseInt(s.nextLine());

						switch(studentSelection)
						{

							//Input Previous Courses
							case 1:
								boolean inputEscape = false;
								while(!inputEscape)
								{
									System.out.println("Enter Previous Course Subject:");
									String preCourseName = s.nextLine();
									System.out.println("Enter Previous Course Level:");
									String preCourseLevel = s.nextLine();
									System.out.println("Enter Previous Course Grade:");
									String preCourseGrade = s.nextLine();

									studentCourses.addCourseGrade(preCourseName,preCourseLevel,preCourseGrade);
									System.out.println("Add another course (yes/no):");
									String addAnotherCourse = s.nextLine();
									if (addAnotherCourse.equals("yes"))
									{
										inputEscape = false;
									}else{
										inputEscape = true;
									}
								}
								System.out.println("Your Previous Courses:");
								System.out.println(studentCourses.getCourseTitles());
								break;

							//Generate List of Courses to Take
							case 2:
								System.out.println("Based on your previous courses, here is a list of courses you should take:");
								studentCourses.removeFailures();
								System.out.println("You may need to take the course again if you received a grade of D or below.");
								CourseList toTake = studentMajor.getMissing(studentCourses);
								assignWeights(toTake);
								toTake.sortWeights(toTake);
								printPrerequisites(toTake);
								System.out.println("Higher weight means the course is more useful:");
								System.out.println(toTake.getCourseTitlesWithWeight());
								break;

							//Change Major
							case 3:
								for(int i = 0; i < majors.size(); i++)
								{
									System.out.println(majors.get(i).getName());
								}
								boolean majorEscape = false;
								while(!majorEscape)
								{
									System.out.println("Type Major Name:");
									String majorName = s.nextLine();
									for(int i = 0; i < majors.size(); i++)
									{
										if(majorName.equals(majors.get(i).getName()))
										{
											studentMajor = majors.get(i);
											System.out.println("Your Major Is:");
											System.out.println(studentMajor.getName());
											majorSelected = true;
											majorEscape = true;
										}
									}

								}
								break;

							//Back to main menu.
							case 4:
								studentMenuEscape = true;
								break;
							default:
								System.out.println("Invalid Command");
						}
					}
					break;

				// Administration Menu
				case 2:
					System.out.println("Administration Menu:");
					System.out.println("	1. Add new major");
					System.out.println("	2. Add course to a major");
					System.out.println("	3. Remove course from major");
					System.out.println("	4. Exit to main menu");

					int adminSelection = Integer.parseInt(s.nextLine());

					switch(adminSelection)
					{
						//add new major
						case 1:
							System.out.println("What is this major named? (e.g CSCI)?");
							String name = s.nextLine();
							CourseList newMajor = new CourseList(1, name);
							majors.add(newMajor);
							break;
						//add course to major
						case 2:
							if(majors.isEmpty())
							{
								System.out.println("Major list is empty. Try adding a major.");
								break;
							}

							String majorName = "";
							CourseList selectedMajor = new CourseList(1,majorName);
							boolean majorEscape = false;
							while(!majorEscape)
							{
								System.out.println("Select a Major to Edit");
								for(int i = 0; i < majors.size(); i++)
								{
									System.out.println(majors.get(i).getName());
								}
								System.out.println("Type Major Name:");
								majorName = s.nextLine();
								for(int i = 0; i < majors.size(); i++)
								{
									if(majorName.equals(majors.get(i).getName()))
									{
										selectedMajor = majors.get(i);
										System.out.println("Selected Major Is:");
										System.out.println(selectedMajor.getName());
										majorEscape = true;
									}
								}
							}

							String newCourseSubject;
							String newCourseLevel;
							String prqCourseSubject;
							String prqCourseLevel;
							String prerequisiteSelection;
							CourseList editMajor = selectedMajor;
							CourseList editPrereq = new CourseList(1, "Prerequisites");
							PrereqList newCoursePrereqs = new PrereqList();

							System.out.println("What is the new course subject (e.g. CSCI)?");
							newCourseSubject = s.nextLine();
							System.out.println("What is the new course level (e.g. 1301)?");
							newCourseLevel = s.nextLine();
							System.out.println("Does this course have any prerequisites (e.g. yes/no)?");
							prerequisiteSelection = s.nextLine();
							if (prerequisiteSelection.equals("yes"))
							{
								boolean prereqEscape = false;
								while(!prereqEscape)
								{
									System.out.println("What is the prerequisite course subject (e.g. CSCI)?");
									prqCourseSubject = s.nextLine();
									System.out.println("What is the prerequisite course level (e.g. 1301)?");
									prqCourseLevel = s.nextLine();
									editPrereq.addCourse(prqCourseSubject, prqCourseLevel);
									System.out.println("Add another prerequisite? (type yes/no)");
									if(s.nextLine().equalsIgnoreCase("yes"))
									{
										prereqEscape = false;
									}else{
										prereqEscape = true;
									}
								}
							}else{
								editPrereq.addCourse("NO", "PRQ");
							}
							newCoursePrereqs.addTo(editPrereq);
							editMajor.addCoursePrereq(newCourseSubject, newCourseLevel, newCoursePrereqs);
							break;
						//remove course from major
						case 3:
							if(majors.isEmpty())
							{
								System.out.println("Major list is empty. Try adding a major.");
								break;
							}

							String removeMajorName = "";
							boolean removeMajorEscape = false;
							while(!removeMajorEscape)
							{
								System.out.println("Select a Major to Edit");
								for(int i = 0; i < majors.size(); i++)
								{
									System.out.println(majors.get(i).getName());
								}
								System.out.println("Type Major Name:");
								removeMajorName = s.nextLine();
								for(int i = 0; i < majors.size(); i++)
								{
									if(removeMajorName.equals(majors.get(i).getName()))
									{
										//so I added a new scanner object because nextLine() is funky and needed me to do this
										//don't ask why
										Scanner input = new Scanner(System.in);
										System.out.println("Selected Major Is: " + majors.get(i).getName());
										System.out.println("Courses in Major: " + majors.get(i).getCourseTitles());
										System.out.println("Type the title of the course to remove (e.g. CSCI 1302):");
										removeMajorName = input.nextLine();
										for(int k = 0; k < majors.get(i).length(); k++)
										{
											if(removeMajorName.equals(majors.get(i).courseAt(k).title()))
											{
												majors.get(i).removeFrom(k);
												System.out.println( removeMajorName + " removed");
											}
										}
										removeMajorEscape = true;
									}
								}
							}
							break;

						case 4:
							break;
					}
					break;

				// Exit
				case 3:
					System.out.println("Exit Software? Type \"yes\"");
					//"Q" looks awesome in notepad++
					String exitQuery = s.nextLine();
					if (exitQuery.equals("yes"))
						escape = true;
					break;
				default:
					System.out.println("Invalid Command");
					break;
			}

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

	//attempts to assign weights to the courses in a given courselist
	//I may make this sort the courselist based on weights too
	private static void assignWeights(CourseList cl)
	{
		int w = 0;
		for (int i = 0; i < cl.length(); i++)
		{
			w = weigh(cl, cl.courseAt(i).title());
			cl.courseAt(i).setWeight(w);
		}
	}

	//prints the courselist in a format which lists each prerequiste for each class
	private static void printPrerequisites(CourseList cl)
	{
		for (int i =0; i < cl.length(); i++)
		{
			System.out.println(cl.courseAt(i).title() + " prerequisite courses: " + cl.courseAt(i).prereqs().getPrereqTitles());
		}
	}
}