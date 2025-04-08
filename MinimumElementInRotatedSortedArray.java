public class MinimumElementInRotatedSortedArray {
    public static int findMinBrute(int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
    public static int findMinOptimal_Method_i(int arr[]) { //12345 : 45123 , 23451
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[low] <= arr[mid]){ //it means the left half is sorted
                min = Math.min(arr[low], min); //storing the minimum value in min
                low = mid + 1; //eliminating the left part
            } else { //the right half is sorted here arr[low] >= arr[mid]
                min = Math.min(arr[mid], min);
                high = mid - 1;
            }
        }
        return min;
    }
    public static int findMinOptimal_Method_ii(int arr[]) { //if both the right half and left half are sorted then there is no need to perform binary search , the minimum element is present in the extreme left
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            if(arr[low] <= arr[high]) { // it means that the entire (left and right) array is sorted
                min = Math.min(arr[low], min);
                break; // no need to perform BS
            }
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) { // the left part is sorted
                min = Math.min(arr[low], min);
                low = mid+1;
            } else {
                min = Math.min(arr[mid], min);
                high = mid-1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans1 = findMinBrute(arr);
        int ans2 = findMinOptimal_Method_i(arr);
        int ans3 = findMinOptimal_Method_ii(arr);

        System.out.println("The minimum element is: " + ans1 +" " + ans2 +" "+ans3 );
    }
}
