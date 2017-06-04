
public class Kante {
	
private Knoten ziel;
private int gewicht;

public Kante(Knoten ziel,int gewicht){
	this.ziel= ziel;
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

@Override
public String toString(){
    return "( "+ ziel.getName() + " , "+ gewicht + " )";
}




public int getGewicht(){
	return gewicht;
}


}
