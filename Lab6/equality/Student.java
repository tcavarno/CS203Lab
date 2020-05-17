import java.util.List;
import java.util.Objects;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   public int hashCode(){
      return Objects.hash(surname,givenName,age,currentCourses);
   }

   public boolean equals(Object other){
      if (other == null) return false;
      if(this.getClass() == other.getClass()){
         boolean result = true;
         Student o = ((Student)other);
         result = result && Objects.equals(this.surname, o.surname);
         result = result && Objects.equals(this.givenName,o.givenName);
         result = result && Objects.equals(this.age,o.age);
         result = result && Objects.equals(this.currentCourses, o.currentCourses);
         return result;
      }
      else return false;
      
   }
}
