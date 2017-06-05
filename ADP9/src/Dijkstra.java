import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.PriorityQueue;


public class Dijkstra {

	
	private Graph graph = null;
public Dijkstra(Graph graph){
	this.graph = graph;
}
	
	 public void computePaths(DijkstraKnoten source)
	    {
	        source.setMinWeg(0);
	        PriorityQueue<DijkstraKnoten> vertexQueue = new PriorityQueue<DijkstraKnoten>();
	    vertexQueue.add(source);

	    while (!vertexQueue.isEmpty()) {
	    	DijkstraKnoten u = vertexQueue.poll();

	            // Visit each edge exiting u
	            for (Kante e : graph.getNachbarn(u))
	            {
	                DijkstraKnoten v =  (DijkstraKnoten) e.getZiel();
	                int gewicht = e.getGewicht();
	               
	                double distanceThroughU = u.getMinWeg() + gewicht;
	        if (distanceThroughU < v.getMinWeg()) {
	            vertexQueue.remove(v);
	            
	            v.setMinWeg(distanceThroughU) ;
	            v.setPred(u);
	            vertexQueue.add(v);
	        }
	            } 
	        }
	   
	    }
	 public void printPath(List<DijkstraKnoten> path,DijkstraKnoten a){
		
		 List<Knoten> alleKnoten = graph.getAllKnoten();
		 List<DijkstraKnoten> alleKnoten2 = new ArrayList<DijkstraKnoten>();
		 for(Knoten k : alleKnoten){
			 alleKnoten2.add((DijkstraKnoten)k);
		 }
		 
		 String pathReturn="";
		 for(int i=0;i<alleKnoten2.size();i++){
			if(i==0){
				pathReturn+=alleKnoten2.get(i).getName()+"("+alleKnoten2.get(i).getName()+","+alleKnoten2.get(i).getMinWeg()+") ";
			}else{
				pathReturn+=alleKnoten2.get(i).getName()+"("+alleKnoten2.get(i).getPred().getName()+","+alleKnoten2.get(i).getMinWeg()+") ";
		 }}
		 System.out.println(pathReturn);
	 }
	
	 

	    public List<DijkstraKnoten> getShortestPathTo(DijkstraKnoten target)
	    {
	        List<DijkstraKnoten> path = new ArrayList<DijkstraKnoten>();
	        for (DijkstraKnoten vertex = target; vertex != null; vertex =  vertex.getPred())
	            path.add(vertex);

	        Collections.reverse(path);
	        return path;
	    }
	    
}
