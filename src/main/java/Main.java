class Main {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> n1 = new Node<>(7);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(8);

		n1.setNext(n2);
		n2.setNext(n3);
		
		System.out.println(n1);
		
		delNode(n1, 2);
		
		System.out.println(n1);

	}
public static Node<Integer> delNode(Node<Integer> h, int x) {
		Node<Integer> p = new Node<>(-1, h);
		
		while(p.hasNext()) {
			
			Node<Integer> t;
			
			if (p.getNext().getValue() == x) {
				t = p.getNext();
				p.setNext(p.getNext().getNext());
				t.setNext(null);
				return h.getNext();
			}
			
			p = p.getNext();
		}
		
		return p.getNext();
	}
}
