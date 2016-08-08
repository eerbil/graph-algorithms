# Graph Algorithms
My Project on Graph Algorithms currently contains examples Prim Jarnik Algorithm only.

#Prim Jarnik Algorithm 
Prim Jarnik Algorithm (Prim's Algorithm) is a graph algorithm that is used in order to find a minimum spanning tree of a given graph. 

[You can read about Prim's Algorithm from here] (https://en.wikipedia.org/wiki/Prim%27s_algorithm) 

In my project I read a text file that contains the number of vertices of a graph and the graph in a adjacency matrix format. The format of the input file is like the following:

[Sample Input] (https://github.com/eerbil/graph-algorithms/blob/master/Sample%20Input.png?raw=true)

This shows a graph with 7 verices and each integer [i][j] represents the weight of the edge between vertex i and j.

After the sample input is given the program creates the Vertex objects for each vertex read from the file. Each vertex object holds its edges between other vertices in an integer array. So whenever the Prim's algorithm is executed each vertex can access to its edges and the vertices that are also adjacent to these edges.
The vertex can execute the Prim's algorithm and it prints out the adjacency matrix that of the minimum spanning tree. It also prints out the total weight of the graph.
The format of the output file is like the following:

[Sample Output] (https://github.com/eerbil/graph-algorithms/blob/master/Sample%20Output.png?raw=true)

---

(I have also included the necessary methods to read from and write to a text file)
