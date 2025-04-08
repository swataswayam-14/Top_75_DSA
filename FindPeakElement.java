import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElement {
    public static ArrayList<Integer> findPeakBrute(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr.length == 0) return ans; // handle empty array

        if (arr.length == 1||arr[0] > arr[1]) {
            ans.add(arr[0]);
        }
        if (arr[arr.length-1] > arr[arr.length-2]){
            ans.add(arr[arr.length-1]);
        }
    
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i-1] && arr[i]> arr[i+1]) { // checking if the element is greater than its neighbor
                ans.add(arr[i]);
            }
        }
        return ans;
    }
    public static int findPeakOptimal(ArrayList<Integer>arr) {
        int n = arr.size();
        if (n==0) return 0;
        if (arr.get(0) > arr.get(1)) return 0;
        if (arr.get(n-1) > arr.get(n-2)) return n-1;

        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = (low+high) / 2;
            if(arr.get(mid) > arr.get(mid+1) && arr.get(mid) > arr.get(mid-1)) return mid;
            if (arr.get(mid) > arr.get(mid-1)) {
                low = mid+1; //eliminate left part of the array
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] testArray = {1, 3, 20, 4, 1, 0, 5, 3, 6};
        ArrayList<Integer> peaks = findPeakBrute(testArray);
        System.out.println("Peaks found: " + Arrays.toString(peaks.toArray()));
        ArrayList<Integer> arr =
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 5, 1));
        int ans = findPeakOptimal(arr);
        System.out.println("The peak is at index: " + ans);
    }
}
