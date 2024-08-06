import java.util.*;
 class palindrome
{
	public static void main(String args[])
	{
		String s,s1,rev="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string");
		s=sc.nextLine();
		s1=s.toLowerCase();
		int len=s.length();
		for( int i=len-1;i>=0;i--)
		{
			rev=rev+s1.charAt(i);
		}
		if(s1.equals(rev)==true)
		{
			System.out.println("It is pallindrome");
		}
		else
		{
			System.out.println("It is not pallindrome");
		}
	}
}
