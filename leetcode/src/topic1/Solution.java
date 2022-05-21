package topic1;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 算法题
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static boolean containsDuplicate(int[] nums) {//空间复杂度过高，时间复杂度过高
       long count = Arrays.stream(nums).distinct().count();
       return nums.length!=count;
    }
    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
