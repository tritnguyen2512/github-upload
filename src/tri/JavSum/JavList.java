package tri.JavSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JavList
{
	//Keep the inserted order.
	static void traverseWhile(List<Integer> list)
	{
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext())
		{
			int cur = it.next();
			System.out.print(cur + " ");
		}
	}
	
	static void traverseFor(List<Integer> list)
	{
		for(int num: list)
		{
			System.out.print(num + " ");
		}
	}
	
	static void strTraverse(List<String> strList)
	{
		var it = strList.iterator();
		while(it.hasNext())
		{
			String cur = it.next();
			System.out.print(cur + " ");
		}
	}
	
	static void contains(List<Integer> list, int target)
	{
		if(list.contains(target))
		{
			System.out.println("Found " + target);
		}
		else
		{
			System.out.println("Not found " + target);
		}
	}
	
	static void remove(List<Integer> list, int index)
	{
		list.remove(index);
	}
	
	static void removeObj(List<Integer> list, int value)
	{
		list.remove(  (Integer) value);
	}
	
	static void remove(List<String> list, String obj)
	{
		list.remove(obj);
	}

	static int get(List<Integer> list, int index)
	{
		return list.get(index);
	}
	
	static void set(List<Integer> list, int index, int newValue)
	{
		list.set(index, newValue);
	}
	//add, remove, set, get, contains, hasNext, next, iterator.
	public static void main(String[] args)
	{
		var list = new ArrayList<Integer>();
		
		list.add(33);
		list.add(3);
		list.add(6);
		list.add(11);
		list.add(7);

		traverseFor(list);
		System.out.println();
		Collections.sort(list);
		traverseWhile(list);
		System.out.println();

		
		var strList = new ArrayList<String>();
		
		strList.add("Hello");
		strList.add("Anh");
		strList.add("Tzda");
		strList.add("Today");
		strTraverse(strList);
		System.out.println();
		
		Collections.sort(strList);
		strTraverse(strList);

	}

}
