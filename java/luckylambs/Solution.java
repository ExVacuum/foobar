package luckylambs;

import java.util.Map;

public class Solution {

    static int solution(int lambs){

        /*Get Max # of Henchmen
        Get Min # of Henchmen
        Get diff
        */
        return maxHenchmen(lambs)-minHenchmen(lambs);
    }

    static int maxHenchmen(int lambs){

        //1,1,2,3,5,8,13 - Fibonacci Sequence, get nearest past fibonacci number
        return getFibAt(lambs);

    }

    static int minHenchmen(int lambs){

        //Each additional henchman adds exponentially more balls. 1 henchman = 1, 2 henchmen = 3, 3 henchmen = 7
        return (int)(Math.log(lambs)/Math.log(2));
    }

    //Get nearest fib. number without going over
    static int getFibAt(int lambs){
        int lambsLeft = lambs;
        int count = 0;
        int numa = 0;
        int numb = 1;
        while(lambsLeft > 0){
            count++;
            int tempA = numa;
            numa = numb;
            numb += tempA;
            lambsLeft-=numb;
        }
        return count;
    }
}
