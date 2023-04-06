import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] benchmark;

    public ShuffleAnArray(int[] nums) {
        benchmark = nums;
    }

    public int[] reset() {
        return benchmark;
    }

    public int[] shuffle() {
        int n = benchmark.length;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int[] result = new int[n];
        System.arraycopy(benchmark, 0, result, 0, n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIdx = random.nextInt(n);
            int temp = result[i];
            result[i] = result[randomIdx];
            result[randomIdx] = temp;
        }
        return result;
    }

}
