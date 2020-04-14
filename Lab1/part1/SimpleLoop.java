class SimpleLoop
{
   public static int sum(int low, int high)
   {
      int count = 0;
      for(int i = low; i <=high; i++) count += i;
      return count;
   }
}
