import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

interface Geometric {
	double getArea();
}

abstract class Shape implements Geometric{
	public abstract double getArea();
}

class Circles extends Shape{
	private double radius;
	private double area; 
	
	public Circles(double radius) {
		this.radius = radius;
	}
	public double getArea() {
		area = Math.PI * radius * radius;
		return area;
	}
	// Used to print Circlrs Area details in main()
    public String toString()
    {
        return "Radius: " + this.radius +
                           "----" + "Circles Area: " + this.area;
    }
}

class Squares extends Shape{
	private double length;
	private double area;
	
	public Squares (double length) {
		this.length = length;
	}
	public double getArea() {
		area = length * length;
		return area;
	}	
	// Used to print Squares Area details in main()
    public String toString()
    {
        return "Length: " + this.length +
                           "----" + "Squares Area: " + this.area;
    }
}

class Rectangles extends Shape{
	private double length;
	private double width;
	private double area;
	
	public Rectangles(double length, double width) {
		this.length = length;
		this.width = width;
	}
	public double getArea() {
		area = length * width;
		return area;
	}
	// Used to print Squares Area details in main()
    public String toString()
    {
        return "Length: " + this.length + " " + "Width: " + this.width +
                           "----" + "Rectangle Area: " + this.area;
    }
}

class SortByArea implements Comparator<Shape>
{
    // Used for sorting in ascending order of area    
    public int compare(Shape a, Shape b)
    {
    	double a1 = a.getArea();
    	double b1 = b.getArea();
    	int result;
    	if (a1 == b1) 
    		{result = 0;}
    	else if (a1 > b1) 
    		{result =1;}
    	else {result = -1;}		
    	
        return result;
    }
}

public class AreaCalculator {

	public static void main(String[] args) {
		Circles cir = new Circles(2.0);
		Squares sq = new Squares(3.0);
		Rectangles rec = new Rectangles(4.0, 5.0);
		
		System.out.println(cir.getArea());
		System.out.println(sq.getArea());
		System.out.println(rec.getArea());
		
		ArrayList<Shape> collection = new ArrayList<Shape>(); 
		collection.add(rec);
		collection.add(sq);
		collection.add(cir);
		
		System.out.println("Before sorted by area");
        for (int i=0; i<collection.size(); i++)
            System.out.println(collection.get(i));
	
		Collections.sort(collection, new SortByArea());
		
		System.out.println("After sorted by area");
        for (int i=0; i<collection.size(); i++)
            System.out.println(collection.get(i));
      
	}
}
