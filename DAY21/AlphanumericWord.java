package DAY21;
/*You are given an alphanumeric word W.
You need to find the number of words that can be formed from W.

The words have the following properties:
    - It should be a substring of W of any length, minimum 1.
    - All the letters in the word should be same.


Input Format:
-------------
Single String W.

Output Format:
--------------
Print an integer, the number of words can be formed


Sample Input-1:
---------------
paddy
 
Sample Output-1:
----------------
6

Explanation:
------------
The words are : p, a, d, d, dd, y


Sample Input-2:
---------------
abcde

Sample Output-2:
----------------
5

Explanation:
------------
The words are : a,b,c,d,e*/
import java.util.*;
class AlphanumericWord
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int res=0;
        for(int i=0;i<s.length();i++){
            res++;
            int c=2;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                res+=c;
                c++;
                i++;
            }
        }
        System.out.println(res);
    }
    
}
