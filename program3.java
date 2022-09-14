/*
Write a program to store 'n' numbers of flavors of ice cream. Collection class should not
accept duplicate entries. perform following operation-

a.search for a specific flavour.
b.sort all the flavors.

Accept price for all flavors and create hash table using flavors and prices.(Use existing 
collection class of flavors).

*/

import java.util.*;

class program3 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);
        int size=0;
        System.out.println("How Many Flavors U want to enter : ");
        size=sobj.nextInt();

        Flavors fobj[] = new Flavors[size];

        String str;
        ArrayList<String> al = new ArrayList<String>();

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
        if(bResult==true)
        {
            System.out.println("Flavour is there");
        }
        else
        {
            System.out.println("Flavour is not there");
        }

        Collections.sort(al);
        System.out.println(al);

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