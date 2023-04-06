import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        // Write your code here.
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int N = array.length;
        int[] marker = new int[N];

        int count = 0;
        for (int i = 1; i < N; i++) {
            int num = array[i];
            if (counterTrigger(i, count, num, array)) {
                count++;
                marker[i] = count;
            } else count = 0;
        }

        return result(marker, array);
    }

    private static boolean counterTrigger(int i, int count, int num, int[] array) {
        if (count == 0 && num == array[i - 1]) return false;
        return num - 1 == array[i - 1] || num == array[i - 1];
    }

    private static int[] result(int[] marker, int[] array) {
        int largest = 0;
        int index = 0;
        for (int i = 0; i < marker.length; i++) {
            if (marker[i] > largest) {
                largest = marker[i];
                index = i;
            }
        }
        return new int[]{array[index - largest], array[index]};
    }
    
    public static int[] largestRange2(int[] array){
        int[] result = new int[2];
        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : array){
            map.put(num, true);
        }
        
        for(int num : array){
            if(!map.get(num))   continue;
            map.put(num, false);
            int currentLength = 1;
            int left = num-1;
            int right = num +1;
            while (map.containsKey(left)){
                map.put(left, false);
                currentLength++;
                left--;
            }
            while (map.containsKey(right)){
                map.put(right, false);
                currentLength++;
                right++;
            }
            if(currentLength > longestLength){
                longestLength = currentLength;
                result[0] = left + 1;
                result[1] = right -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] array2 = {1, 2};
        System.out.println(Arrays.toString(largestRange2(array)));
    }
}
