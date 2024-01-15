package circularDoublyLL;

public class Main {
	public static void main(String[] args) {
		CircularDoublyLL circularDoublyLL = new CircularDoublyLL();
		circularDoublyLL.createCDLL(3);
		System.out.println(circularDoublyLL.head.value);
		circularDoublyLL.insertInCDLL(4, 0);
		circularDoublyLL.insertInCDLL(6, 1);
		circularDoublyLL.insertInCDLL(10, 9);
		System.out.println(circularDoublyLL.head.value);
		circularDoublyLL.traverseCDLLForward();
		circularDoublyLL.traverseCDLLReverse();
		circularDoublyLL.searchInCDLL(10);
		circularDoublyLL.deleteFromCDLL(1);
		circularDoublyLL.traverseCDLLForward();
		circularDoublyLL.deleteCDLL();
		circularDoublyLL.traverseCDLLForward();
	}

}
