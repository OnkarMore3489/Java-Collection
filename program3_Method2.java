/*
Write a program to store 'n' numbers of flavors of ice cream. Collection class should not
accept duplicate entries. perform following operation-

a.search for a specific flavour.
b.sort all the flavors.

Accept price for all flavors and create hash table using flavors and prices. (Use existing 
collection class of flavors).
*/
import java.util.*;

class program3_Method2 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);
        int size=0;
        System.out.println("How Many Flavors U want to enter : ");
        size=sobj.nextInt();

        Add aobj = new Add(size);
        aobj.Accept();

        int choice=1;
        while(choice!=0)
        {
            System.out.println("1.For Search Flavour || 2.For Sorting || 3.Add prices || 0.Exit");

            System.out.println("Enter Your choice : ");
            choice=sobj.nextInt();

            switch(choice)
            {
                case 1:
                       boolean bRet=aobj.Search();
                       if(bRet==true)
                       {
                           System.out.println("Flavour is there");
                       }
                       else
                       {
                           System.out.println("Flavour is not there");
                       }
                       break;
                case 2:
                       aobj.Sorting();
                       break;
                case 3:
                       aobj.AddPrice();
                case 0:System.exit(0);
                       break;
            }
        }
    }    
}
class Add
{
    Flavors fobj[];

    private String str;
    ArrayList<String> al;

    public Add(int size)
    {
        fobj=new Flavors[size];
        al=new ArrayList<String>();
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        for(int i=0;i<fobj.length;i++)
        {
            System.out.println("Enter the "+(i+1)+" Flavour");
            str=sobj.next();
            if(al.contains(str))
            {
                System.out.println("This Flavour Already Exist Please Enter Another Flavour : ");
                str=sobj.next();
            }
            fobj[i]=new Flavors(str);
            al.add(fobj[i].getString());
        }

        System.out.println(al);
    }

    public boolean Search()
    {
        Scanner sobj = new Scanner(System.in);

        String search;
        System.out.println("Enter the Flavour that U want to search : ");
        search=sobj.next();

        Iterator it1 = al.iterator();
        boolean bResult=false;
        while(it1.hasNext())
        {
            if(it1.next().equals(search))
            {
                bResult=true;
                break;
            }
        }
        return bResult;
    }

    public void Sorting()
    {
        Collections.sort(al);
        System.out.println(al);
    }

    public void AddPrice()
    {
        Scanner sobj = new Scanner(System.in);

        float price=0.0f;
        Hashtable<String,Float> ht = new Hashtable<String,Float>();
        for(int i=0;i<fobj.length;i++)
        {
            System.out.println("Enter the price of "+fobj[i].getString()+" Flavour");
            price=sobj.nextFloat();
            ht.put(fobj[i].getString(),price);
        }
        
        System.out.println(ht);
    }
}
class Flavors
{
    private String str;

    public Flavors(String str)
    {
        this.str=str;
    }

    public String getString()
    {
        return this.str;
    }
}