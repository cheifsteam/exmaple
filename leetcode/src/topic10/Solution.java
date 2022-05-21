package topic10;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 * 最大连续1的个数
 * 给定一个二进制数组 nums  ，如果可以翻转最多1 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int right=0;
        int result=0;
        int zeroCount=0;
        while(right<nums.length) {
            if (nums[right]==0){
                zeroCount++;
            }
            while (zeroCount > 1){
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
              }
            // 更新结果
            result =  Math.max(result, right-left+1);
            //右指针移动
            right++;

        }
        return result;

    }
    /**
     *最大连续1的个数 III
     *给定一个二进制数组 nums 和一个整数 k ，如果可以翻转最多k 个 0 ，则返回 数组中连续 1 的最大个数 。
     **/
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int result=0;
        int zeroCount=0;
        while(right<nums.length) {
            if (nums[right]==0){
                zeroCount++;
            }
            while (zeroCount > k){
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            // 更新结果
            result =  Math.max(result, right-left+1);
            //右指针移动
            right++;

        }
        return result;

    }
}
