public class max {
    public static int bla(int divisor){
        int value = 1;
        int sum = 0;
        int count = 0;
        while (value<1000){
            sum += value * value;
            if (sum % divisor == 0 ){
                count++;
            }
            value++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bla(16));
    }

}
