package hw2;

import java.util.ArrayList;

public class hwqueue {


private ArrayList<Integer> que=new ArrayList<Integer>();
private int index=0;


public void enqueue(int value)
{
que.add(value);
}

public int dequeue()
{
if(que.isEmpty())
{
System.out.println("Queue is empty");
return -1;
}
else
{
int val=que.get(index);
que.remove(index);
return val;
}
}


public boolean isEmpty()
{
return que.isEmpty();
}


public int size()
{
return que.size();
}


public int front()
{
return que.get(index);
}
public static void main(String[] args) {
hwqueue q=new hwqueue();
q.enqueue(4);
q.enqueue(5);
q.enqueue(6);
System.out.println("The item removed is "+q.dequeue());
q.enqueue(10);
System.out.println("The item at front is "+q.front());
System.out.println("The item removed is "+q.dequeue());
System.out.println("The item removed is "+q.dequeue());
System.out.println("The item removed is "+q.dequeue());
}
  
}