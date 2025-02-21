/*
Số chính phương là số có thể biểu diễn dưới dạng bìnhphương của một số tự nhiên (chẳng hạn 0, 1, 4, 9, 16…).
Hãy viết chương trình đếm số chính phương xem giữa hai số nguyên dương L,R (với1 ≤ L, R ≤ 10^18)
2
2 5
3 25

1
4
 */

import java.util.*;

/*
class Main{                     // cant use KTCOBAN003 as Main

    public static long SquareNumber(long num1, long num2){
        long sum = 0;
        for (long i = num1 ; i <= num2; i++){
            long j = (long)Math.sqrt(i) ;              // sqrt(i) * sqrt(i) = i
            if (j * j == i){
                sum++;
            }
        }
        return sum;
    }

    public static void main (String[] args){
        Scanner numInput = new Scanner(System.in);
        long num = numInput.nextLong();
        long num1, num2;
        for (long i = 0; i < num; i++){
            num1 = numInput.nextLong();
            num2 = numInput.nextLong();  
            System.out.println(SquareNumber(Math.min(num1, num2), Math.max(num1, num2)));       
        }
        
        numInput.close();
    }
}
    */

class Main{
    // a <= i^2 <= b    =>  sqrt(a) <= i <= sqrt(b)
    public static long SquareNumber(long num1, long num2){          
        long sum = 0;
        long tmp1 = (long)Math.sqrt(num1);
        long tmp2 = (long)Math.sqrt(num2);
        if (tmp1 * tmp1 != num1){               // ví dụ: (2, 5) => căn bặc 2 của 2 là 1.4 nếu để long sẽ bị làm tròn xuống thành 1. Mà một ngoài khoảng (1.4, 2.23) nên phải làm tròn lên từ 1.4 thành 2 để giá trị vẫn nằm trong khoảng được tính
            tmp1++;
        }
        for (long i = tmp1; i <= tmp2; i++){
            sum++;
        }
        return sum;

    }

    public static void main (String[] args){
        Scanner numInput = new Scanner(System.in);
        long num = numInput.nextLong();
        long num1, num2;
        for (int i = 0; i < num; i++){
            num1 = numInput.nextLong();
            num2 = numInput.nextLong();  
            System.out.println(SquareNumber(Math.min(num1, num2), Math.max(num1, num2)));
        }
        numInput.close();
    }
}