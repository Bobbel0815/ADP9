
public class DijkstraKnoten extends Knoten implements Comparable<DijkstraKnoten>{


	private DijkstraKnoten pred =null;
	private double minWeg= Double.POSITIVE_INFINITY;
	private boolean markiert=false;
	
	public DijkstraKnoten(String name) {
		super(name);
	}

	@Override
	public int compareTo(DijkstraKnoten o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMinWeg() {
		return minWeg;
	}

	public void setMinWeg(double distanceThroughU) {
		this.minWeg = distanceThroughU;
	}

	public DijkstraKnoten getPred() {
		return pred;
	}

	

	public void setPred(DijkstraKnoten u) {
		this.pred = u;
		
	}

	

	

}
