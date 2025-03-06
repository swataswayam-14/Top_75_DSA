public class BestTimeToBuyAndSell{
    public static void main(String[] args) {
        int arr[] = new int[]{7,1,4,9,8};
        System.out.println("Maximum profit: "+maxProfit(arr));
    }

    public static int maxProfit(int arr[]) {
        int maxProfit = 0;
        int mini = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currProfit = arr[i] - mini;
            maxProfit = Math.max(maxProfit, currProfit);
            mini = Math.min(mini, arr[i]);
        }

        return maxProfit;
    }
}