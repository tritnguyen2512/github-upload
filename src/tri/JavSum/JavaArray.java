package tri.JavSum;

import java.util.*;

public class JavaArray
{
	static ArrayList<Integer> sumUp(int arr[])
	{
		int start = 0;
		int sum = 0;
		var res = new ArrayList<Integer>();
		
		for(int i = 1; i < arr.length; i++)
		{
			sum = 0;
			for(int j = 0; j < i; j++)
			{
				if(start < arr.length)
					sum += arr[start++];
				else
					break;
			}
			if(start < arr.length)
				res.add(sum);
			else
				break;
		}
		if(sum > 0)
			res.add(sum);
		return res;
	}
	
	static int min(int arr[])
	{
		int len = arr.length;
		if(len == 1)
		{
			return arr[0];
		}
		if(arr[0] < arr[len-1])
		{
			return arr[0];
		}
		int l = 0;
		int r = len - 1;
		
		while(l <= r)
		{
			int mid = l + (r-l)/2;
			
			if(arr[mid] < arr[mid-1])
			{
				return arr[mid];
			}
			if(arr[mid] > arr[mid+1])
			{
				return arr[mid+1];
			}
			if(arr[mid] < arr[l])
			{
				r = mid-1;
			}
			else
			{
				l = mid+1;
			}
		}
		
		return arr[r];
	}
	
	static void swap(List<Integer> arr, int pos1, int pos2)
	{
		int p1 = arr.get(pos1);
		int p2 = arr.get(pos2);
		arr.set(pos1, p2);
		arr.set(pos2, p1);

	}
	static void permu(List<Integer> arr, int start, int end, List<List<Integer>> res)
	{
		if(start == end)
		{
			res.add(new ArrayList<Integer>(arr));
			return;
		}
		for(int i = start; i <= end; i++)
		{
			swap(arr, start,i);
			permu(arr, start+1, end, res);
			swap(arr, start, i);
			
		}
	}
  
	static List<List<Integer>> getPermutations(List<Integer> arr) 
	{
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		
		permu(arr, 0, arr.size() - 1, res);
		
		return res;
	}
	
	static void combSumRec(int arr[], LinkedList<Integer> comb, int start, int remain, List<List<Integer>> res)
	{
		if(remain == 0)
		{
			res.add(new ArrayList<Integer>(comb));
			return;
		}
		if(remain < 0)
		{
			return;
		}
		for(int i = start; i < arr.length; i++)
		{
			comb.add(arr[i]);
			combSumRec(arr, comb, i, remain - arr[i], res);
			comb.removeLast();
		}
	}
	
	static List<List<Integer>> combSum(int arr[], int target)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		LinkedList<Integer> comb = new LinkedList<Integer>();
		
		combSumRec(arr, comb, 0, target, res);
		return res;
	}
	
	static ArrayDeque<Integer> findMaxSlidingWindow(int arr[], int k)
	{
		ArrayDeque<Integer> list = new ArrayDeque<Integer>();
		ArrayDeque<Integer> res = new ArrayDeque<Integer>();
		
		if(arr.length < k)
		{
			return res;
		}
		for(int i = 0; i < k; i++)
		{
			while(!list.isEmpty() && arr[i] >= arr[list.peekLast()])
			{
				list.removeLast();
			}
			list.add(i);
		}
		for(int j = k ; j < arr.length; j++)
		{
			res.add(arr[list.peek()]);
			
			while(!list.isEmpty() && (j-k) >= list.peek() )
			{
				list.removeFirst();
			}
			
			while(!list.isEmpty() && arr[j] >= arr[list.peekLast()])
			{
				list.removeLast();
			}
			list.add(j);
		}
		
		res.add(arr[list.peek()]);
		
		return res;
	}
	
	static int binarySearchRotated(int[] arr, int key) 
	{
		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0;
		
		while(lo <= hi)
		{
			mid = lo + (hi-lo)/2;
			
			if(arr[mid] == key)
			{
				return mid;
			}

			if(arr[lo] < arr[mid])
			{
				if(key >= arr[lo] && key < arr[mid])
				{
					hi = mid - 1;
				}
				else
				{
					lo = mid + 1;
				}
			}
			else
			{
				if(key > arr[mid] && key <= arr[hi])
				{
					lo = mid + 1;
				}
				else
				{
					hi = mid - 1;
				}
			}
		}
		
	return -1;
	}
	public static void main(String[] args)
	{
	    int[] v1 = {6, 7, 1, 2, 3, 4, 5};
	    System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
	    System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));
	    
	    int[] v2 = {4, 5, 6, 1, 2, 3};
	    System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
	    System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));
		
	}

}
