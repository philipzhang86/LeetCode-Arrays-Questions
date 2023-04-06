import java.util.Arrays;

public class ConcatenationOfArrayLC {
    public static int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length*2];
        System.arraycopy(nums,0,result,0,nums.length);
        System.arraycopy(nums,0,result,nums.length,nums.length);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,1};
        System.out.println(Arrays.toString(getConcatenation(array)));
    }
}
