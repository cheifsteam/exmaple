package topic11;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 股票买卖的最佳时机
 */
public class Solution {
//    public int maxProfit(int[] prices) {
//        int minprice = Integer.MAX_VALUE;
//        int maxprofit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minprice) {
//                minprice = prices[i];
//            } else if (prices[i] - minprice > maxprofit) {
//                maxprofit = prices[i] - minprice;
//            }
//        }
//        return maxprofit;
//    }

public static void main(String[] args) {
    int [] arr={2,1,2,1,0,1,2};
    final int i = maxProfit(arr);
    System.out.println(i);
}
    public static int maxProfit(int[] prices) {
        int fast=0;
        int last=0;
        int maxprofit=0;
        while (fast<prices.length){
            if (prices[last]>prices[fast]){
                last=fast;
            }
            else {

                maxprofit=Math.max(prices[fast]-prices[last],maxprofit);
            }
            fast++;

        }
        return maxprofit;
    }
}
