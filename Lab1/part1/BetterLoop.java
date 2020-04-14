class BetterLoop
{
   public static boolean contains(int [] values, int v)
   {
      for(Integer i: values){
         if(i == v) return true;
      }
      return false;
   }
}
