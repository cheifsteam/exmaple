package topic13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 杨辉三角
 */
public class Solution {
    public static void main(String[] args) {
        final List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
//    public static List<List<Integer>> generate(int numRows) {
//
//        int[][] dp = new int[numRows][numRows];
//        List<List<Integer>> list=new ArrayList<>();
//        List<Integer> arr=new ArrayList<>();
//        arr.add(1);
//        list.add(arr);
//        for (int i = 1; i <numRows; i++) {
//            List<Integer> num=new ArrayList<>();
//            dp[i][0]=1;
//            num.add(dp[i][0]);
//            for (int j =1 ; j <i; j++) {
//                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
//                num.add(dp[i][j]);
//            }
//            dp[i][i]=1;
//            num.add(dp[i][i]);
//            list.add(num);
//        }
//        return list;
//    }
public static List<List<Integer>> generate(int numRows) {
    final ArrayList<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i <numRows ; i++) {
        List<Integer> row = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i) {//j在最后一个或者是第一个元素时大小为1
                row.add(1);
            } else {
                //每个数字等于上一行的左右两个数字之和，可用此性质写出整个杨辉三角。即第 nn 行的第 ii 个数等于第 n-1n−1 行的第 i-1i−1 个数和第 ii 个数之和。这也是组合数的性质之一，
                row.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
            }

        }
        lists.add(row);
    }
    return lists;
}
}
