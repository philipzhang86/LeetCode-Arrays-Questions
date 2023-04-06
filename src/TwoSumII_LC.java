public class TwoSumII_LC {
    public static int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int current = numbers[lo] + numbers[hi];
            if (current == target) {
                return new int[]{lo + 1, hi + 1};
            }
            else if (current < target) lo++;
            else hi--;
        }
        return new int[]{};
    }
}
