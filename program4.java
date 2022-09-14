/*
Create a class student having members roll no,name and age. Use ArrayList to store
information of three student objects. Make use of Comparator interface to perform sorting on
the basis of names and ages and display the result.
 */
import java.util.*;

class program4 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);

        Student s[] = new Student[3];

        ArrayList<Student> al = new ArrayList<Student>();

        int roll_no=0;
        String name;
        int age=0;

        for(int i=0;i<3;i++)
        {
            System.out.println("Enter roll no of "+(i+1)+" Student");
            roll_no=sobj.nextInt();
            System.out.println("Enter name of "+(i+1)+" Student");
            name=sobj.next();
            System.out.println("Enter age of "+(i+1)+" Student");
            age=sobj.nextInt();

            s[i]=new Student(roll_no, name, age);
            al.add(s[i]);
        }

        for(Student ss:al)
        {
            System.out.println("roll_no : "+ss.getrollno()+" name : "+ss.getname()+" age : "+ss.getage());
        }

        Collections.sort(al,new NameComparator());
        System.out.println("Sorting by name : ");
        for(Student ss:al)
        {
            System.out.println("roll_no : "+ss.getrollno()+" name : "+ss.getname()+" age : "+ss.getage());
        }

        
        Collections.sort(al,new AgeComparator());
        System.out.println("Sorting by age : ");
        for(Student ss:al)
        {
            System.out.println("roll_no : "+ss.getrollno()+" name : "+ss.getname()+" age : "+ss.getage());
        }
    }
}
class Student
{
    private int roll_no;
    private String name;
    private int age;

    public Student(int roll_no,String name,int age)
    {
        this.roll_no=roll_no;
        this.name=name;
        this.age=age;
    }
    public int getrollno()
    {
        return this.roll_no;
    }
    public String getname()
    {
        return this.name;
    }
    public int getage()
    {
        return this.age;
    }
}
class NameComparator implements Comparator<Student>
{
    public int compare(Student s1,Student s2)
    {
        return s1.getname().compareTo(s2.getname());
    }
}
class AgeComparator implements Comparator<Student>
{
    public int compare(Student s1,Student s2)
    {
        if(s1.getage()==s2.getage())
        {
            return 0;
        }
        else if(s1.getage()>s2.getage())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}