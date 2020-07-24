import java.util.*;

class MiddleInsert {
    static class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
            this.next = null;
        }
        
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    
	public static void main(String[] args) {
		int[] ele = {0, 1, 2, 3, 4};
		int[] ind = {0, 1, 2, 1, 2};

		Node head = new Node(ele[0]);
		Node curr = head;
		for (int i = 1; i < ele.length; i++) {
		    Node tmp = new Node(ele[i]);
		    curr.next = tmp;
		    curr = curr.next;
		}
		
		for (int i = 0; i < ind.length; i++) {
		    if (i == ind[i])
		        continue;
		        
		    int curPos = i;
		    int newPos = ind[i];
		    
		    Node tmp = head;
		    Node prev = head;
		    for (int j = 0; j < curPos; j++) {
		        prev = tmp;
		        tmp = tmp.next;
		    }
		    
		    prev.next = tmp.next;
		    tmp.next = null;
		    
		    prev = head;
		    Node newtmp = head;
		    for (int j = 0; j < newPos; j++) {
		        prev = newtmp;
		        newtmp = newtmp.next;
		    }
		    
		    tmp.next = prev.next;
		    prev.next = tmp;
		}

		for (Node i = head; i != null; i = i.next) {
			System.out.print(i.val + " ");
		}
	}
}
