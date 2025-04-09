public class MedianOf2SortedArray {
    public static int findMedianBrute(int arr1[], int arr2[]) { //merge code of the merge sort algorithm
        //median is just the middle element 
        int n = arr1.length;
        int m = arr2.length;
        int [] ans = new int[n+m];
        int i=0, j=0;
        int k = 0;
        while (i<n && j < m) {
            if(arr1[i] <= arr2[j]) {
                ans[k] = arr1[i];
                i++;
            } else {
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i<n) {
            ans[k] = arr1[i];
            i++;
            k++;
        }
        while (j<m) {
            ans[k] = arr2[j];
            j++;
            k++;
        }
        if((n+m) % 2 == 0) {
            int index = (n+m) / 2;
            int median = (ans[index] + ans[index-1]) / 2;
            return median;
        }
        return ans[(n+m)/2];
    }
    public static int findMedianBetter(int arr1[], int arr2[]) { // we realise for the median (just a single element) we donot need an entire merge array
        int n1 = arr1.length;
        int n2 = arr2.length;

        int n = n1+n2;

        int ind2 = n/2;
        int ind1 = ind2 - 1;

        int cnt = 0;
        int ind1el = -1, ind2el = -1; //stores the element present in that index

        int i=0, j=0;
        while(i<n1 && j<n2) {
            if(arr1[i] <= arr2[j]) {
                if(cnt == ind1) ind1el = arr1[i];
                if(cnt == ind2) ind2el = arr1[i];
                cnt++;
                i++;
            } else {
                if(cnt == ind1) ind1el = arr2[j];
                if(cnt==ind2) ind2el = arr2[j];
                cnt++;
                j++;
            }
        }
        while (i<n1) {
            if(cnt == ind1) ind1el = arr1[i];
            if(cnt == ind2) ind2el = arr1[i];
            cnt++;
            i++;
        }
        while(j<n2) {
            if(cnt == ind1) ind1el = arr2[j];
            if(cnt == ind2) ind2el = arr2[j];
            cnt++;
            j++;
        }
        if(n%2 == 1) return ind2el;
        return (ind1el+ind2el)/2;

    }
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println("Median: " + MedianOf2SortedArray.findMedianBrute(arr1, arr2)); // Output: 3
        System.out.println(MedianOf2SortedArray.findMedianBetter(arr1, arr2)); // Output: 3

        // Test case 2
        int[] arr3 = {1, 2};
        int[] arr4 = {3, 4};
        System.out.println("Median: " + MedianOf2SortedArray.findMedianBrute(arr3, arr4)); // Output: 2
        System.out.println(MedianOf2SortedArray.findMedianBetter(arr3, arr4)); // Output: 2

        // Test case 3
        int[] arr5 = {1, 3};
        int[] arr6 = {2};
        System.out.println("Median: " + MedianOf2SortedArray.findMedianBrute(arr5, arr6)); // Output: 2
        System.out.println(MedianOf2SortedArray.findMedianBetter(arr5, arr6)); // Output: 2

        // Test case 4
        int[] arr7 = {0, 0};
        int[] arr8 = {0, 0};
        System.out.println("Median: " + MedianOf2SortedArray.findMedianBrute(arr7, arr8)); // Output: 0
        System.out.println(MedianOf2SortedArray.findMedianBetter(arr7, arr8)); // Output: 0

        // Test case 5 (unequal lengths)
        int[] arr9 = {1, 2, 3, 4};
        int[] arr10 = {5, 6};
        System.out.println("Median: " + MedianOf2SortedArray.findMedianBrute(arr9, arr10)); // Output: 3
        System.out.println(MedianOf2SortedArray.findMedianBetter(arr9, arr10)); // Output: 3
    }
}
