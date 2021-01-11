package tri.JavSum;

import java.util.*;

class Node
{
	int data;
	Node next;
	Node(int val)
	{
		this.data = val;
		next = null;		
	}
}

public class JavaLinkList
{
    //2,35,22,6,7,9,12,1
    static Node buildList()
    {
		Node head = new Node(2);
		Node n1 = new Node(35);
		Node n2 = new Node(22);
		Node n3 = new Node(6);
		Node n4 = new Node(7);
		Node n5 = new Node(9);
		Node n6 = new Node(12);
		Node n7 = new Node(1);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		return head;
    }
    
    //2,35,22,6,7,9,12,1
    static Node buildListLoop()
    {
		Node head = new Node(2);
		Node n1 = new Node(35);
		Node n2 = new Node(22);
		Node n3 = new Node(6);
		Node n4 = new Node(7);
		Node n5 = new Node(9);
		Node n6 = new Node(12);
		Node n7 = new Node(1);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n3;
		
		return head;
    }
    
    static Node buildPalinList()
    {
		Node head = new Node(2);
		Node n1 = new Node(35);
		Node n2 = new Node(22);
		Node n3 = new Node(6);
		Node n4 = new Node(6);
		Node n5 = new Node(22);
		Node n6 = new Node(35);
		Node n7 = new Node(2);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		return head;
    }    
    
    static void printList(Node head)
    {
    	while(head != null)
    	{
    		System.out.print(head.data + " ");
    		head = head.next;
    	}
    	System.out.println();
    }

    static Node rmNode(Node head, int k)
    {
    	if(head == null)
    	{
    		return head;
    	}
    	Node cur = head;
    	int len = 0;
    	while(cur != null)
    	{
    		len++;
    		cur = cur.next;
    	}
    	Node dummy = new Node(0);
    	dummy.next = head;
    	len = len - k;
    	cur = dummy;
    	while(len > 0)
    	{
    		len--;
    		cur = cur.next;
    	}
    	cur.next = cur.next.next;
    	return dummy.next;
    }
    

	public static void main(String[] args)
	{

	}

}
