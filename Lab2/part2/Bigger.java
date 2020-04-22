public class Bigger{
    public static double whichIsBigger(Circle c, Rectangle r, Polygon p){
        if (c.perimeter() > r.perimeter() && c.perimeter() > p.perimeter()){
            return c.perimeter();
        }
        else if (r.perimeter() > c.perimeter() && r.perimeter() > p.perimeter()){
            return r.perimeter();
        }
        return p.perimeter();
        
    }
}