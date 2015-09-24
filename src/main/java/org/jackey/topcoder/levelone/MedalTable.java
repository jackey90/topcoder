package org.jackey.topcoder.levelone;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 4/18/14
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement for MedalTableProblem Statement    The Olympic Games in Athens end tomorrow. Given the results of the olympic disciplines, generate and return the medal table.
 * <p/>
 * <p/>
 * <p/>
 * The results of the disciplines are given as a String[] results, where each element is in the format "GGG SSS BBB". GGG, SSS and BBB are the 3-letter country codes (three capital letters from 'A' to 'Z') of the countries winning the gold, silver and bronze medal, respectively.
 * <p/>
 * <p/>
 * <p/>
 * The medal table is a String[] with an element for each country appearing in results. Each element has to be in the format "CCO G S B" (quotes for clarity), where G, Sand B are the number of gold, silver and bronze medals won by country CCO, e.g."AUT 1 4 1". The numbers should not have any extra leading zeros.
 * <p/>
 * Sort the elements by the number of gold medals won in decreasing order. If several countries are tied, sort the tied countries by the number of silver medals won in decreasing order. If some countries are still tied, sort the tied countries by the number of bronze medals won in decreasing order. If a tie still remains, sort the tied countries by their 3-letter code in ascending alphabetical order. Definition    Class:MedalTableMethod:generateParameters:String[]Returns:String[]Method signature:String[] generate(String[] results)(be sure your method is public)     Constraints-results contains between 1 and 50 elements, inclusive.-Each element of results is formatted as described in the problem statement.-No more than 50 different countries appear in results. Examples0)
 * {"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"}
 * <p/>
 * Returns:
 * { "KOR 3 1 0",
 * "ITA 1 0 0",
 * "TPE 0 1 1",
 * "CHN 0 1 0",
 * "JPN 0 1 0",
 * "AUS 0 0 1",
 * "GBR 0 0 1",
 * "UKR 0 0 1" }
 * <p/>
 * These are the results of the archery competitions.1)
 * {"USA AUT ROM"}
 * <p/>
 * Returns: { "USA 1 0 0",  "AUT 0 1 0",  "ROM 0 0 1" }
 * <p/>
 * 2)
 * {"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"}
 * <p/>
 * Returns: { "AUT 1 1 1",  "GER 1 1 1",  "SUI 1 1 1" }
 */
public class MedalTable {
    Map<String, int[]> countryMap = new HashMap<String, int[]>();

    public String[] generate(String[] results) {

        if (results != null) {
            for (String rankings : results) {
                String[] rankingArray = rankings.split(" ");
                for (int i = 0; i < rankingArray.length; i++) {
                    String country = rankingArray[i];
                    if (!countryMap.containsKey(country)) {
                        countryMap.put(country, new int[3]);
                    }
                    countryMap.get(country)[i]++;
                }
            }
        }

        List<String> countryList = new ArrayList<String>(countryMap.keySet());
        Collections.sort(countryList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (!o1.equals(o2)) {
                    for (int i = 0; i < 3; i++) {
                        if (countryMap.get(o1)[i] != countryMap.get(o2)[i]) {
                            return countryMap.get(o2)[i] - countryMap.get(o1)[i];
                        }
                    }
                }
                return 0;
            }
        });
        String[] array = new String[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            String country = countryList.get(i);
            array[i] = country + " " + countryMap.get(country)[0] + " " + countryMap.get(country)[1] + " " + countryMap.get(country)[2];
            System.out.println(array[i]);
        }

        return array;
    }


    public static void main(String[] args) {
        String[] test = {"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"};
        new MedalTable().generate(test);
    }

}
