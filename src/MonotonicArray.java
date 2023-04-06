import java.util.LinkedList;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        if (array == null) return false;

        int N = array.length;
        if (N <= 2) return true;

        boolean result = true;
        LinkedList<Boolean> checker = new LinkedList<>();
        int residual = array[1] - array[0];
        for (int i = 2; i < N; i++) {
            if (residual == 0) {
                residual = array[i] - array[i - 1];
                continue;
            }

            if (residual > 0) {
                result = increasingChecker(array, i, checker);
            } else {
                result = decreasingChecker(array, i, checker);
            }
            if (!checker.isEmpty()) break;
        }

        return result;
    }

    private static boolean increasingChecker(int[] array, int index, LinkedList<Boolean> checker) {
        boolean result = true;
        for (int i = index; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                result = false;
                checker.add(false);
                break;
            }
        }
        return result;
    }

    private static boolean decreasingChecker(int[] array, int index, LinkedList<Boolean> checker) {
        boolean result = true;
        for (int i = index; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result = false;
                checker.add(false);
                break;
            }
        }
        return result;
    }

    public static boolean isMonotonic2(int[] array) {
        if (array == null) return false;
        int N = array.length;
        if (N <= 2) return true;

        int direction = array[1] - array[0];
        for (int i = 2; i < N; i++) {
            if (direction == 0) {
                direction = array[i] - array[i - 1];
                continue;
            }
            if (breaksDirection(direction, array[i - 1], array[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean breaksDirection(int direction, int previous, int current) {
        int difference = current - previous;
        if (direction > 0 ) return difference<0; //direction为+而difference为-  1、2、3、4、-10
        return difference > 0;// direction 为负而difference为正  5、4、3、2、10 break direction
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 0};
        int[] array2 = {1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        System.out.println(isMonotonic2(array2));
    }
}
