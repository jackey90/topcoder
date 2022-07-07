package org.jackey.leetcode.hard;

import org.jackey.base.BaseCase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CatMouseII extends BaseCase {

    public static void main(String[] args) {
        new CatMouseII().doTest("canMouseWin");
    }

    boolean canMouseWin = false;
    private static Map<String,Boolean> cache = new HashMap();
    int m;
    int n;
    int catLength;
    int mouseLength;
    int[] food;
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean canMouseWin(String[] sg, int catJump, int mouseJump) {
        m = sg.length;
        n = sg[0].length();
        char[][] grid = new char[m][n];
        catLength = catJump;
        mouseLength = mouseJump;
        int[] cat = null;
        int[] mouse = null;
        for(int i = 0; i < m; i++){
            grid[i] = sg[i].toCharArray();
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'C'){
                    cat = new int[]{i,j};
                }else if(grid[i][j] == 'M'){
                    mouse = new int[]{i,j};
                }else if(grid[i][j] == 'F'){
                    food = new int[]{i,j};
                }
            }
        }

        boolean result = dfs(grid,cat,mouse,0);
        return result;
    }

    private boolean dfs(char[][] grid, int[] cat, int[] mouse, int round){

        if(round > 1000 || Arrays.equals(cat,food) || Arrays.equals(cat,mouse)){
            return false;
        }

        if(Arrays.equals(mouse,food)){
            return true;
        }

        String key = key(cat, mouse, round);
        if(cache.get(key) != null){
            return cache.get(key);
        }
        boolean ret = false;
        if(round % 2 == 0){
            //mouse move
            for(int[] dir: directions){
                for(int mm = 1; mm <= mouseLength; mm++){
                    int x = mouse[0] + mm * dir[0];
                    int y = mouse[1] + mm * dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n){
                        break;
                    }
                    int[] newMouse = new int[]{x,y};
                    //no walls
                    if(grid[x][y] == '#'){
                        break;
                    }
                    //no cat
                    if(Arrays.equals(newMouse,cat)){
                        continue;
                    }
                    if(mouseWin(grid,cat,newMouse,round + 1)){
                        ret = true;
                        break;
                    }
                    ret = ret || dfs(grid, cat, newMouse, round + 1);
                    if(ret){
                        break;
                    }
                }
                if(ret){
                    break;
                }
            }
        }else{
            //cat move
            boolean tempRet = true;
            for(int[] dir: directions){
                for(int cm = 1; cm <= catLength; cm++){
                    int x = cat[0] + cm * dir[0];
                    int y = cat[1] + cm * dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n){
                        break;
                    }
                    //wall not vaid
                    if(grid[x][y] == '#'){
                        break;
                    }
                    int[] newCat = new int[]{x,y};
                    if(catWin(grid, newCat, mouse, round + 1)){
                        tempRet = false;
                        break;
                    }
                    tempRet = tempRet && dfs(grid, newCat, mouse, round + 1);
                    if(!tempRet){
                        break;
                    }
                }
                if(!tempRet){
                    break;
                }
            }
            ret = tempRet;
        }
        cache.put(key,ret);
        return ret;
    }

    private String key(int[] cat, int[] mouse, int round){
        return cat[0] + "-" + cat[1] + "-" + mouse[0] + "-" + mouse[1] + "-" + round;
    }

    private boolean mouseWin(char[][] grid, int[] cat, int[] mouse, int round){
        if(round <= 1000 && Arrays.equals(mouse,food)){
            return true;
        }
        return false;
    }

    private boolean catWin(char[][] grid, int[] cat, int[] mouse, int round){
        if(round > 1000 || Arrays.equals(cat,food) || Arrays.equals(cat,mouse)){
            return true;
        }
        return false;
    }


}
