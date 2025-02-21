/*
 Số hoàn hảo (hay còn gọi là số hoàn chỉnh, số hoàn thiện hoặc số hoàn thành) là một số nguyên dương mà tổng các ước nguyên dương chính thức của số đó (ngoại trừ số đó) bằng chính nó. Ví dụ: 6 có tổng các ước số không tính nó là: 1+2+3 =6 nên 6 là số hoàn hảo.

Cho số nguyên n (1≤n≤10^18). Hãy kiểm tra xem n có phải là số hoàn hảo hay không?

2
15
6

0
1

Các số hoàn hảo:
6
28
496
8128
33550336
8589869056
137438691328
2305843008139952128

 */
import java.util.*;
// using Eculid - Euler algorithm to find perfect number (Nếu p là số nguyên tố và 2p - 1 cũng là số nguyên tố thì : 2p-1 * (2p - 1) sẽ là một số hoàn hảo)
/* 
class Main {

    public static int SpecialNumber(int num1){
        int sum = 0; 
    
        for (int i = 1; i < num1; i++){
            if (num1 % i == 0){
                sum += i;
            }
        }
        if (sum == num1){
            return 1;
        }else{
            return 0;
        }
    } 




    public static void main (String [] args){
        Scanner numInput = new Scanner(System.in);
        int num = numInput.nextInt();
        for (int i = 0; i < num; i++){
            int num1 = numInput.nextInt();
            System.out.println(SpecialNumber(num1));  
        }



        numInput.close();
    }
    
}*/
/*
class Main{

    public static boolean isPrime(long num){
        if (num < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }


    public static long ListPerfectNumber(long num1){
        for (int i = 1; i <= 33; i++){
            if(isPrime(i)){
                long tmp1 = (long) Math.pow(2, i) - 1;
                if (isPrime(tmp1)){
                    long tmp2 = (long) Math.pow(2, i - 1);
                    if (tmp1 * tmp2 == num1){
                        return 1;
                    }
                }
            }

        }
        return 0;
    }

    public static void main (String [] args){
        Scanner numInput = new Scanner(System.in);
        int num = numInput.nextInt();
        for (int i = 0; i < num; i++){
            int num1 = numInput.nextInt();
            System.out.println(ListPerfectNumber(num1));
        }
        numInput.close();
    }
}
*/

class KTUOCSO003{                   // need to change class name to Main when sumit code
    static int flag = 1;            // 1: not perfect number, 0: perfect number (check codition) if flag = 0, break loop and countinue to next Input and reset flag = 1
    static Vector <Long> ListPerfectNumber = new Vector<>();

    public static boolean isPrime(long num){            // check prime number 
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


    public static void PerfectNumber(){                             // check perfect number, if correct then add to array vector ListPerfectNumber
        for (long i = 1; i <= 33; i++){
            if(isPrime(i)){
                long tmp1 = (long) Math.pow(2, i) - 1;
                if (isPrime(tmp1)){
                    long tmp2 = (long) Math.pow(2, i - 1);
                    ListPerfectNumber.add((long)(tmp1 * tmp2));
                }
            }

        }
    }

    public static void main (String [] args){
        PerfectNumber();
        Scanner numInput = new Scanner(System.in);
        long num = numInput.nextLong();
        for (long i = 0; i < num; i++){
            flag = 1;
            long num1 = numInput.nextLong();
            for (long j : ListPerfectNumber){                  // check if Input is perfect number in ListPerfectNumber
                if (num1 == j){
                    System.out.println(1);                   // is perfect number
                    flag = 0;
                    break;
                }
            } 
            if (flag == 1){
                System.out.println(0);                     // not perfect number 
            }
        }
        numInput.close();
    }
}


