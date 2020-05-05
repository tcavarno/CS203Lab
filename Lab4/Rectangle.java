import java.awt.Color;
import java.awt.Point;

class Rectangle implements Shape {
    private double width;
    private double height;
    private Point topLeft;
    private Color color;

    Rectangle(double width, double height, Point topLeft, Color color){
        this.height= height;
        this.width=width;
        this.topLeft = topLeft;
        this.color = color;
    }
    public double getWidth(){
        return this.width;
    }
    
    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight() {
        return this.getHeight();
    }

    public void setHeight(double height) 
    {
        this.height = height;
    }

    public Point getTopLeft() {
        return this.topLeft;
    }   
    public boolean equals(Object other){
        if(other == null) return false;
        else if(other.getClass() == this.getClass()){
            boolean a = this.topLeft.equals(((Rectangle) other).topLeft); 
            boolean b = this.width == ((Rectangle) other).width; 
            boolean c = this.height == ((Rectangle) other).height;
            boolean d = this.color == ((Rectangle) other).color;
            return (a && b && c && d);
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
       return this.width*this.height;
    }

   
    public double getPerimeter() {
        return 2*this.width +2*this.height;
    }

    public void translate(Point p) {
        this.topLeft = new Point( (int)(this.topLeft.getX()+p.getX()), (int)(this.topLeft.getY() +p.getY()));

    }
    


    
}