package DAY16;
/* */
import java.util.*;
class happyNumber
{
 
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(isHappy(n))
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }
    public static boolean isHappy(int n)
    {
        if(n==1)
        {
            return true;
        }
        if(n==4)
        {
            return false;
        }
        return isHappy(sumOfDigits(n));
    }
    public static int sumOfDigits(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
}
    

