package app;

import com.jwetherell.algorithms.data_structures.Graph;
import com.jwetherell.algorithms.data_structures.Graph.Edge;
import com.jwetherell.algorithms.data_structures.Graph.TYPE;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jwetherell.algorithms.graph.*;

public class Main {
    public static void main(String[] args){
        UndirectedGraph test_graph = new UndirectedGraph(); // UndirectedGraph object
        AStar<Integer> algorithm_aStar = new AStar<Integer>(); 
        List<Graph.Edge<Integer>> solution_path = algorithm_aStar.aStar(test_graph.graph, test_graph.v6, test_graph.v7);
        System.out.println(solution_path);
    }

    private static class UndirectedGraph {
        final List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
        final Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);
        final Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);
        final Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);
        final Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);
        final Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(5);
        final Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(6);
        final Graph.Vertex<Integer> v7 = new Graph.Vertex<Integer>(7);
        final Graph.Vertex<Integer> v8 = new Graph.Vertex<Integer>(8);
        final Graph.Vertex<Integer> v9 = new Graph.Vertex<Integer>(9);
        final Graph.Vertex<Integer> v10 = new Graph.Vertex<Integer>(10);
        {
            verticies.add(v1);
            verticies.add(v2);
            verticies.add(v3);
            verticies.add(v4);
            verticies.add(v5);
            verticies.add(v6);
            verticies.add(v7);
            verticies.add(v8);
            verticies.add(v9);
            verticies.add(v10);
        }

        final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
        final Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(3, v1, v2);
        final Graph.Edge<Integer> e1_5 = new Graph.Edge<Integer>(6, v1, v5);
        final Graph.Edge<Integer> e1_9 = new Graph.Edge<Integer>(11, v1, v9);
        final Graph.Edge<Integer> e1_10 = new Graph.Edge<Integer>(4, v1, v10);
        final Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(7, v2, v4);
        final Graph.Edge<Integer> e2_8 = new Graph.Edge<Integer>(3, v2, v8);
        final Graph.Edge<Integer> e3_7 = new Graph.Edge<Integer>(11, v3, v7);
        final Graph.Edge<Integer> e3_9 = new Graph.Edge<Integer>(2, v3, v9);
        final Graph.Edge<Integer> e4_6 = new Graph.Edge<Integer>(3, v4, v6);
        final Graph.Edge<Integer> e5_6 = new Graph.Edge<Integer>(1, v5, v6);
        final Graph.Edge<Integer> e6_10 = new Graph.Edge<Integer>(5, v6, v10);
        final Graph.Edge<Integer> e8_7 = new Graph.Edge<Integer>(1, v8, v7);
        final Graph.Edge<Integer> e9_2 = new Graph.Edge<Integer>(5, v9, v2);
        {
            edges.add(e1_2);
            edges.add(e1_5);
            edges.add(e1_9);
            edges.add(e1_10);
            edges.add(e2_4);
            edges.add(e2_8);
            edges.add(e3_7);
            edges.add(e3_9);
            edges.add(e4_6);
            edges.add(e5_6);
            edges.add(e6_10);
            edges.add(e8_7);
            edges.add(e9_2);
        }

        final Graph<Integer> graph = new Graph<Integer>(verticies, edges);
    }
 /* 
    // Directed
    private static class DirectedGraph {
        final List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
        final Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);
        final Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);
        final Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);
        final Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);
        final Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(5);
        final Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(6);
        final Graph.Vertex<Integer> v7 = new Graph.Vertex<Integer>(7);
        final Graph.Vertex<Integer> v8 = new Graph.Vertex<Integer>(8);
        {
            verticies.add(v1);
            verticies.add(v2);
            verticies.add(v3);
            verticies.add(v4);
            verticies.add(v5);
            verticies.add(v6);
            verticies.add(v7);
            verticies.add(v8);
        }

        final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
        final Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(7, v1, v2);
        final Graph.Edge<Integer> e1_3 = new Graph.Edge<Integer>(9, v1, v3);
        final Graph.Edge<Integer> e1_6 = new Graph.Edge<Integer>(14, v1, v6);
        final Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(10, v2, v3);
        final Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(15, v2, v4);
        final Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(11, v3, v4);
        final Graph.Edge<Integer> e3_6 = new Graph.Edge<Integer>(2, v3, v6);
        final Graph.Edge<Integer> e6_5 = new Graph.Edge<Integer>(9, v6, v5);
        final Graph.Edge<Integer> e6_8 = new Graph.Edge<Integer>(14, v6, v8);
        final Graph.Edge<Integer> e4_5 = new Graph.Edge<Integer>(6, v4, v5);
        final Graph.Edge<Integer> e4_7 = new Graph.Edge<Integer>(16, v4, v7);
        final Graph.Edge<Integer> e1_8 = new Graph.Edge<Integer>(30, v1, v8);
        {
            edges.add(e1_2);
            edges.add(e1_3);
            edges.add(e1_6);
            edges.add(e2_3);
            edges.add(e2_4);
            edges.add(e3_4);
            edges.add(e3_6);
            edges.add(e6_5);
            edges.add(e6_8);
            edges.add(e4_5);
            edges.add(e4_7);
            edges.add(e1_8);
        }

        final Graph<Integer> graph = new Graph<Integer>(Graph.TYPE.DIRECTED, verticies, edges);
    }
    */
}
