package hw2;

class ThreadsDemo implements Runnable {

private Thread t;

private String Name; 

ThreadsDemo( String name)

{

Name = name;

System.out.println("Creating " + Name );

}

public void run()
{

System.out.println("Running " + Name ); 

try

{

for(int i = 4; i > 0; i--) {

System.out.println("Thread: " + Name + ", " + i);

Thread.sleep(50);

}

}

catch (InterruptedException e) {

System.out.println("Thread " + Name + " interrupted.");

}

System.out.println("Thread " + Name + " exiting.");

}

public void start () //thread starting method

{

System.out.println("Starting " + Name );

if (t == null) {

t = new Thread (this, Name);

t.start ();

}

}

}

public class threadhw {

public static void main(String args[]) {

ThreadsDemo T1 = new ThreadsDemo( "Thread-1");

T1.start();

ThreadsDemo T2 = new ThreadsDemo( "Thread-2");

T2.start();

ThreadsDemo T3 = new ThreadsDemo( "Thread-3");

T3.start();

}   

}