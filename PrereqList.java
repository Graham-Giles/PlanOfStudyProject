import java.util.ArrayList;
public class PrereqList
{
   private ArrayList<CourseList> prereqs = new ArrayList<>();

    //adds a courselist to the prerequisite list
    public void addTo(CourseList list)
    {
        prereqs.add(list);
    }
    //returns the ArrayList object
    public ArrayList getList()
    {
        return prereqs;
    }

    //returns the titles of the prereqs in the list
    public String getPrereqTitles()
    {
        String name = "";
        CourseList temp;

        for(CourseList c: prereqs)
        {
            name = name + c.getCourseTitles();
        }

        return name;
    }
}
