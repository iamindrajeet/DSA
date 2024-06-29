
public class GraphUsingAdjacencyMatrix {
	private int V;
	private boolean[][] adjMatrix;

	public GraphUsingAdjacencyMatrix(int v) {
		V = v;
		adjMatrix = new boolean[V][V];
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adjMatrix[v][w] = true;
		adjMatrix[w][v] = true; // for undirected graph, not for directed graph;
	}

	// A utility function to print the adjacency matrix representation of graph
	void printGraph() {
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (adjMatrix[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		GraphUsingAdjacencyMatrix g = new GraphUsingAdjacencyMatrix(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.printGraph();
	}
}
