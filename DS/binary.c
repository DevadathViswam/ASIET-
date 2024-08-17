#include<stdio.h>
int main()
{
  int i,m,ar[100],n,s,count=0;
  printf("Enter the limit=");
  scanf("%d",&n);
  printf("Enter the element=");
  for(i=0;i<n;i++)
  {
    scanf("%d",&ar[i]);
    }
  printf("Enter the number that you want to search=");
  scanf("%d",&s);
  int l=0;
  int r=n-1;
  while(l<=r)
  {
    m=l+(r-l)/2;
    if(ar[m]==s)
    {
      printf("It is found");
      count=1;
      break;
      }
    if(ar[m]<s)
    {
       l=m+1;
       }
    else
    {
       r=m-1;
       }
       }
       
       
       if (count==0)
       {
         printf("Not found");
         }
      
     return 0;
     
}
