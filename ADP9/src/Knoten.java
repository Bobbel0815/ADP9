import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Knoten {

	
	private List<Kante> kanten;
	private String name ="";

	Knoten pred;
	float cost;
	boolean marked;
	
	
	private List<Knoten> kuerzesterWeg = new LinkedList();
	private Integer gewicht = Integer.MAX_VALUE;
	Map<Knoten, Integer> nachbarKnoten = new HashMap<>();
	private boolean besucht = false;

	
	
	
	
	
	
	
	public Knoten(String name) {
		this.name = name;
		this.kanten = new ArrayList<Kante>();
	}

	
	public void addCost(Knoten knoten,int gewicht){
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
	public Knoten getPred() {
		return pred;
	}

	public void setPred(Knoten pred) {
		this.pred = pred;
	}

	public float getCost() {
		return cost;
	}



	public void setCost(float cost) {
		this.cost = cost;
	}


	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

}