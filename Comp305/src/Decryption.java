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

