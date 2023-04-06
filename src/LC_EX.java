import java.util.Arrays;
import java.util.stream.IntStream;

public class LC_EX {
    public static int minRewards(int[] scores) {
        int N = scores.length;
        int[] rewards = new int[N];
        Arrays.fill(rewards,1);
        for(int i = 0;i < N-1; i++){
            if(scores[i+1]>scores[i]) rewards[i+1]=rewards[i]+1;
        }

        for(int i =N-1; i>0; i--){
            if(scores[i-1]>scores[i]){
                rewards[i-1] = Math.max(rewards[i-1], rewards[i]+1);
            }
        }
        return IntStream.of(rewards).sum();
    }
    public static void main(String[] args) {
        int[] array = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        System.out.println(minRewards(array));
    }
}
