import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllocateMinNumOfPages {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m>n) {
            return -1;
        }
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for (int pages = low; pages <= high; pages ++) {
            if(countStudents(arr, pages) == m) return pages;
        }
        return low;
    }
    public static int findPagesOptimal(ArrayList<Integer> arr, int n, int m) {
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low +high) /2;
            if (countStudents(arr, mid) > m){ // the value needs to be increased (right half)
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return low;
    }
    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        int pagesAllocatedToStudent = 0;
        for (int i=0;i<n;i++) {
            if(pagesAllocatedToStudent + arr.get(i) <= pages) {
                pagesAllocatedToStudent += arr.get(i);
            } else {
                students++;
                pagesAllocatedToStudent = arr.get(i);
            }
        }
        return students;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans1 = findPages(arr, n, m);
        System.out.println("The answer is: " + ans1);
        int ans2 = findPagesOptimal(arr, n, m);
        System.out.println("The answer is: " + ans2);
    }
}
