class SimpleArray
{
   public static int [] squareAll(int values[])
   {
      
      int [] newValues = new int[values.length];  // This allocates an array of integers.

      for(int i = 0; i<values.length; i++){
         newValues[i] = values[(int)Math.pow(i,2)];
      }
      return newValues;
   }
}
