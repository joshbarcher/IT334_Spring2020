package driver;

import graphs.DirectedALGraph;
import graphs.Edge;
import graphs.IGraph;

import java.util.List;
import java.util.Set;

public class DriverProgram
{
    public static void main(String[] args)
    {
        IGraph<Character> letterGraph = new DirectedALGraph<>();

        letterGraph.addVertices('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
        letterGraph.addEdges(
            new Edge<>('A', 'B', 2),
            new Edge<>('A', 'D', 3),
            new Edge<>('B', 'C', 4),
            new Edge<>('D', 'E', 2),
            new Edge<>('F', 'G', 3),
            new Edge<>('G', 'F', 1)
        );

        //a, b, c, d, e, ...
        List<Character> dfs = letterGraph.dfs();
        for (char character : dfs)
        {
            System.out.println(character);
        }
    }

    private static void actorsExample()
    {
        IGraph<String> actorGraph = new DirectedALGraph<>();

        actorGraph.addVertices(
                "Christian Bale",
                "Morgan Freeman",
                "Denzel Washington",
                "Rashida Jones",
                "Meryl Streep"
        );

        Set<String> actors = actorGraph.vertices();
        for (String actor : actors)
        {
            System.out.println(actor);
        }

        //which famous actor is falling which on Twitter
        actorGraph.addEdges(
                new Edge<>("Christian Bale", "Morgan Freeman", 0),
                new Edge<>("Morgan Freeman", "Denzel Washington", 0),
                new Edge<>("Morgan Freeman", "Meryl Streep", 0),
                new Edge<>("Meryl Streep", "Rashida Jones", 0),
                new Edge<>("Rashida Jones", "Christian Bale", 0)
        );

        System.out.println(actorGraph.hasEdge("Christian Bale", "Morgan Freeman"));
        System.out.println(actorGraph.hasEdge("Morgan Freeman", "Denzel Washington"));
        System.out.println(actorGraph.hasEdge("Christian Bale", "Ice Cube"));

        System.out.println("Edges: " + actorGraph.edgeSize());

        //loop over all our edges
        Set<Edge<String>> edges = actorGraph.edges();
        for (Edge<String> edge : edges)
        {
            System.out.println(edge);
        }
    }
}







