import java.util.*;

public class EasySmallNum {
    public static void main(String []args){ 
        int [] arr= new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<=4;i++){
            System.out.println("Enter a number");
            int at = sc.nextInt(); 
            arr[i]=at;
        }
        Arrays.sort(arr);
        int small = arr[1];
        System.out.print("the smallest number is:"+small);
    }
}
