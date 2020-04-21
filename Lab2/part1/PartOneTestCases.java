import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PartOneTestCases
{
   public static final double DELTA = 0.00001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[][] {new Class[0]});

      verifyImplSpecifics(Polygon.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testUtilImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "perimeter", "perimeter", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         double.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[] {Circle.class},
         new Class[] {Polygon.class},
         new Class[] {Rectangle.class});

      verifyImplSpecifics(Util.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }

   @Test
   public void testCirlce()
   {
      Circle circle = new Circle(new Point(0,0) , 3.0);
      assertEquals(3.0, circle.getRadius(), DELTA);

      assertEquals(0.0 , circle.getCenter().getX(), DELTA);
      assertEquals(0.0 , circle.getCenter().getY(), DELTA);

   }

   @Test
   public void testRectangle()
   {
      Rectangle rectangle = new Rectangle(new Point(0,3), new Point(3,3));
      assertEquals(0.0, rectangle.getTopLeft().getX(), DELTA);
      assertEquals(3.0, rectangle.getTopLeft().getY(), DELTA);
      assertEquals(3.0 , rectangle.getBottomRight().getX(), DELTA);
      assertEquals(3.0 , rectangle.getBottomRight().getY(), DELTA);

   }

   @Test
   public void testPolygon()
   {
      List<Point> inputPoints = new ArrayList<Point>();
      inputPoints.add(new Point(0,0));
      inputPoints.add(new Point(3,4));
      inputPoints.add(new Point(4,0));

      Polygon polygon = new Polygon(inputPoints);
      assertEquals(inputPoints, polygon.getPoints());
   }

   @Test
   public void testPerimPoly() {
        List<Point> points = new ArrayList<Point>(); 
        points.add(new Point(0, 0));
        points.add(new Point(3,0));
        points.add(new Point(0,4));
        double d = Util.perimeter(new Polygon(points));
        assertEquals(12.0, d, DELTA);
   }

   @Test
   public void testPerimRec() {
        Point top = new Point(0,4);
        Point bottom = new Point(4, 0);
        Rectangle r = new Rectangle(top,bottom);
        double d = Util.perimeter(r);
        assertEquals(16.0, d, DELTA);
   }
   @Test
   public void testPerimCir() {
        Point center = new Point(0,0);
        double radius = .5;

        double d = Util.perimeter(new Circle(center,radius));
        assertEquals(Math.PI, d, DELTA);
   }
   @Test
   public void testBigger() {
        Point center = new Point(0,0);
        double radius = .5;
        Circle c = new Circle(center,radius);
        
        Point top = new Point(0,4);
        Point bottom = new Point(4, 0);
        Rectangle r = new Rectangle(top,bottom);

        List<Point> points = new ArrayList<Point>(); 
        points.add(new Point(0, 0));
        points.add(new Point(3,0));
        points.add(new Point(0,4));
        Polygon p = new Polygon(points);


        assertEquals(16.0, bigger.whichIsBigger(c,r,p), DELTA);
   }



}
