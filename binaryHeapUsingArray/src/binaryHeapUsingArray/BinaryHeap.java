package binaryHeapUsingArray;

public class BinaryHeap {
	public int arr[];
	public int sizeOfTree;

	public BinaryHeap(int size) {
		arr = new int[size + 1]; // beacuse we are not using the first index i.e. 0
		this.sizeOfTree = 0;
		System.out.println("Binary Heap created successfully!!!!");
	}

	public boolean isEmpty() {
		if (sizeOfTree == 0)
			return true;
		else
			return false;
	}

	public int peek() {
		if (!isEmpty())
			return arr[1];
		else {
			System.out.println("Binary heap is empty!!");
			return 0;
		}
	}

	// returns the no. of filled cells in array
	public int sizeOfBinaryHeap() {
		return sizeOfTree;
	}

	public void levelOrder() {
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	// Heapify for insert - heapifyBottomToTop
	public void heapifyBottomToTop(int index, String heapType) {
		int parent = index / 2;
		if (index <= 1) {
			return;
		}
		if (heapType.equals("MinHeap")) {
			if (arr[index] < arr[parent]) {
				int temp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		} else if (heapType.equals("MaxHeap")) {
			if (arr[index] > arr[parent]) {
				int temp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		}
		heapifyBottomToTop(parent, heapType); // ------------------------------> O(log N)
	}

	public void insert(int value, String typeOfHeap) {
		arr[sizeOfTree + 1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree, typeOfHeap);
		System.out.println("Inserted " + value + " successfully in heap!!!");
	}

	// Heapify for deletion of root - heapifyTopToBottom
	public void heapifyTopToBottom(int index, String heapType) {
		int leftChildIndex = 2 * index;
		int rightChildIndex = 2 * index + 1;
		int swapChild = 0;
		if (sizeOfTree < leftChildIndex) {
			return;
		}
		if (heapType.equals("MaxHeap")) {
			// we have only 1 child
			if (sizeOfTree == leftChildIndex) {
				if (arr[index] < arr[leftChildIndex]) {
					int temp = arr[index];
					arr[index] = arr[leftChildIndex];
					arr[leftChildIndex] = temp;
				}
				return;
			}
			// we have 2 children
			else {
				if (arr[leftChildIndex] > arr[rightChildIndex]) {
					swapChild = leftChildIndex;
				} else {
					swapChild = rightChildIndex;
				}
				if (arr[index] < arr[swapChild]) {
					int temp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = temp;
				}
			}
		} else if (heapType.equals("MinHeap")) {
			// we have only 1 child
			if (sizeOfTree == leftChildIndex) {
				if (arr[index] > arr[leftChildIndex]) {
					int temp = arr[index];
					arr[index] = arr[leftChildIndex];
					arr[leftChildIndex] = temp;
				}
				return;
			}
			// we have 2 children
			else {
				if (arr[leftChildIndex] < arr[rightChildIndex]) {
					swapChild = leftChildIndex;
				} else {
					swapChild = rightChildIndex;
				}
				if (arr[index] > arr[swapChild]) {
					int temp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = temp;
				}
			}
		}
		heapifyTopToBottom(swapChild, heapType); // ------------------------------> O(log N)
	}
	
	// extract head/root of heap
	public int extractHeadOfBinaryHeap(String heapType) {
		if(isEmpty())
			return -1;
		else {
			int extractedValue = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree--;
			heapifyTopToBottom(1, heapType);
			return extractedValue;
		}
	}
	
	public void deleteEntireBinaryHeap() {
		arr = null;
		System.out.println("Binary heap is deleted successfully!!!");
	}
}
