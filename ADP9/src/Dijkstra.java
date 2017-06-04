import java.util.ArrayList;

public class Dijkstra {

	ArrayList<DijkstraKnoten> DList;
	Graph graph;

	public Dijkstra() {
		DList = new ArrayList<DijkstraKnoten>();
	}

	public ArrayList<DijkstraKnoten> berechneKürzestenWeg(Knoten knoten) {
		ArrayList<Knoten> graphenListe = graph.getAllKnoten();
		String name = "";
		ArrayList<Kante> kanten;
		Knoten aktuellerKnoten = null;
		Knoten pred = null;
		int gewicht = 0;

		for (int i = 0; i < graphenListe.size(); i++) {

			aktuellerKnoten = graphenListe.get(i);
			kanten = graph.getNachbarn(aktuellerKnoten);
			if (aktuellerKnoten == knoten) {
				name = kanten.get(i).getZiel().getName();
				pred = knoten;
				gewicht = 0;
				DList.add(0, (new DijkstraKnoten(name, pred, gewicht, true)));

			}
			kanten = graph.getNachbarn(aktuellerKnoten);

			for (int j = 0; j < kanten.size(); j++) {
				if (aktuellerKnoten != knoten) {
					name = kanten.get(i).getZiel().getName();
					pred = aktuellerKnoten;
					gewicht = kanten.get(i).getGewicht();
					DList.add(new DijkstraKnoten(name, pred, gewicht, false));
				}
			}
		}
		return DList;
	}

	public ArrayList<DijkstraKnoten> errechneKürzesteWege(ArrayList<DijkstraKnoten> DList, DijkstraKnoten DKnotenj) {

		return DList;

	}

}
