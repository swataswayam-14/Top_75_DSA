import java.util.Arrays;

public class AggressiveCows {
    public static boolean canWePlace(int[] stalls, int dist, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int last = stalls[0];
        int cntCows = 1;
        for (int i = 1; i < n; i++) {
            if(stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= k) {
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int stalls[], int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int limit = stalls[n-1] - stalls[0];

        for (int i = 1; i <= limit; i++) {
            if(canWePlace(stalls, i, k) == false) return i-1;
        }
        return limit;
    }
    public static int aggressiveCowsOptimal(int stalls[], int k) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 1, high = stalls[n-1] - stalls[0];

        while (low<=high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans1 = aggressiveCows(stalls, k);
        int ans2 = aggressiveCowsOptimal(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans1);
        System.out.println("The maximum possible minimum distance is: " + ans2);
    }
}
