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
		long startTime = System.nanoTime();
		File file = new File("src/discovery_6.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String firstLine;
		String[] parts_1;
		String numberOfTranslations;
		String numberOfWords;
		
		firstLine = br.readLine();
		parts_1 = firstLine.split("\\s");
		
		numberOfTranslations = parts_1[0];
		numberOfWords = parts_1[1];
		
		int x = Integer.parseInt(numberOfTranslations);
		
		DecryptionGraph dg = new DecryptionGraph(26);
		
		for(int i = 0; i < x; i++) {
			
			String line = br.readLine();
			
			char source = line.charAt(0);
			char translation = line.charAt(2);
			
			dg.connect((int) source - 97, (int) translation - 97);
			
		}
		
		int y = Integer.parseInt(numberOfWords);
		
		String line;
		String[] parts_2;
		String[] strings = new String[y*2];
		
		for(int i = 0; i <= (2*y-2); i = i+2) {
			
			line = br.readLine();
			parts_2 = line.split("\\s");
			
			String word = parts_2[0];
			String translation = parts_2[1];
			strings[i] = word;
			strings[i+1] = translation; 
		}
		int current=0;
		int word_length=0;
		boolean convertable=true;
		
		for(int i=0; i<y;i++) {
			word_length=strings[current].length();
			if(strings[current].equals(strings[current+1])) {
				System.out.println("Yes");
				
			}
			else if(strings[current].length()!=strings[current+1].length()) {
				System.out.println("No");
			}else {
				for(int j=0;j<word_length;j++) {
					if(!(dg.convertable((int) strings[current].charAt(j) -97, (int) strings[current+1].charAt(j) -97)) &&
							(int) strings[current].charAt(j) -97!=(int) strings[current+1].charAt(j) -97	) {
						convertable=false;
						System.out.println("No");
						break;
					}
				}
				if(convertable) {
					System.out.println("Yes");
				}
			}
			convertable=true;
			word_length=0;
			current+=2;	
		}

	    long endTime = System.nanoTime();

	    // get the difference between the two nano time valuess
	    long timeElapsed = endTime - startTime;

	    System.out.println(timeElapsed / 1000000);

	}

}
