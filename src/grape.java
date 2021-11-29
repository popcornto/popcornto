public class grape {
    public static int interval(int a, int b) {

        int sum = 0;
        if (a < b) {
            for (int i = a; i <= b; i++) {
                sum = sum + i;
            }
            }
        else

            for (int i = b; i <= a; i++) {
                sum = sum + i;

        }
        return sum;}
    public static void main(String[] args) {
        System.out.println(interval(1,7));
    }

}
