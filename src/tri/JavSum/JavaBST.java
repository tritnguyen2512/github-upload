package tri.JavSum;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class BinNode 
{
    int key;
    BinNode left, right;
    BinNode(int x)
    {
        key = x;
        left = right = null;
    }
}
class NodeInt
{
	BinNode bn;
	int index;
	
	NodeInt(BinNode bn, int index)
	{
		this.bn = bn;
		this.index = index;
	}
}

public class JavaBST
{

	static boolean findSum(BinNode root)
	{
		ArrayDeque<BinNode> q = new ArrayDeque<BinNode>();
		
		if(root == null)
		{
			return false;
		}
		q.offer(root);
		while(!q.isEmpty())
		{
			
		}
		
		
		return false;
	}
	/*
	 *                                   10
	 *                               8         20
	 *                          4       9   11      30
	                                             25    35
	*/
	static BinNode buildBST()
	{
		BinNode root = new BinNode(10);  
        root.left = new BinNode(8);  
        root.right = new BinNode(20);  
        root.left.left = new BinNode(4);
        root.left.right = new BinNode(9);
        root.right.left = new BinNode(11);
        root.right.right = new BinNode(30);  
        root.right.right.left = new BinNode(25);
        root.right.right.right = new BinNode(35);
        
        return root;
	}
	
	static int calcWidth(BinNode root)
	{
		ArrayDeque<NodeInt> q = new ArrayDeque<NodeInt>();
		
		if(root == null)
		{
			return 0;
		}
		q.offer(new NodeInt(root, 0));
		
		int max = 0;
		while(!q.isEmpty())
		{
			NodeInt cur = null;
			int size = q.size();
			NodeInt head = q.peek();
			
			for(int i = 0; i < size; i++)
			{
				cur = q.poll();
				if(cur.bn.left != null)
				{
					q.offer(new NodeInt(cur.bn.left, cur.index * 2));
				}
				if(cur.bn.right != null)
				{
					q.offer(new NodeInt(cur.bn.right, cur.index * 2 + 1));
				}
			}
			max = Math.max(max, cur.index - head.index + 1);
		}
		
		return max;
	}
	
	static void inOrder(BinNode root)
	{
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
	


    static int widthOfBinaryTree(BinNode root) 
    {
        if (root == null)
            return 0;

        // queue of elements [(node, col_index)]
        LinkedList<NodeInt> queue = new LinkedList<>();
        Integer maxWidth = 0;

        queue.addLast(new NodeInt(root, 0));
        while (queue.size() > 0) {
            NodeInt head = queue.getFirst();

            // iterate through the current level
            Integer currLevelSize = queue.size();
            NodeInt elem = null;
            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                BinNode node = elem.bn;
                if (node.left != null)
                    queue.addLast(new NodeInt(node.left, 2 * elem.index));
                if (node.right != null)
                    queue.addLast(new NodeInt(node.right, 2 * elem.index + 1));
            }

            // calculate the length of the current level,
            //   by comparing the first and last col_index.
            maxWidth = Math.max(maxWidth, elem.index - head.index + 1);
        }

        return maxWidth;
    }
	
     static int maxWidth(BinNode root)
     {
        if(root==null)
        	return 0;
        Queue<BinNode> q=new LinkedList<>();
        q.add(root);
        int res=0;
        while(q.isEmpty()==false)
        {
            int count=q.size();
            res=Math.max(res,count);
            for(int i=0;i<count;i++){
                BinNode curr=q.poll();
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return res;
    }
	
     static int heightBinTree(BinNode root)
     {
    	 if(root == null)
    	 {
    		 return 0;
    	 }
    	 int lh = heightBinTree(root.left);
    	 int rh = heightBinTree(root.right);
    	 
    	 
    	 return 1 + Math.max(lh, rh);
     }
     
     static void printKlevel(BinNode root, int k)
     {
    	 if(root == null)
    	 {
    		 return;
    	 }
    	 if(k == 0)
    	 {
    		 System.out.print(root.key + " ");
    		 return;
    	 }
    	 printKlevel(root.left, k-1);
    	 printKlevel(root.right, k-1);
    	 return;
    	 
     }
	static void  printLevel(BinNode root)
	{
		var q = new ArrayDeque<BinNode>();
		
		if(root == null)
		{
			return;
		}
		q.add(root);
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				BinNode head = q.poll();
				System.out.print(head.key + " ");
				
				if(head.left != null)
				{
					q.add(head.left);
				}
				if(head.right != null)
				{
					q.add(head.right);
				}
			}
			System.out.println();
		}
		
	}
	

	static int totalNodes(BinNode root)
	{
		if(root == null)
		{
			return 0;
		}

		return 1 + totalNodes(root.left) + totalNodes(root.right);
	}
	
	static int maxBST(BinNode root)
	{
		if(root == null)
		{
			return 0;
		}
		BinNode cur = root;
		
		while(cur != null && cur.right != null)
		{
			cur = cur.right;
		}
		return cur.key;
	}

	
	static int maxBinTree(BinNode root)
	{
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		return Math.max(root.key, Math.max(maxBinTree(root.left), maxBinTree(root.right)));
	}
	
	
	static public void main(String[] args)
	{
		BinNode root = buildBST();
		
		int max = maxBinTree(root);
		System.out.println(max);
	}

}
