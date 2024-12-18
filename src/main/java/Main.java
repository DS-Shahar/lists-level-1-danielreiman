import java.util.*;
public class Main {
	public static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40};
		
		Node<Integer> head = buildList(array);
	   	System.out.println(head.toString());
	    
	    ex2(head);
	    
	    Node<Integer> newHead = ex3();
	    System.out.println(newHead);
	    
	    ex4(head);
	    
	    System.out.println(ex5(head, 20));
	    
	    head = ex6(head, 20);
	    System.out.println(head.getNext());

	    Node<Integer> lA = new Node<>(1, new Node<>(2, new Node<>(3, null)));
        Node<Integer> lB = new Node<>(1, new Node<>(2, new Node<>(3, null)));

        boolean areTheSame = ex8(lA, lB);
        System.out.println(areTheSame);
        
        ex9(lA, lB);

	Node<Integer> l1 = new Node<>(1, new Node<>(2, new Node<>(3, null)));
	Node<Integer> l2 = new Node<>(3, new Node<>(1, new Node<>(5, null)));

	System.out.println(ex10(l1, l2));
	System.out.println(ex11(l1, l2));

	}
	
	public static Node<Integer> buildList(int[] a) {
		Node<Integer> h = new Node<Integer>(-1);
		Node<Integer> p = h;
		Node<Integer> x;
		
		for (int i = 0; i < a.length; i++) {
			x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		
		return h.getNext();
	}
	
	public static void ex2(Node<Integer> head) {
		
		Node<Integer> p = head;
		
		while (p.hasNext()) {
			System.out.println(p.getValue());
			p = p.getNext();
		}
	}
	
	public static Node<Integer> ex3() {
	    Node<Integer> dhead = new Node<>(-1);
	    Node<Integer> p = dhead;
	    int input = reader.nextInt();
	    while (input != -1) {
		p.setNext(new Node<>(input));
		p = p.getNext();
		input = reader.nextInt();
		
	    }
	    return dhead.getNext();
	}
	
	public static void ex4(Node<Integer> head) {
		Node<Integer> c = head;
	    while (c.getNext() != null) {
		if (c.getValue() % 2 == 0) {
			System.out.println(c.getValue());
		}
		
		c = c.getNext();
	    }
	}
	
	public static boolean ex5(Node<Integer> h, int t) {
	    if (h.getValue() == t) {
		return true;
	    }
	    
	    return ex5(h.getNext(), t);
	}
	
	public static Node<Integer> ex6(Node<Integer> h, int t) {
		h = new Node<Integer>(-1, h);
		Node<Integer> p = h;
		boolean done = false;
		while (!done && p.hasNext()) {
			if (p.getNext().getValue() == t) {
				p.setNext(p.getNext().getNext());
				done = true;
			} else {
				p = p.getNext();
			}
		}
		return h.getNext();
	}
	
	public static Node<Integer> ex7(Node<Integer> head, int x) {
		Node<Integer> c = head;
		int count = 0;
		
		while (c.hasNext()) {
			if (count == x) {
				ex6(head, c.getValue());
				return head;
			}
			
			count++;
			c = c.getNext();
		}
		
		return head;
	}

	public static boolean ex8(Node<Integer> headOfListA, Node<Integer> headOfListB) {
		if (headOfListA == null && headOfListB == null)
			return true;
		
		if (headOfListA.getValue() == headOfListB.getValue())
			return ex8(headOfListA.getNext(), headOfListB);
		
		if (!headOfListA.hasNext() || !headOfListB.hasNext())
			return true;
		
		return ex8(headOfListA, headOfListB.getNext());
	}
	
	public static void ex9(Node<Integer> headOfListA, Node<Integer> headOfListB) {
		if (headOfListA.getValue() == headOfListB.getValue())
			System.out.println(headOfListA.getValue());
		
		if (headOfListA.hasNext() && headOfListB.hasNext())
			ex9(headOfListA.getNext(), headOfListB.getNext());
	}
	
	public static Node<Integer> ex10(Node<Integer> l1, Node<Integer> l2) {
		Node<Integer> dummy = new Node<>(-1);
		Node<Integer> head = dummy;

		Node<Integer> c = l1;

		while (c != null) {
			
			Node<Integer> c2 = l2;
			while (c2 != null) {
				if (c.getValue().equals(c2.getValue())) {
					head.setNext(new Node<>(c2.getValue()));
					
					head = head.getNext();
				}
				
				c2 = c2.getNext();
			}
			
			c = c.getNext();
		}
			 
		return dummy.getNext();
	}
		  public static Node<Integer> ex11(Node<Integer> list1, Node<Integer> list2) {
		    Node<Integer> p = new Node<>(0, list1);
		    Node<Integer> first = p;
		    while (p.hasNext()) {
		      int num = p.getNext().getValue();
		      if (isNumIn(list2, num))
		        p.setNext(p.getNext().getNext());
		      else 
		        p = p.getNext();
		    }
		    return first.getNext();
		  }
	  
	  public static boolean isNumIn(Node<Integer> p, int num) {
		    if (p == null)
		      return false;
		    if (p.getValue() == num)
		      return true;
		    return isNumIn(p.getNext(), num);
		  
}
