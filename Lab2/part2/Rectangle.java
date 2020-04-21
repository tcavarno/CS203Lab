public class Rectangle{

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight){
        this.topLeft = topLeft;
        this.bottomRight =  bottomRight;
    }

    public Point getTopLeft(){
        return this.topLeft;
    }

    public Point getBottomRight(){
        return this.bottomRight;
    }
    public  double perimeter(){
        double sideOne = Math.abs(topLeft.getX()-bottomRight.getX());
        double sideTwo = Math.abs(topLeft.getY()-bottomRight.getY());
        return 2*sideOne+2*sideTwo;
    }

}