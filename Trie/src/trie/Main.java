package trie;

public class Main {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("API");
		trie.insert("APPLE");
		//trie.insert("APIS");
		//trie.search("APIS");
		trie.delete("API");
		trie.search("API");
	}

}
 