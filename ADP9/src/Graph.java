import java.util.ArrayList;
import java.util.HashMap;

public interface Graph {

	

public void knotenEntfernen(Knoten knoten);
public void kanteEinfuegen(Knoten knoten1,Knoten knoten2,int gewicht);
public void kanteEntfernen(Knoten knoten1,Knoten knoten2);
public void traversieren();
public int anzahlKnoten();
public int anzahlKanten();
public void GraphLöschen();
public void initKnoten(ArrayList<Knoten> graphList);
public void knotenHinzufuegen(HashMap nachbarn, Knoten knoten);


}
