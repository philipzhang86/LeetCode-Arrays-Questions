import java.util.LinkedList;

public class longestPeak {

    public static int longestPeak(int[] array) {
        LinkedList<Integer> peakList = new LinkedList<>();
        for(int i = 1; i<array.length-1; i++){
            if(array[i]>array[i-1] && array[i+1]<array[i])  peakList.add(i);
        }

        if(peakList.isEmpty())  return 0;
        if(array.length==3) return 3;

        int length = 3;
        while (!peakList.isEmpty()){
            int peak = peakList.removeFirst();
            int left = peak-1;
            int right = peak+1;
            while (left>0 && array[left-1]<array[left]){ // 两个判断条件的先后顺序决定了，成还是不成
                left--;
            }
            while (right<array.length-1 && array[right]>array[right+1]){
                right++;
            }
            int temp = right-left+1;
            if(temp>length) length = temp;
        }

        return length;
    }

    public static void main(String[] args) {

    }
}
