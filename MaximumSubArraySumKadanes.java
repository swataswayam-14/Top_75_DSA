import java.util.ArrayList;

public class MaximumSubArraySumKadanes {
    public static void main(String[] args) {
        int arr_1[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int arr_2[] = new int[]{1};
        System.out.println(maximumSubArrayBrute(arr_1));
        System.out.println(maximumSubArrayBrute(arr_2));
        System.out.println(maxSubArraySumBetter(arr_1));
        System.out.println(maxSubArraySumBetter(arr_2));
        System.out.println(maximumSubArrayOptimal_Kadans(arr_1));
        System.out.println(maximumSubArrayOptimal_Kadans(arr_2));
    }
    public static int maximumSubArrayBrute(int arr[]) {
        ArrayList<Integer> maxSubArray = new ArrayList<>();
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                ArrayList<Integer> tempSubArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    tempSubArray.add(arr[k]);
                }
                if (sum > maximum) {
                    maximum = sum;
                    maxSubArray = new ArrayList<>(tempSubArray);
                }
            }
        }
        System.out.println("The maximum subarray is "+maxSubArray);
        return maximum;
    }
    public static int maxSubArraySumBetter(int arr[]) {
        int maximum = Integer.MIN_VALUE; 
        ArrayList<Integer>maxSubArray = new ArrayList<>();   
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            ArrayList<Integer>tempSubArray = new ArrayList<>();  
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                tempSubArray.add(arr[j]);
                if (sum > maximum) {
                    maximum = sum;
                    maxSubArray = new ArrayList<>(tempSubArray);
                }
            }
        }
        System.out.println("Sub Array having the maximum sum " + maxSubArray);
        return maximum;
    }
    public static int maximumSubArrayOptimal_Kadans(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
    
        int maximum = Integer.MIN_VALUE;
        int current_sum = 0;
    
        ArrayList<Integer> maxSubArray = new ArrayList<>();
        ArrayList<Integer> tempSubArray = new ArrayList<>();
    
        for (int num : arr) {
            if (current_sum < 0) {
                current_sum = num;
                tempSubArray.clear();
                tempSubArray.add(num);
            } else {
                current_sum += num;
                tempSubArray.add(num);
            }
            if (current_sum > maximum) {
                maximum = current_sum;
                maxSubArray = new ArrayList<>(tempSubArray);
            }
        }
        System.out.println("The subarray with the maximum sum: " + maxSubArray);
        return maximum;
    }
}
