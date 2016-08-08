package graphAlgorithms;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;



public class Vertex implements Comparable<Vertex> {
	private int num;
	private int[] edge;
	private boolean visited;
	private int power;

	public Vertex(int num, int[] edge, boolean visited){
		this.num =num;
		this.edge=edge;
		this.visited=visited;
		this.power=0;
	}

	public Vertex(int num, int[] edge){
		this.num =num;
		this.edge=edge;
		this.visited=false;
		this.power=0;
	}

	public int getNum() {
		return num;
	}

	public int[] getEdge() {
		return edge;
	}

	public boolean isVisited() {
		return visited;
	}

	public int getPower() {
		return power;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setEdge(int[] edge) {
		this.edge = edge;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Vertex [num=" + num + ", edge=" + Arrays.toString(edge)
		+ ", visited=" + visited + "]";
	}

	public boolean areAdjacent(Vertex v){
		if(this.edge[v.getNum()]!=0){
			return true;
		}
		return false;
	}

	public int distanceToNode(Vertex v){
		return this.getEdge()[v.getNum()];
	}

	public static int[][] primJarnik(Vertex[] graph){
		int [][] treeMatrix = new int[graph.length][graph.length];
		int [][] tree = new int[graph.length][graph.length];
		for(int i=0; i<graph.length; i++){
			graph[i].setPower(9999999);
		}
		PriorityQueue<Vertex> v = new PriorityQueue<>(graph.length);
		for(int i=0; i<graph.length; i++){
			v.add(graph[i]);
		}
		while(v.isEmpty()==false){
			Vertex u = v.poll();
			u.setVisited(true);
			int a = returnMinLocation(u);
			treeMatrix[u.getNum()][a]=1;
			tree[u.getNum()][a]=u.getEdge()[a];
			treeMatrix[a][u.getNum()]=1;
			tree[a][u.getNum()]=u.getEdge()[a];
		}

		int weight = graphWeight(treeMatrix, graph);

		System.out.println("Prim's Algorithm");
		System.out.println();
		System.out.println("Total weight of the minimum spanning tree is: " + weight);
		System.out.println();
		System.out.println("The minimum spanning tree is: ");
		printDoubleArray(tree);
		System.out.println();
		return tree;
	}

	public int compareTo(Vertex o) {
		if(this.power>o.getPower()){
			return 1;
		} else if(this.power<o.getPower()){
			return -1;
		} else {
			if(this.num>o.getNum()){
				return 1;
			} else {
				return -1;
			} 
		}
	}

	public static void printDoubleArray(int [][] e){
		for(int i=0; i<e.length; i++){
			for(int j=0; j<e[i].length; j++){
				System.out.print(e[i][j] + " ");
			}System.out.println();
		}
	}
	
	public static int returnMinLocation(Vertex v){
		int [] edges= v.getEdge();
		int [] temp= new int[edges.length];
		for(int i=0; i<edges.length; i++){
			if(edges[i]==0){
				temp[i]=999999;
			} else{
				temp[i]=edges[i];
			}
		}
		int num = 0;
		int min = 999;
		for(int i=0; i<edges.length; i++){
			if(temp[i]<min){ 
				min = temp[i];
				num = i;
			}
		}
		return num;
	}
	
	public static int graphWeight(int[][] g, Vertex[] v){
		int[][]temp = new int [g.length][g.length];
		for(int i=0; i<g.length; i++){
			for(int j=0; j<g[i].length; j++){
				temp[i][j]=g[i][j];
			} 
		}
		int weight=0;
		for(int i=0; i<temp.length; i++){
			for(int j=0; j<temp[i].length; j++){
				if(temp[i][j]!=0){
					weight+=v[j].getEdge()[i];
					temp[j][i]=0;
				}
			}
		}
		return weight;
	}

}
