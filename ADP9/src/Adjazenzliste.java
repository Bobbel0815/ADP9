import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.omg.PortableServer.AdapterActivator;

public class Adjazenzliste implements Graph {
	public static ArrayList<Knoten> graphList;

	public Adjazenzliste() {
		graphList = new ArrayList<Knoten>();

	}

	@Override
	public void knotenHinzufuegen(Knoten knoten) {
		if (!graphList.contains(knoten)) {
			graphList.add(knoten);

		}
	}

	@Override
	public void knotenEntfernen(Knoten knoten) {
		Knoten EntfKnoten=null;
		for(int i=0;i<graphList.size();i++){
			if(knoten != graphList.get(i)){
				kanteEntfernen(knoten, graphList.get(i));
			}
				graphList.remove(knoten);
			
			}
	}

	@Override
    public String toString(){
        String returnValue = "";
        for(int i = 0;i<graphList.size();i++){
            returnValue += graphList.get(i) + "\n";
        }
        return returnValue;
	}
	
	@Override
	public void kanteEntfernen(Knoten knoten1, Knoten knoten2) {
		Knoten knotenKante=null;
		for(int i=0;i<knoten1.adjazenzListe.size();i++){
			knotenKante = knoten1.adjazenzListe.get(i).getZiel();
			if(knotenKante == knoten2){
				knoten1.adjazenzListe.remove(i);
				continue;
			}
		}
			for(int j=0;j<knoten2.adjazenzListe.size();j++){
				knotenKante = knoten2.adjazenzListe.get(j).getZiel();
				if(knotenKante == knoten1){
					knoten2.adjazenzListe.remove(j);
					continue;
		
		}
	}
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
	public  void graphLöschen() {
		graphList.clear();

	}
	// @Override
	// public void initKnoten(ArrayList<Knoten> list) { //Djiakstra!
	// Knoten knoten;
	// for (int i = 0; i < list.size(); i++) {
	// knoten = list.get(i);
	// if (i == 0) {
	// knoten.setPred(knoten);
	// knoten.setCost(0);
	// knoten.setMarked(true);
	// }
	// else{
	// knoten.setPred(null);
	// knoten.setCost(Integer.MAX_VALUE);
	// knoten.setMarked(false);
	// }
	// }
	// }

	@Override
	public void kanteHinzufügen(Knoten knoten1, Knoten knoten2, int gewicht) {
		if(graphList.contains(knoten1)){
			knoten1.adjazenzListe.add(0, new Kante(knoten2, gewicht));
			knoten2.adjazenzListe.add(0,new Kante(knoten1,gewicht));
		}
		
	}

	

	public int anzahlKanten(Knoten knoten) {
		return knoten.adjazenzListe.size();
	}

	@Override
	public void initKnoten(ArrayList<Knoten> graphList) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getGewicht(Knoten knoten1, Knoten knoten2) {
		int gewicht=-1;
		for(int i=0;i<knoten1.adjazenzListe.size();i++){
		if (knoten1.adjazenzListe.get(i).getZiel()==knoten2) {
			gewicht= knoten1.adjazenzListe.get(i).getGewicht();
	
		}
		}
		return gewicht;
	}

	@Override
	public int getAnzahlKnoten() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAnzahlKanten() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public static void main(String[] args) {

		Graph graph = new Adjazenzliste();
		
		Knoten a = new Knoten("A");
		Knoten b = new Knoten("B");
		Knoten c = new Knoten("C");
		Knoten d = new Knoten("D");
		Knoten e = new Knoten("E");

		
		graph.knotenHinzufuegen(a);
		graph.knotenHinzufuegen(b);
		graph.knotenHinzufuegen(c);
		graph.knotenHinzufuegen(d);
		graph.knotenHinzufuegen(e);
		graph.kanteHinzufügen(a, b, 2);
		graph.kanteHinzufügen(b, c, 2);
		graph.kanteHinzufügen(a, d, 4);
		System.out.println(graph);
		graph.kanteEntfernen(a, b);
		System.out.println(graph.getGewicht(a, b));
	//graph.knotenEntfernen(a);
	

		
		System.out.println(graph);

		// knotenA.addCost(knotenA, 0);
		// knotenB.addCost(knotenA, 5);
		// knotenA.nachbarKnoten(knotenB, 5);
		//
	}

	

	}

