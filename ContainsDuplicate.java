import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,3,4,2,1,6};
        int arr2[] = new int[]{1,2,3,4,6,99};
        int arr3[] = new int[]{1,2,3,4,5,5};
        System.out.println(isDuplicateBrute(arr));
        System.out.println(isDuplicateBrute(arr2));
        System.out.println(isDuplicateBetter(arr));
        System.out.println(isDuplicateBetter(arr2));
        System.out.println(isDuplicateBetter_ii(arr));
        System.out.println(isDuplicateBetter_ii(arr2));
        System.out.println(isDuplicateBetter(arr3));
    }

    public static Boolean isDuplicateBrute(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }
    public static Boolean isDuplicateBetter(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i+1<arr.length && arr[i] == arr[i+1]) return true;
        }
        return false;
    }
    public static Boolean isDuplicateBetter_ii(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        if(set.size() != arr.length) return true;
        return false;
    }
}
