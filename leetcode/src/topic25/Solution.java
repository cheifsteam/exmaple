package topic25;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution {

    public static int singleNonDuplicate(int[] nums){
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int mid =l+(h-l)/2;
            mid-=mid&1;//确保mid为奇数
            if (nums[mid]==nums[mid+1]){//m+1<index时得nums[m]==nums[m+1],
                l=mid+2;//调整左边界
            }
            else {//m+1>index时得nums[m]!=nums[m+1],
                h=mid;//调整右边界
            }

        }
      return nums[l];
    }
}

