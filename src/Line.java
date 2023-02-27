public class Line {
    private double a;
    private double b;
    private double c;

    public Line(){
        this.a =0;
        this.b =0;
        this.c =0;
    }
    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean contains(double x, double y) {
        return a*x + b*y + c == 0;
    }

    public double[] Intersection(Line otherLine) {
        double determinant = a * otherLine.b - b * otherLine.a;
        if (determinant == 0) {
            return null;
        } else {
            double x = (b * otherLine.c - otherLine.b * c) / determinant;
            double y = (otherLine.a * c - a * otherLine.c) / determinant;
            return new double[] {x, y};
        }
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    @Override
    public String toString() {
     return String.format("%.2fx + %.2fy + %.2f = 0",a,b,c);
    }
    @Override
    public boolean equals(Object obj) {
        boolean r = false;
        if ( obj instanceof Line )
        {
            Line obj1 = (Line) obj;
            if ( a==obj1.getA() && b==obj1.getB() && c == obj1.getC() ) r = true;
        }
        return r;
    }


    public static void Task3() {
        Line line1 = new Line(2, 3, -8);
        Line line2 = new Line(-3, 2, 7);
        double x =1;
        double y =2;
        System.out.println("Point {"+x+","+y+"} constrains line1 : "+line1.contains(x, y));
        System.out.println("Line 1 : "+line1.toString());
        System.out.println("Line 2 : "+line2.toString());
        double[] intersectionPoint = line1.Intersection(line2);
        if (intersectionPoint == null) {
            System.out.println("Lines are parallel");
        } else {
            System.out.println("Crossing point: (" + intersectionPoint[0] + ", " + intersectionPoint[1] + ")");
        }
        if(line1.equals(line2)){
            System.out.println("Equals");
        }
        else System.out.println("Not equals");

    }
}