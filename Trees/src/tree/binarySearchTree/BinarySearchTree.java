package tree.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public BSTNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	// insert in BST
	private BSTNode insertInBST(BSTNode currentNode, int value) {
		if (currentNode == null) {
			BSTNode newNode = new BSTNode();
			newNode.value = value;
			newNode.left = newNode.right = null;
			System.out.println("Node with value " + value + " inserted successfully!!!");
			return newNode;
		}
		// check if the value to be inserted is less than or equal to the currentNode
		// value then
		// insert as left child
		else if (value <= currentNode.value) {
			currentNode.left = insertInBST(currentNode.left, value); // ------> O(N/2)
			return currentNode;
		}
		// check if the value to be inserted is greater than the currentNode value then
		// insert as right child
		else {
			currentNode.right = insertInBST(currentNode.right, value);// ------> O(N/2)
			return currentNode;
		}
	}

	public void insertInBST(int value) {
		BSTNode rootNode = insertInBST(root, value);
		root = rootNode;

	}

	// pre-order traversal
	public void preOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.value + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	// in-order traversal
	public void inOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		} else {
			inOrderTraversal(node.left);
			System.out.print(node.value + " ");
			inOrderTraversal(node.right);
		}
	}

	// post-order traversal
	public void postOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		} else {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.value + " ");
		}
	}

	// level-order traversal
	public void levelOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		} else {
			Queue<BSTNode> queue = new LinkedList<>();
			queue.add(node);
			while (!queue.isEmpty()) {
				BSTNode presentNode = queue.remove();
				System.out.print(presentNode.value + " ");
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}

		}
	}

	// search in BST
	public void searchInBST(BSTNode node, int value) {
		if (node == null) {
			System.out.println(value + " is not present in BST!!!!");
			return;
		} else {
			if (node.value == value) {
				System.out.println(value + " is present in BST!!!!");
				return;
			} else if (value <= node.value) {
				searchInBST(node.left, value);
			} else {
				searchInBST(node.right, value);
			}
		}
	}

	// find successor of the given node(minimum node in right subtree)
	public static BSTNode minimumNode(BSTNode root) {
		if (root.left == null) {
			return root;
		} else {
			return minimumNode(root.left);
		}
	}

	// delete node in BST
	public BSTNode deleteFromBST(BSTNode root, int value) {
		if (root == null) {
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.value) {
			root.left = deleteFromBST(root.left, value);
		} else if (value > root.value) {
			root.right = deleteFromBST(root.right, value);
		} else {
			// if node to be deleted has 2 children
			if (root.left != null && root.right != null) {
				BSTNode temp = root;
				BSTNode minNodeForRight = minimumNode(temp.right);
				root.value = minNodeForRight.value;
				root.right = deleteFromBST(root.right, minNodeForRight.value);
			}
			// if node to be deleted has 1 child
			else if (root.left != null) {
				root = root.left;
			} else if (root.right != null) {
				root = root.right;
			}
			// if node to be deleted is leaf node
			else
				root = null;
		}
		return root;
	}
	
	public void deleteEntireBST() {
		root = null;
		System.out.println("BST has been deleted successfully!!!");
	}
}
