public class Util{
    public static double perimeter(Circle circle){
            return Math.PI*circle.getRadius()*2;
    }
    
    public static double perimeter(Rectangle rectangle){
        double sideOne = 0.0;
        double sideTwo = 0.0;
        sideOne = Math.abs(rectangle.getTopLeft().getX()-rectangle.getBottomRight().getX());
        sideTwo = Math.abs(rectangle.getTopLeft().getY()-rectangle.getBottomRight().getY());
        return 2*sideOne+2*sideTwo;
    }


    public static double perimeter(Polygon polygon){
        double perimeter = 0;
        for(int i = 1; i< polygon.getPoints().size(); i ++){
            double x1 = polygon.getPoints().get(i-1).getX();
            double x2 = polygon.getPoints().get(i).getX();
            double y1 = polygon.getPoints().get(i-1).getY();
            double y2 = polygon.getPoints().get(i).getY();

            perimeter += distanceFormula(x1,y1,x2,y2);
        }
        double x1 = polygon.getPoints().get(0).getX();
        double x2 = polygon.getPoints().get(polygon.getPoints().size()-1).getX();
        double y1 = polygon.getPoints().get(0).getY();
        double y2 = polygon.getPoints().get(polygon.getPoints().size()-1).getY();
        return perimeter + distanceFormula(x1,y1,x2,y2);
        
    }
    private static double distanceFormula(double x1, double y1,double x2,double y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
}