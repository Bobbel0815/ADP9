import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public interface Graph {

	

	
public void knotenEntfernen(Knoten knoten);


public void kanteHinzuf�gen(Knoten knoten1,Knoten knoten2,int gewicht);



public void kanteEntfernen(Knoten knoten1,Knoten knoten2);

public void traversieren();

public int getAnzahlKnoten();

public int getAnzahlKanten();



public void initKnoten(ArrayList<Knoten> graphList);

public int getGewicht(Knoten knoten1,Knoten knoten2);



void knotenHinzufuegen(Knoten knoten); //Done


int anzahlKnoten();


void graphL�schen();





}
