import java.util.*;


class test{

    

    public static void main (String [] args){
        Scanner numInput = new Scanner(System.in);
        int numTest = numInput.nextInt();
        String tmp = String.valueOf(numTest);
        System.out.println((int)tmp.charAt(0));
        numInput.close();
    }
}
