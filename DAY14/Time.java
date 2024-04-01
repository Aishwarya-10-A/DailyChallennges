package DAY14;

import java.util.Scanner;

/*Tubby a Third Class Student has given a Assignment on Time Chapter by his class teacher.
Tubby is supposed to change the time given in AM/PM Format to 24 Hours Format. 
Help Tubby Solve the Problem 
  
The Maths teacher gave him the time in the following Format - HH:MM:SS:AM/PM
   
Assume all HH,MM,SS are in the valid range only 
  
Note: Midnight is 12:00:00AM on a 12-hour clock,  and 00:00:00 on a 24-hour clock. 
Noon is 12:00:00PM on a 12-hour clock,  and 12:00:00 on a 24-hour clock. 
       
Assume all input times are valid
    

Example:
input = 06:10:20PM
output = 18:10:20
   */
public class Time
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input = ");
        String timein12 = sc.next();
        String timein24 = clock(timein12);
        System.out.println("output = " + timein24);
    }

    public static String clock(String timein12) {
        String[] parts = timein12.split(":");
        String hours = parts[0];
        String minutes = parts[1];
        String secondsAndPeriod = parts[2];
        int seconds = Integer.parseInt(secondsAndPeriod.substring(0, 2));
        String period = secondsAndPeriod.substring(2);
        
        if(period.equals("PM") && !hours.equals("12")) {
            int hour = Integer.parseInt(hours) + 12;
            hours = String.valueOf(hour);
        } else if(period.equals("AM") && hours.equals("12")) {
            hours = "00";
        }
        
        return hours + ":" + minutes + ":" + seconds;
    }
    
}
