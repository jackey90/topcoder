package org.jackey.test;

import org.jackey.base.BaseCase;

import java.util.*;


class Result  {

    /*
     * Complete the 'awardTopKHotels' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING positiveKeywords
     *  2. STRING negativeKeywords
     *  3. INTEGER_ARRAY hotelIds
     *  4. STRING_ARRAY reviews
     *  5. INTEGER k
     */

    /**
     *
     *
     *
     *
     *
     *
     *
     * 2
     * @param args
     */
    public static void main(String[] args) {
        String positiveKeywords = "breakfast beach citycenter location metro view staff price";
        String negativeKeywords = "not";
        List<Integer> hotelIds = new ArrayList<>();
        hotelIds.add(1);
        hotelIds.add(2);
        hotelIds.add(1);
        hotelIds.add(1);
        hotelIds.add(2);
        List<String> reviews = new ArrayList<>();
        reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
        reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
        reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
        reviews.add("Good price but I couldn't take my dog and there were other guests with dogs!");
        reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");
        int k = 2;
        awardTopKHotels(positiveKeywords,negativeKeywords,hotelIds,reviews,2);
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        // Write your code here
        Set<String> positiveSet = getStrSet(positiveKeywords);
        Set<String> negativeSet = getStrSet(negativeKeywords);

        System.out.println(positiveSet);
        System.out.println(negativeSet);
        Map<Integer,HotelScore> scoreMap = new HashMap();
        for(int i = 0; i < reviews.size(); i++){
            int id = hotelIds.get(i);
            HotelScore hotelScore = scoreMap.get(id);
            if(hotelScore == null){
                hotelScore = new HotelScore(id);
                scoreMap.put(id,hotelScore);
            }
            String oneRevew = reviews.get(i);
            long oneScore = calScoreForOneReview(oneRevew, positiveSet, negativeSet);
            //System.out.println(id + " " + oneScore);
            hotelScore.score  = hotelScore.score + oneScore;
        }

        List<HotelScore> allScore = new ArrayList(scoreMap.values());
        Collections.sort(allScore);

        System.out.println(allScore);
        List<Integer> ret = new ArrayList();
        int size = Math.min(allScore.size(),k);
        for(int i = 0; i < size; i++){
            ret.add(allScore.get(i).id);
        }
        return ret;
    }

    private static long calScoreForOneReview(String review, Set<String> positiveSet, Set<String> negativeSet){
        long ret = 0;
        if(review == null | review.length() == 0){
            return ret;
        }
        review = review.replaceAll("\\.", "");
        review = review.replaceAll(",", "");
        String[] words = review.split(" ");


        for(String word: words){
            System.out.println(word);
            if(positiveSet.contains(word)){
                ret += 3;
            }else if(negativeSet.contains(word)){
                ret -= 1;
            }
        }
        return ret;
    }

    private static Set<String> getStrSet(String input){
        String[] array = input.split(" ");
        Set<String> set = new HashSet();
        for(String str: array){
            set.add(str);
        }
        return set;
    }


    static class HotelScore implements Comparable<HotelScore>{
        int id;
        long score;

        public HotelScore(int id){
            this.id = id;
            this.score = 0;
        }

        @Override
        public int compareTo(HotelScore other){
            if(this.score > other.score){
                return -1;
            }else if (this.score < other.score){
                return 1;
            } else {
                return this.id - other.id;
            }
        }

        @Override
        public String toString(){
            return "id = " + id + " , score = " + score;
        }
    }

}


