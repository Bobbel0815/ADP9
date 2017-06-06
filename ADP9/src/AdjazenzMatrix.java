import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjazenzMatrix implements Graph {

	private static int counterGetNachbarn=0;
	private static int counterIstNachbar=0;

	public static int getCounter() {
		return counterGetNachbarn;
	}

	public static void resetCounter() {
		AdjazenzMatrix.counterGetNachbarn = 0;
	}

	private final int DEFAULT_CAPACITY = 10;
	private int numVertices; // number of vertices in the graph
	private int numEdges;
	private int[][] adjMatrix; // adjacency matrix
	private Knoten[] vertices; // values of vertices

	/******************************************************************
	 * Creates an empty graph.
	 ******************************************************************/
	public AdjazenzMatrix() {
		numVertices = 0;
		numEdges = 0;
		this.adjMatrix = new int[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
		this.vertices = new Knoten[DEFAULT_CAPACITY];
	}

	@Override
	public void knotenHinzufuegen(Knoten knoten) {
		if (numVertices == vertices.length)
			expandCapacity();

		vertices[numVertices] = knoten;
		for (int i = 0; i <= numVertices; i++) {
			adjMatrix[numVertices][i] = 0;
			adjMatrix[i][numVertices] = 0;
		}
		numVertices++;
	}

	@Override
	public void knotenEntfernen(Knoten knoten) {

		int index = getIndex(knoten);

		if (indexIsValid(index)) {
			numVertices--;

			for (int i = index; i < numVertices; i++)
				vertices[i] = vertices[i + 1];

			for (int i = index; i < numVertices; i++)
				for (int j = 0; j <= numVertices; j++)
					adjMatrix[i][j] = adjMatrix[i + 1][j];

			for (int i = index; i < numVertices; i++)
				for (int j = 0; j < numVertices; j++)
					adjMatrix[j][i] = adjMatrix[j][i + 1];
		}
	}

	/******************************************************************
	 * Removes a vertex at the given index from the graph. Note that this may
	 * affect the index values of other vertices.
	 ******************************************************************/

	/******************************************************************
	 * Creates new arrays to store the contents of the graph with twice the
	 * capacity.
	 ******************************************************************/
	protected void expandCapacity() {
		Knoten[] largerVertices = new Knoten[vertices.length * 2];
		int[][] largerAdjMatrix = new int[vertices.length * 2][vertices.length * 2];

		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				largerAdjMatrix[i][j] = adjMatrix[i][j];
			}
			largerVertices[i] = vertices[i];
		}

		vertices = largerVertices;
		adjMatrix = largerAdjMatrix;
	}

	public void kanteHinzufügen(int index1, int index2, int gewicht) {
		if (indexIsValid(index1) && indexIsValid(index2)) {
			adjMatrix[index1][index2] = gewicht;
		}
	}

	@Override
	public void kanteEinfuegen(Knoten knoten1, Knoten knoten2, int gewicht) {
		kanteHinzufügen(getIndex(knoten1), getIndex(knoten2), gewicht);
		numEdges++;
	}

	/******************************************************************
	 * Removes an edge between two vertices of the graph.
	 ******************************************************************/
	public void kanteEntfernen(int index1, int index2) {
		if (indexIsValid(index1) && indexIsValid(index2)) {
			adjMatrix[index1][index2] = 0;
		}
	}

	/******************************************************************
	 * Removes an edge between two vertices of the graph.
	 ******************************************************************/
	@Override
	public void kanteEntfernen(Knoten knoten1, Knoten knoten2) {
		kanteEntfernen(getIndex(knoten1), getIndex(knoten2));
		numEdges--;
	}

	@Override
	public void traversieren() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAnzahlKnoten() {
		return numVertices;
	}

	@Override
	public int getAnzahlKanten() {
		return numEdges;
	}

	public int getGewicht(int knoten1, int knoten2) {
		return adjMatrix[knoten1][knoten2];

	}

	@Override
	public int getGewicht(Knoten knoten1, Knoten knoten2) {
		return getGewicht(getIndex(knoten1), getIndex(knoten2));
	}

	@Override
	public void graphLöschen() {
		numVertices = 0;
		numEdges = 0;
		this.adjMatrix = new int[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
		this.vertices = (Knoten[]) (new Object[DEFAULT_CAPACITY]);
	}

	@Override
	public ArrayList<Knoten> getAllKnoten() {
		ArrayList<Knoten> alleKnoten = new ArrayList<Knoten>();

		for (int i = 0; i < numVertices; i++) {
			alleKnoten.add(this.vertices[i]);
		}

		return alleKnoten;
	}

	@Override
	public boolean istNachbar(Knoten knoten, Knoten knoten2) {
		int i = getIndex(knoten);
		for (int j = 0; j < numVertices; j++) {
			counterIstNachbar++;
			if (knoten2.equals(vertices[j])) {
				if (adjMatrix[i][j] != 0) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Kante> getNachbarn(Knoten knoten) {
		int i = getIndex(knoten);
		assert (0 <= i && i < numVertices);
		ArrayList<Kante> nbrs = new ArrayList<Kante>();

		for (int j = 0; j < numVertices; j++) {
			counterGetNachbarn++;
			if (adjMatrix[i][j] != 0) {
				nbrs.add(new Kante(vertices[j], adjMatrix[i][j]));
			}
		}

		return nbrs;
	}

	/******************************************************************
	 * Returns the index value of the first occurrence of the vertex. Returns -1
	 * if the key is not found.
	 ******************************************************************/
	public int getIndex(Knoten knoten) {
		for (int i = 0; i < numVertices; i++)
			if (vertices[i].equals(knoten)) {
				return i;
			}
		return -1;
	}

	/******************************************************************
	 * Returns true if the given index is valid.
	 ******************************************************************/
	protected boolean indexIsValid(int index) {
		return ((index < numVertices) && (index >= 0));
	}

	@Override
	public int anzahlKnoten() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {

		Graph graph = new AdjazenzMatrix();

		// Knoten A = new Knoten("A");
		// Knoten B = new Knoten("B");
		// Knoten C = new Knoten("C");
		// Knoten D = new Knoten("D");
		//
		// graph.knotenHinzufuegen(A);
		// graph.knotenHinzufuegen(B);
		// graph.knotenHinzufuegen(C);
		// graph.knotenHinzufuegen(D);

		// graph.kanteEinfuegen(A, B, 2);
		// graph.kanteEinfuegen(B, C, 2);
		// graph.kanteEinfuegen(A, D, 4);
		// System.out.println(graph);
		// //graph.kanteEntfernen(A, B);
		// System.out.println("Gewicht zwischen " + A.getName() + " und " +
		// B.getName() + " = " + graph.getGewicht(A, B));
		// graph.knotenEntfernen(A);

		Dijkstra dijkstra = new Dijkstra(graph);
		DijkstraKnoten A = new DijkstraKnoten("A");
		DijkstraKnoten B = new DijkstraKnoten("B");
		DijkstraKnoten C = new DijkstraKnoten("C");
		DijkstraKnoten D = new DijkstraKnoten("D");
		DijkstraKnoten E = new DijkstraKnoten("E");
		DijkstraKnoten F = new DijkstraKnoten("F");
		DijkstraKnoten G = new DijkstraKnoten("G");
		DijkstraKnoten H = new DijkstraKnoten("H");

		graph.knotenHinzufuegen(A);
		graph.knotenHinzufuegen(B);
		graph.knotenHinzufuegen(C);
		graph.knotenHinzufuegen(D);
		graph.knotenHinzufuegen(E);
		graph.knotenHinzufuegen(F);
		graph.knotenHinzufuegen(G);
		graph.knotenHinzufuegen(H);

		graph.kanteEinfuegen(A, B, 8);
		graph.kanteEinfuegen(A, C, 2);
		graph.kanteEinfuegen(A, D, 5);

		graph.kanteEinfuegen(B, D, 2);
		graph.kanteEinfuegen(B, F, 13);

		graph.kanteEinfuegen(C, E, 5);
		graph.kanteEinfuegen(C, D, 2);

		graph.kanteEinfuegen(D, F, 6);
		graph.kanteEinfuegen(D, E, 1);
		graph.kanteEinfuegen(D, G, 3);

		graph.kanteEinfuegen(E, G, 1);

		graph.kanteEinfuegen(G, F, 2);
		graph.kanteEinfuegen(G, H, 6);

		graph.kanteEinfuegen(F, H, 3);
		System.out.println(graph.istNachbar(A, H));
		
		
		 dijkstra.computePaths(A); // run Dijkstra
		 System.out.println("cnt getNbr= "+counterGetNachbarn);
		 System.out.println("cnt istNbr= "+counterIstNachbar);
		//
		//
		//
		// System.out.println("Distance to " + H + ": " + H.getMinWeg());
		// List<DijkstraKnoten> path = dijkstra.getShortestPathTo(F);
		//
		// dijkstra.printPath(path,H);

	}

	public static int getCounterGetNachbarn() {
		return counterGetNachbarn;
	}

	public static void setCounterGetNachbarn(int counterGetNachbarn) {
		AdjazenzMatrix.counterGetNachbarn = counterGetNachbarn;
	}

	public static int getCounterIstNachbar() {
		return counterIstNachbar;
	}

	public static void setCounterIstNachbar(int counterIstNachbar) {
		AdjazenzMatrix.counterIstNachbar = counterIstNachbar;
	}

}
