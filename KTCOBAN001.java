/*
 * Số Armstrong là số mà từng chữ số trong số đó lũy thừa với số chữ số của nó bằng chính nó.

Ví dụ: 153 là số Armstrong vì 1^3 + 5^3 + 3^3 = 153.

Cho số nguyên (1<= n <= 10^18). Hãy kiểm tra n có phải là số Armstrong hay không?
 */
import java.util.*;


class KTCOBAN001{

    public static String IntToString (int num){         //change int to string
        return String.valueOf(num);
    }

    public static boolean isArmstrong(int num){                 //check if the number is Armstrong or not
        String temp = IntToString(num);
        long sum = 0;
        for (int i = 0; i < temp.length(); i++ ){
            int temp1 = temp.charAt(i) - '0';                   // change char in String to int
            sum = sum + (long)Math.pow(temp1, temp.length());   // calculate the sum of the number (^ số chữ số)
        }
        if (sum == num){
            return true;
        } else {
            return false;
        }
    }

    public static void main (String [] args){
        Scanner numInput = new Scanner(System.in);
        int numTest = numInput.nextInt();
        for (int i = 0; i < numTest; i++){
            int num = numInput.nextInt();
            if (isArmstrong(num)){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        numInput.close();
    }
}
