
    import javax.swing.*;

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
            Fraction[] fractions1 = {f4, f5, f6, f7, f8, f9, f10};

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
            System.out.println(f1.toShtring(fractions));

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

        public static Fraction apply(Fraction[] arr, Fraction x) {
            Fraction middle;
            if (arr.length % 2 == 0 || arr.length < 3) {
                return x.multiplikation(new Fraction(1, 2));
            } else if (arr.length <= 3 & arr.length % 2 != 0) {

                middle = arr[arr.length / 2];
                return middle.add(x);
            }
            return x;
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

    }


