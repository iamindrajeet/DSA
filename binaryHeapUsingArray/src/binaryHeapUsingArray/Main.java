package binaryHeapUsingArray;

public class Main {
	public static void main(String[] args) {
		BinaryHeap binaryHeap = new BinaryHeap(5);
		binaryHeap.peek();
		binaryHeap.sizeOfBinaryHeap();
		binaryHeap.insert(10, "MinHeap");
		binaryHeap.insert(5, "MinHeap");
		binaryHeap.insert(15, "MinHeap");
		binaryHeap.insert(1, "MinHeap");
		binaryHeap.levelOrder();
		
		binaryHeap.extractHeadOfBinaryHeap("MinHeap");
		binaryHeap.levelOrder();
		
		binaryHeap.deleteEntireBinaryHeap();
	}
}
