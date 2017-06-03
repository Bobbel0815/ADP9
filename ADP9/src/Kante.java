
public class Kante {
	
private Knoten ziel;
private int gewicht;



public Kante(Knoten ziel){

    this(ziel, 0);
}
public Kante(Knoten ziel,int gewicht){
	
	
	this.start = ziel;
    
    this.gewicht = gewicht;
}




public void setZiel(Knoten ziel) {
	this.ziel = ziel;
}

public void setGewicht(int gewicht) {
	this.gewicht = gewicht;
}

public Knoten getZiel(){
	return ziel;
}

public int getGewicht(){
	return gewicht;
}


}
