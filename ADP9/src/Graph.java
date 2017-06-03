
public interface Graph {

	
void knotenHinzufuegen(Knoten knoten);
void knotenEntfernen(Knoten knoten);
void kanteEinfuegen(Knoten knoten1,Knoten knoten2);
void kanteEntfernen(Knoten knoten1,Knoten knoten2);
void traversieren();
int anzahlKnoten();
int anzahlKanten();
void GraphLöschen();

}
