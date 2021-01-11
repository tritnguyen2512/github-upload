package tri.JavSum;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;



public class JavaSet
{
	static boolean contains(HashSet<Integer> hash, int value)
	{
		return hash.contains(value);
	}
	
	static void remove(HashSet<Integer> hash, int value)
	{
		hash.remove(value);
	}
	
	static void traverseFor(HashSet<Integer> hash)
	{
		for(var e: hash)
		{
			System.out.print(e + " ");
		}
	}
	
	static void traverseWhile(HashSet<Integer> hash)
	{
		Iterator<Integer> it = hash.iterator();
		while(it.hasNext())
		{
			int cur = it.next();
			System.out.print(cur + " ");
		}
	}
	
	//Collections.sort() cannot use with Set.
	//To sort we can use TreeSet because it will sort when element to be inserted.
	//However, it is not a hash data structure but a Binary Search Tree. So the
	//time to insert and retrieve is O(log n) not O(1) as a hash table.
	public static void main(String[] args)
	{
		var hash = new TreeSet<Integer>();
		
		hash.add(44);
		hash.add(3);
		hash.add(11);
		hash.add(37);
		hash.add(21);
		
		for(var num: hash)
		{
			System.out.print(num + " ");
		}


	}

}
