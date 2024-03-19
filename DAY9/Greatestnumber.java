
/*Kalpana a third class student is playing with numbers. 
She has given her brother the same set of numbers and asked him to find the 
next greatest nearest number which contains the same set of digits same number of times. 

If no such number exists print -1 

input = 121
output = 211

input = 653
output = -1


input = 456
output = 465*/

import java.util.*;

public class Greatestnumber 
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = greatestNumber(n);
        System.out.print(result);
    }

    public static int greatestNumber(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        
        int pivot = -1;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            return -1;
        }

        int swap = -1;
        for (int i = digits.length - 1; i > pivot; i--) {
            if (digits[i] > digits[pivot]) {
                swap = i;
                break;
            }
        }

        char temp = digits[pivot];
        digits[pivot] = digits[swap];
        digits[swap] = temp;

        reverse(digits, pivot + 1);

        int result = Integer.parseInt(new String(digits));
        return result;
    }

    private static void reverse(char[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

    

