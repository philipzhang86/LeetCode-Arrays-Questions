import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int N = arrayOne.length;
        int M = arrayTwo.length;
        int result = Math.abs(arrayOne[0] - arrayTwo[M - 1]);
        int oneIndex = 0;
        int twoIndex = M - 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Math.abs(arrayOne[i] - arrayTwo[j]) < result) {
                    result = Math.abs(arrayOne[i] - arrayTwo[j]);
                    oneIndex = i;
                    twoIndex = j;
                }
            }
        }
        return new int[]{arrayOne[oneIndex], arrayTwo[twoIndex]};
    }

    public static int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int N = arrayOne.length;
        int M = arrayTwo.length;
        int result, smallest = Math.abs(arrayOne[0] - arrayTwo[M - 1]);
        int oneIndex = 0;
        int twoIndex = 0;
        int[] answer = new int[2];

        while (oneIndex < N && twoIndex < M) {
            int num1 = arrayOne[oneIndex];
            int num2 = arrayTwo[twoIndex];

            if (num1 < num2) {
                result = Math.abs(num1 - num2);
                oneIndex++;
            } else if (num1 > num2) {
                result = Math.abs(num1 - num2);
                twoIndex++;
            } else return new int[]{num1, num2};

            //每一轮都有一个最小值
            if (smallest > result) {
                smallest = result;
                answer[0] = num1;
                answer[1] = num2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        System.out.println(Arrays.toString(smallestDifference2(arrayOne, arrayTwo)));
    }
}
