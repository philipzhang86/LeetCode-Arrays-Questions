import java.util.*;


/*
技术能力：就是对遇到的业务问题进行抽象、提炼以及逻辑的构建，通过研发工具以提升解决问题的效能，
减低人工低效的重复工作。
* */
public class ApartmentHunting {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        int[][] minDistanceFromBlocks = new int[reqs.length][];//用了空间换时间的思路，一次吧reqs的各内容都找出来
        for(int i = 0; i<reqs.length; i++){
            minDistanceFromBlocks[i] = getMinDistances(blocks, reqs[i]);
        }
        int[] maxDistanceAtBlocks = getMaxDistanceAtBlocks(minDistanceFromBlocks);
        int index = 0;
        int tempMax = maxDistanceAtBlocks[index];
        for(int i =0; i<maxDistanceAtBlocks.length; i++){
            int current = maxDistanceAtBlocks[i];
            if(current<tempMax){
                tempMax = current;
                index = i;
            }
        }
        return index;
    }

    //快慢针玩到出神入化
    private static int[] getMinDistances(List<Map<String, Boolean>> blocks, String require){
        int[] minDistances = new int[blocks.size()];
        int closesReqIdx = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).get(require))  closesReqIdx = i;
            minDistances[i] = distanceBetween(i,closesReqIdx); // 返回reqe 在对应block是否存在，存在返回 minDistances[i] = 0
        }
        for(int i = blocks.size()-1; i>=0; i--){
            if(blocks.get(i).get(require))  closesReqIdx = i;
            minDistances[i] = Math.min(minDistances[i], distanceBetween(i, closesReqIdx));
            //distanceBetween 快慢针玩到出神入化， require 存在(慢针)closesReIdx = i, i是快针 二者相减就是左到右、右到左的最短距离
            //取左到右、右到左最短距离的min值，就是该block 到require的最短距离
        }
        return minDistances;
    }

    private static int distanceBetween(int a, int b){
        return Math.abs(a-b);
    }

    private static int[] getMaxDistanceAtBlocks(int[][] minDistancesFromBlocks){
        int[] maxDistancesAtBlocks = new int[minDistancesFromBlocks[0].length];
        int col = 0;
        while (col<minDistancesFromBlocks[0].length){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for(int row = 0; row<minDistancesFromBlocks.length; row++){
                maxHeap.add(minDistancesFromBlocks[row][col]);
            }
            maxDistancesAtBlocks[col] = maxHeap.peek();
            col++;
        }
        return maxDistancesAtBlocks;
    }

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("gym",false);map.put("school",true); map.put("store",false);
        blocks.add(map);
        HashMap<String, Boolean> map2 = new HashMap<>();
        map2.put("gym",true);map2.put("school",false); map2.put("store",false);
        blocks.add(map2);
        HashMap<String, Boolean> map3 = new HashMap<>();
        map3.put("gym",true);map3.put("school",true); map3.put("store",false);
        blocks.add(map3);
        System.out.println(Arrays.toString(getMinDistances(blocks, "gym")));
    }
}
