
import java.util.*;

class Grocery{
        int pos=-1;
        int price[];
        String name[],quantity[];
        public Grocery()
        {
            price=new int[50];
            name=new String[50];
            quantity=new String[50];
        }
    public  int update(String Name,String Quantity,int Price)
    {
      if(pos==-1)
          return -1;
      for(int i=0;i<=pos;i++)
      {
          if(name[i].equals(Name))
          {
              int change=Price-price[i];
              price[i]=Price;
              quantity[i]=Quantity;
              return change;
          }
      }
      return -1;
    }
    public void searchItem(int price)
    {
        String name="";
       for(int i=0;i<=pos;i++)
       {
           if(this.price[i]<price)
               name=this.name[i];
           if(this.price[i]==price)
           {
               name=this.name[i];
               break;
           }
       }
       if(!name.equals(""))
           System.out.println("Amount left you can buy "+name);
    }
    public  int ManageGrocery(int budget)
    {
        String product,quantity;
        System.out.print("Enter Product:   ");
        Scanner sc=new Scanner(System.in);
        product=sc.nextLine();
        System.out.print("Enter Quantity:  ");
        quantity=sc.nextLine();
        System.out.print("Enter Price:     ");
        int price=sc.nextInt();
        if(price>budget)
        {
            System.out.println("Can't buy the price beacuse it out of budget");
            return 0;
        }
        int change=update(product,quantity,price);
        if(change!=-1)
            return change;
        pos++;
        this.price[pos]=price;
        this.name[pos]=product;
        this.quantity[pos]=quantity;
        return price;
    }
    public void display()
    {
        System.out.println("Grocery List is:");
        System.out.println("Product Name   Quantity     Price");
        for(int i=0;i<=pos;i++)
        {
            System.out.println(name[i]+"      "+quantity[i]+"     "+price[i]);
        }
    }
    }
public class GroceryList {
    
   public static void main(String []args)
   {
       Grocery G=new Grocery();
       System.out.print("Enter your budget: ");
       Scanner sc=new Scanner(System.in);
       int budget=sc.nextInt();
       int ch=0;
       do{
           System.out.println("1-Add an item");
           System.out.println("2-Exit");
           System.out.print("Enter your Choice: ");
           ch=sc.nextInt();
           if(ch==1)
            budget=budget-G.ManageGrocery(budget);
           System.out.println();
           System.out.println("Amount left: "+budget);
           System.out.println();
       }while(ch!=2);
       System.out.println();
       if(budget!=0)
           G.searchItem(budget);
       G.display();
   }
}
