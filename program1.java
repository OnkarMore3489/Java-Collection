import java.util.*;
class program1
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);

        int size=0;
        System.out.println("How Many details u want to enter : ");
        size=sobj.nextInt();

        String Name[]=new String[size];
        long Mobile[] = new long[size];

        Hashtable<String,Long> ht = new Hashtable<String,Long>();

        for(int i=0;i<size;i++)
        {
            System.out.println("Enter the name of "+(i+1)+" student : ");
            Name[i]=sobj.next();
            System.out.println("Enter the mobile no of "+(i+1)+" student : ");
            Mobile[i]=sobj.nextLong();

            ht.put(Name[i],Mobile[i]);
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
}