import java.util.Arrays;

public class Non_Constructible_Change {

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int minimumChange = 0;
        for(int coin : coins){
            if(coin > minimumChange+1){
                return minimumChange+1;
            }
            minimumChange +=coin;
        }
        return minimumChange;
    }


    public static void main(String[] args) {
        int[] coins = {1,2,4,7,9};
        System.out.println(nonConstructibleChange(coins));
    }
}
