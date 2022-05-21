package topic4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 */
public class Solution {
    public static void main(String[] args) {
        int [] ints={1,2,3,0,0,0};
        int [] ints1={2,5,6};
        merge(ints,3,ints1,3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=m-1;
        int q=n-1;
        int tail=m+n-1;
        int cur;
       while (p>=0||q>=0){
           if (p == -1) {
               cur = nums2[q--];
           } else if (q == -1) {
               cur = nums1[p--];
           }
            else if (nums1[p]<nums2[q])
            {
                cur=nums2[q--];
            }
            else {
                cur=nums1[p--];
            }
            nums1[tail--]=cur;

        }
    }
}
