import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ExampleMap
{
   public static List<String> highEnrollmentStudents(
      Map<String, List<Course>> courseListsByStudentName, int unitThreshold)
   {
      List<String> overEnrolledStudents = new LinkedList<>();
   
      for(String s: courseListsByStudentName.keySet()){
         int sum = 0;
         for(Course c: courseListsByStudentName.get(s)){
            sum += c.getNumUnits();
         }
         if(sum > unitThreshold) overEnrolledStudents.add(s);
      }
      

      return overEnrolledStudents;      
   }
}
