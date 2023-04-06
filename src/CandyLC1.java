import java.util.Arrays;
import java.util.stream.IntStream;

public class CandyLC1 {
    /*无论是[2,1.....1,3]、[1,2.....2,1]，只要左右两边各扫一次，都是可以处理这两种情况
    因为已经从左到右扫了一次，reward的元素不只是纯粹的1，所以在往回扫时要注意最大值的选取。
    右往左回扫时要注意更大值的选取
    * */

    public static int candy(int[] ratings){
        int N = ratings.length;
        int[] rewards = new int[N];
        Arrays.fill(rewards,1);
        for(int i = 0; i<N-1; i++){
            if(ratings[i+1] > ratings[i])   rewards[i+1] = rewards[i]+1;
        }
        for (int i = N-1; i>0; i--){
            if(ratings[i-1] > ratings[i]) {
                //因为是最低限度的填充，∴哪个大就选哪个
                rewards[i - 1] = Math.max(rewards[i] + 1,rewards[i-1]);
            }
        }
        return IntStream.of(rewards).sum();
    }

    public static void main(String[] args) {
        int[] rating = {1,2,3,5,4,3,2,1,4,3,2,1,3,2,1,1,2,3,4};
        int[] rating2 = {1,3,4,5,2};
        int[] array = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        System.out.println(candy(rating));
    }
}
