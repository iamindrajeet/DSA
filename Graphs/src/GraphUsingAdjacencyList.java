import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingAdjacencyList {
	private int V;
	private LinkedList<Integer>[] adj;

	public GraphUsingAdjacencyList(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v); // for undirected graph. For directed we can't write this
	}

	public void printGraph() {
		for (int i = 0; i < V; i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.print("head");
			for (int pCrawl : adj[i]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	// A utility function to perform DFS
	// using recursion
	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int n : adj[v]) {
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
//		Iterator<Integer> i = adj[v].listIterator();
//		while (i.hasNext()) {
//			int n = i.next();
//			if (!visited[n])
//				DFSUtil(n, visited);
//		}
	}

	// DFS traversal
	void DFS(int v) {
		boolean[] visited = new boolean[V];
		DFSUtil(v, visited);
	}

	// DFS traversal using stack
	void DFSWithoutRecursion(int v) {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();

		// Push the current source vertex into the stack
		stack.push(v);

		while (!stack.isEmpty()) {
			// Pop a vertex from stack and print it
			v = stack.pop();

			if (!visited[v]) {
				System.out.print(v + " ");
				visited[v] = true;
			}

			// Get all adjacent vertices of the popped vertex v.
			// If an adjacent vertex has not been visited, then push it to the stack.
			Iterator<Integer> iterator = adj[v].iterator();
			while (iterator.hasNext()) {
				int n = iterator.next();
				if (!visited[n]) {
					stack.push(n);
				}
			}
		}
	}

	public void bfs(int s) {
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			// Pop a vertex from stack and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If an adjacent vertex has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	public static void main(String[] args) {
		GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.printGraph();

		System.out.println("DFS starting from vertex 2:");
		g.DFS(2);

		System.out.println();

		GraphUsingAdjacencyList g1 = new GraphUsingAdjacencyList(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 4);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(1, 4);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);

		System.out.println("DFS starting from vertex 2:");
		g1.DFS(2);

		GraphUsingAdjacencyList g2 = new GraphUsingAdjacencyList(5);
		g2.addEdge(0, 1);
		g2.addEdge(0, 4);
		g2.addEdge(1, 2);
		g2.addEdge(1, 3);
		g2.addEdge(1, 4);
		g2.addEdge(2, 3);
		g2.addEdge(3, 4);
		
		System.out.println();


		System.out.println("BFS traversal starting from vertex 2:");
		g2.bfs(2);
	}

}
