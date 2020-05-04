import java.awt.Color;
import java.awt.Point;

class Triangle implements Shape {
    private Point a;
    private Point b;
    private Point c;
    private Color color;

    Triangle(Point a, Point b, Point c, Color color){
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
    }

    public Point getVertexA() {
        return this.a;
    }

    public Point getVertexB() {
        return this.b;
    }

    public Point getVertexC() {
        return this.c;
    }
    
    public boolean equals(Object other) {
        if (other == null) return false;
        else if (other.getClass() == this.getClass()) {
            if(this.a.equals(((Triangle) other).a) &&
               this.b.equals(((Triangle) other).b) &&
               this.c.equals(((Triangle) other).c) &&
               this.color == ((Triangle) other).color) 
               return true;
            else return false;
        }
        return false;
    }
   
   
    public Color getColor() {
        return this.color;
    }

     
    public void setColor(Color c) {
       this.color = c;
    }

     
    public double getArea() {
        return (this.a.getX()*(Math.abs(this.b.getY() - this.c.getY())) + 
                this.b.getX()*(Math.abs(this.c.getY() - this.a.getY())) + 
                this.c.getX()*(Math.abs(this.b.getY() - this.a.getY())))/2;
    }

     
    public double getPerimeter() {
        double leg1 = Math.sqrt(Math.pow(Math.abs(a.getX()-b.getX()),2)+ Math.pow(Math.abs(a.getY()-b.getY()),2));
        double leg2 = Math.sqrt(Math.pow(Math.abs(b.getX()-c.getX()),2)+ Math.pow(Math.abs(b.getY()-c.getY()),2));
        double leg3 = Math.sqrt(Math.pow(Math.abs(c.getX()-a.getX()),2)+ Math.pow(Math.abs(c.getY()-a.getY()),2));
        return leg1 + leg2 + leg3;
    }

    public void translate(Point p) {
        this.a = new Point((int)(this.a.getX()+p.getX()), (int)(this.a.getY()+p.getY()));
        this.b = new Point((int)(this.b.getX()+p.getX()), (int)(this.b.getY()+p.getY()));
        this.c = new Point((int)(this.c.getX()+p.getX()), (int)(this.c.getY()+p.getY()));

    }

}