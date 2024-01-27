package tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLinkedList {
	public BinaryNode root;

	public BinaryTreeLinkedList() {
		this.root = null;
	}

	// pre order traversal
	public void preOrder(BinaryNode node) {
		// this is the base condition to stop our recursion
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
		// traversing left subtree
		preOrder(node.left); // time complexity for this line of code is O(N/2)
		// traversing right subtree
		preOrder(node.right); // time complexity for this line of code is O(N/2)
	}

	// pre-order traversal iterative
	public void preOrderTraversal(BinaryNode root) {
		if (root == null)
			return;

		Stack<BinaryNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			BinaryNode node = stack.pop();
			System.out.print(node.value + " ");

			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	// in-order traversal
	public void inOrder(BinaryNode node) {
		// this is the base condition to stop our recursion
		if (node == null) {
			return;
		}
		// traversing left subtree
		inOrder(node.left); // time complexity for this line of code is O(N/2)
		System.out.print(node.value + " ");
		// traversing right subtree
		inOrder(node.right); // time complexity for this line of code is O(N/2)
	}

	// in-order traversal iterative approach
	public void inOrderTraversal(BinaryNode root) {
		Stack<BinaryNode> stack = new Stack<>();
		BinaryNode current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.value + " ");
			System.out.print(current.value + " ");
			current = current.right;
		}
	}

	// post-order traversal
	public void postOrder(BinaryNode node) {
		// this is the base condition to stop our recursion
		if (node == null) {
			return;
		}
		// traversing left subtree
		postOrder(node.left); // time complexity for this line of code is O(N/2)

		// traversing right subtree
		postOrder(node.right); // time complexity for this line of code is O(N/2)
		System.out.print(node.value + " ");
	}

	// post-order traversal iteratively
	public void postOrderTraversal(BinaryNode root) {
		Stack<BinaryNode> stack1 = new Stack<>();
		Stack<BinaryNode> stack2 = new Stack<>();

		if (root != null)
			stack1.push(root);

		while (!stack1.isEmpty()) {
			BinaryNode node = stack1.pop();
			stack2.push(node);

			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
		}

		while (!stack2.isEmpty()) {
			BinaryNode node = stack2.pop();
			System.out.print(node.value + " ");
		}
	}

	// level-order traversal

	// time and space complexity - O(n)
	// space complexity is O(n) because we create a queue to add and remove n nodes
	// to and from it.
	public void levelOrder(BinaryNode node) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		if (node == null) {
			return;
		}
		queue.add(node);
		while (!queue.isEmpty()) { // ------------> this will run n times so time complexity O(n)
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
	}

	// search method
	public void search(String value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.value.equals(value)) {
				System.out.println("The value " + value + " is present in the binary tree");
				return;
			} else {
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}

				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}
		}
		System.out.println("The value " + value + " is not present in the binary tree");
	}

	// insert node
	public void insert(String value) {
		BinaryNode newNode = new BinaryNode();
		newNode.value = value;
		if (root == null) {
			root = newNode;
			System.out.println("Inserted new node at root!!");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.left == null) {
				presentNode.left = newNode;
				System.out.println("Successfully inserted!!!");
				break;
			} else if (presentNode.right == null) {
				presentNode.right = newNode;
				System.out.println("Successfully inserted!!!");
				break;
			} else {
				queue.add(presentNode.left);
				queue.add(presentNode.right);
			}
		}
	}

	// get deeptest node
	public BinaryNode getDeeptestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		return presentNode;
	}

	// delete deepest node from the tree
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.left == null) {
				previousNode.right = null;
				return;
			} else if (presentNode.right == null) {
				previousNode.left = null;
				return;
			}
			queue.add(presentNode.left);
			queue.add(presentNode.right);
		}
	}

	// delete given node
	public void deleteNode(String value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.value == value) {
				presentNode.value = getDeeptestNode().value; // ---------------> O(N)
				deleteDeepestNode(); // -------------> O(N)
				System.out.println("The node is deleted!!");
				return;
			} else {
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}
		}
		System.out.println("The node doesn't exist in binary tree");
	}

	// delete entire binary tree
	public void deleteBinaryTree() {
		root = null;
		System.out.println("Binary tree has been deleted successfully!!!!");
	}
}
