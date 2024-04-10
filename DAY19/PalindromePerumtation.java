package DAY19;
/*Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.

Example 1:

input =code
output =false

input =aab
output =true
Example 3:

input=carerac
output =true
 

Constraints:

1 <= s.length <= 5000
s consists of only lowercase English letters.
 */
public class PalindromePerumtation
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(pal(s));
    }
    static boolean pal(String s)
    {
        BitSet bs=new BitSet();
        int i=0;
        for(i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            bs.flip(c);
        }
        return bs.cardinality()<2;
    }
    
}
