import java.util.ArrayList;

public class Validate_Subsequence {
    public static boolean isValidSubsequence(int[] array, int[] sequence) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int num : array){
            list1.add(num);
        }
        for(int num : sequence){
            list2.add(num);
        }
        int arrayIndex = 0;
        int sequenceIndex = 0;
        while (arrayIndex<list1.size() && sequenceIndex<list2.size()){
            if(list1.get(arrayIndex).equals(list2.get(sequenceIndex))){
                sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == list2.size();
    }

    public static boolean isValidSubsequence2(int[] array, int[] sequence){
        int i =0;
        int j = 0;
        while (i<array.length && j < sequence.length){
            if(array[i] == sequence[j]) j++;
            i++;
        }
        return j== sequence.length;
    }




    public static void main(String[] args) {
        int[] array =    {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = {5, 1, 22, 22, 6, -1, 8, 10};
        System.out.println(isValidSubsequence2(array, sequence));
    }
}
