import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Knoten {

	
	public LinkedList<Kante> adjazenzListe;
	private String name ="";
	
	public Knoten(String name) {
		this.name = name;
		this.adjazenzListe = new LinkedList<Kante>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        String returnValue = "" + name;
        returnValue += adjazenzListe;
        return returnValue;
    }

	

	
	



}