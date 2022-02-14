package lambdaAufg;

public class Structure {
    private double[] values;

    public Structure(double[] p) {
        values = p;
    }

    public double make(BoolFunc test, DoubleFunc result) {
        int count = 0;
        double sum = 0;
        int i = 0;
        for (double d : values) {
            if (test.apply(i, d)) {
                count++;
                sum = sum + d;
            }
            i++;
        }
        return result.apply(count, sum);
    }

    public static void main(String[] args) {
        double[] arr = {1, 2, 3};
        Structure arrs = new Structure(arr);
        double count = arrs.make((x, y) -> (y > 0.0), (x, y) -> x);
        System.out.println(count);

        double inte = arrs.make((x, y) ->
                        true
                , (x, y) -> {
                    if (arrs.values.length > 0){
                        return y/count;
                    }else{
                        return -1;
                    }
                });
        System.out.println(inte);

    }


}
