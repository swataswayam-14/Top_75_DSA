import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = new int[]{3,8,9,1};
        int target1 = 4;
        int target2 = 11;
        int target3 = 14;
        int n = arr.length;
        System.out.println(twoSumBrute_i(n, arr, target1));
        System.out.println(twoSumBrute_i(n, arr, target2));
        System.out.println(twoSumBrute_i(n, arr, target3));
        System.out.println(Arrays.toString(twoSumBrute_ii(n, arr, target1)));
        System.out.println(Arrays.toString(twoSumBrute_ii(n, arr, target2)));
        System.out.println(Arrays.toString(twoSumBrute_ii(n, arr, target3)));
        System.out.println(twoSumBetter_i(n, arr, target1));
        System.out.println(twoSumBetter_i(n, arr, target2));
        System.out.println(twoSumBetter_i(n, arr, target3));
        System.out.println(Arrays.toString(twoSumBetter_ii(n, arr, target1)));
        System.out.println(Arrays.toString(twoSumBetter_ii(n, arr, target2)));
        System.out.println(Arrays.toString(twoSumBetter_ii(n, arr, target3)));
        System.out.println(twoSumOptimal_i(n, arr, target1));
        System.out.println(twoSumOptimal_i(n, arr, target2));
        System.out.println(twoSumOptimal_i(n, arr, target3));
        System.out.println(Arrays.toString(twoSumOptimal_ii(n, arr, target1)));
        System.out.println(Arrays.toString(twoSumOptimal_ii(n, arr, target2)));
        System.out.println(Arrays.toString(twoSumOptimal_ii(n, arr, target3)));
    }
    static String twoSumBrute_i(int n, int arr[], int target) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
    static int[] twoSumBrute_ii(int n, int arr[], int target) {

        int ans[] = new int[2];
        ans[0] = ans[1] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    static String twoSumBetter_i(int n, int arr[], int target) {

        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            int moreNeeded = target - curr;
            if (mpp.containsKey(moreNeeded)) {
                return "YES";
            } else {
                mpp.put(arr[i], i);
            }
        }
        return "NO";
    }
    static int[] twoSumBetter_ii(int n, int arr[], int target) {
        int ans[] = new int[2];
        ans[0] = ans[1] = -1;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            int moreNeeded = target - curr;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            } else {
                mpp.put(arr[i], i);
            }
        }
        return ans;
    }
    static String twoSumOptimal_i(int n, int arr[], int target) {
        int left = 0;
        int right = n - 1;

        Arrays.sort(arr);

        while (left < right) {
            if (arr[left] + arr[right] == target) {
                return "YES";
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right --;
            }
        }
        return "NO";
    }
    static int[] twoSumOptimal_ii(int n, int arr[], int target) {// here we are modifying the array , hence we may not get the correct indices for the elements.
        //hence the best method for solving this problem is using HashMap
        int left = 0;
        int right = n - 1;

        Arrays.sort(arr);

        int ans[] = new int[2];
        ans[0] = ans[1] = -1;

        while (left < right) {
            if (arr[left] + arr[right] == target) {
                ans[0] = left;
                ans[1] = right;
                return ans;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right --;
            }
        }
        return ans;
    }
}