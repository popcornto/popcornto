public class Fractioncalculator {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(9,3);
        Fraction f2 = new Fraction(6,9);
        Fraction f3 = f1.add(f2);
        Fraction f4 = f1.sub(f2);
        System.out.println("add: "+  f1.toString()+ "  +  " + f2.toString()+ "  =  " + f3.toString() );
        System.out.println("sub: "+ f1.toString() + "  -  "+ f2.toString() + "  =   "+ f4.toString());
        System.out.println();
    }
}
