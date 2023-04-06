import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> listK = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        while (k > 0){
            int rest = k % 10;
            listK.addFirst(rest);
            k /= 10;
        }
        int carry = 0;
        int i = num.length - 1, j = listK.size() - 1;
        while (i >= 0 || j >= 0){
            int tempSum = carry;
            if(i >= 0){
                tempSum += num[i];
                i--;
            }
            if(j >= 0){
                tempSum += listK.get(j);
                j--;
            }
            if(tempSum > 9){
                tempSum %= 10;
                carry = 1;
            }else carry = 0;
            ans.addFirst(tempSum);
        }

        if(carry > 0){
            ans.addFirst(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1, 9, 9};
        System.out.println(addToArrayForm(num, 1));
    }
}
