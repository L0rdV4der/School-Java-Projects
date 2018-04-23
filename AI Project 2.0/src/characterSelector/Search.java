//https://ide.geeksforgeeks.org/index.php
//The Website listed above gave me inspiration to complete my search tree.
//Thank you very much Aakash Hasija
package characterSelector;

import java.util.Iterator;
import java.util.LinkedList;


class Search
{
	private int V; // My vertices

	// Array of lists for Linked List
	private LinkedList<Integer> vert[];

	// Constructor for my search
	Search(int v)
	{
		V = v;
		vert = new LinkedList[v];
		for (int i=0; i<v; ++i)
			vert[i] = new LinkedList();
	}

	//Function for adding edges
	void addEdge(int v, int w)
	{
		vert[v].add(w); // Add w to v's list.
	}

	// Function for my search 
	void DFSUtil(int v,boolean visited[])
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v+" ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = vert[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSUtil(n,visited);
		}
	}

	// This function is for Depth first search traversal.
	void DFS()
	{
		// Mark all as not visited
		
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i=0; i<V; ++i)
			if (visited[i] == false)
				DFSUtil(i, visited);
	}


}


