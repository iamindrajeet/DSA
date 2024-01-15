package doublyLL.main;

import doublyLL.doublyLinkedList.DoublyLL;

public class Main {
	public static void main(String args[]) {
		DoublyLL doublyLL = new DoublyLL();
		doublyLL.createDoublyLL(1);
		doublyLL.insertInDLL(7, 0);
		doublyLL.insertInDLL(5, 1);
		doublyLL.insertInDLL(3, 7);
		//System.out.println(doublyLL.head.value);
		doublyLL.traverseDLL();
		doublyLL.reverseTraverseDLL();
		doublyLL.searchInDLL(3);
		doublyLL.deleteInDLL(1);
		doublyLL.traverseDLL();
		doublyLL.deleteEntireDLL();
		doublyLL.traverseDLL();
	}
}
