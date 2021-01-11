package tri.JavSum;

import java.util.*;

class StrCmp implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2)
	{
		// TODO Auto-generated method stub
		return s1.compareTo(s2);
	}
	
}

class StrCmpIgnoreCase implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2)
	{
		// TODO Auto-generated method stub
		return s1.compareToIgnoreCase(s2);
	}
	
}

public class JavaString
{
    static ArrayList<ArrayList<String>> groupAna(String strArr[])
    {
    	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    	
    	for(String s: strArr)
    	{
    		char arr[] = s.toCharArray();
    		Arrays.sort(arr);
    		String cur = String.valueOf(arr);
    		if(map.containsKey(cur) == false)
    		{
    			map.put(cur, new ArrayList());
    		}
    		map.get(cur).add(s);
    	}
    	
    	return new ArrayList(map.values());
    }
	static List<String> getWordsUseToken(String str)
	{
		List<String> strList = new ArrayList<>();
		StringTokenizer stoken = new StringTokenizer(str);
		
		while(stoken.hasMoreTokens())
		{
			String cur = stoken.nextToken();
			strList.add(cur);
		}
		
		return strList;
	}
	static List<String> getWordsUseScan(String str)
	{
		Scanner sc = new Scanner(str);
		List<String> strList = new ArrayList<>();
		
		while(sc.hasNext())
		{
			String cur = sc.next();
			strList.add(cur);
		}
		
		sc.close();
		return strList;	
	}
	//Extract words with single space between them to the ArrayList.
	static List<String> getWordsUseSplit(String str)
	{
		List<String> strList = new ArrayList<>();

		str = str.trim();
		for(String s: str.split(" "))
		{
			if( !s.equals(" ") && !s.equals(""))
			{
				strList.add(s);
			}
		}
		return strList;
	}
	
	static List<String> getWords(String str)
	{
		List<String> list = new ArrayList<>();
		String arr[] = str.split(" ");
		
		for(int i = 0; i < arr.length; i++)
		{
			if(!arr[i].equals("") && !arr[i].equals(" "))
			{
				list.add(arr[i]);
			}
		}
		
		return list;
	}
	
	static void freqCountArr(String str)
	{
		int arr[] = new int[256];
		
		for(int i = 0; i < str.length(); i++) 
		{
			int num = str.charAt(i);
			arr[num]++;
		}
		for(int a: arr)
		{
			System.out.print(a + " ");
		}
	}
	static void freqCountMap(String str)
	{
		var map = new HashMap<Integer, Integer>();

		for(int i = 0; i < str.length(); i++)
		{
			int num = str.charAt(i);
			if(map.containsKey(num))
			{
				map.put(num, map.get(num) + 1);
			}
			else
			{
				map.put(num, 1);
			}
		}
		
	}
	
	static void longestSub(String str)
	{
		if(str == null || str.length() == 0)
		{
			return;
		}
		char arr[] = str.toCharArray();
		int alpha[] = new int[256];
		
		Arrays.fill(alpha, -1);
		int start = 0;
		int end = 0;
		int left = 0;
		int maxLen = 0;
		
		for(int right = 0; right < arr.length; right++)
		{
			char c = arr[right];
			if(alpha[c] == -1)
			{
				alpha[c] = right;
			}
			else
			{
				left = alpha[c] + 1;
				alpha[c] = right;
			}
			int curLen = right - left + 1;
			if(curLen > maxLen)
			{
				start = left;
				end = right;
				maxLen = curLen;
			}
		}
		System.out.println("Start index: " + start + ", End index: " + end);
	}
	
	static Queue<String> revWords(String str)
	{
		ArrayDeque<String> res = new ArrayDeque<String>();
		
		String strArr[] = str.split(" ");
		int count = 0;
		for(int i = 0; i < strArr.length; i++)
		{
			if(!strArr[i].equals(""))
			{
				if(count == 0)
				{
					res.addFirst(strArr[i]);
				}
				else
				{
					res.addFirst(strArr[i] + " ");
				}
				count++;
			}
		}
		
		return res;
	}
	
	static int makeValid(String str)
	{
		int bal = 0;
		int res = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(c == '(')
			{
				bal = bal + 1;
			}
			else
			{
				bal = bal - 1;
			}
			if(bal == -1)
			{
				res++;
				bal = 0;
			}
		}
		return res + bal;
	}
	
	static void sortStrIgnoreCase(List<String> strList)
	{
		Collections.sort(strList, String::compareToIgnoreCase);
	}
	static void sortStr(List<String> strList)
	{
		Collections.sort(strList);
	}
	
	static String swap(String str, int i, int j)
	{
		char cArr[] = str.toCharArray();
		
		char tmp = cArr[i];
		cArr[i] = cArr[j];
		cArr[j] = tmp;
		
		return String.valueOf(cArr);
	}
	static void permu(String str, int left, int right)
	{
		if(left == right)
		{
			System.out.println(str);
			return;
		}
		else
		{
			for(int i = left; i <= right; i++)
			{
				str = swap(str, left, i);
				permu(str, left + 1, right);
				str = swap(str, left, i);
			}
		}
	}
	
	static void powerSet(String str)
	{
		char cArr[] = str.toCharArray();
		int n = cArr.length;
		int powerSize = (1 << n);
		
		// Run a loop from 0 to 2^n
		for (int i = 0; i < powerSize; i++)
		{
			System.out.print("{ ");
			int m = 1; // m is used to check set bit in binary representation.
			// Print current subset
			for (int j = 0; j < n; j++)
			{
				if ((i & m) > 0)
				{		
					System.out.print(cArr[j] + " ");
				}
				m = 1 << m;
			}
			
			System.out.println("}");
		}
	}
	public static void main(String[] args)
	{
		String str = "ABC";
		
		powerSet(str);
	}

}
