package org.jackey.topcoder;

public class Test5 {


    public static void main(String[] args) {
        Test5 t = new Test5();
        System.out.println(t.removeN("12119",2));
        System.out.println(t.removeN("10001",2));
        System.out.println(t.removeN("1011",2));
        System.out.println(t.removeN("1021",1));
        System.out.println(t.removeN("5335",2));
        System.out.println(t.removeN("",2));
        System.out.println(t.removeN("1",2));
        System.out.println(t.removeN(null,2));
    }

    /**
     * remove N 个字符
     * @param str
     * @param n
     * @return
     */
    public String removeN(String str, int n){
        if(str == null || str.length() <= n){
            return "0";
        }

        String ret = str;
        while(n > 0){
            ret = removeOne(ret);
            n--;
        }
        ret = removeLeadingZeros(ret);
        return ret;
    }

    /**
     * 移除前导0
     * @param str
     * @return
     */
    private String removeLeadingZeros(String str){
        if(str.length() == 1){
            return str;
        }
        String ret = str;
        int cnt = 0;
        for(int i = 0; i < ret.length() - 1; i++){
            char c = ret.charAt(i);
            if(c == '0'){
                cnt++;
            }else{
                break;
            }
        }
        if(cnt == 0){
            return str;
        }else{
            return str.substring(cnt , str.length());
        }
    }

    /**
     * 移除一个字符
     * @param str
     * @return
     */
    private String removeOne(String str){
        int min = Integer.MAX_VALUE;
        String ret = null;
        // 判断空
        for(int i = 0; i < str.length(); i++){
            String temp = str.substring(0,i) + str.substring(i + 1,str.length());
            int cur = Integer.valueOf(temp);
            if(cur < min){
                ret = temp;
                min = cur;
            }
        }
        return ret;
    }

}
