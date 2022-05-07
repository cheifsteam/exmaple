package topic24;

import java.util.ArrayList;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        ArrayList<int[]> arrayList = new ArrayList();
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    arrayList.add(new int[]{i,j});
                }
            }
        }
        for (int i = 0; i <arrayList.size(); i++) {
             int[] ints = arrayList.get(i);
            for (int l = 0; l <m; i++) {
                if (l==ints[0]) {
                    for (int j = 0; j < n; j++) {
                        matrix[l][j]=0;
                    }
                }else {
                    for (int j = 0; j < n; j++) {
                        if (j==ints[1]){
                            matrix[l][j]=0;
                        }
                    }
                }


            }
        }
    }
}
