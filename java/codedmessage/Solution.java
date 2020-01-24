package codedmessage;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    //Biggest Number Divisible by 3
    static int biggest = 0;

    static int solution(int[] list) {

        // Size of permutation we want to search for
        int size = list.length;
        while (size>0){

            // Get all permutations of size k
            getCombinations(list,size);

            // If no suitable permutation found, decrease size and try again
            if(biggest==0)
                size--;
            else break;
        }
        return biggest;
    }


     static void getCombinations(int[] list, int k){

        //Place list of ints into Integer array
        Integer[] listObjs = Arrays.stream(list).boxed().toArray(Integer[]::new);
        ArrayList<Integer> elements  = new ArrayList<Integer>(Arrays.asList(listObjs));

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            a.add(elements.get(i));
        }
        for(ArrayList<Integer> perm : choose (a, k)){
            int res = 0;
            for(int i = 0; i < perm.size(); i++){
                res += perm.get(i)*Math.pow(10,perm.size()-1-i);
            }

            if(res%3==0&&res>biggest) biggest = res;
        }
    }

    // a is the original array
    // k is the number of elements in each permutation
    public static ArrayList<ArrayList<Integer>> choose(ArrayList<Integer> a, int k) {
        ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
        enumerate(a, a.size(), k, allPermutations);
        return allPermutations;
    }

    // Enumerate over every permutation of size k
    private static void enumerate(ArrayList<Integer> a, int n, int k, ArrayList<ArrayList<Integer>> allPermutations) {
        if (k == 0) {
            ArrayList<Integer> singlePermutation = new ArrayList<Integer>();
            for (int i = n; i < a.size(); i++) {
                singlePermutation.add(a.get(i));
            }
            allPermutations.add(singlePermutation);
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            enumerate(a, n - 1, k - 1, allPermutations);
            swap(a, i, n - 1);
        }
    }

    // Swap values in arraylist
    public static void swap(ArrayList<Integer> a, int i, int j) {
        Integer temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}