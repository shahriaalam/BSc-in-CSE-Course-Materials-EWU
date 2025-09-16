public class EvenOdd extends Thread
{
    int starting;
    EvenOdd(int starting)
    {
        this.starting = starting;
    }

    void display(){
        for (int i = starting; i < 50; i+=2)
        {
            System.out.println(i);
        }
        try
        {
            Thread.sleep(10000);
        }
        catch(Exception e){}
    }

    public void run()
    {
        display();
    }

    public static void main(String[] args)
    {

        EvenOdd n = new EvenOdd(2);
        EvenOdd n1 = new EvenOdd(1);

        n.start();

        try
        {
            n.join();
        }
        catch(Exception e){}

        n1.start();
        try
        {
            n1.join();
        }
        catch(Exception e){}
        System.out.println("Main ends here.");
    }
}