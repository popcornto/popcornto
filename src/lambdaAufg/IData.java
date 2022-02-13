package lambdaAufg;

public class IData {
    private Integer[] iValues;

    public IData(Integer[] p) {
        iValues = p;
    }

    public Integer dof(IntegerBiFunction ibf) {
        Integer LastApply = null;
        for (Integer value : iValues) {
            if (value != null) {
                LastApply = ibf.apply(value, LastApply);
            }
        }
        return LastApply;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[8];
        IData id = new IData(arr1);
        arr1[0] = null;
        arr1[1] = null;
        arr1[2] = 2;
        arr1[3] = 3;
        arr1[4] = 4;
        arr1[5] = 5;
        arr1[6] = 6;
        arr1[7] = null;
        Integer count = id.dof((p1, p2) -> {
            if (p1 != null) {
                if (p2 != null) {
                    System.out.println(p2);
                    return p2 + 1;
                } else {
                    return 1;
                }
            }
            return p2;
        });
        /*Integer MaxIndex = id.dof((p1, p2) -> {
           if ()
        });*/
        System.out.println(count);
    }
}
