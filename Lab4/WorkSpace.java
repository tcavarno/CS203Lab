import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;

class WorkSpace{
    private List<Shape> shapes;
    public WorkSpace(){
        this.shapes = new ArrayList<Shape>();
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }
    public Shape get(int index) {
        return this.shapes.get(index);
    }
    public int size() {
        return shapes.size();
    }
    public List<Circle> getCircles() {
        List<Circle> subList = new ArrayList<Circle>();
        for(Shape s: shapes){
            if (s instanceof Circle) subList.add((Circle) s);
        }
        return subList;
    }
    public List<Rectangle> getRectangles() {
        List<Rectangle> subList = new ArrayList<Rectangle>();
        for(Shape s: shapes){
            if (s instanceof Rectangle) subList.add((Rectangle) s);
        }
        return subList;
    }

    public List<Triangle> getTriangles() {
        List<Triangle> subList = new ArrayList<Triangle>();
        for(Shape s: shapes){
            if (s instanceof Triangle) subList.add((Triangle) s);
        }
        return subList;
    }
    public List<Shape> getShapesByColor(Color color) {
        List<Shape> subList = new ArrayList<Shape>();
        for(Shape s: shapes){
            if (s.getColor() == color) subList.add( s);
        }
        return subList;
    
    } 
    public double getAreaOfAllShapes() {
        double sum = 0;
        for(Shape s: this.shapes){
            sum += s.getArea();
        }
        return sum;
    }
    public double getPerimeterOfAllShapes() {
        double sum = 0;
        for(Shape s: this.shapes){
            sum += s.getPerimeter();
        }
        return sum;
    }
    public static void main(String[] Args){
        WorkSpace ws = new WorkSpace();

        ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
        ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
        ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), 
                 Color.BLACK));
        System.out.print(ws.getAreaOfAllShapes());
    }
}