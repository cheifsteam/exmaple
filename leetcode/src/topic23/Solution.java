package topic23;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 48.旋转图像
 */
public class Solution {
    public static void main(String[] args) {
       int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
       rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int n= matrix.length;
        int[][]matrix_new=new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n ; j++) {
                matrix_new[j][n-1-i]=matrix[i][j];
            }
        }
        matrix=matrix_new;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}
