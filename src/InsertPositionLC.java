public class InsertPositionLC {

    public static int searchInsert(int[] nums, int target){
        int lo = 0;
        int hi = nums.length-1;
        while (lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target )return mid;
            else if(nums[mid] < target) lo = mid+1;
            else                        hi = mid-1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        System.out.println(searchInsert(array,2));
    }
}
