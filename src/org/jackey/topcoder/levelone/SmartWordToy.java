package org.jackey.topcoder.levelone;

import sun.applet.Main;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 4/17/14
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 * sovled:https://gist.github.com/ishikawa/17590
 * Problem Statement for SmartWordToy
 * <p/>
 * <p/>
 * Problem Statement
 * The toy company "I Can't Believe It Works!" has hired you to help develop educational toys. The current project is a word toy that displays four letters at all times. Below each letter are two buttons that cause the letter above to change to the previous or next letter in alphabetical order. So, with one click of a button the letter 'c' can be changed to a 'b' or a 'd'. The alphabet is circular, so for example an 'a' can become a 'z' or a 'b' with one click.
 * <p/>
 * <p/>
 * <p/>
 * In order to test the toy, you would like to know if a word can be reached from some starting word, given one or more constraints. A constraint defines a set of forbidden words that can never be displayed by the toy. Each constraint is formatted like "X X X X", where each X is a string of lowercase letters. A word is defined by a constraint if the ith letter of the word is contained in the ith X of the contraint. For example, the constraint "lf a tc e" defines the words "late", "fate", "lace" and "face".
 * <p/>
 * <p/>
 * <p/>
 * You will be given a String start, a String finish, and a String[] forbid. Calculate and return the minimum number of button presses required for the toy to show the word finish if the toy was originally showing the wordstart. Remember, the toy must never show a forbidden word. If it is impossible for the toy to ever show the desired word, return -1.
 * <p/>
 * Definition
 * <p/>
 * Class:	SmartWordToy
 * Method:	minPresses
 * Parameters:	String, String, String[]
 * Returns:	int
 * Method signature:	int minPresses(String start, String finish, String[] forbid)
 * (be sure your method is public)
 * <p/>
 * <p/>
 * <p/>
 * Constraints
 * -	start and finish will contain exactly four characters.
 * -	start and finish will contain only lowercase letters.
 * -	forbid will contain between 0 and 50 elements, inclusive.
 * -	Each element of forbid will contain between 1 and 50 characters.
 * -	Each element of forbid will contain lowercase letters and exactly three spaces.
 * -	Each element of forbid will not contain leading, trailing or double spaces.
 * -	Each letter within a group of letters in each element of forbid will be distinct. Thus "aa a a a" is not allowed.
 * -	start will not be a forbidden word.
 * <p/>
 * Examples
 * 0)
 * <p/>
 * "aaaa"
 * "zzzz"
 * {"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"}
 * Returns: 8
 * <p/>
 * 1)
 * <p/>
 * "aaaa"
 * "bbbb"
 * {}
 * Returns: 4
 * Simply change each letter one by one to the following letter in the alphabet.
 * 2)
 * <p/>
 * "aaaa"
 * "mmnn"
 * {}
 * Returns: 50
 * Just as in the previous example, we have no forbidden words. Simply apply the correct number of button presses for each letter and you're there.
 * 3)
 * <p/>
 * "aaaa"
 * "zzzz"
 * {"bz a a a", "a bz a a", "a a bz a", "a a a bz"}
 * Returns: -1
 * Here is an example where it is impossible to go to any word from "aaaa".
 * 4)
 * <p/>
 * "aaaa"
 * "zzzz"
 * {"cdefghijklmnopqrstuvwxyz a a a",
 * "a cdefghijklmnopqrstuvwxyz a a",
 * "a a cdefghijklmnopqrstuvwxyz a",
 * "a a a cdefghijklmnopqrstuvwxyz"}
 * Returns: 6
 * <p/>
 * 5)
 * <p/>
 * "aaaa"
 * "bbbb"
 * {"b b b b"}
 * Returns: -1
 * <p/>
 * 6)
 * <p/>
 * "zzzz"
 * "aaaa"
 * {"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 * "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"}
 * Returns: -1
 * <p/>
 */
public class SmartWordToy {
    private static final int N = 26 * 26 * 26 * 26;

    private boolean[] forbs = new boolean[N];
    private boolean[] visited = new boolean[N];
    private int[] distance = new int[N];
    private int[] q = new int[N];
    private int qs, qe;

    private static int code(char c1, char c2, char c3, char c4) {
        return (c1 - 'a') * 26 * 26 * 26 +
                (c2 - 'a') * 26 * 26 +
                (c3 - 'a') * 26 +
                (c4 - 'a');
    }

    private static int code(String word) {
        return code(word.charAt(0), word.charAt(1), word.charAt(2), word.charAt(3));
    }

    public int minPresses(String start, String finish, String[] forbid) {

        initForbid(forbid);

        final int startCode = code(start);
        final int finishCode = code(finish);
        if (forbs[finishCode]) return -1;

        visited[startCode] = true;
        distance[startCode] = 0;
        q[qe++] = startCode;

        int[] temp = new int[4];
        while (qs < qe) {
            int code = q[qs++];
            if (code == finishCode) return distance[code];
            int v = code;

            temp[3] = v % 26; v /= 26;
            temp[2] = v % 26; v /= 26;
            temp[1] = v % 26; v /= 26;
            temp[0] = v % 26; v /= 26;
            for (int i = 0; i < 4; i++) {
                for (int b = 0; b < 2; b++) {
                    int next = next(temp, i, b == 0);
                    if (visited[next] || forbs[next]) continue;
                    visited[next] = true;
                    distance[next] = distance[code]+1;
                    q[qe++] = next;
                }
            }
        }

        return -1;
    }

    private int next(int[] temp, int pos, boolean up) {
        int t = temp[pos];
        temp[pos] += up ? 1 : -1;
        if (temp[pos] == -1) temp[pos] = 25;
        else if (temp[pos] == 26) temp[pos] = 0;
        int c = temp[0] * 26 * 26 * 26 +
                temp[1] * 26 * 26 +
                temp[2] * 26 +
                temp[3];
        temp[pos] = t;
        return c;
    }

    private void initForbid(String[] forbid) {
        for (int index = 0; index < forbid.length; index++) {
            String[] items = forbid[index].split(" ");
            assert items.length == 4;

            for (int i = 0; i < items[0].length(); i++) {
                final char c1 = items[0].charAt(i);
                for (int j = 0; j < items[1].length(); j++) {
                    final char c2 = items[1].charAt(j);
                    for (int k = 0; k < items[2].length(); k++) {
                        final char c3 = items[2].charAt(k);
                        for (int l = 0; l < items[3].length(); l++) {
                            final char c4 = items[3].charAt(l);
                            forbs[code(c1, c2, c3, c4)] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        String[] forbids = {"a a a a","b b b b","a b b b","b b a a"};
        System.out.println(new SmartWordToy().minPresses("aaaa", "bbbb", forbids));

    }
}
