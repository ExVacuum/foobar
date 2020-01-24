package labourshifts;

import java.util.ArrayList;
import java.util.Arrays;

class Solution{

    static int[] solution(int[] data, int n){
        int[] solnList = data;
        if(data.length<100) {
                for (int i = 0; i<data.length; i++) {
                    int count = 0;
                    for (int j = 0; j<data.length; j++) {
                        if(data[i]==data[j]){
                            count++;
                        }
                    }
                    if(count>n){
                        Integer[] dataObjs = Arrays.stream(solnList).boxed().toArray(Integer[]::new);
                        ArrayList<Integer> tempList = new ArrayList<Integer>(Arrays.asList(dataObjs));
                        for (int k = 0; k < tempList.size(); k++){
                            if(data[i]==tempList.get(k).intValue()){
                                tempList.remove(k);
                            }
                        }
                        solnList = new int[tempList.size()];
                        for (int k = 0; k < tempList.size(); k++){
                            solnList[k] = tempList.get(k).intValue();
                        }
                    }
                 }
        }else{
            System.err.println("[Minion Labour Shifts]: List must be less than 100 integers!");
        }
        return solnList;
    }
}