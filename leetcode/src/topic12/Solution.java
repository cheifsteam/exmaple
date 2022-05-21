package topic12;

import java.util.Arrays;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution {
    public static void main(String[] args) {
        int[] [] arr={{1,2},{3,4}};
        matrixReshape(arr,1,4);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] arr = new int[r][c];
        int m=mat.length;
        int n=mat[0].length;
        int len=m*n;
        if (r*c!=m*n){
            return mat;
        }
        for (int i = 0; i <r*c; i++) {
            arr[i/c][i%c]=mat[i/n][i%n];
        }
        return arr;
    }
}
