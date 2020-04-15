import sun.jvm.hotspot.utilities.Assert;

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
        boolean xDir = this.x>0;
        boolean yDir = this.y>0;
        if (x == 0 && yDir) return Math.PI/2.0;
        if (x == 0 && !yDir) return 3*Math.PI/2.0;
        if (y == 0 && xDir) return 0.0;
        if (y == 0 && !xDir) return Math.PI;
        if (!xDir && yDir) return Math.PI - Math.atan(this.y/(-1*this.x));
        if (!xDir && !yDir) return Math.PI + Math.atan((-1*this.y)/(-1*this.x));
        if (xDir && !yDir) return 2*Math.PI - Math.atan((-1*this.y)/this.x);
        
        return Math.atan(this.y/this.x);
    }

    public Point rotate90(){
        return new Point(-this.y,this.x);
    }

}