package graphAlgorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		FileReader file;
		try {
			file = new FileReader("input3.txt");
			BufferedReader rd = new BufferedReader(file);
			int j=0;
			String numOfVertex = rd.readLine();
			int num = Integer.parseInt(numOfVertex);
			Vertex[] graph = new Vertex[num];
			int [][] matrix = new int [num][num];
			while(true){
				String line = rd.readLine();
				if(line!=null){
					StringTokenizer tk = new StringTokenizer(line);
					for(int i=0; i<num; i++){
						matrix[i][j]=Integer.parseInt(tk.nextToken());
					}
					j++;
				} else {
				break;
				}
			}
			for(int i=0; i<num; i++){
				Vertex v = new Vertex(i, matrix[i], false);
				graph[i]=v;
			}
			Vertex.primJarnik(graph);
			rd.close();
		} catch (IOException e){
			System.out.println("Error");
		}
	}

	public static void printDoubleArray(int [][] e){
		for(int i=0; i<e.length; i++){
			for(int j=0; j<e[i].length; j++){
				System.out.print(e[i][j] + " ");
			}System.out.println();
		}
	}

	public static void writeDoubleArray(int[][] arr){
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("myOutput4.txt",true));
			for(int i=0; i<arr.length; i++){
				for(int j=0; j<arr[i].length; j++){
					writer.print(arr[i][j] + " ");
				} writer.println(" ");
			}
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void write(int weight){
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("myOutput4.txt",true));
			writer.println(weight);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
