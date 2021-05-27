import java.util.*;

class DecryptionGraph
{
	
	private int vertices; 
	private LinkedList<Integer> nodes[]; 

	//Creating the graph with adjacency list
	DecryptionGraph(int size)
	{
		vertices = size;
		nodes = new LinkedList[size];
		for (int i=0; i<size; ++i)
			nodes[i] = new LinkedList();
	}

	//This function is to add a new letter to the graph
	void connect(int firstLetter,int secondLetter) { 
		nodes[firstLetter].add(secondLetter); 
	}

	//This function is to find whether there is a path from the firstLetter to secondLetter
	//It uses BFS while searching
	Boolean convertable(int firstLetter, int secondLetter)
	{
		
		boolean visited[] = new boolean[vertices];
		LinkedList<Integer> visitedNodes = new LinkedList<Integer>();
		Iterator<Integer> iter;
		int nextNode;

		visited[firstLetter]=true;
		visitedNodes.add(firstLetter);

		while (visitedNodes.size()!=0)
		{
			firstLetter = visitedNodes.poll();
			iter = nodes[firstLetter].listIterator();

			while (iter.hasNext())
			{
				nextNode = iter.next();
				if (nextNode==secondLetter) {
					return true;
				}
				if (visited[nextNode]==false)
				{
					visited[nextNode] = true;
					visitedNodes.add(nextNode);
				}
			}
		}
		return false;
	}
}


public class Main {

	public static void main(String[] args) {
		int x = 9;
		int y = 5;
		DecryptionGraph dg = new DecryptionGraph(26);
		dg.connect((int) 'a' -97, (int) 'b' -97);
		dg.connect((int) 'b' -97, (int) 'c' -97);
		dg.connect((int) 'c' -97, (int) 'd' -97);
		dg.connect((int) 'd' -97, (int) 'e' -97);
		dg.connect((int) 'e' -97, (int) 'f' -97);
		dg.connect((int) 'f' -97, (int) 'g' -97);
		dg.connect((int) 'g' -97, (int) 'h' -97);
		dg.connect((int) 'h' -97, (int) 'i' -97);
		dg.connect((int) 'i' -97, (int) 'j' -97);
		dg.connect((int) 'j' -97, (int) 'z' -97);
		
		char x1 = 'a';
		char y1 = 'd';
		if (dg.convertable((int) x1 -97, (int) y1 -97))
			System.out.println( x1 + " can be convertable to " + y1);
		else
			System.out.println(x1 + " can not be convertable to " + y1);


	}

}

