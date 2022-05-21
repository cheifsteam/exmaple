package topic6;

import java.util.Arrays;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 * 两个数组的交集 II
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *

 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1={4,9,5,4,4,4};
        int[] nums2={9,4,9,8,4,4};
        final int[] intersection = intersection(nums1, nums2);
        for (int i :intersection) {
            System.out.print(i);
        }

    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p=0,q=0,index=0;
        int count=0;
        int num1,num2;
        int[] arr = new int[nums1.length+nums2.length];
        while (p<nums1.length&&q<nums2.length)
        {
            num1=nums1[p];
            num2=nums2[q];
            if (num1==num2)
            {   count++;
                if (index==0||num1!=arr[index-1]) {
                    arr[index++] = num1;

                }
                if (count>index){
                    arr[index++] = num1;
                }
                p++;
                q++;
            }
            else if (num1<num2){
                p++;
            }else {
                q++;
            }
        }
        return Arrays.copyOf(arr,index);
    }
}
