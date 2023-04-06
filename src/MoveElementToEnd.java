import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int N = array.size();
        int hi = N - 1;

        for (int i = 0; i < N && hi > i; i++) {
            if (array.get(i) == toMove) {
                while (array.get(hi) == toMove && hi != 0) hi--;
                if (hi <= i) break;
                exchange(array, i, hi);
                hi--;
            }
        }
        return array;
    }

    private static void exchange(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static int[] moveElementToEnd(int[] array, int toMove) {
        int N = array.length;

        int hi = N - 1;
        for (int i = 0; i < N && hi > i; i++) {
            if (array[i] == toMove) {
                while (array[hi] == toMove && hi != 0) hi--;
                if (hi <= i) break;
                exchange(array, i, hi);
                hi--;
            }
        }
        return array;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 3, 3, 3, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println(moveElementToEnd(list, 3));
        System.out.println(Arrays.toString(moveElementToEnd(array, 3)));
    }
}
