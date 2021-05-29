import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\aydin\\Desktop\\discovery_1.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String firstLine;
		String[] parts;
		String numberOfTranslations;;
		String numberOfWords;
		
		firstLine = br.readLine();
		parts = firstLine.split(" ");
		
		numberOfTranslations = parts[0];
		numberOfWords = parts[1];
		
		int x = Integer.parseInt(numberOfTranslations);
		int y = Integer.parseInt(numberOfWords);
		
		DecryptionGraph dg = new DecryptionGraph(26);
		
		for(int i = 0; i < x; i++) {
			
			String line = br.readLine();
			
			char source = line.charAt(0);
			char translation = line.charAt(2);
			
			dg.connect((int) source - 97, (int) translation - 97);
			
		}
		
		
		char x1 = 'c';
		char y1 = 'r';
		
		if (dg.convertable((int) x1 -97, (int) y1 -97))
			System.out.println( x1 + " can be convertable to " + y1);
		else
			System.out.println(x1 + " can not be convertable to " + y1);


	}

}

