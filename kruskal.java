
Copy code
import java.util.*;

public class KruskalMST {

    static class Edge implements Comparable<Edge> {

        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Subset {

        int parent, rank;
    }

    static Edge[] edgeArray;

    static int V, E;

    static int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(Subset subsets[], int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (xRoot == yRoot)
            return;

        if (subsets[xRoot].rank < subsets[yRoot].rank)
            subsets[xRoot].parent = yRoot;
        else if (subsets[xRoot].rank > subsets[yRoot].rank)
            subsets[yRoot].parent = xRoot;

        else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    static void printMST(Edge mst[], int size) {
        System.out.println("Edge \tWeight");
        for (int i = 0; i < size; ++i) {
            System.out.println(mst[i].src + " - " + mst[i].dest + "\t" + mst[i].weight);
        }
    }

    static Edge[] kruskalMST(int[][] graph) {
        edgeArray = new Edge[V * (V - 1) / 2];
        int index = 0;
        for (int i = 0; i < V; ++i)
            for (int j = i + 1; j < V; ++j) {
                Edge e = new Edge();
                e.src = i;
                e.dest = j;
                e.weight = graph[i][j];
                edgeArray[index++] = e;
            }

        Edge[] mst = new Edge[V - 1];
        Arrays.sort(edgeArray);

        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int e = 0, count = 0;
        while (e < V - 1) {
            Edge next_edge = new Edge();
            next_edge = edgeArray[e++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                mst[count++] = next_edge;
                union(subsets, x, y);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 9, 75, 0, 0, 12},
                {9, 0, 75, 90, 45, 0},
                {75, 75, 0, 12, 65, 45},
                {0, 90, 12, 0, 10, 0},
                {0, 45, 65, 10, 0, 32},
                {12, 0, 45, 0, 32, 0}
        };

        V = graph.length;
        E = 0;
        for (int i = 0; i < V; ++i)
            for (int j = i + 1; j < V; ++j)
                if (graph[i][j] != 0)
                    E++;

        Edge[] mst = new Edge[V - 1];
        mst = kruskalMST(graph);

        System.out.println("Edges in the constructed MST: ");
        printMST(mst, V - 1);
    }
}