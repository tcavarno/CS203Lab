import java.util.List;

public class Polygon{
    List<Point> pointList;

    public Polygon(List<Point> pointList){
        this.pointList=pointList;
    }

    public List<Point> getPointList(){
        return this.pointList;
    }
}