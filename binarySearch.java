import java.util.HashMap;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;
        
        System.out.println(binarySearch(nums, target)); // Output: 4
    }
}