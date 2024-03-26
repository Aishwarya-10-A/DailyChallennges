/*Tinku a Small Kid is playing with the Amazon Fire TV Stick Remote
Tinku is not familar with the alphabets. 
He father gives him few alphabets and asks Tinku to type it. 
Tinku uses only one finger. 
At the Beginining, he will put his finger at the the 1st key, k[0];
To type the Next Alphabet he has to move his finger from that key(m) 
to that particular alphabet(n) he takes |m-n| seconds. 

Help Tinkus Father to see how much seconds does Tinku take to type the given alphabets.


input=poiuytrewqasdfghjklmnbvcxz
kmit
output=39


input=abcdefghijklmnopqrstuvwxyz
code
output=26



*/package DAY12;

import java.util.*;

public class KeyboardTime
{
    public static int cal(String key, String word) {
        int time = 0;
        char currentKey = key.charAt(0);
        for (char c : word.toCharArray()) {
            int i = key.indexOf(c);
            time += Math.abs(i - key.indexOf(currentKey));
            currentKey = c;
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String key = sc.nextLine();
        String word = sc.nextLine();
        int time = cal(key, word);
        System.out.println(time);
    }
    
}
