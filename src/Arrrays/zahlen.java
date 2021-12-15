package Arrrays;

public class zahlen {

    public static String digitToString(int z1) {
        String[] a = new String[z1 + 1];
        if (z1 == 0) {
            a[0] = "null";
        } else if (z1 == 1) {
            a[1] = "eins";
        } else if (z1 == 2) {
            a[2] = "zwei";
        } else if (z1 == 3) {
            a[3] = "drei";
        } else if (z1 == 4) {
            a[4] = "vier";
        } else if (z1 == 5) {
            a[5] = "fünf";
        } else if (z1 == 6) {
            a[6] = "sechs";
        } else if (z1 == 7) {
            a[7] = "sieben";
        } else if (z1 == 8) {
            a[8] = "acht";
        } else if (z1 == 9) {
            a[9] = "nein!";
        }
        return a[z1];
    }
}

