package perimeter_quiz;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        FileResource fr = new FileResource();
        int count = 0;
        for (String line : fr.lines())
        {
            count ++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double avgLength;
        double p = getPerimeter(s);
        int n = getNumPoints(s);
        avgLength = p / n;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
         Point prevPt = s.getLastPoint() ;
         double maxSide = 0.0;
        for ( Point curpt : s.getPoints())
        {  
            maxSide = prevPt.distance(curpt);
            if(maxSide > prevPt.distance(curpt))
            {
                maxSide = prevPt.distance(curpt);
            }
            prevPt = curpt;
        }
        
        return maxSide;
    }

    public double getLargestX(Shape s) {
        double phatX = 0.0;
        int p;
        for (Point pt : s.getPoints())
        {
             p = pt.getX();
            if(p > phatX)
            {
                phatX = p;
            }
        }
        return phatX;
    }

    public double getLargestPerimeterMultipleFiles() {
       DirectoryResource dr = new DirectoryResource();
       double largestPerim = 0.0;

       for (File f : dr.selectedFiles())
       {
           FileResource fr = new FileResource(f);
           Shape s = new Shape(fr);
           double perim = getPerimeter(s);
           if(perim >largestPerim)
           {
               largestPerim = perim;
            }
    }
    return largestPerim;
}

    public String getFileWithLargestPerimeter() {
       DirectoryResource dr = new DirectoryResource();
       File temp = null; 
       double largestPerim = 0.0;

       for (File f : dr.selectedFiles())
       {
           FileResource fr = new FileResource(f);
           Shape s = new Shape(fr);
           double perim = getPerimeter(s);
           if(perim >largestPerim)
           {
               temp = f;
               largestPerim = perim;
            }
    }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largeSide = getLargestSide(s);
        double largeX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("The number of points = " + numPoints);
        System.out.println("The average length = " + avgLength);
        System.out.println("The largest side  = " + largeSide);
        System.out.println("The largest X  = " + largeX);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
       double largestP = getLargestPerimeterMultipleFiles();
       System.out.println("the largest permiter in the files given is " + largestP);
     
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
