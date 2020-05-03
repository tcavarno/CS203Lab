import java.awt.Color;
import java.awt.Point;

class Circle implements Shape {
    private double radius;
    private Point center;
    private Color color;

    public Circle(double radius, Point center, Color color){
        this.radius=radius;
        this.center=center;
        this.color=color;
    }
    
    public Color getColor() {
        return this.color;
    }

    
    public void setColor(Color c) {
        this.color = c;
    }

  
    public double getArea() {
        return Math.PI*Math.pow(this.radius,2);
    }


    public double getPerimeter() {
        return Math.PI*2*this.radius;
    }


    public void translate(Point p) {
        this.center = new Point((int)(center.getX() + p.getX()), (int)(center.getY() + p.getY()));
    }

    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Point getCenter(){
        return this.center;
    }
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        else if(other.getClass() == this.getClass()){
            return true;
        }
        return false;
    }



}