import java.util.ArrayList;

public class Aufwand {
	Graph LGraph ;
	Graph MGraph;
	
	private boolean verbunden(Knoten a,Knoten b){
		return MGraph.istNachbar(a, b) && LGraph.istNachbar(a, b);
		
	}
	public void graphenErzeugen() {
		 LGraph = new Adjazenzliste();
		 MGraph = new AdjazenzMatrix();
		ArrayList<Knoten> knotenList = new ArrayList<Knoten>();
		
		
		int exp = 1;

		Knoten hKnoten = new Knoten("HauptKnoten");
		knotenList.add(hKnoten);
		
		int k = (int) Math.pow(10, exp);
		
		for (int i = 0; i < k; i++) {
			StringBuffer sb = new StringBuffer("K"+i);
			Knoten knoten = new Knoten(sb.toString());
			knotenList.add(knoten);

			LGraph.knotenHinzufuegen(knoten);
			MGraph.knotenHinzufuegen(knoten);
			LGraph.kanteEinfuegen(hKnoten, knoten, 9999999);
			MGraph.kanteEinfuegen(hKnoten, knoten, 9999999);
			sb.append(i);

			System.out.println(sb);
			System.out.println(knotenList);
		}

		for (int i = 1; i < k ; i++) {

			int randomAnzahlNachbarn = 1 + (int) (Math.random() * (k - 1));

			for (int j = 0; j <= randomAnzahlNachbarn; j++) {
				
				//int rKnoten2 = 1 + (int) (Math.random() * (k - 1));
				int rKnoten2 = 1;
				while (i == rKnoten2) {
					rKnoten2 = 1 + (int) (Math.random() * (k - 1));
					boolean wert = !verbunden(knotenList.get(i),knotenList.get(rKnoten2));
					if((i != rKnoten2) &&!(verbunden(knotenList.get(i),knotenList.get(rKnoten2)))) {
					
						break;
					}
				}
				int gewicht = (int) (Math.random() * (knotenList.size()*knotenList.size()));
				MGraph.kanteEinfuegen(knotenList.get(i), knotenList.get(rKnoten2),gewicht);
				LGraph.kanteEinfuegen(knotenList.get(i), knotenList.get(rKnoten2),gewicht);

			}
		}

		System.out.println(knotenList);

	}

	public static void main(String[] args) {
		Aufwand aufwand = new Aufwand();
		aufwand.graphenErzeugen();
	}
}
