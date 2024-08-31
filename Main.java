import java.util.Scanner;

class Main
{
  public static void main(String[] args)
  {
    //Get the amount of vertices in the graph
    Scanner scan = new Scanner(System.in);
    System.out.println("How many vertices are in your graph?");
    int vertNum = scan.nextInt();
    Graph userGraph = new Graph(vertNum);
    //Enter the values of each vertex
    for(int i = 0; i < vertNum; i++)
    {
      System.out.println("What is the value of vertex " + (i + 1) + "?");
      int vertVal = scan.nextInt();
      userGraph.defineVertex(i, vertVal);
      //Possibly connect the new vertex to the chosen existing vertices
      for(int j = 0; j < i; j++)
      {
        System.out.println("Is there a direct connection between this vertex and vertex " + (j + 1) + "?");
        System.out.println("Enter \"yes\" if there is.");
        String edgeConfirm = scan.next().toLowerCase();
        if(edgeConfirm.equals("yes"))
        {
          userGraph.addEdge(i, j);
        }
      }
    }
    //Print out the graph
    System.out.println("\nSimple info print:");
    userGraph.testPrint();
    System.out.println("\n\nBreadth First Search:");
    userGraph.breadthFirstSearch(0);
  }
}