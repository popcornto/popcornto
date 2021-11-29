public class aref {
    static char a = 0, b = a++, e = a++, f = (char) (a / a);

    static char p(String s)
    {
        return (char) Byte.parseByte(s, a);
    }
    public static int Gcd(int a,int n){
        int count =1;
        int b = a;
        int c = n;
        int i1;
        int count1 =0;
        int i2;

        if (b<c) {
            for (int i = b; i <= c; i *= count) {
                count++;
            }
            for (i1 = b * count; i1 == c; i1++) {
                count1++;
                c = b;
                b = count1;
            }if (i1%count==0){
                return count1;
            }
        } else if (c<b){
                for (int i = c;i<= b; i*=count){
                    count++;
                }
                for (i2 = c*count;i2==b;i2++){
                    count1++;
                    b = c;
                    c = count1;
                }if (i2%count==0){
                return count1;
            }
        }

        return b;
    }
    public static void main(String[] z)
    {

        System.out.println(Gcd(156,66));


        long x = e, y = b;
        String c = ((Long) x).toString(), d = ((Long) y).toString();
        char l = p(c + c + d + c + c + d + d),
                m = p(c + c + d + d + c + d + c),
                o = (char) (l + a + f);
        b = p(c + d + d + d + d + d);
        e = b++;
        System.out.print(new char[]
                {
                        p(c + d + d + c + d + d + d)
                        ,
                        m, l, l, o, e,
                        p(c + d + c + d + c + c + c),
                        o, (char) (o + a + f),
                        l,
                        (char) (m - f), b
                });
    }
}
    /**public static double euler(int n) {
        int[] b= new int[n];
        double k;
        int one = 1;
        double summe=1;
        int[] multi = new int[n];
        int[] count;

        for (int i = 0; multi[0] <= multi.length; multi = new int[i++]) {
            System.out.println("summe1 :"+summe);
            count = new int[i];
            summe = summe + one * i+count.length;
            for (k =0;k<count.length;k=k+summe){


                System.out.println( "summe2 :" +summe);

                one=one++;
                System.out.println("one :" + one);

                summe=1/summe;
                System.out.println("summe3 :"+summe);}
        }
        return b[9];
    }
    public static void main (String[]args){
        System.out.println(euler(9));
        }**/