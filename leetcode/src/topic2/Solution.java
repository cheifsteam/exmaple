package topic2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private static int pre;
    public static void main(String[] args) {
        int[] arr = {1,2,-7,4,-1,5};
        int max = maxSubArray(arr); // 根据 Collections 查找最大值
        int maxArr=arr[0];
        int calculate;
        pre=arr[0];
        for (int i = 1; i <arr.length ; i++) {

             pre= calculate(arr, i , i);
            maxArr=Math.max(pre, maxArr);
        }
        System.out.println(pre);
        System.out.println("最大值是：" + max);
    }

    public static int maxSubArray(int [] arr) {
        int max=0;
        int maxArr=0;
        int pre=0;
        max=arr[0];
        int endingPoint=0;
        for (int num:arr) {

            endingPoint=Math.max(endingPoint+num,num);
            max=Math.max(max,endingPoint);
        }


        return max;
    }

    public static int calculate (int [] arr) {
        int num=0;
        for (int i = 0; i <arr.length ; i++) {
                num+=arr[i];
        }
        return num;
    }
    public static int calculate(int [] arr,int last,int i){
      return Math.max(pre+arr[i],arr[i]);
    }

    private static int findMaxByRecursive(int[] arr) {
        int max=arr[0];
        for (int i = 0; i <arr.length ; i++) {
           max=Math.max(max, arr[i]);
        }
        return max;
    }
    private static int findMinByRecursive(int[] arr, int head, int last) {
        int min=arr[head];
        for (int i = head; i <last ; i++) {
            min=Math.min(min, arr[i]);
        }
        return min;
    }
}
