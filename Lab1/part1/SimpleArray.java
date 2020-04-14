class SimpleArray
{
   public static int [] squareAll(int values[])
   {
      
      int [] newValues = new int[values.length];  // This allocates an array of integers.

      for(int i = 0; i<values.length; i++) newValues[i] = (int)Math.pow(values[i],2);

      return newValues;
   }
   /*
   public static void main(String args[]){
      int[] l = new int[] {1,2,3,4,5,6};
      System.out.print(SimpleArray.squareAll(l) == new int[] {1,4,8,16,25,36});
   }
   */
}
