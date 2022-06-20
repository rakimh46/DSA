import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable < Edge > {
        int v;
        int wt;

        Edge(int nbr, int wt) {
            this.v = nbr;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < ArrayList < Edge >> graph = new ArrayList < > ();
        for (int i = 0; i < vtces; i++) {
            graph.add(new ArrayList < > ());
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph.get(v1).add(new Edge(v2, wt));
            graph.get(v2).add(new Edge(v1, wt));
        }

        int cost = prims(graph);
        System.out.println(cost);

    }


    public static int prims(ArrayList < ArrayList < Edge >> graph) {
        PriorityQueue < Edge > pq = new PriorityQueue < > ();

        int cost = 0;
        pq.add(new Edge(0, 0));
        boolean[] vis = new boolean[graph.size()];

        while (pq.size() > 0) {
            //remove
            Edge rem = pq.remove();

            //mark
            if (vis[rem.v] == true) {
                continue;
            }
            vis[rem.v] = true;

            //work
            cost += rem.wt;

            //add nbr
            for (Edge ne: graph.get(rem.v)) {
                int nbr = ne.v;
                int wt = ne.wt;
                if (vis[nbr] == false) {
                    pq.add(new Edge(nbr, wt));
                }
            }
        }

        return cost;
    }


}