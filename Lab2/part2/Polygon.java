import java.util.List;

public class Polygon{
    List<Point> pointList;

    public Polygon(List<Point> pointList){
        this.pointList=pointList;
    }

    public List<Point> getPoints(){
        return this.pointList;
    }
    public  double perimeter(){
        double perimeter = 0;
        for(int i = 1; i< this.pointList.size(); i ++){
            double x1 = this.pointList.get(i-1).getX();
            double x2 = this.pointList.get(i).getX();
            double y1 = this.pointList.get(i-1).getY();
            double y2 = this.pointList.get(i).getY();

            perimeter += distanceFormula(x1,y1,x2,y2);
        }
        double x1 = this.pointList.get(0).getX();
        double x2 = this.pointList.get(this.pointList.size()-1).getX();
        double y1 = this.pointList.get(0).getY();
        double y2 = this.pointList.get(this.pointList.size()-1).getY();
        return perimeter + distanceFormula(x1,y1,x2,y2);
        
    }
    private double distanceFormula(double x1, double y1,double x2,double y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
}