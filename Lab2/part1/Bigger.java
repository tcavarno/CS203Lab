public class Bigger{
    public static double whichIsBigger(Circle c, Rectangle r, Polygon p){
        if (Util.perimeter(c) > Util.perimeter(r) && Util.perimeter(c) > Util.perimeter(p)){
            System.out.println("circle");
            return Util.perimeter(c);
        }
        else if (Util.perimeter(r) > Util.perimeter(c) && Util.perimeter(r) > Util.perimeter(p)){
            System.out.println("rectangle");
            return Util.perimeter(r);
        }
        System.out.print("polygon");
        return Util.perimeter(p);
        
    }
}