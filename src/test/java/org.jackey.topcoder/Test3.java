//package org.jackey.topcoder;
//
//
///**
// *
// *
// *
// */
//public class Test3 {
//
//
//
//    /**
//     *
//     * @param input
//     * @return
//     */
//    public String addOne(String input){
//        if(input == null || input.length() == 0){
//            throw new RuntimeException("input is empty");
//        }
//        input = input.trim();
//        if(input.length() == 0){
//            throw new RuntimeException("input is empty");
//        }
//        int carray = 1;
//        boolean positive = true;
//        char[] array = input.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        StringBuilder zeros = new StringBuilder();
//        for(int i = array.length - 1; i >= 0; i--){
//            char c = array[i];
//            if(c == '+' || c == '-'){
//                assertTrue(i == 0,"input invalid");
//                positive = c == '+';
//            }else if(isNum(c)){
//                int cur = carray + (int)(c - '0');
//                if(cur < 10){
//                    carray = 0;
//                    array[i] = (char)('0' + cur);
//                }else{
//                    array[i] = '0';
//                    carray = 1;
//                }
//            }else{
//                throw new RuntimeException("input invalid");
//            }
//        }
//        String ret = new String(array);
//        if(carray == 1){
//            ret = "1" + ret;
//        }
//        ret = removeLeadingZero(ret);
//
//    }
//
//    private String removeLeadingZero(String str){
//
//    }
//
//    private boolean isNum(char c){
//        return c >= '0' && c <= '9';
//    }
//
//
//    private void assertTrue(boolean flag, String message){
//        if(!flag){
//            throw new RuntimeException(message);
//        }
//    }
//
//}
