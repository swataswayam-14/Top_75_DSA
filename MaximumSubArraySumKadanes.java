import java.util.ArrayList;

public class MaximumSubArraySumKadanes {
    public static void main(String[] args) {
        int arr_1[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int arr_2[] = new int[]{1};
        System.out.println(maximumSubArray(arr_1));
        System.out.println(maximumSubArray(arr_2));
    }
    public static int maximumSubArray(int arr[]) {
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
}
