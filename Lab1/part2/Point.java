public class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getRadius(){
        return Math.pow(Math.pow(this.x,2) + Math.pow(this.y,2),.5);
    }
    public double getAngle(){
        return Math.atan(this.y/this.x);
    }

    public Point rotate90(){
        return new Point(-this.y,this.x);
    }

}