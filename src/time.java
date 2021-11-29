public class time {
    public static int hourstoSeconds(int hours, int minutes)
    {
        return (hours*3600)+(minutes * 60);
    }
    public static int remainder( int dividend, int divisor){
        return ((divisor * (dividend / divisor) - (dividend))*-1);
    }
    public static int showtime(int time){
        return (time/60);
    }

    public static void main(String[] args){
        System.out.println(hourstoSeconds(1, 1));
        System.out.println(showtime(800)+ ":" + remainder(800, 60));
    }

}
