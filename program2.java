/*
Create two singly linked lists for string data (Do Not allow duplicates elements in one list).
perform

a.Union
b.Intersection
c.Exit
 */
import java.util.*;

class program2 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);

        int size1=0,size2=0;
        System.out.println("How Many details u want to enter in 1st Linked List : ");
        size1=sobj.nextInt();
        System.out.println("How Many details u want to enter in 2nd Linked List : ");
        size2=sobj.nextInt();

        String str;

        LinkedList<String> lobj = new LinkedList<String>();
        LinkedList<String> lobj1 = new LinkedList<String>();

        SinglyLL s[] = new SinglyLL[size1];
        SinglyLL s1[] = new SinglyLL[size2];

        System.out.println("Enter the String in 1st Linked list : ");
        for(int i=0;i<s.length;i++)
        {
            System.out.println("Enter the "+(i+1)+" String : ");
            str=sobj.next();

            if(lobj.contains(str))
            {
                System.out.println("Duplicates Not Allowed Please Enter Another String : ");
                str=sobj.next();
                s[i]=new SinglyLL(str);
                lobj.add(s[i].str);
            }
            else
            {
                s[i]=new SinglyLL(str);
                lobj.add(s[i].str);
            }
        }

        System.out.println("Enter the String in 2nd Linked list : ");
        for(int i=0;i<s1.length;i++)
        {
            System.out.println("Enter the "+(i+1)+" String : ");
            str=sobj.next();
            s1[i]=new SinglyLL(str);
            lobj1.add(s1[i].str);
        }

        System.out.println("Elements in 1st LL : ");
        Iterator it = lobj.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        System.out.println("Elements in 2nd LL : ");
        Iterator it1 = lobj1.iterator();

        while(it1.hasNext())
        {
            System.out.println(it1.next());
        }

        LinkedList<String> l = new LinkedList<String>();

        System.out.println("Intersection is : ");

        Iterator t = lobj.iterator();
        Iterator t1 = lobj1.iterator();

        while(t.hasNext())
        {
            Object b= t.next();
            if(lobj1.contains(b))
            {
                l.add((String)b);
            }
        }

        Iterator i = l.iterator();

        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        System.out.println("Union is : ");

        LinkedList<String> l1 = new LinkedList<String>();
        Iterator e = lobj.iterator();
        Iterator f = lobj1.iterator();

        while(e.hasNext())
        {
            Object a= e.next();
            l1.add((String)a);
        }

        while(f.hasNext())
        {
            Object u=f.next();
            if(l1.contains(u))
            {

            }
            else
            {
                l1.add((String)u);
            }
        }

        Iterator p = l1.iterator();

        while(p.hasNext())
        {
            System.out.println(p.next());
        }
    }  
}
class SinglyLL
{
    public String str;

    public SinglyLL(String str)
    {
        this.str=str;
    }
}
