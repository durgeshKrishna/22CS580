import java.util.*;

public class Main1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean found=false;
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int digitalSum = getDigitalSum(arr[i]);
            if (digitalSum % 2 != 0) {
                System.out.print(arr[i] + " ");
                found=true;
            }
        }
        if(!found) System.out.print(-1);
    }
    public static int getDigitalSum(long num) {
        while (num > 9) {
            num = num % 10 + num / 10;
        }
        return (int) num;
    }
}
