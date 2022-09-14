/*
Create two singly linked lists for string data (Do Not allow duplicates elements in one list).
perform

a.Union
b.Intersection
c.Exit
 */
import java.util.*;
class program2_Method2 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);

        int size1=0,size2=0;
        System.out.println("How Many details u want to enter in 1st Linked List : ");
        size1=sobj.nextInt();
        System.out.println("How Many details u want to enter in 2nd Linked List : ");
        size2=sobj.nextInt();

        Intersection iobj = new Intersection(size1, size2);
        iobj.Accept();
        
        int choice=1;
        while(choice!=0)
        {
            System.out.println("1.For Union || 2.For Intersection || 0.Exit");

            System.out.println("Enter Your choice : ");
            choice=sobj.nextInt();

            switch(choice)
            {
                case 1:
                       iobj.DisplayUnion();
                       break;
                case 2:
                       iobj.DisplayIntersection();
                       break;
                case 0:System.exit(0);
                       break;
            }
        }
    }   
}
class add
{
    LinkedList<String> lobj=null;
    LinkedList<String> lobj1 =null;
    SinglyLL s[];
    SinglyLL s1[];

    public add(int size1,int size2)
    {
        s=new SinglyLL[size1];
        s1=new SinglyLL[size2];

        lobj = new LinkedList<String>();
        lobj1 = new LinkedList<String>();
    }
    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);
        String str;

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
        System.out.println(lobj);

        System.out.println("Elements in 2nd LL : ");
        System.out.println(lobj1);
    }
}
class Union extends add
{
    LinkedList<String> l1=new LinkedList<String>();

    public Union(int size1,int size2)
    {
        super(size1,size2);
    }

    public void DisplayUnion()
    {
        System.out.println("Union is : ");

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
class Intersection extends Union
{
    LinkedList<String> l=new LinkedList<String>();


    public Intersection(int size1,int size2)
    {
        super(size1,size2);
    }

    public void DisplayIntersection()
    {
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
