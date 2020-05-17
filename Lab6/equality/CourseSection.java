import java.time.LocalTime;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public boolean equals(Object other){
      if (other == null) {return false; }
      if (this.getClass() == other.getClass()){
         CourseSection o = (CourseSection)other;
         boolean result = true;
         if(this.prefix== null){ result = o.prefix == null ;}
         else {result = result && this.prefix.equals(o.prefix);}

         if(this.number== null){ result = o.number == null ;}
         else {result = result && this.number.equals(o.number);}

         if(this.startTime== null){ result = o.startTime == null ;}
         else {result = result && this.startTime.equals(o.startTime);}

         if(this.endTime== null){ result = o.endTime == null ;}
         else {result = result && this.endTime.equals(o.endTime);}



         if(result && this.enrollment == o.enrollment){return true;}
         else{return false;}
      }
      return false;
   }

   public int hashCode(){
      int hash = 1;
   
      hash= hash * 31+ prefix== null ? 0 : prefix.hashCode();

      hash= hash * 31+ number == null ? 0 : number.hashCode();

      hash= hash * 31+((Integer)enrollment).hashCode();
     
      hash= hash * 31 + (startTime == null ? 0 : startTime.hashCode());

      hash= hash * 31+ (endTime == null ? 0 : endTime.hashCode());

      return hash;
   }

   // additional likely methods not defined since they are not needed for testing
   public static void main(String[] args){
      
      final CourseSection one = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));
      final CourseSection two = new CourseSection("CSC", "203", 35,
         LocalTime.of(9, 40), LocalTime.of(11, 0));

      one.equals(two);
      two.equals(one);
   }
   
}
