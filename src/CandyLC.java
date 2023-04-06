import java.util.Arrays;
import java.util.stream.IntStream;

public class CandyLC {
    public static int candy(int[] ratings) {
        int N = ratings.length;
        int[] rewards = new int[N];
        Arrays.fill(rewards,1);
        for(int i = 0; i <N-1; i++){
            if(ratings[i]<ratings[i+1]){
                rewards[i+1] = rewards[i] + 1;
            }
        }

        for (int i = N-1; i>0; i--){
            if(ratings[i-1] > ratings[i]){
                rewards[i-1] = Math.max(rewards[i-1], rewards[i]+1);
            }
        }
        return IntStream.of(rewards).sum();
    }


    public static void main(String[] args) {
        int[] rating = {1,2,3,5,4,3,2,1,4,3,2,1,3,2,1,1,2,3,4};
        System.out.println(candy(rating));
    }
}
