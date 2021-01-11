package tri.JavSum;

import java.util.*;

class IntStr implements Comparable<IntStr> 
{
	String str;
	int val;
	
	IntStr(int val, String str)
	{
		this.val = val;
		this.str = str;
	}
	
	@Override
	public int compareTo(IntStr obj)
	{
		 //return obj.val - this.val;
		return obj.str.compareTo(this.str);
	}
	
}

public class JavaMap
{
	static void sortHashMap()
	{
		Map< Integer, String> map=new HashMap<Integer, String>();

		map.put(101, "Hemendra");
		map.put(99, "Andrew");
		map.put(103, "Anish");
		map.put(18, "Mohan");
		map.put(11, "Christine");
		map.put(109, "Rebeca");
		map.put(111, "David");
		map.put(19, "Rahim");
		map.put(10, "Krishna");
    
	    PriorityQueue<IntStr> heap = new PriorityQueue<IntStr>();
	    
	    for(var e: map.entrySet())
	    {
	    	IntStr cur = new IntStr(e.getKey(), e.getValue());
	    	heap.offer(cur);
	    }
    
	    while(!heap.isEmpty())
	    {
	    	IntStr top = heap.poll();
	    	System.out.print(top.val+ "=" + top.str + ", ");
	    }
	}


	public static void main(String[] args)
	{
		sortHashMap();

	}

}
