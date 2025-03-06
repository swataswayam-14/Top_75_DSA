import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productOfArrayExceptSelf(arr)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf_Optimal(arr)));
    }
    public static int[] productOfArrayExceptSelf(int arr[]) {
        int productArray[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int currIdx = i;
            int product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j != currIdx) {
                    product = arr[j] * product;
                }
            }
            productArray[i] = product;
        }
        return productArray;
    }
    public static int[] productOfArrayExceptSelf_Optimal(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
}
