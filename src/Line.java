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
}