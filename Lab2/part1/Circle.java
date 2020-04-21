public class Circle
{
    private Point center;
    private double radius;

    public Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public Point getPoint(){
        return this.center;
    }

    public double getRadius(){
        return this.radius;
    }



}

