
public class DijkstraKnoten extends Knoten {

	private Knoten pred =null;
	private int gewicht= Integer.MAX_VALUE;
	private boolean marked=false;
	
	public DijkstraKnoten(String name,Knoten pred,int gewicht,boolean marked) {
		super(name);
		this.pred = pred;;
		this.gewicht= gewicht;
		this.marked= marked;
		
	}

}
