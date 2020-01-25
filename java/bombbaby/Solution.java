package bombbaby;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("4","7"));
    }

    static final boolean PROCESS_MACH = true;
    static final boolean PROCESS_FACULA = false;

    /**
     * Get minimum number of generations required to generate exactly thr appropriate amount of bombs
     * @param m Required Mach bombs
     * @param f Required Facula bombs
     * @return minimum number of generations required to generate exactly thr appropriate amount of bombs
     */
    static String solution(String m, String f){

        BigInteger count = BigInteger.ZERO;
        BigInteger mLeft = new BigInteger(m);
        BigInteger fLeft = new BigInteger(f);
        boolean lastStep;

        //If either mach or facula is greater than 1, we need to take more steps
        while(mLeft.compareTo(BigInteger.ONE)==1||fLeft.compareTo(BigInteger.ONE)==1){

            //If the number of mach and facula is uneven, we can do something.
            if(mLeft.compareTo(fLeft)!=0) {


                /*If mach > facula, the last process MUST have been the mach process, and the same goes for the opposite.
                we can use this to reverse engineer the best solution.
                 */
                lastStep = (mLeft.compareTo(fLeft)==1);
                if (lastStep == PROCESS_MACH) {
                    count = count.add(!fLeft.equals(BigInteger.ONE)?mLeft.divide(fLeft):BigInteger.ONE);
                    mLeft = mLeft.subtract(!fLeft.equals(BigInteger.ONE)?fLeft.multiply(mLeft.subtract(BigInteger.ONE).divide(fLeft)):BigInteger.ONE);
                    System.out.println("mac: " + count+ ", " + mLeft.toString() + ", " + fLeft.toString());
                }
                if (lastStep == PROCESS_FACULA) {
                    count = count.add(!mLeft.equals(BigInteger.ONE)?fLeft.divide(mLeft):BigInteger.ONE);
                    fLeft = fLeft.subtract(!mLeft.equals(BigInteger.ONE)?mLeft.multiply(fLeft.subtract(BigInteger.ONE).divide(mLeft)):BigInteger.ONE);
                    System.out.println("fac: "  + count + ", " + mLeft.toString() + ", " + fLeft.toString());
                }
            }else{
                return "impossible";
            }
        }
        return count.toString();
    }
}
