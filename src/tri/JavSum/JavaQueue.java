package tri.JavSum;
import java.util.*;


class TriStack
{
	ArrayDeque<Integer> q1;
	ArrayDeque<Integer> q2;
	
	TriStack()
	{
		q1 = new ArrayDeque<Integer>();
		q2 = new ArrayDeque<Integer>();
	}
	boolean isEmpty()
	{
		return q1.isEmpty();
	}
	int size()
	{
		return q1.size();
	}
	int top()
	{
		if(!q1.isEmpty())
			return q1.peek();
		else
			return -1;
	}
	int pop()
	{
		return q1.poll();
	}
	void push(int num)
	{
		if(q1.isEmpty())
		{
			q1.offer(num);
		}
		else
		{
			q2.offer(num);
			while(!q1.isEmpty())
			{
				q2.offer(q1.poll());
			}
			while(!q2.isEmpty())
			{
				q1.offer(q2.poll());
			}
		}
	}
}
public class JavaQueue
{

	
	public static void main(String[] args)
	{
		TriStack st = new TriStack();
		
		System.out.println(st.size());
		st.push(12);
		st.push(23);
		st.push(3);
		st.push(77);
		System.out.println(st.size());
		System.out.println(st.pop());
		System.out.println(st.pop());


	}

}
