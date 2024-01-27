package tree.binarySearchTree;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insertInBST(70);
		binarySearchTree.insertInBST(50);
		binarySearchTree.insertInBST(90);
		binarySearchTree.insertInBST(30);
		binarySearchTree.insertInBST(60);
		binarySearchTree.insertInBST(80);
		binarySearchTree.insertInBST(100);
		binarySearchTree.insertInBST(20);
		binarySearchTree.insertInBST(40);

		System.out.println("-----------PRE-ORDER TRAVERSAL-----------");
		binarySearchTree.preOrderTraversal(binarySearchTree.root);

		System.out.println();
		System.out.println("-----------IN-ORDER TRAVERSAL-----------");
		binarySearchTree.inOrderTraversal(binarySearchTree.root);

		System.out.println();
		System.out.println("-----------POST-ORDER TRAVERSAL-----------");
		binarySearchTree.postOrderTraversal(binarySearchTree.root);

		System.out.println();
		System.out.println("-----------LEVEL-ORDER TRAVERSAL-----------");
		binarySearchTree.levelOrderTraversal(binarySearchTree.root);
		
		System.out.println();
		binarySearchTree.searchInBST(binarySearchTree.root, 200);
		
		System.out.println();
		binarySearchTree.deleteFromBST(binarySearchTree.root, 90);
		System.out.println();
		System.out.println("-----------LEVEL-ORDER TRAVERSAL-----------");
		binarySearchTree.levelOrderTraversal(binarySearchTree.root);
		
		System.out.println();
		binarySearchTree.deleteFromBST(binarySearchTree.root, 40);
		System.out.println();
		System.out.println("-----------LEVEL-ORDER TRAVERSAL-----------");
		binarySearchTree.levelOrderTraversal(binarySearchTree.root);
		
		System.out.println();
		binarySearchTree.deleteFromBST(binarySearchTree.root, 30);
		System.out.println();
		System.out.println("-----------LEVEL-ORDER TRAVERSAL-----------");
		binarySearchTree.levelOrderTraversal(binarySearchTree.root);
	
		System.out.println();
		binarySearchTree.deleteEntireBST();
		System.out.println();
		System.out.println("-----------LEVEL-ORDER TRAVERSAL-----------");
		binarySearchTree.levelOrderTraversal(binarySearchTree.root);
	}

}
