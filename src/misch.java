
import java.util.ArrayList;
import java.util.Arrays;

public class misch {

    public static void main(String[] args) {
        //Görße von 1. und 2. Array vergleichen und nicht null sein -> ArrayList nicht empty
        //Array 1 index 1 < Array 2 index 1 -> add Array 1 index 1 zu neue Array - Array 1 remove index 1
        //Array 2 index 1 < Array 1 index 1 -> add Array 2 index 1 zu neue Array - Array 2 remove index 1
        int [] a1 = {3,7,8,11,15,16};
        int [] b1 = {4,9,10,13,18,19};

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> arrayToSave = new ArrayList<>();

        for(int i = 0; i < a1.length; i++) {
            a.add(a1[i]);
        }
        for(int i = 0; i < b1.length; i++) {
            b.add(b1[i]);
        }
        while (true) {
            int i = 0;
            if(a.size() == 0) {
                /*
                    for(int j = 0; j < b.size(); j++) {
                        arrayToSave.add(b.get(j));
                    }
                 */
                arrayToSave.addAll(b);
                break;
            }
            if(b.size() == 0) {
                arrayToSave.addAll(a);
                break;
            }
            if(a.get(i) < b.get(i)) {
                arrayToSave.add(a.get(i));
                a.remove(i);
            }else if(a.get(i) > b.get(i)) {
                arrayToSave.add(b.get(i));
                b.remove(i);
            }
        }
        System.out.println(Arrays.toString(arrayToSave.toArray()));





    }



}