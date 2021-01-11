package tri.JavSum;


class Pair implements Comparable<Pair>
{
	int val1;
	int val2;
	
	@Override
	public String toString()
	{
		return "[" + val1 + ", " + val2 + "]";
	}
	Pair(int v1, int v2)
	{
		val1 = v1;
		val2 = v2;
	}
	Pair()
	{
		val1 = 0;
		val2 = 0;
	}

	@Override
	public int compareTo(Pair p)
	{
		//Min Heap
		return this.val2 - p.val2;
		
		//Max Heap
		//return p.val2 - this.val2;
	}
}

public class JavaHeap
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
