import java.util.*;

class Main{
    public static Vector <Long> ListPerfectNumber = new Vector<>();

    public static boolean isPrime(long num){
        if (num < 2){
            return false;
        }
        for (long j = 2; j <= Math.sqrt(num); j++){ 
            if (num % j == 0){
                return false;
            }
        }
        return true;
    }


    public static void PerfectNumber(){
        for (long i = 1; i <= 33; i++){
            if(isPrime(i)){
                long tmp1 = (long) Math.pow(2, i) - 1;
                if (isPrime(tmp1)){
                    long tmp2 = (long) Math.pow(2, i - 1);
                    ListPerfectNumber.add((long)(tmp1 * tmp2));
                    System.out.println((long)(tmp1 * tmp2));
                }
            }

        }
    }

    public static void main (String [] args){
        PerfectNumber();
        for (long k : ListPerfectNumber){
            System.out.println(k);
        }
        
    }
}