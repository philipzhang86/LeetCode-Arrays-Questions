import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverLappingIntervals {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        //Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for(int[] next : intervals){
            int currentEnd = currentInterval[1];
            int intervalStart = next[0];
            int intervalEnd = next[1];

            if(currentEnd >= intervalStart){
                int newEnd = Math.max(currentEnd,intervalEnd);
                currentInterval[1] = newEnd;
            }else {
                currentInterval = next;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{89, 90},{-10,20},{-50, 0},{70, 90},
                {90, 91},{90, 95}};
        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(intervals)));
    }
}
