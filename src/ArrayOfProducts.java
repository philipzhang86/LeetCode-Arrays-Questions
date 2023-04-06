import java.util.Arrays;

public class ArrayOfProducts {
    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int N = array.length;
        int[] result = new int[N];
        int index = 0;
        while (index< N){
            int answer = 1 ;
            for(int num : array){
                if(num==array[index]) continue;
                answer *=num;
            }
            result[index]=answer;
            index++;
        }

        return result;
    }

    public static int[] arrayOfProducts2(int[] array){
        int N = array.length;
        int[] result = new int[N];
        int[] leftProducts = new int[N];
        int[] rightProducts = new int[N];
/*      left product & right product 是一格一格地错开了，而这种错开一合起来，就是最终我们想要的答案
        输入         [5, 1, 4, 2]
        错开的左边    [1, 5, 5, 20]   leftAnswer,rightAnswer 最终都会是40，∵全部都乘了一遍，但我们不要这个答案，只要之前的product
        错开的右边    [8, 8, 2, 1]
        两边一合起来  [8, 40, 10, 20]
* */
        int leftAnswer = 1;
        for(int i = 0; i<N; i++){
            leftProducts[i] = leftAnswer;
            leftAnswer *=array[i];
        }

        int rightAnswer = 1;
        for(int i = N-1; i>=0; i--){
            rightProducts[i] = rightAnswer;
            rightAnswer *=array[i];
        }
        System.out.println(Arrays.toString(leftProducts));
        System.out.println(Arrays.toString(rightProducts));

        for(int i = 0; i<N; i++){
            result[i] = leftProducts[i] * rightProducts[i];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        //System.out.println(Arrays.toString(arrayOfProducts(array)));
        System.out.println(Arrays.toString(array));
        arrayOfProducts2(array);
    }
}
