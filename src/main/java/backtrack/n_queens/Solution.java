package backtrack.n_queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    题⽬链接： https://leetcode-cn.com/problems/n-queens/
        n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.n_queens(4));

    }
    public List<List<String>> n_queens(int n){
        int[][] quenns = new int[n][n];
        ArrayList<List<String>> res = new ArrayList<>();
        backtracking(res,quenns,0);
        return res;
    }

    public void backtracking(List<List<String>> res , int[][] quenns,int row){
        if (row == quenns.length){
            ArrayList<String> list = new ArrayList<>();
            for (int[] quenn : quenns) {
                StringBuilder rowStr = new StringBuilder();
                for (int i1 = 0; i1 < quenns[0].length; i1++) {
                    if (quenn[i1] == 1) {
                        rowStr.append("Q");
                    } else {
                        rowStr.append(".");
                    }
                }
                list.add(rowStr.toString());
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < quenns.length; i++) {
            // 思路： 以列为单位想向下回溯，位置符合继续回溯，不符合或已回溯完则停止
            if (isValid(quenns,row,i)){
                quenns[row][i] = 1;
                backtracking(res,quenns,row+1);
                quenns[row][i] = 0;
            }
        }
    }
    public boolean isValid(int[][] quenns,int row,int col){
        // 检查同一列
        for (int i = 0; i < row; i++) {
            if (quenns[i][col]==1){
                return false;
            }
        }
        // 右上
        for (int i = row-1,j = col+1; i >=0 && j < quenns.length; i--,j++) {
            if (quenns[i][j]==1){
                return false;
            }
        }
        // 左上
        for (int i = row-1,j = col-1; i >=0 && j >=0; i--,j--) {
            if (quenns[i][j]==1){
                return false;
            }
        }
        return true;

    }
}
