import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked") 
public class Graph {
    
    Vertex[] vertexList; // This list contain vertices
    LinkedList<Integer>[] adjacencyList; // Graph implemented by Adjacency List
    
    int cap;
    int size;
    int cc;

    public Graph(int cap){
        // Pls initialize all varibles here
        this.cap = cap;
        this.size = 0;
        vertexList = new Vertex[cap];
        adjacencyList = new LinkedList[cap];

        for(int i = 0; i < cap; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    public void addVertex(int key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }
        
        // Create Vertex object and the LinkedList object
        // Add these objects to the corresponding arrays
        // finally, size++;
        Vertex v = new Vertex(key);
        v.dist = Integer.MAX_VALUE;
        v.prev = null;

        vertexList[size] = v;
        size++;
        
    }
    
    // Two way edge
    // If you make a path from u to v, you must make a path from v to u
    public void addEdge(int u, int v){
        if (vertexList[u]==null){
            System.out.println("Source node does not exist");
            return;
        } if (vertexList[v]==null){
            System.out.println("Destination node does not exist");
            return;
        }
        
        // Check if there is already an edge from u to v
        if (!isConnected(u, v)){
            adjacencyList[u].add(v);    //add edge from vectex(u) to vertex(v)
            adjacencyList[v].add(u);    //add edge from vectex(v) to vertex(u)
            // Add edge from Vertex(u) to Vertex(v)
            // and then from Vertex(v) to Vertex(u)
            
        }else{
            System.out.println("There is already an edge connecting vertex "+u+" and vertex "+v);
        }
    }
    
    // Check if Vertex(u) and Vertex(v) has an edge to one another
    public boolean isConnected(int u, int v){
        if(adjacencyList[u].indexOf(v) != -1 || adjacencyList[v].indexOf(u) != -1){ //if vertex(u) has edge to vectec(v) or vectex(v) has edge to vectex(u)
            return true;
        }
        return false;
    }

    // This function is complete, no need to edit
    // Please study how this function works
    // if you understand this function, you will undertand the whole homework
    public void showAdjacentVertices(int u){
        Vertex v = vertexList[u];
        System.out.print("Vertex " + v.strKey + " connected to the following vertices: ");
        
        LinkedList<Integer> list = adjacencyList[u];
        for (int vertex_index : list) {
            System.out.print(vertexList[vertex_index].strKey + ", ");
        }
        System.out.println();
    }  
    
    public void BFS(Vertex s){
      // Set all Vertex.dist to Infinity (Use Integer.MAX_VALUE to represent Infinity)

        int index = s.intKey;

        for(int i = 0; i < vertexList.length; i++){
            if(vertexList[i] != null){
                vertexList[i].dist = Integer.MAX_VALUE;
                vertexList[i].prev = null;
            }
        }
        
        Queue<Vertex> q = new LinkedList<>();
        
        // Set dist of the start vertex (s) to 0
        vertexList[index].dist = 0;

      // Push the start vertex to an empty queue
        q.add(vertexList[index]);

        // [*] Check if the queue is not empty
        while(!q.isEmpty()){
            // Pop the queue, and get the current vertex
            Vertex cur = q.remove();
            int indexcur = cur.intKey;

            // Extract the list of all vertices that are connected to current vertex
            for(int e : adjacencyList[cur.intKey]){
                // Traverse all the list, and check if the dist value of anyone are still infinity or not 
                // If yes
                if(vertexList[e].dist == Integer.MAX_VALUE){
                    //push that vertex into the queue
                    q.add(vertexList[e]);
                    //increase the dist variable of that vertex by one
                    vertexList[e].dist = vertexList[indexcur].dist + 1;
                    vertexList[e].prev = vertexList[indexcur];
                }
            }

        }
      
      //          set the prev variable of that vertex to the current vertex
      
      // Repeat [*]
  }

  
  public Stack<Vertex> getShortestPathList(Vertex S, Vertex U){
    //FIX THIS
    if (U.prev == null) {
      System.out.printf("There is no path from %d to %d", S.intKey, U.intKey);
      return new Stack<>();
    }
      // Create a stack
      Stack<Vertex> stack = new Stack<>();
      // Start from Vertex U
      stack.push(U);
      U.visited = true;

      while(U != S){
        if(U.prev != null ){
            U = U.prev;
            if(U.visited == false){
                stack.push(U);
                U.visited = true;
            }
        }
      }
      // [*] push the current Vertex into the stack
      // Go back one Vertex using U.prev
      // Repeat [*] until you reach the Vertex S
      
      // return the stack
      return stack; // Fix this
  }
  
  public void printShortestPath(int s_index, int u_index){
    
      // Map Vertex names to index numbers
      // Get vertices from the vertexList
      Vertex s = vertexList[s_index];
      Vertex u = vertexList[u_index];
      
      // Run BFS() at the starting Vertex
      BFS(s);

      // Get shortestPartList(starting Vertex, ending Vertex)
      Stack<Vertex> stack = getShortestPathList(s, u);

      // Traverse all the stack and print the Vertex name
      while(!stack.isEmpty()){
          Vertex cur = stack.pop();
          
          System.out.print(cur.intKey);
          if(!stack.isEmpty())  System.out.print(" -> ");
      }
  }
    
    
    // This is editable test case, but no need to edit
    public static Graph constructGraph1(){
        Graph graph = new Graph(32); 
        for (int i=0; i<16; i++)
            graph.addVertex(i);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(4, 8);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(6, 10);
        graph.addEdge(6, 9);
        graph.addEdge(7, 14);
        graph.addEdge(8, 9);
        graph.addEdge(8, 13);
        graph.addEdge(8, 12);
        graph.addEdge(10, 14);
        graph.addEdge(11, 15);
        graph.addEdge(13, 14);
        graph.addEdge(14, 15);
        
        return graph;
    }
    
    // This is editable test case, but no need to edit
    public static Graph constructGraph2(){
        Graph graph = new Graph(32); 
        for (int i=0; i<16; i++)
            graph.addVertex(i);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 6);
        graph.addEdge(5, 9);
        graph.addEdge(6, 9);
        graph.addEdge(7, 14);
        graph.addEdge(8, 13);
        graph.addEdge(8, 12);
        graph.addEdge(10, 14);
        graph.addEdge(11, 15);
        graph.addEdge(14, 15);
        return graph;
    }
}
