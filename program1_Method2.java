/*
 create Hash table containing Person name and contact number. Display the details of the
 Hashtable. Also search for a specific person and display the contact number of that person.
 */
import java.util.*;

class program1_Method2 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);

        int size=0;

        System.out.println("How Many details u want to enter : ");
        size=sobj.nextInt();

        String Name;
        long Mobile;

        Hashtable<String,Long> ht = new Hashtable<String,Long>();
        Person pobj[] = new Person[size];

        for(int i=0;i<pobj.length;i++)
        {
            System.out.println("Enter the name of "+(i+1)+" student : ");
            Name=sobj.next();
            if(ht.containsKey(Name))
            {
                System.out.println("Do Not Allowed Please Enter Another name : ");
                Name=sobj.next();
            }
            System.out.println("Enter the mobile no of "+(i+1)+" student : ");
            Mobile=sobj.nextLong();

            pobj[i]=new Person(Name,Mobile);
            ht.put(pobj[i].getName(),pobj[i].Mobile());
        }

        Iterator<Map.Entry<String,Long>> it = ht.entrySet().iterator();

        Map.Entry<String,Long> entry =null;
        while(it.hasNext())
        {
            entry=it.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        System.out.println("Enter the name u want to search : ");
        String str=sobj.next();

        Iterator<Map.Entry<String,Long>> i = ht.entrySet().iterator();

        Map.Entry<String,Long> e =null;

        if(ht.containsKey(str))
        {
          while(i.hasNext())
          {
             e=i.next();
             String s=e.getKey();
             if(s.equals(str))
             {
                 System.out.println(e.getKey()+" "+e.getValue());
                 break;
             }
          }
        }
        else
        {
            System.out.println("Name is Not There");
        }
    }
}
class Person
{
    private String Name;
    private long Mobile;

    public Person(String name,long mobile)
    {
        this.Name=name;
        this.Mobile=mobile;
    }

    public String getName()
    {
        return this.Name;
    }
    public long Mobile()
    {
        return this.Mobile;
    }
}
