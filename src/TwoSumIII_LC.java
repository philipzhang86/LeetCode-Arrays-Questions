import java.util.ArrayList;
import java.util.Collections;

public class TwoSumIII_LC {
    private ArrayList<Integer> arrayList;

    public TwoSumIII_LC() {
        arrayList = new ArrayList<>();
    }

    public void add(int number) {
        arrayList.add(number);
    }

    public boolean find(int value) {
        Collections.sort(arrayList);
        int lo = 0;
        int hi = arrayList.size()-1;
        while (lo<hi){
            int temp = arrayList.get(lo) + arrayList.get(hi);
            if(temp == value)   return true;
            else if(temp < value)   lo++;
            else                    hi--;
        }
        return false;
    }
}
