package org.jackey.leetcode.medium;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by jackey90 on 2016/11/17.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombination {
    public Map<Character, String[]> digitMap = new HashMap();
    public String[] letter2 = {"a", "b", "c"};
    public String[] letter3 = {"d", "e", "f"};
    public String[] letter4 = {"g", "h", "i"};
    public String[] letter5 = {"j", "k", "l"};
    public String[] letter6 = {"m", "n", "o"};
    public String[] letter7 = {"p", "q", "r", "s"};
    public String[] letter8 = {"t", "u", "v"};
    public String[] letter9 = {"w", "x", "y", "z"};

    {
        digitMap.put('2', letter2);
        digitMap.put('3', letter3);
        digitMap.put('4', letter4);
        digitMap.put('5', letter5);
        digitMap.put('6', letter6);
        digitMap.put('7', letter7);
        digitMap.put('8', letter8);
        digitMap.put('9', letter9);
    }

    public  List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() <= 0 ){
            return new ArrayList<String>();
        }
        char[] chars = digits.toCharArray();
        String[] letters = digitMap.get(chars[0]);
        for(int i = 1; i < chars.length; i++){
            letters = combination(letters, digitMap.get(chars[i]));
        }

        return Arrays.asList(letters);
    }

    public String[] combination(String[] list1, String[] list2) {
        return Stream.of(list1).flatMap(letter1 ->
                Stream.of(list2).map(letter2 -> (letter1 + "" + letter2))
        ).distinct().toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombination().letterCombinations("23345"));
    }

}
