package accesscodes;

public class Solution {

    static int solution(int[] list){

        int count = 0;
        for (int x = 0; x < list.length; x++) {
            for (int y = x+1; y < list.length; y++) {
                for (int z = y +1; z < list.length; z++){

                    //If z divides evenly into z, and x into y,
                    if(list[z]%list[y]==0&&list[y]%list[x]==0){
                        System.out.println(list[x]+", "+list[y]+", "+list[z]);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
