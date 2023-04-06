
import java.util.*;

public class TheSkylineProblemLC {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings){
            height.add(new int[]{b[0],-b[2]});//-高表左边， + 高表右边
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0]; // x轴不等， 按x轴排
            else             return a[1] - b[1]; // x轴等，a[1]<b[1] if a[1]= -10, b[1]-7, 高在前刚好满足题意
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int preHeight = 0;
        //扫带（x，高度)的arraylist, pq 保证hight,
        // 有了高度差后，arraylist nth 的int[] h的h[0] 保证x坐标是skyline首次出现的左x,而不是右x
        for(int[] h : height){
            if(h[1]<0)  pq.add(-h[1]);
            else        pq.remove(h[1]);

            int currentHeight = pq.peek();
            if(preHeight != currentHeight){
                result.add(Arrays.asList(h[0], currentHeight));//出现高度差，就加进result
                preHeight = currentHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{2,9,10},{3,7,15}, {5,12,12}, {15,20,10},{19,24,8}};
        System.out.println(getSkyline(array));
    }
}
