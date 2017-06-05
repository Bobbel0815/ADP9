
import java.util.ArrayList;
import java.util.List;


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
		Knoten EntfKnoten = null;
		for (int i = 0; i < graphList.size(); i++) {
			if (knoten != graphList.get(i)) {
				kanteEntfernen(knoten, graphList.get(i));
			}
			graphList.remove(knoten);

		}
	}

	@Override
	public String toString() {
		String returnValue = "";
		for (int i = 0; i < graphList.size(); i++) {
			returnValue += graphList.get(i) + "\n";
		}
		return returnValue;
	}

	@Override
	public void kanteEntfernen(Knoten knoten1, Knoten knoten2) {
		Knoten knotenKante = null;
		for (int i = 0; i < knoten1.adjazenzListe.size(); i++) {
			knotenKante = knoten1.adjazenzListe.get(i).getZiel();
			if (knotenKante == knoten2) {
				knoten1.adjazenzListe.remove(i);
				continue;
			}
		}
		for (int j = 0; j < knoten2.adjazenzListe.size(); j++) {
			knotenKante = knoten2.adjazenzListe.get(j).getZiel();
			if (knotenKante == knoten1) {
				knoten2.adjazenzListe.remove(j);
				continue;

			}
		}
		System.out.println("Kante zwischen "+knoten1.getName()+" und "+knoten2.getName()+" entfernt.");
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
	public void graphLöschen() {
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
	public void kanteEinfuegen(Knoten knoten1, Knoten knoten2, int gewicht) {
		if (graphList.contains(knoten1)) {
			knoten1.adjazenzListe.add(0, new Kante(knoten2, gewicht));
			knoten2.adjazenzListe.add(0, new Kante(knoten1, gewicht));
		}

	}

	public int anzahlKanten(Knoten knoten) {
		return knoten.adjazenzListe.size();
	}


	@Override
	public int getGewicht(Knoten knoten1, Knoten knoten2) {
		int gewicht = -1;
	//	for (int i = 0; i < knoten1.adjazenzListe.size(); i++) {
			//if (knoten1.adjazenzListe.get(i).getZiel() == knoten2) {
		int index = getIndexInAdjListe(knoten1,knoten2);
		if(index != -1){
		gewicht = knoten1.adjazenzListe.get(getIndexInAdjListe(knoten1,knoten2)).getGewicht();

			//}
		//}
		}
		return gewicht;
	}

	@Override
	public int getAnzahlKnoten() {
		return graphList.size();
	}

	@Override
	public int getAnzahlKanten() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getIndexInAdjListe(Knoten knoten1, Knoten knoten2) {
		int index = -1;
		
		if ((knoten1.adjazenzListe.size()) < (knoten2.adjazenzListe.size())) {
			
			for (int i = 0; i < knoten1.adjazenzListe.size(); i++) {
				if (knoten1.adjazenzListe.get(i).getZiel() == knoten2) {
					index = i;
					continue;
					
				}
				
			}
		} else {
			for (int i = 0; i < knoten2.adjazenzListe.size(); i++) {
				if (knoten2.adjazenzListe.get(i).getZiel() == knoten1) {
					index =i;
					continue;
					
				}
			}
			
		}
		return index;
	}

	public static void main(String[] args) {

		Graph graph = new Adjazenzliste();

//		Knoten a = new Knoten("A");
//		Knoten b = new Knoten("B");
//		Knoten c = new Knoten("C");
//		Knoten d = new Knoten("D");
//		Knoten e = new Knoten("E");
//
//		graph.knotenHinzufuegen(a);
//		graph.knotenHinzufuegen(b);
//		graph.knotenHinzufuegen(c);
//		graph.knotenHinzufuegen(d);
//		graph.knotenHinzufuegen(e);
//		graph.kanteHinzufügen(a, b, 2);
//		graph.kanteHinzufügen(b, c, 2);
//		graph.kanteHinzufügen(a, d, 4);
//		System.out.println(graph);
//		graph.kanteEntfernen(a, b);
//		System.out.println("Gewicht zwischen " + a.getName() + " und " + b.getName() + " = " + graph.getGewicht(a, b));
//		graph.knotenEntfernen(a);

		

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
		
//    	graph.kanteHinzufügen(A, B, 5);
//		graph.kanteHinzufügen(B, C, 4);
//		graph.kanteHinzufügen(A, C, 12);
//		
//		graph.kanteHinzufügen(E, C, 2);
//    	

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
		
		//System.out.println(graph);
     
	
		dijkstra.computePaths(A); // run Dijkstra
    
    
       
        System.out.println("Distance to " + H + ": " + H.getMinWeg());
        List<DijkstraKnoten> path = dijkstra.getShortestPathTo(H);
        
        dijkstra.printPath(path,H);
//        for(int i=0;i<path.size();i++){
//        System.out.print(path.get(i).getName()+" "+path.get(i).getMinWeg());
//        }
	}

	@Override
	public ArrayList<Knoten> getAllKnoten() {
		
		return graphList;
	}

	@Override
	public ArrayList<Kante> getNachbarn(Knoten knoten) {
		ArrayList<Knoten> nachbarn = new ArrayList<Knoten>();
		
		for(int i=0;i<graphList.size();i++){
			if(graphList.get(i) == knoten){
				return graphList.get(i).adjazenzListe;
			}
		}
		
		return null;
	}

//	 @Override
//	    public ArrayList<Kante> getNachbarn(Knoten knoten)
//	    {
//	        ArrayList<Kante> result = null;
//	        if (graphList.contains(knoten))
//	        {
//	            List<Kante> verbindungen = knoten.adjazenzListe;
//	            result = new ArrayList<Kante>() ;
//	 
//	            for (int i = 0; i < result.size(); i++)
//	            {
//	                result.add(i, verbindungen.get(i).getZiel()) ;
//	            }
//	        }
//	        return result;
//	    }
	
	
	
}
