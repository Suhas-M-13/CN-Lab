//import java.util.*;
//
//public class BellmanFord {
//    static class Edge {
//        int src;
//        int dest;
//        int wt;
//
//        public Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.wt = w;
//        }
//    }
//
//    static void createGraph(ArrayList<Edge> graph[], int[][] adjacencyMatrix) {
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph.length; j++) {
//                if (adjacencyMatrix[i][j] != 0) {
//                    graph[i].add(new Edge(i, j, adjacencyMatrix[i][j]));
//                }
//            }
//        }
//    }
//
//    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
//        int dist[] = new int[graph.length];
//        for (int i = 0; i < dist.length; i++) {
//            if (i != src)
//                dist[i] = Integer.MAX_VALUE;
//        }
//
//        // O(V)
//        for (int i = 0; i < graph.length - 1; i++) {
//            // edges - O(E)
//            for (int j = 0; j < graph.length; j++) {
//                for (int k = 0; k < graph[j].size(); k++) {
//                    Edge e = graph[j].get(k);
//                    int u = e.src;
//                    int v = e.dest;
//                    int wt = e.wt;
//                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
//                        dist[v] = dist[u] + wt;
//                    }
//                }
//            }
//        }
//
//        // Detecting Negative Weight Cycle
//        for (int j = 0; j < graph.length; j++) {
//            for (int k = 0; k < graph[j].size(); k++) {
//                Edge e = graph[j].get(k);
//                int u = e.src;
//                int v = e.dest;
//                int wt = e.wt;
//                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
//                    System.out.println("Negative weight cycle exists");
//                    return;
//                }
//            }
//        }
//
//        System.out.println("Shortest distances from source " + src + ":");
//        for (int i = 0; i < dist.length; i++) {
//            System.out.print(dist[i] + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String args[]) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the number of nodes: ");
//        int V = scanner.nextInt();
//
//        ArrayList<Edge> graph[] = new ArrayList[V];
//        int[][] adjacencyMatrix = new int[V][V];
//
//        System.out.println("Enter the adjacency matrix:");
//        for (int i = 0; i < V; i++) {
//            for (int j = 0; j < V; j++) {
//                adjacencyMatrix[i][j] = scanner.nextInt();
//            }
//        }
//
//        createGraph(graph, adjacencyMatrix);
//
//        System.out.print("Enter the source node: ");
//        int src = scanner.nextInt();
//
//        bellmanFord(graph, src);
//
//        scanner.close();
//    }
//}

//Bellman ford
import java.util.*;

public class BellmanFord {
    static int N;
    static int[][] cost;

    static void bellmanFord(int src) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < N; i++)
            for (int u = 0; u < N; u++)
                for (int v = 0; v < N; v++)
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + cost[u][v] < dist[v])
                        dist[v] = dist[u] + cost[u][v];
        for (int u = 0; u < N; u++)
            for (int v = 0; v < N; v++)
                if (dist[u] != Integer.MAX_VALUE && dist[u] + cost[u][v] < dist[v]) {
                    System.out.println("Negative weight cycle detected.");
                    return;
                }
        System.out.println("Vertex\tDistance from source");
        for (int i = 0; i < N; i++)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        N = in.nextInt();
        cost = new int[N][N];
        System.out.println("Enter the cost matrix : ");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                cost[i][j] = in.nextInt();
        System.out.print("Enter the source vertex : ");
        int src = in.nextInt();
        bellmanFord(src);

    }
}