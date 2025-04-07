public class SearchElementInRotatedArray {
    boolean searchBrute(int arr[], int n , int k) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) return true;
        }
        return false;
    }
    boolean searchInRotatedSortedArray(int arr[], int k) {
        int n = arr.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[mid] == k) return true;
            if (arr[mid] == arr[mid] && arr[mid] == arr[high]) {
                low = low+1;
                high = high-1;
                continue;
            }
            //checking if the left part is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]){ // element exists in this part
                    high = mid-1;
                } else { //element does not exist
                    low = mid+1;
                }
            } else { //the right part is sorted
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else { //element does not exist
                    high = mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        SearchElementInRotatedArray ob = new SearchElementInRotatedArray();
        boolean ans1 = ob.searchInRotatedSortedArray(arr, k);
        boolean ans2 = ob.searchBrute(arr, arr.length, k);
        if (ans1 == false && ans2 == false)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}
//Time Complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array.
// Reason: In the best and average scenarios, the binary search algorithm is primarily utilized and hence the time complexity is O(logN). However, in the worst-case scenario, where all array elements are the same but not the target (e.g., given array = {3, 3, 3, 3, 3, 3, 3}), we continue to reduce the search space by adjusting the low and high pointers until they intersect. This worst-case situation incurs a time complexity of O(N/2).

// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).