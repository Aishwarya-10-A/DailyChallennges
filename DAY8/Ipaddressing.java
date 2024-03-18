
/* Bob Khan is working with various number systems.
He has created two kinds of addressing systems to share information 
between any two electronic devices.

Addresses in Type-I has following properties:
	- This addressing has four parts, each part is called as 'octet'
	- each octet can have a decimal value between 0 to 255 only
	- each part is separated by periods(.) 
	- Leading 0's are not allowed.
	- each part should conatins atmost 3 digits.

if any octet in the 4 parts, is not satisfying the rules
specified said to be  "invalid" addressing.


Addresses in Type-II has following properties:
	- This addressing has eight parts, each part is called as 'hextet'
	- each hextext can have a hexadecimal value between 0 to ffff only
	- each part is separated by colons (:) 
	- each part should conatins atmost 4 alphanumerics, 
	  as per hexademial number system.

if any hextet in the 8 parts, is not satisfying the rules
specified said to be "Invalid" addressing.
		
You will be given an address as a string	addr.
Your task is to find, whether the given address "addr" belongs to which asddress type.
And return "Type-I" if belongs to "Type-I" Addressing, 
return "Type-II" if belongs to "Type-II" Addressing, 
return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.


Input Format:
-------------
A string, an address addr.

Output Format:
--------------
Print a string output, as mentioned in above statement.


Sample Input-1:
---------------
213.234.45.12

Sample Output-1:
----------------
Type-I


Sample Input-2:
---------------
abcd:ef12:3456:7:dce8:fab9:1:0cda

Sample Output-2:
----------------
Type-II


Sample Input-3:
---------------
abcd:ef12:3456:7:0dce8:fab9:1:0cda

Sample Output-3:
----------------
Invalid


Sample Input-4:
---------------
123.234.34@.31

Sample Output-4:
----------------
Invalid

*/
import java.util.*;
class Ipaddressing
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(validIPAddress(s));
    }
    public static String validIPAddress(String IP) 
    {
	if(isValidIPv4(IP))
	   return "Type-I";
	else if(isValidIPv6(IP)) 
       return "Type-II";
	else 
	   return "Invalid";
    }

    public  static boolean isValidIPv4(String ip)
   {
	if(ip.length()<7) 
	   return false;
	if(ip.charAt(0)=='.') 
	  return false;
	if(ip.charAt(ip.length()-1)=='.') 
	  return false;
	String[] tokens = ip.split("\\.");
	if(tokens.length!=4) 
	  return false;
	for(String token:tokens) 
	  {
		if(!isValidIPv4Token(token))
		  return false;
	  }
	 return true;
   }
   public static boolean isValidIPv4Token(String token)
   {
	if(token.startsWith("0") && token.length()>1) 
	   return false;
	try
	 {
		int parsedInt = Integer.parseInt(token);
		if(parsedInt<0 || parsedInt>255) 
		return false;
	 }
		catch(NumberFormatException nfe) 
		{
		 return false;
		}
	return true;
}
	
public static boolean isValidIPv6(String ip) 
{
	if(ip.length()<15) 
	   return false;
	if(ip.charAt(0)==':')
	  return false;
	if(ip.charAt(ip.length()-1)==':')
	  return false;
	String[] tokens = ip.split(":");
	if(tokens.length!=8) 
	  return false;
	for(String token: tokens) 
	{
		if(!isValidIPv6Token(token)) 
		   return false;
	}
	return true;
}
    public static boolean isValidIPv6Token(String token) 
   {
	if(token.length()>4 || token.length()==0) 
	   return false;
	char[] chars = token.toCharArray();
	for(char c:chars) 
	{
		boolean isDigit = c>=48 && c<=57;
		boolean isUppercaseAF = c>=65 && c<=70;
		boolean isLowerCaseAF = c>=97 && c<=102;
		if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
			return false;
	}
	return true;
   }

}