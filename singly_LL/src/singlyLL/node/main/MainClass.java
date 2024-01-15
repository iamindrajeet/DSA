package singlyLL.node.main;

import singlyLL.node.singlyll.SinglyLinkedList;

public class MainClass {
	public static void main(String args[]) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.createSinglyLinkedList(5);
		//System.out.println(singlyLinkedList.head.value);
		singlyLinkedList.insertInLinkedList(6, 1);
		singlyLinkedList.insertInLinkedList(7, 3);
		singlyLinkedList.insertInLinkedList(8, 4);
		singlyLinkedList.insertInLinkedList(9, 0);
		//System.out.println(singlyLinkedList.head.next.next.value);
		singlyLinkedList.traverseSinglyLL();
		System.out.println();
		int position = singlyLinkedList.searchSinglyLL(0);
		if(position != 0)
			System.out.println("Node value found at position " + position);
		else
			System.out.println("Node not present with specified value");
		singlyLinkedList.deletionSinglyLL(4);
		singlyLinkedList.traverseSinglyLL();
		System.out.println();
		singlyLinkedList.deleteEntireSLL();
		singlyLinkedList.traverseSinglyLL();
	}
}
