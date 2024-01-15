package linkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.createLL(11);
		linkedList.insertNode(2);
		linkedList.insertNode(3);
		linkedList.insertNode(2);
		linkedList.insertNode(5);
		linkedList.insertNode(6);
		linkedList.insertNode(10);
		linkedList.traverseLL();
		Questions questions = new Questions();
		questions.deleteDuplicates(linkedList);
		linkedList.traverseLL();
		Node node = questions.nthToLast(linkedList, 4);
		System.out.println(node.value);
		questions.partiton(linkedList, 6);
		linkedList.traverseLL();
		
		LinkedList linkedList1 = new LinkedList();
		linkedList1.insertNode(7);
		linkedList1.insertNode(1);
		linkedList1.insertNode(6);
		
		LinkedList linkedList2 = new LinkedList();
		linkedList2.insertNode(5);
		linkedList2.insertNode(9);
		linkedList2.insertNode(2);
		
		LinkedList newLinkedList = questions.sumLists(linkedList1, linkedList2);
		newLinkedList.traverseLL();
		
		LinkedList linkedList3 = new LinkedList();
		linkedList3.insertNode(3);
		linkedList3.insertNode(1);
		linkedList3.insertNode(5);
		linkedList3.insertNode(9);
		
		LinkedList linkedList4 = new LinkedList();
		linkedList4.insertNode(2);
		linkedList4.insertNode(4);
		linkedList4.insertNode(6);
		
		questions.addSameNode(linkedList3, linkedList4, 7);
		questions.addSameNode(linkedList3, linkedList4, 2);
		questions.addSameNode(linkedList3, linkedList4, 1);
		Node intersection = questions.findIntersection(linkedList3, linkedList4);
		System.out.println("Intersecting node : " + intersection.value);
	}

}
