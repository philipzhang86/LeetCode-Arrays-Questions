import java.util.*;

public class ApartmentHuntingEX {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] minDistanceFromBlocks = new int[reqs.length][];
        for(int i = 0; i<reqs.length; i++){
            minDistanceFromBlocks[i] = getMinDistanceForReqs(blocks, reqs[i]);
        }
        TreeMap<Integer, Integer> result = getMaxDistanceForEveryBlock(minDistanceFromBlocks);
        return result.get(result.firstKey());
    }

    private static int[] getMinDistanceForReqs(List<Map<String, Boolean>> blocks, String reqs){
       int[] minDistance = new int[blocks.size()];
       int closeReqIdx = Integer.MAX_VALUE;
       for(int i = 0; i<blocks.size(); i++){
           if(blocks.get(i).get(reqs))  closeReqIdx = i;
           minDistance[i] = distanceBetween(i,closeReqIdx);
       }
       for(int i = blocks.size()-1; i>=0; i--){
           if(blocks.get(i).get(reqs)) closeReqIdx = i;
           minDistance[i] = Math.min(minDistance[i], distanceBetween(i,closeReqIdx));
       }
       return  minDistance;
    }

    private static int distanceBetween(int a, int b){
        return Math.abs(a-b);
    }

    private static TreeMap<Integer, Integer> getMaxDistanceForEveryBlock(int[][] minDistanceFromBlocks){
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int block = 0;
        while (block < minDistanceFromBlocks[0].length){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for(int row = 0; row<minDistanceFromBlocks.length; row++){
                maxHeap.add(minDistanceFromBlocks[row][block] );
            }
            treeMap.put(maxHeap.peek(),block);
            block++;
        }
        return treeMap;
    }
}
