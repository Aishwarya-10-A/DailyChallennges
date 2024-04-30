package DAY23;

import java.util.Scanner;

/*Given an expression in string format print the value of the expression after evaluating 

Rules for Evaluation :
The expression is Evaluated from Left to Right and operators allowed are only +,-,/,*
Ignore Operator Precedence and evaluate the expression from left to right
Assume the expression only consists of numbers(0-9)(both postive and negative) and 
operators(+,-,*,/)

Test Case-1
input = 2+3*6
output = 30

Explanation :- The sum of 2+3 is 5 and 5*6 = 30 


Test Case-2
input = 5+7-9+0*0+1
output = 1

Explanation - The sum of 5+7 is 12 
12-9 is 3 and 3+0 is 3, 3*0 is 0 and 0+1 is 1 


Test Case-3
input = -1+-1*2
output = -4

Explanation -
-1 + -1 is -2 
and -2 * 2 is -4
 */
import java.util.*;

class ExpressEvaluate
{
    public static void main (String[] args)
     {
         Scanner sc=new Scanner(System.in);
         String str=sc.next();
         char k=str.charAt(0);
         int sign=1;
         int result=0;
         if(!Character.isDigit(k))
         {
             if(k=='+')
                 sign=1;
             else if(k=='-')
                 sign=-1;
             k='0';
         }
         else
              result=str.charAt(0)-'0';
	 for(int i=1;i<str.length();i++)
         {
             if(Character.isDigit(str.charAt(i)))
             {
                 if(k=='+')
                         result+=sign*(str.charAt(i)-'0');
                 else if(k=='-')
                         result-=sign*(str.charAt(i)-'0');
                 else if(k=='*')
                        result*=sign*(str.charAt(i)-'0');
                 else if(k=='/')
                       result/=sign*(str.charAt(i)-'0');
                 else
                       result=sign*(str.charAt(i)-'0');
                sign=1;
             }
             else if(!Character.isDigit(str.charAt(i-1)))
             {
                 if(str.charAt(i)=='+')
                 sign=1;
                 else if(str.charAt(i)=='-')
                 sign=-1;
                k=str.charAt(i-1);
             }
             else
                k=str.charAt(i);
         }
         System.out.println(result);
     }
    
}
