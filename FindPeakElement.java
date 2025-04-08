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
    public static void main(String[] args) {
        int[] testArray = {1, 3, 20, 4, 1, 0, 5, 3, 6};
        ArrayList<Integer> peaks = findPeakBrute(testArray);
        System.out.println("Peaks found: " + Arrays.toString(peaks.toArray()));
    }
}
