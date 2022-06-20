import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void getSingleComp(ArrayList < Edge > [] graph, int src, ArrayList < Integer > list, boolean[] vis) {

        list.add(src);

        vis[src] = true;

        for (Edge edge: graph[src]) {
            int nbr = edge.nbr;

            if (vis[nbr] == false) {
                getSingleComp(graph, nbr, list, vis);
            }
        }
    }

    public static void getConnectedComps(ArrayList < Edge > [] graph, ArrayList < ArrayList < Integer >> comps) {

        boolean[] vis = new boolean[graph.length];

        for (int v = 0; v < graph.length; v++) {
            if (vis[v] == false) {
                ArrayList < Integer > scc = new ArrayList < > ();
                getSingleComp(graph, v, scc, vis);
                comps.add(scc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();

        // write your code here
        getConnectedComps(graph, comps);

        System.out.println(comps);
    }
}