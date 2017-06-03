import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.omg.PortableServer.AdapterActivator;

public class Adjazenzliste implements Graph {
	ArrayList<Knoten> graphList;
	
	
	
	public Adjazenzliste(){
		graphList = new ArrayList<Knoten>();
		
	}
	
	
	@Override
	public void knotenHinzufuegen(Knoten knoten) {
		if(!graphList.contains(knoten)){
			graphList.add(knoten);
		}
		}

	

	@Override
	public void knotenEntfernen(Knoten knoten) {
		graphList.remove(knoten);
		
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
		int[] kantenList;
		for(int i =0; i< graphList.size();i++){
			graphList.get(i).;
		}
		return 0;
	}

	@Override
	public void GraphLöschen() {
		// TODO Auto-generated method stub

	}
	@Override
	public void initKnoten(ArrayList<Knoten> list) {
		Knoten knoten;
		for (int i = 0; i < list.size(); i++) {
			knoten = list.get(i);
			if (i == 0) {
				knoten.setPred(knoten);
				knoten.setCost(0);
				knoten.setMarked(true);
			}
			else{
				knoten.setPred(null);
				knoten.setCost(Integer.MAX_VALUE);
				knoten.setMarked(false);
			}
		}
	}

	public static void Main(String[] args) {
		Knoten knotenA = new Knoten("A");
		Knoten knotenB = new Knoten("B");
		Knoten knotenC = new Knoten("C");
		Knoten knotenD = new Knoten("D");
		Knoten knotenE = new Knoten("E");
		
		knotenA.kn
		Graph graph  = new AdjazenzListe();
		
		Map<Integer, Knoten> adjazenzliste = new HashMap<>();
		ArrayList<Knoten> graphList = new ArrayList<Knoten>();
		
		graph.initKnoten(graphList);
		
		knotenA.addCost(knotenA, 0);
		knotenB.addCost(knotenA, 5);
		knotenA.nachbarKnoten(knotenB, 5);
		
		
	}

	@Override
	public void kanteEinfuegen(Knoten knoten1, Knoten knoten2, int gewicht) {
		

	}

	@Override
	public int getAnzahlKnoten() {
		return graphList.size();
	}

	@Override
	public int getAnzahlKanten() {
		return graphList.size();
			
	
	}

	@Override
	public void knotenHinzufuegen() {
		// TODO Auto-generated method stub
		
	}


	
	
}
