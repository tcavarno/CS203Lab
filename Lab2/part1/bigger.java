public class bigger{
    public static double whichIsBigger(Circle c, Rectangle r, Polygon p){
        if (Util.perimeter(c) > Util.perimeter(r) && Util.perimeter(c) > Util.perimeter(p)){
            return Util.perimeter(c);
        }
        else if (Util.perimeter(r) > Util.perimeter(c) && Util.perimeter(r) > Util.perimeter(p)){
            return Util.perimeter(r);
        }
        return Util.perimeter(p);
        
    }
}