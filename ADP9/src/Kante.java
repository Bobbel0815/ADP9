
public class Kante {
	
private Knoten start;
private Knoten ende;
private int gewicht;

public Kante(Knoten start, Knoten ende,int gewicht){
	this.start = start;
    this.ende = ende;
    this.gewicht = gewicht;
}
public Knoten getNachbar(Knoten knoten){
	if(! knoten.equals(start)|| knoten.equals(ende)){
		return null;
		
	}
	 return knoten.equals(start) ? ende: start;
}
public Knoten getStart(){
	return start;
}
public Knoten getEnde(){
	return ende;
}
public int getGewicht(){
	return gewicht;
}
}
