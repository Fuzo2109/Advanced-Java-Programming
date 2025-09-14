import java.util.*;

public class DigitsDescending {
    public static int sortDigitsDescending(int num) {
        int[] digits = new int[10];
        int count = 0;

        while(num > 0){
            digits[count] = num % 10;
            num /= 10;
            count++;
        }
        for(int i = 0; i < count - 1; i++){
            for(int j = 0; j < count - i - 1; j++){
                if(digits[j] < digits[j + 1]){
                    int temp = digits[j];
                    digits[j] = digits[j + 1];
                    digits[j + 1] = temp;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < count; i++){
            result = result * 10 + digits[i];         
        }
         return result;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a non-negative integer:");
        int input = sc.nextInt();

        int result = sortDigitsDescending(input);
        System.out.println("Digits in descending order: " + result);
        
        sc.close();
    }
}
