import java.util.Scanner;
class fibanocci
{
public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
int a=0,b=1,c,n,i;
System.out.println("enter the numbers of elements");
n=sc.nextInt();
System.out.println(a);
System.out.println(b);
c=a+b;
System.out.println(c);
for(i=4;i<=n;i++)
{
a=b;
b=c;
c=a+b;
System.out.println(c);
}
sc.close();
}}




