package circularLL.src.main;

public class Main {
	public static void main(String args[]) {
		CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
		circularSinglyLinkedList.createCircularLinkedList(5);
		circularSinglyLinkedList.insertIntoCircularSinglyLinkedList(4, 0);
		circularSinglyLinkedList.insertIntoCircularSinglyLinkedList(6, 1);
		circularSinglyLinkedList.insertIntoCircularSinglyLinkedList(7, 8);
		//System.out.println(circularSinglyLinkedList.head.value);
		circularSinglyLinkedList.traverseCSLL();
		System.out.println();
		circularSinglyLinkedList.searchCSLL(5);
		circularSinglyLinkedList.searchCSLL(10);
		circularSinglyLinkedList.deleteFromCSLL(1);
		circularSinglyLinkedList.traverseCSLL();
		circularSinglyLinkedList.deleteEntireCSLL();
		circularSinglyLinkedList.traverseCSLL();
	}
}
