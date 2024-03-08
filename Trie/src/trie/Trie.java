package trie;

public class Trie {

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
		System.out.println("The trie is created successfully!!!");
	}

	// insert in trie
	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfString = true;
		System.out.println("Successfully inserted " + word + " in trie ");
	}

	// search in trie
	public boolean search(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.children.get(ch);
			if (node == null) {
				System.out.println("Word: " + word + " doesn't exists in Trie!!!");
				return false;
			}
			currentNode = node;
		}
		if (currentNode.endOfString == true) {
			System.out.println("Word: " + word + " exists in Trie!!!");
			return true;
		} else {
			System.out.println("Word: " + word + " doesn't exists in Trie. But it's a prefix of another string!!!");
			return false;
		}
	}

	// delete in trie
	private boolean delete(TrieNode parentNode, String word, int index) {
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;
		// case 1: some other prefix of string is same as the one that we want to delete
		// (API, APPLE)
		if (currentNode.children.size() > 1) {
			delete(currentNode, word, index + 1);// call the next node ,  we are not going to delete 
			return false;
		}

		// case 2: The string is a prefix of some other string(API, APIS)
		if (index == word.length() - 1) { // we are at the last character of the word
			if (currentNode.children.size() >= 1) {
				currentNode.endOfString = false;
				return false;
			} else {
				parentNode.children.remove(ch);
				return true;
			}
		}
		// case 3: other string is a prefix of this string (APIS, AP)
		if (currentNode.endOfString == true) {
			delete(currentNode, word, index + 1);
			return false;
		}
		// case 4: not any node depends on this string
		canThisNodeBeDeleted = delete(currentNode, word, index + 1);
		if (canThisNodeBeDeleted == true) {
			parentNode.children.remove(ch);
			return true;
		} else {
			return false;
		}
	}

	public void delete(String word) {
		if (search(word) == true) {
			delete(root, word, 0);
		}
	}
}
