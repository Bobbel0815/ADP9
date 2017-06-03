import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DijkstraList implements Graph {

	private Map<Integer, Knoten> nachbarn = new HashMap<>();
	private ArrayList<Knoten> graph = new ArrayList<Knoten>();

@Override
public void knotenHinzufuegen(Knoten knoten) {
	if(nachbarn.containsKey(knoten)){
		
	}
	
	
}

	@Override
	public void knotenEntfernen(Knoten knoten) {
		// TODO Auto-generated method stub

	}

	@Override
	public void kanteEinfuegen(Knoten knoten1, Knoten knoten2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void kanteEntfernen(Knoten knoten1, Knoten knoten2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void traversieren() {
		// TODO Auto-generated method stub

	}

	@Override
	public int anzahlKnoten() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int anzahlKanten() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void GraphLöschen() {
		// TODO Auto-generated method stub

	}

	public static void Main(String[] args) {
		Knoten knotenA = new Knoten("A");
		Knoten knotenB = new Knoten("B");
		Knoten knotenC = new Knoten("C");
		Knoten knotenD = new Knoten("D");
		Knoten knotenE = new Knoten("E");

		knotenA.addStrecke(knotenA, 0);
		knotenB.addStrecke(knotenA, 5);
		knotenA.nachbarKnoten(knotenB, 5);
	}
}
