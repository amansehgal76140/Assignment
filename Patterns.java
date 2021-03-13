import java.util.*;
public class Patterns {
    public static void pattern1(int n){
        System.out.println("Pattern1 is");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n)
    {
        System.out.println("Pattern2 is");
        char ch='A';
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
            {
               System.out.print(ch);
               ch++;
               if(ch>'Z')
                 ch='A';
            }
            System.out.println();
        }
    }
    
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows for Pattern1");
        int n=sc.nextInt();
        System.out.println("Enter rows for Pattern2");
        int m=sc.nextInt();
        pattern1(n);
        pattern2(m);
    }
}
