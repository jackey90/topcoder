package org.jackey.algorithms.simulation;

import java.util.ArrayList;
import java.util.List;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.press('1'));
        System.out.println(bc.press('+'));
        System.out.println(bc.press('2'));
        System.out.println(bc.press('3'));
        System.out.println(bc.press('='));
        System.out.println(bc.press('+'));
        System.out.println(bc.press('1'));
        System.out.println(bc.press('='));
        System.out.println(bc.press('='));
        System.out.println(bc.press('='));
        System.out.println(bc.press('1'));
        System.out.println(bc.press('+'));
        System.out.println(bc.press('2'));
        System.out.println(bc.press('+'));
        System.out.println(bc.press('2'));
        System.out.println(bc.press('='));
        System.out.println(bc.press('='));
    }


    /**
     * status: 0 , init  任何数字输入，都会加在第一个值上
     * status: 1 , 刚刚输入过数字
     * status: 2,  刚刚输入过+号
     * status: 3   刚刚输出过=号
     */
        private List<Integer> queue = new ArrayList<Integer>();
        {
            queue.add(0);
        }
        
        private int status = 0;
        private final char PLUS = '+';
        private final char CL = 'C';
        private final char EQ = '=';

        public String press(char c){
            if(status == 0){
                if(isNum(c)){
                    increLast(c);
                    status = 1;
                }else if(PLUS == c){
                    addTogather();
                    status = 2;
                }else if(EQ == c){
                    addTogather();
                    status = 3;
                }
            }else if(status == 1){
                if(isNum(c)){
                    increLast(c);
                    status = 1;
                }else if(PLUS == c){
                    addTogather();
                    status = 2;
                }else if(EQ == c){
                    addTogather();
                    status = 3;
                }
            }else if(status == 2){
                if(isNum(c)){
                    addToLast(c);
                    status = 1;
                }else if(PLUS == c){
                    addTogather();
                    status = 2;
                }else if(EQ == c){
                    addTogather();
                    status = 3;
                }
            }else if(status == 3){
                if(isNum(c)){
                    addToFirst(c);
                    status = 1;
                }else if(PLUS == c){
                    addTogather();
                    status = 2;
                }else if(EQ == c){
                    addTogather();
                    status = 3;
                }
            }
            return queue.get(queue.size() - 1) + "";
        }

        private void addTogather(){
            int ret = queue.stream().mapToInt(o -> o).sum();
            queue.set(0,ret);
            if(queue.size() == 2){
                queue.remove(1);
            }
        }

        private void addToFirst(char c){
            int i = c - '0';
            queue.set(0,i);
        }

        private void increLast(char c){
            int i = c - '0';
            int last = queue.get(queue.size() - 1);
            last = last * 10 + i;
            queue.set(queue.size() - 1, last);
        }

        private void addToLast(char c){
            int i = c - '0';
            queue.add(i);
        }

        private boolean isNum(char c){
            return c - '0' >= 0 && c - '0' <= 9;
        }

}
