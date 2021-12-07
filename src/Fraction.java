public class Fraction {
    private int numurator;
    private int denominator;


    public Fraction(int num, int denom) {
        if (denom != 0) {
            if (denom < 0) {
                numurator = -num;
                denominator = -denom;
            } else {
                numurator = num;
                denominator = denom;
            }
            reduce();
        } else {
            throw new IllegalArgumentException();
        }
    }


    public Fraction() {
        numurator = 0;
        denominator = 1;
    }

    public Fraction(int num) {
        numurator = num;
        denominator = 1;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(5, 15);
        Fraction f2 = new Fraction(6, 2);
        Fraction f3 = new Fraction(2, 4);
        Fraction f4 = new Fraction(1);
        Fraction f5 = new Fraction(2);
        Fraction f6 = new Fraction(3);
        Fraction f7 = new Fraction(4);
        Fraction f8 = new Fraction(5);
        Fraction f9 = new Fraction(6);
        Fraction f10 = new Fraction(7);


        Fraction[] fractions = {f1, f2, f3};
        Fraction[] fractions1 = {f4, f5, f6, f4, f8, f9, f10};
        Fraction[] fractions2 = {f4,f5,f6,f7,f8};

        //System.out.println(f1.add(f2));
        //System.out.println(f1.toString());
        //System.out.println(f3.countNegatives(new Fraction[]{f1,f2,f3}));
        //System.out.println(f1.sumUpNegatives(new Fraction[]{f1,f2,f3}));
        //System.out.println(f1.maximum(new Fraction[]{f1, f2, f3}));
        //System.out.println(f2.countmaximum(fractions));
        //System.out.println(f1.isSorted1(fractions1));
        //System.out.println(f1.increaseArray(fractions, f1));
        /*for (Fraction f12: f1.increaseArray(fractions, f1)) {
            System.out.println(f12.toString());
        }*/
            /*for (Fraction f12: f1.doubleifContainpositive(fractions)) {
                System.out.println(f12.toString());}*/
        //System.out.println(f1.toShtring(fractions));
        //System.out.println(f1.Sorted(fractions1, fractions1.length-1));
        //System.out.println(f6.maximum(fractions1, fractions1.length-1));
        //Rekusioned
        //System.out.println(f1.maximumrekfrac(fractions1, fractions1.length-1));
        //System.out.println(f1.LastPositive(fractions1,fractions1.length-1));
        System.out.println(f1.firstPositive(fractions1, fractions1.length-1));
        System.out.println(f1.isSorted(fractions2, fractions2.length-1));
        System.out.println(f1.contains(fractions2, fractions2.length-1, f4));
        System.out.println(f1.countPositives(fractions2, 0 , fractions2.length-1));
    }

    //Praktikumsbaltt 4;
    public Fraction maximumrekfrac(Fraction[] arr, int i) {
        if (i == 0) {
            return arr[i];
        }

        Fraction maximum = maximumrekfrac(arr, i - 1);
        if (maximum.toDouble() < arr[i].toDouble()) {
            maximum = arr[i];
        }
        return maximum;
    }
    public Fraction LastPositive(Fraction[] arr, int i){
        if (i == 1){
            return null;
        }
        if (arr[i].toDouble() > 0){
            return arr[i];
        }
        else return LastPositive(arr, i-1);
    }
    public Fraction firstPositive(Fraction[] arr, int i){
        if (i == 1){
            return null;
        }
        if (arr[arr.length-i-1].toDouble() > 0){
            return arr[arr.length-i-1];
        }
        else return LastPositive(arr, i-1);
    }
    public boolean isSorted(Fraction[] arr, int i){
        if (i == 1){
            return true;
        }
        if (arr[i].toDouble() < arr[i-1].toDouble()) {
            return false;
        }return isSorted(arr, i-1);

    }

    public boolean contains(Fraction[] arr, int i , Fraction x){
        if (i == 0 && arr[i] != x){
            return false;
        }
        if (arr[i] == x ) {
            return true;
        }return contains(arr, i-1, x);
    }

    public int countPositives(Fraction[] arr, int d , int t){
        if (t+1  == d){
            return t+1;
        }
        int count = countPositives(arr, d,t-1);
        if (arr[t].toDouble() > 0){
            count++;
        }

        return count;
    }

    public Fraction apply(Fraction[] arr, Fraction x) {
        Fraction middle;
        if (arr.length % 2 == 0 || arr.length < 3) {
            return x.multiplikation(new Fraction(1, 2));
        } else if (arr.length <= 3 & arr.length % 2 != 0) {

            middle = arr[arr.length / 2];
            return middle.add(x);
        }
        return x;
    }



    private void reduce() {
        if (numurator != 0) {
            int gcd = calculateGcd();
            numurator /= gcd;
            denominator /= gcd;
        } else {
            denominator = 1;
        }
    }

    private int calculateGcd() {
        int value1 = Math.abs(numurator);
        int value2 = denominator;
        while (value1 != 0 & value2 != 0) {
            if (value1 > value2) {
                value1 = value1 % value2;
            } else {
                value2 = value2 % value1;
            }
        }
        if (value1 == 0) {
            return value2;
        } else return value1;
    }

    public String toString() {
        return numurator + "/" + denominator;
    }

    public Fraction changesign() {
        return new Fraction(-numurator, denominator);
    }

    public Fraction reverse() {
        return new Fraction(denominator, numurator);
    }

    public Fraction add(Fraction other) {
        int num = numurator * other.denominator + other.numurator * denominator;
        int denom = denominator * other.denominator;
        return new Fraction(num, denom);
    }

    public Fraction sub(Fraction other) {
        int num = numurator * other.denominator - other.numurator * denominator;
        int denum = denominator * other.denominator;
        return new Fraction(num, denum);
    }

    public Fraction multiplikation(Fraction other) {
        int num = numurator * other.numurator;
        int denum = denominator * other.denominator;
        return new Fraction(num, denum);
    }

    public Fraction Division(Fraction other) {
        return multiplikation(other.reverse());
    }

    public double toDouble() {
        return (double) numurator / (double) denominator;
    }

    public Fraction clone() {
        return new Fraction(numurator, denominator);
    }

    public boolean equals(Fraction other) {
        return numurator == other.numurator & denominator == other.denominator;

    }

    public boolean greaterthan(Fraction other) {
        return numurator > other.numurator & denominator > other.denominator;
    }

    public boolean smallerthan(Fraction other) {
        return numurator < other.numurator & denominator < other.denominator;
    }

    public boolean greatereqeal(Fraction other) {
        return numurator >= other.numurator & denominator >= other.denominator;
    }

    public boolean smallerequal(Fraction other) {
        return numurator <= other.numurator & denominator <= other.denominator;
    }

    public Fraction countNegatives(Fraction[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toDouble() < 0) {
                count++;
            }
        }
        return new Fraction(count);
    }

    public Fraction sumUpNegatives(Fraction[] arr) {
        Fraction sum = new Fraction(0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toDouble() < 0) {
                sum = sum.add(arr[i]);
            }
        }
        return sum;
    }

    public Fraction maximum(Fraction[] arr) {
        Fraction max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            /**
             if (arr[i].toDouble() < arr[i + 1].toDouble()) {
             max = arr[i + 1];
             arr[i] = arr[i + 1];
             }
             if (arr[i].toDouble() > arr[i + 1].toDouble()) {
             max = arr[i];
             }
             */
            if (arr[i].toDouble() > max.toDouble()) {
                max = arr[i];
            }

        }
        return max;
    }

    public Fraction countmaximum(Fraction[] arr) {
        Fraction max = maximum(arr);
        Fraction count = new Fraction(0, 1);
        Fraction addone = new Fraction(1, 1);
        //System.out.println(maximum(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toDouble() == max.toDouble()) {
                count = count.add(addone);
            }
        }


        return count;
    }

    public boolean isSorted(Fraction[] arr) {
        boolean sorted = true;
        Fraction next = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (next.toDouble() <= arr[i].toDouble()) {
                sorted = true;
                next = arr[i];
            } else if (next.toDouble() > arr[i].toDouble()) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public boolean isSorted1(Fraction[] arr) {
        boolean sorted = true;
        Fraction next = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (next.toDouble() < arr[i].toDouble()) {
                sorted = true;
                next = arr[i];
            } else if (next.toDouble() > arr[i].toDouble()) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public Fraction[] increaseArray(Fraction[] arr, Fraction z) {
        Fraction[] copyarray = new Fraction[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyarray[i] = arr[i].add(z);
        }
        return copyarray;
    }

    public Fraction[] doubleifContainpositive(Fraction[] arr) {
        Fraction[] copyarray = arr;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toDouble() > 0) {
                count++;
            }
        }
        if (count > 0) {

            for (int i = 0; i < arr.length; i++) {
                copyarray[i] = arr[i].multiplikation(new Fraction(2));
            }
        }
        return copyarray;
    }

    public String toShtring(Fraction[] arr) {
        String empty = "";
        String komma = ",";
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length) {
                empty = empty + arr[i];
                if (i != arr.length - 1)
                    empty = empty + komma;
                ;
            }

        }
        return empty;
    }/*
        public String selectnegatives(Fraction[] arr){
            int count = 0;
            Fraction[] newarray = new Fraction[countNegatives(arr).toDouble()];


        }*/

    public boolean Sorted(Fraction[] arr, int i) {
        if (arr[i].toDouble() > arr[i - 1].toDouble() && i == 1) {
            return true;
        }
        if (arr[i].toDouble() < arr[i - 1].toDouble()) {
            return false;
        }

        return Sorted(arr, i - 1);

    }

}

