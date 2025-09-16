public class Final extends Thread
{
    String name;
    Final(String N)
    {
        name=N;
    }
    void display1()
    {
            System.out.println("Thread "+name+" Starting");
    }
void display()
{
    for (int i =0; i<3;i++)
    {
        System.out.println(name+" This is extends Thread class");
    }
}

public void run()
{
    display1();
    display();
    try {
        Thread.sleep(3000);
    }
    catch (Exception e){}
}

    public static void main(String[] args)
    {
        Final F= new Final("one");
        Final Q=new Final("two");
        F.start();
        try
        {
            F.join();
        }
        catch (Exception e){}

        Q.start();
        try
        {
            Q.join();
        }
        catch (Exception e){}
        for (int i =0; i<5;i++)
        {
            System.out.println("This is main class");
        }
        System.out.println("Main class ends");
    }
}
