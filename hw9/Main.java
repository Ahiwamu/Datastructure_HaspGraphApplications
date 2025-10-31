public class Main {

    public static void test1(){

        int p = 110001;     // Big Prime    (Hash key1)
        int x = 1001;       // Small number (Hash key2)
        HashTable table = new HashTable(16, p, x);
        String[] names = {"a", "b", "c", "A", "B", "BA", "BBA", "aaa", "aaaaa", "0","1","11","111", "abcdABCD01234" };
        for (int i=0; i<names.length; i++)
            System.out.println("HashCode of '" + names[i] + "' is "+HashTable.polyHash(names[i], p, x));
        
        for (int i=0; i<names.length; i++){
            table.addString(names[i]);
            System.out.println("Index of '" + names[i] + "' is "+table.getIndex(names[i]));
        }
    }
    
    public static void test2(){
        int p = 110001;     // Big Prime    (Hash key1)
        int x = 101;       // Small number (Hash key2)
        HashTable table = new HashTable(16, p, x);
        String[] names = { "Abraham","Andrew","Benjamin","Claudia","Gabriel","Esther","Martha","Rebecca","Moses","Timothy"};
        for (int i=0; i<names.length; i++)
            System.out.println("HashCode of " + names[i] + " is "+HashTable.polyHash(names[i], p, x));
        
        for (int i=0; i<names.length; i++){
            table.addString(names[i]);
            System.out.println("Index of " + names[i] + " is "+table.getIndex(names[i]));
        }
    }


    
    
    public static void main(String[] args) {
/* 
        Graph graph = new Graph(32); 
        for (int i=0; i<16; i++) {
            graph.addVertex(i);
        }
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
        graph.showAdjacentVertices(0);
        graph.showAdjacentVertices(1);
        graph.showAdjacentVertices(5);
        graph.showAdjacentVertices(14);
        graph.showAdjacentVertices(11);
        graph.BFS(graph.vertexList[0]);
*/
        /*
        graph.showAdjacentVertices(1);
        graph.showAdjacentVertices(5);
        graph.showAdjacentVertices(14);
        graph.showAdjacentVertices(11);
        
        graph.DFS();
        */
        
        
        // Graph graph = new Graph(32); 
        // for (int i=0; i<16; i++)
        //     graph.addVertex(i);
        // graph.addEdge(0, 1);
        // graph.addEdge(0, 5);
        // graph.addEdge(0, 4);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 5);
        // graph.addEdge(2, 3);
        // graph.addEdge(3, 6);
        // graph.addEdge(5, 9);
        // graph.addEdge(6, 9);
        // graph.addEdge(7, 14);
        // graph.addEdge(8, 13);
        // graph.addEdge(8, 12);
        // graph.addEdge(10, 14);
        // graph.addEdge(11, 15);
        // graph.addEdge(14, 15);
        // graph.BFS(graph.vertexList[0]);

        // graph.printShortestPath(0,9);
        // System.out.println("Number of connected components = " + (graph.cc-1));
        
        //for (int i=0; i<16; i++)
        //    graph.showAdjacentVertices(i);
        
        
        
        /*
        int p = 101111; // Big Prime (Hash key1)
        int x = 101;    // Small number (Hash key2)
        HashGraph graph = new HashGraph(32, p, x); 
        String[] cities = new String[]{"Dublin", "Edinburgh", "Manchester", 
            "Copenhagen", "Lisbon", "London", "Berlin", "Prague", "Madrid", 
            "Paris", "Vienna", "Budapest", "Geneva", "Milan", "Zurich", "Rome"};
        for (int i=0; i<16; i++){
            graph.addVertex(cities[i]);
        }
        
        //graph.showVertexList();
        
        graph.addEdge("Dublin", "Edinburgh");
        graph.addEdge("Dublin", "London");                
        graph.addEdge("Dublin", "Lisbon");
        graph.addEdge("Edinburgh", "Manchester");
        graph.addEdge("Manchester", "London");
        graph.addEdge("Manchester", "Copenhagen");
        graph.addEdge("Copenhagen", "Berlin");
        graph.addEdge("Lisbon", "Madrid");
        graph.addEdge("London", "Paris");
        graph.addEdge("Berlin", "Prague");
        graph.addEdge("Berlin", "Vienna");
        graph.addEdge("Berlin", "Paris");
        graph.addEdge("Prague", "Zurich");
        graph.addEdge("Madrid", "Paris");
        graph.addEdge("Madrid", "Milan");
        graph.addEdge("Madrid", "Geneva");
        graph.addEdge("Vienna", "Zurich");
        graph.addEdge("Budapest", "Rome");
        graph.addEdge("Milan", "Zurich");
        graph.addEdge("Zurich", "Rome");
        graph.showVertexList();
        
        graph.showAdjacentVertices(graph.getListIndex("Paris"));
        graph.showAdjacentVertices(graph.getListIndex("Zurich"));
        graph.showAdjacentVertices(graph.getListIndex("Geneva"));

        graph.DFS();
        System.out.println("Number of connected components = " + (graph.cc-1));
        */
        /* 
        graph.printShortestPath("London", "Budapest");
        graph.printShortestPath("Berlin", "Dublin");
        */
        
        /*int p = 101111; // Big Prime (Hash key1)
        int x = 101;    // Small number (Hash key2)
        HashGraph graph = new HashGraph(32, p, x); 
        String[] cities = new String[]{"Liu Bei", "Liu Shi", "Liu Shan", 
            "Liu Liang", "Sun Jian", "Sun Ce", "Sun Quan", "Sun Liang", "Sun Xiu", 
            "Sun Hao", "Cao Cao", "Cao Pi", "Cao Rui", "Cao Fang", "Cao Mao", "Cao Huan"};
        for (int i=0; i<16; i++){
            graph.addVertex(cities[i]);
        }
        
        graph.addEdge("Liu Bei", "Liu Shi");
        graph.addEdge("Liu Bei", "Liu Shan");
        graph.addEdge("Liu Liang", "Liu Shan");
        graph.addEdge("Sun Jian", "Sun Ce");
        graph.addEdge("Sun Jian", "Sun Quan");
        graph.addEdge("Sun Quan", "Sun Ce");
        graph.addEdge("Sun Quan", "Sun Liang");
        graph.addEdge("Sun Liang", "Sun Xiu");
        graph.addEdge("Sun Xiu", "Sun Hao");
        graph.addEdge("Cao Cao", "Cao Pi");
        graph.addEdge("Cao Cao", "Cao Rui");
        graph.addEdge("Cao Cao", "Cao Fang");
        graph.addEdge("Cao Pi", "Cao Rui");
        graph.addEdge("Cao Rui", "Cao Fang");
        graph.addEdge("Cao Pi", "Cao Fang");
        graph.addEdge("Cao Fang", "Cao Mao");
        graph.addEdge("Cao Fang", "Cao Huan");
        graph.addEdge("Cao Mao", "Cao Huan");

        graph.showVertexList();

        graph.showAdjacentVertices(graph.getListIndex("Cao Cao"));
        graph.showAdjacentVertices(graph.getListIndex("Liu Bei"));
        graph.showAdjacentVertices(graph.getListIndex("Sun Ce"));


        graph.DFS();
        System.out.println("Number of connected components = " + (graph.cc-1));
        */
        
        
    }
    
}

