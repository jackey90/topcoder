package org.jackey.algorithms.backtracking;

import com.google.gson.Gson;
import org.jackey.base.BaseCase;

public class Sudoku extends BaseCase {

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        s.doTest("solveSudoku");
    }


    int[] rows = new int[9];
    int[] columns = new int[9];
    int[][] blocks = new int[3][3];
    private int ALL = 511;
    boolean valid = false;

    /**
     1024/2 = 512
     1. 二进制表示   111111111=512
     2. 剩余可选值



     010101000  row
     110110101  column
     100100000  block
     |  110111101
     111111111
     ^  001000010
     低1和6位可以选择

     001000010
     001000001 去除最低位1
     &  001000000

     001000010
     000000010 去除最低位1
     ^  001000000

     001000010
     获取最低位1的位置
     Interger.bitCount(x-1);
     */
    public void solveSudoku(char[][] board) {
        int n = board.length;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                char c = board[x][y];
                if(c != '.'){
                    flip(x,y,(int)(c-'1'));
                }
            }
        }
        dfs(board,0,0,n);
        System.out.println(new Gson().toJson(board));
    }

    private int count;
    private void dfs(char[][] board, int x, int y, int n){
        System.out.println(x + " " + y + " " + count++);
        //System.out.println(new Gson().toJson(board));
        if(x == n){
            valid = true;
            return;
        }
        if(y == n){
            dfs(board,x + 1,0, n);
            return;
        }
        if(board[x][y] != '.'){
            dfs(board, x, y+1, n);
            return;
        }
        int r = rows[x];
        int c = columns[y];
        int b = blocks[x/3][y/3];
        //可用的值
        int able = (r|c|b)^ALL;
        for(;able > 0; able = able&(able-1)){
            int low = able&(-able);
            int index = Integer.bitCount(low - 1);
            flip(x,y,index);
            board[x][y] = (char)(index + '1');
            dfs(board,x,y+1,n);
            if(valid){
                return;
            }
            board[x][y] = '.';
            flip(x,y,index);
        }
    }


    private void flip(int x, int y, int num){
        int mask = (1 << num);
        rows[x] = rows[x]^mask;
        columns[y] = columns[y]^mask;
        blocks[x/3][y/3] = blocks[x/3][y/3]^mask;
    }
}
