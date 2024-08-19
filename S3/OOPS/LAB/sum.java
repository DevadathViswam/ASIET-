import java.util.Scanner;
class sum{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
float num1,num2,s1=0;
int num3,num4,s2=0;
double num5,num6,s3=0;
System.out.println("enter the num1");
num1=sc.nextFloat();
System.out.println("enter the num2");
num2=sc.nextFloat();
s1=num1+num2;
System.out.println("enter the num3");
num3=sc.nextInt();
System.out.println("enter the num4");
num4=sc.nextInt();
s2=num3+num4;
System.out.println("enter the num5");
num5=sc.nextDouble();
System.out.println("enter the num6");
num6=sc.nextDouble();
s3=num5+num6;
System.out.println("sum of float is "+s1);
System.out.println("sum of integer is "+s2);
System.out.println("sum of double is "+s3);
sc.close();
}
}
