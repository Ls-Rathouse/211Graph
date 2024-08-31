import java.util.ArrayList;

class Graph
{
  //Define variables
  private int verticesAmount;
  private int[] verticesValue;
  private boolean[][] adjMatrix;

  //Constructor
  public Graph(int vertNum)
  {
    //Set variables
    verticesAmount = vertNum;
    verticesValue = new int[verticesAmount];
    adjMatrix = new boolean[verticesAmount][verticesAmount];
    //Make all vertices connect to themselves for accuracy
    for(int i = 0; i < verticesAmount; i++)
    {
      adjMatrix[i][i] = true;
    }
  }

  //Define the vertex's value
  public void defineVertex(int index, int value)
  {
    verticesValue[index] = value;
  }

  //Add an edge between the two given values
  public void addEdge(int index1, int index2)
  {
    adjMatrix[index1][index2] = true;
    adjMatrix[index2][index1] = true;
  }

  //A neat printing structure that's somewhat easy to understand
  public void testPrint()
  {
    System.out.println("Vertices: ");
    for(int i = 0; i < verticesAmount; i++)
    {
      System.out.print(verticesValue[i] + " ");
    }
    System.out.print("\nAdjacency Matrix: ");
    for(int i = 0; i < verticesAmount; i++)
    {
      System.out.println();
      for(int j = 0; j < verticesAmount; j++)
      {
        System.out.print(adjMatrix[i][j] + "\t");
      }
    }
  }

  //The actual preinting method required for the assignment
  public void breadthFirstSearch(int start)
  {
    //Set up visited and queue
    ArrayList<Integer> visited = new ArrayList<Integer>();
    ArrayList<Integer> queue = new ArrayList<Integer>();
    visited.add(start);
    queue.add(start);
    //Repeat until everything has been discovered
    while(0 < queue.size())
    {
      for(int i = 0; i < verticesAmount; i++)
      {
        //Visit connected vertices and add if not visited already
        if(adjMatrix[queue.get(0)][i] && !visited.contains(i))
        {
          visited.add(i);
          queue.add(i);
        }
      }
      //Print current vertex and remove it from queue
      System.out.print(verticesValue[queue.get(0)] + " ");
      queue.remove(0);
    }
    //Notifies the user if they entered a graph with at least one separated vertex
    if(visited.size() < verticesAmount)
    {
      System.out.println("\nNot every vertex had a path between them,");
    }
  }
}