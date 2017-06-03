import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Knoten {

	private List<Kante> kanten;
	private String name ="";
	private List<Knoten> kuerzesterWeg = new LinkedList();
	private Integer gewicht = Integer.MAX_VALUE;
	Map<Knoten, Integer> nachbarKnoten = new HashMap<>();
	private boolean besucht = false;

	public Knoten(String name) {
		this.name = name;
		this.kanten = new ArrayList<Kante>();
	}
	public void addStrecke(Knoten knoten,int gewicht){
		nachbarKnoten.put(knoten, gewicht);
	}

	List<Knoten> getKuezesterWeg() {
		return kuerzesterWeg;
	}
	int getGewicht(){
		return gewicht;
	}
	Map<Knoten,Integer> getNachbarn(){
		return nachbarKnoten;
	}
	public void nachbarKnoten(Knoten knotenB, int i) {
		// TODO Auto-generated method stub
		
	}
	public int anzahlKanten(){
		return kanten.size();
	}

	public boolean istBesucht(){
		return besucht;
	}
}