/*
 * Dãy cấp số cộng là một dãy số thoả mãn điều kiện: hai phần tử liên tiếp nhau sai khác nhau một hằng số (gọi là công sai của cấp số cộng).
Cho một dãy số nguyên gồm n phần tử (1≤n≤10^6). Hãy kiểm tra xem dãy đó có phải là dãy cấp số cộng hay không?


2
5
1 4 7 9 12
NO
6
2 4 6 8 10 12 
YES

 */
import java.util.*;

class KTDAYSO001{
    static Vector <Integer> arr = new Vector <>();

    public static void ArithmeticSequence(){
        if (arr.size() == 1){
            System.out.println("YES");
            return;
        }
        int temp1 = arr.get(0);
        int temp2 = arr.get(1);
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i) - arr.get(i - 1) != temp2 - temp1){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    
    public static void main (String [] args){
        Scanner numInput = new Scanner(System.in);
        int numTest = numInput.nextInt();
        for (int i = 0; i < numTest; i ++){
            int numSize = numInput.nextInt();
            for (int j = 0; j < numSize; j++){
                int num = numInput.nextInt();
                arr.add(num);
            }
            ArithmeticSequence();
            arr.clear();
        }
        numInput.close();
    }
}