package Graphs;

import java.util.*;

class AdjacentListGraph2 {
    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacentListGraph2() {
        this.adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For undirected graph
    }

    // Get neighbors of a vertex
    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    // Check if an edge exists between two vertices
    public boolean hasEdge(int source, int destination) {
        return adjacencyList.get(source).contains(destination);
    }

    // Print the graph
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // DFS traversal starting from a specific vertex
    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(startVertex, visited);
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // BFS traversal starting from a specific vertex
    public void bfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacentListGraph2 graph = new AdjacentListGraph2 ();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("Graph:");
        graph.printGraph();

        System.out.println("\nDFS starting from vertex 1:");
        graph.dfs(1);

        System.out.println("\nBFS starting from vertex 1:");
        graph.bfs(1);
    }
}
