package topic9;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 长度最小的子数组
 * 给定一个含有个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 */
public class Solution {
    public static void main(String[] args) {
        int [] arr={2,3,1,2,4,3};
        final int i = minSubArrayLen(7, arr);
        System.out.println(i);
    }
    //我的解法
//    public int minSubArrayLen(int target, int[] nums) {
//        int head=0;
//        int temp=0;
//        int num=Integer.MAX_VALUE;;
//        while (head<nums.length) {
//            int max=0;
//            for (int i =head; i <nums.length ; i++) {
//                max=max+nums[i];
//                if (max>=target){
//                    temp=i-head+1;
//                    break;
//                }
//            }
//            num=Math.min(num,temp);
//            head++;
//        }
//        return num;

    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int num=Integer.MAX_VALUE;
        int sum=0;
        while (right<nums.length) {
            sum=sum+nums[right];
            while (sum>=target){
                num=Math.min(num,right-left+1);
                sum=sum-nums[left];
                left++;
            }
            right++;

        }
        return num==Integer.MAX_VALUE?0:num;
    }
}
