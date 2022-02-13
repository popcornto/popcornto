public class Data {
    private int[] intValues;
    public Data( int[] iV ) {
        intValues = iV;
    }
    public int doInt( IntFunction f ) {
        int result = 0;

        for (int i =0; i < intValues.length;i++){
            int v = intValues[i];
            result = f.apply( v, result );
        }
        return result;
    }


    static boolean moreThan(Data d, int i1, int i2){
        int count1 = d.doInt((x, y) -> {if (x == i1){return y+1;}else {return y;}});
        int count2 = d.doInt((x, y) -> {if (x == i2){return y+1;}else{return y;}});
        if (count1 > count2){
            return true;
        }else{
            return false;
        }
    }
    static boolean mostAreSmaller(Data d, int p){
        int half = d.intValues.length/2;
        int count = d.doInt((x, y) -> {
            if (x < p){
                return y+1;
            }else{
                return y;
            }
        });

        if (count > half){
            return true;
        }else{
            return false;
        }
    }

    static int addIf(Data d, int limit){
        if (d.intValues.length < limit){
            int Sum = d.doInt((x, y) -> { return y + x;});
            return Sum;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,3,3,3,3,6};
        Data data = new Data(arr);
        System.out.println(moreThan(data, 3, 6));
        System.out.println(mostAreSmaller(data, 2));
        System.out.println(addIf(data, 2));
    }
}
