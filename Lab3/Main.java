import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

class Main 
{

    public static void main(String[] args)
    {
        // This is where we map students to their classes
        HashMap<String, List<Course>> courseMap = new HashMap<String, List<Course>>();

        courseMap.put("Garrett",
            Arrays.asList(
                new Course("csc123", 4),
                new Course("csc203", 4),
                new Course("csc492", 2)
            ));
        
        courseMap.put("Rachel",
            Arrays.asList(
               new Course("csc203", 4),
               new Course("csc492", 2),
               new Course("csc369", 4)));
   
        courseMap.put("Weston",
            Arrays.asList(
               new Course("csc101", 4),
               new Course("csc349", 4),
               new Course("csc203", 4)));

        courseMap.put("Duncan", null);

        printCoursesForStudent(courseMap);

        printStudentsForCourse(courseMap, "csc492");
        
        printStudentsForCourse(courseMap, "csc203");
   
    }

    /**
     * TODO: Write a function that prints out each student for the given courseName.
     * Example: If the courseName is "csc203", the output would be 
     * Course: csc203
     *    Evelyn
     *    Weston
     *    Rachel
     */
    public static void printStudentsForCourse(HashMap<String, List<Course>> mapOfCourses, String courseName)
    {
        // print out all of the data in the map
        System.out.println("Course: " + courseName);
        for (String key : mapOfCourses.keySet())
        {     
            List<Course> courses = mapOfCourses.get(key);
            if (courses != null) for (Course c : courses) if (c.getName().equals(courseName)) System.out.println(key);  
        }
            
        
    
    }

    public static void printCoursesForStudent(HashMap<String, List<Course>> mapOfCourses)
    {
        // print out all of the data in the map
        for (String key : mapOfCourses.keySet())
        {
            System.out.println("Student: " + key);
            List<Course> courses = mapOfCourses.get(key);
            if (courses != null)
            {
                for (Course c : courses)
                {
                    System.out.println("    " + c.getName());
                }
            }
            else
            {
                System.out.println("    No courses");
            }
        }
    }
    

}
