package org.jackey.topcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Sudoku {

    public static void main(String[] args) {
        char[][] input = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        new Sudoku().solveSudoku(input);
    }

    private List<Character> allNum = new ArrayList();
    {
        allNum.add('1');
        allNum.add('2');
        allNum.add('3');
        allNum.add('4');
        allNum.add('5');
        allNum.add('6');
        allNum.add('7');
        allNum.add('8');
        allNum.add('9');
    }
    private HashSet<Character>[] rows;
    private HashSet<Character>[] columns;
    private HashSet<Character>[] blocks;
    private char[][] result;

    public void solveSudoku(char[][] board) {
        int n = board.length;
        result = new char[n][n];
        this.rows = new HashSet[n];
        for(int i = 0; i < n; i++){
            rows[i] = new HashSet();
        }
        this.columns = new HashSet[n];
        for(int i = 0; i < n; i++){
            columns[i] = new HashSet();
        }
        this.blocks = new HashSet[n];
        for(int i = 0; i < n; i++){
            blocks[i] = new HashSet();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    rows[i].add(ch);
                    columns[j].add(ch);
                    blocks[getBlockIndex(i,j,n)].add(ch);
                }
            }
        }
        solveSudoku(board,0,n);
        copy(result,board);
        System.out.println(board);
    }


    private void solveSudoku(char[][] board, int count, int n){
        int x = count/n;
        int y = count%n;
        if(x == n - 1 && y == n - 1){
            copy(board,result);
            return;
        }
        if(board[x][y] != '.'){
            solveSudoku(board,count + 1,n);
            return;
        }

        List<Character> list = validList(x,y,n);
        if(list.size() == 0){
            return;
        }
        for(int i = 0; i < list.size(); i++){
            Character c = list.get(i);
            board[x][y] = c;
            rows[x].add(c);
            columns[y].add(c);
            blocks[getBlockIndex(x,y,n)].add(c);
            solveSudoku(board,count+1,n);
            board[x][y] = '.';
            rows[x].remove(c);
            columns[y].remove(c);
            blocks[getBlockIndex(x,y,n)].remove(c);
        }
    }

    private void copy(char[][] chars, char[][] result) {
        for(int i = 0; i < chars.length; i++){
            for(int j = 0; j < chars[i].length; j++){
                result[i][j] = chars[i][j];
            }
        }
    }


    private List<Character> validList(int x, int y, int n){
        List<Character> list = new ArrayList(allNum);
        list.removeAll(rows[x]);
        list.removeAll(columns[y]);
        list.removeAll(blocks[getBlockIndex(x,y,n)]);
        return list;
    }

    private int getBlockIndex(int x, int y, int n){
        int sqrt = (int)Math.sqrt(n);
        return y/sqrt + (int)(x/sqrt) * sqrt;
    }
}
