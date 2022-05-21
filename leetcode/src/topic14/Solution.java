package topic14;

import java.util.HashMap;

/**
 * @author 屈燃希
 * @version 1.0
 * @project 有效的数独
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
char[][] board={{'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','7'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        final boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }
//    public static boolean isValidSudoku(char[][] board) {
//        //定义数字行内出现的次数
//        int[][] row = new int[9][9];
//        //定义数字列内出现的次数
//        int[][] column = new int[9][9];
//        //定义数字九宫格内出现的次数最大为9次
//        int[][][] jiugongge = new int[3][3][9];
////      创建二维数组 rows 和 columns 分别记录数独的每一行和每一列中的每个数字的出现次数，创建三维数组 \textit{subboxes}subboxes 记录数独的每一个小九宫格中的每个数字的出现次数
//
//        //遍历数组
//        for (int i =0;i <9;i++){
//            for(int j = 0;j<9;j++){
//                char c = board[i][j];
//                //只要存在数字
//                if (c !='.'){
//                    //把数字-1化成索引下标,c是字符串要减去字符串，-1会报错。
//                    int index = c-'1';//当前数独位置的数字
//                    //row[i][index]++;当前行代表数独数字出现次数，如果当前行数独出现相同的数字,那么会定位相同row[i][index]位置进行+1
//                    //此时row[i][index]>1就不成立一个数组
//                    row[i][index]++;
//                    // column[j][index]++;当前列代表数独数字出现次数，如果当前列数独出现相同的数字,那么会定位相同column[j][index]位置进行+1
//                    // 此时column[j][index]>1就不成立一个数组
//                    column[j][index]++;
//                    //并且九宫格内次数也同理，i/3 j/3会自动定位到所在的小宫格
//                    jiugongge[i/3][j/3][index]++;
//                    //次数大于1就不成立一个数独
//                    if (row[i][index]>1||column[j][index]>1||jiugongge[i/3][j/3][index]>1) return false;
//                }
//            }
//        }
//        return true;
//    }
public static boolean isValidSudoku(char[][] board) {
        int[][] row =new int[9][9];
        int[][] col =new int[9][9];
        int[][][] sub_board=new int[3][3][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j <9 ; j++) {
            char c=board[i][j];
            if (c!='.'){
               int index =c-'1';
               row[i][index]++;
               col[j][index]++;
               sub_board[i/3][j/3][index]++;
               if (row[i][index]>1||col[j][index]>1||sub_board[i/3][j/3][index]>1){
                   return false;
               }
            }
        }
    }
        return true;}
}
