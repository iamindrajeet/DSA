package tree.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
	BinaryNode root;

	public AVL() {
		root = null;
	}

	public void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.value + " ");
		inOrder(node.right);
	}

	public void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value + " ");
	}

	public void levelOrder() {
		if (root == null) {
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
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

	public BinaryNode search(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value " + value + " is not found in AVL");
			return null;
		} else if (value < node.value) {
			return search(node.left, value);
		} else if (value > node.value) {
			return search(node.right, value);
		} else {
			System.out.println("Value " + value + " found in AVL");
			return node;
		}
	}

	// getHeight
	private int getHeight(BinaryNode node) {
		if (node == null)
			return 0;
		return node.height;
	}

	// getBalance
	private int getBalance(BinaryNode node) {
		if (node == null)
			return 0;
		return getHeight(node.left) - getHeight(node.right);
	}

	// leftRotation
	private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
		BinaryNode newNode = disbalancedNode.right;
		disbalancedNode.right = disbalancedNode.right.left;
		newNode.left = disbalancedNode;
		disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
		newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
		return newNode;
	}

	// rightRotation
	private BinaryNode rotateRight(BinaryNode disbalancedNode) {
		BinaryNode newNode = disbalancedNode.left;
		disbalancedNode.left = disbalancedNode.left.right;
		newNode.right = disbalancedNode;
		disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
		newNode.height = 1 + Math.max(getHeight(newNode.left), getHeight(newNode.right));
		return newNode;
	}

	private BinaryNode insertNode(BinaryNode node, int nodeValue) {
		if (node == null) {
			BinaryNode newNode = new BinaryNode();
			newNode.value = nodeValue;
			newNode.height = 1;
			return newNode;
		} else if (nodeValue < node.value) {
			node.left = insertNode(node.left, nodeValue);
		} else {
			node.right = insertNode(node.right, nodeValue);
		}
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		int balance = getBalance(node);

		// LL rotation
		if (balance > 1 && nodeValue < node.left.value) {
			return rotateRight(node);
		}

		// LR rotation
		if (balance > 1 && nodeValue > node.left.value) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		// RR rotation
		if (balance < -1 && nodeValue > node.right.value) {
			return rotateLeft(node);
		}

		// RL rotation
		if (balance < -1 && nodeValue < node.right.value) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}

		return node;

	}

	public void insert(int value) {
		root = insertNode(root, value);
	}

	// minimum node
	public static BinaryNode minimumNode(BinaryNode root) {
		if (root.left == null) {
			return root;
		}
		return minimumNode(root.left);
	}

	// delete node
	public BinaryNode deleteNode(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value not found in AVL");
			return node;
		} else if (value < node.value) {
			node.left = deleteNode(node.left, value);
		} else if (value > node.value) {
			node.right = deleteNode(node.right, value);
		} else {
			// if the node to be deleted has 2 children
			if (node.left != null && node.right != null) {
				BinaryNode temp = node;
				BinaryNode minNodeForRight = minimumNode(temp.right);
				node.value = minNodeForRight.value;
				node.right = deleteNode(node.right, minNodeForRight.value);
			}
			// if node to be deleted has only 1 left child
			else if (node.left != null) {
				node = node.left;
				System.out.println("Value deleted successfully!!! ");
			}
			// if node to be deleted has only 1 right child
			else if (node.right != null) {
				node = node.right;
				System.out.println("Value deleted successfully!!! ");
			}
			// if node to be deleted is leaf node
			else {
				node = null;
				System.out.println("Value deleted successfully!!! ");
			}
		}
		int balance = getBalance(node);

		// LL rotation
		if (balance > 1 && getBalance(node.left) >= 0) {
			return rotateRight(node);
		}

		// LR rotation
		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		// RR rotation
		if (balance < -1 && getBalance(node.right) <= 0) {
			return rotateLeft(node);
		}

		// RL rotation
		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

	public void delete(int value) {
		root = deleteNode(root, value);
	}
	
	// delete entire AVL
	public void deleteEntireAVLTree() {
		root = null;
		System.out.println("AVL tree has been deleted successfully!!!");
	}
}
