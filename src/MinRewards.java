import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MinRewards {
    public static int minRewards1(int[] scores) {
        // Write your code here.
        int N = scores.length;
        int[] rewards = new int[N];
        Arrays.fill(rewards,1);
        for(int i = 1; i<N; i++){
            int j = i - 1;
            if(scores[i] > scores[j]){
                rewards[i] = rewards[j]+1;
            }else {
                while (j >= 0 && scores[j] > scores[j+1]){
                    rewards[j] = Math.max(rewards[j], rewards[j+1]+1);
                    j--;
                }
            }
        }

        return IntStream.of(rewards).sum();//求数组所有元素sum的新方法
    }

    public static int minRewards(int[] scores){
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards,1);
        List<Integer> localMinList = getLocalMinList(scores);
        for(Integer localMinIndex : localMinList){
            expandFromLocalMin(localMinIndex, scores, rewards);
        }
        return IntStream.of(rewards).sum();
    }

    private static List<Integer> getLocalMinList(int[] array){
        List<Integer> localMinList = new ArrayList<>();
        int N = array.length;
        if(N == 1){
            localMinList.add(0);
            return localMinList;
        }
        for(int i = 0; i<N; i++){
            if(i == 0 && array[i]<array[i+1])   localMinList.add(i);//头
            if(i == N-1 && array[i]<array[i-1]) localMinList.add(i);//尾 满足条件都入localMin
            if(i == 0 || i == N-1) continue;
            if(array[i] < array[i+1] && array[i] < array[i -1]) localMinList.add(i);
        }
        return localMinList;
    }

    //take a look how to expand?
    private static void expandFromLocalMin(int localMin, int[] scores, int[] rewards){
        int left = localMin -1;
        while (left>=0 && scores[left] > scores[left+1]){
            rewards[left] = Math.max(rewards[left], rewards[left+1] + 1);
            left--;
        }
        int right = localMin + 1;
        while (right < scores.length && scores[right] > scores[right -1]){
            rewards[right] = rewards[right-1] +1;
            right++;
        }
    }

    public static int minRewards3(int[] scores){
        int N = scores.length;
        int[] rewards = new int[N];
        Arrays.fill(rewards,1);
        for(int i = 1; i<N; i++){
            if(scores[i]>scores[i-1])   rewards[i] = rewards[i-1]+1;
        }

        for(int i = N-2; i>=0; i--){
            if(scores[i] > scores[i+1]) {
                rewards[i] = Math.max(rewards[i], rewards[i+1] +1);
            }
        }
        return IntStream.of(rewards).sum();
    }

    public static void main(String[] args) {
        int[] array = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        System.out.println(minRewards3(array));
    }
}
