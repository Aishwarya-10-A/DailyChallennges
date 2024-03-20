/*write a  java program to count the GrandChild/Child for given name 
Assume the relations here limit only to child and grandChild only 
all the inputs will be given in lower case characters(a-z) and are valid relations 

the first line of input consists of number of relations followed by child name and fathers name seperated by ',' 
followed by a name. 



Where the first string is "Child", second string is "Father".
If the given name is Father print the count of his children
If the given name is GrandFather print the count of his GrandChildren

Print -1 for any other boundary conditions 

for given input like this

input =
5
kishore,ramesh
dev,gopal
gopal,ramu
srinu,gopal
praveen,ranjit
ramu
output = 2

And given input "ramu" we have to find his no of grandchildren/child
Here "ramu" has one direct child gopal and gopal has 2 children(dev,srinu).
So ramu has 2 grand children dev,srinu. so output is 2

example:2 

input =
5
ranjit,knr
ramesh,pradeep
kittu,ranjit
yogesh,ranjit
praveen,ranjit
knr
output=
3

//given data for knr we need print the count of grand children . 
here knr direct child is ranjit and ranjit has three children   ---- kittu,yogesh,praveen so print 3


input = 
8
a,b
c,b
d,b
f,a
g,a
e,a
m,c
z,d
b
output =
5*/import java.util.*;
class Family
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String res[]=new String[n];
        for(int i=0;i<n;i++)
        {
            res[i]=sc.next();
        }
        String head=sc.next();
        if(func(n,res,head)==0)
        {
            System.out.println("-1");
        }
        else{
            System.out.println(func(n,res,head));
        }
    }
    public static int func(int n,String[]res,String head)
    {
        int count=0;
        List<String>son=new ArrayList<String>();
        HashMap<String,String>hm=new HashMap<>();
        for(String r:res)
        {
            String a[]=r.split(",");
            hm.put(a[0],a[1]);
        }
        for(Map.Entry<String,String>entry:hm.entrySet())
        {
            if(entry.getValue().equals(head))
            {
                son.add(entry.getKey());
            }
        }
        for(String s:son){
            for(Map.Entry<String,String>entrys:hm.entrySet())
            {
                if(entrys.getValue().equals(s))
                {
                    count++;
                }
            }
        }
        if(count==0)
        {
            count=son.size();
        }
        return count;
    }
}

