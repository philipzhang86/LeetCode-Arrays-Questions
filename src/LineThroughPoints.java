import java.util.Arrays;
import java.util.HashMap;

public class LineThroughPoints {
    // the same line means both points has same slope
    // All the points are unique. 你的判定会更复杂
    public static int lineThroughPoints(int[][] points) {
        int result = 1;
        HashMap<Double, Integer> hashMap = new HashMap<>();
        for(int i =0; i<points.length; i++){
            hashMap.clear();
            for(int j = 0 ; j<points.length; j++){//∵只是找最长的边，双循环之下j=i+1可以省去重复的点
                if(isSamePoint(points[i],points[j])) continue;
                double slope = getSlope(points[i], points[j]);
                hashMap.computeIfAbsent(slope,k-> 1);
                hashMap.put(slope,hashMap.get(slope)+1);
                result = Math.max(hashMap.get(slope), result);
            }
        }

        return result;
    }

    private static double getSlope(int[] a, int[] b){
        double x1 = a[0];
        double y1 = a[1];
        double x2 = b[0];
        double y2 = b[1];

        if(x1 == x2)  return Double.MAX_VALUE;
        else if(y1 == y2) return 0;
        return (y2-y1)/(x2-x1);
    }

    private static boolean isSamePoint(int[] a, int [] b){
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        int[][] array = {{1,1},{2,2},{3,3},{0,4},{-2,6},{4,0},{2,1}};
        System.out.println(lineThroughPoints(array));
    }
}
