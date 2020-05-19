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
            new Edge<>('A', 'B'),
            new Edge<>('A', 'D'),
            new Edge<>('B', 'C'),
            new Edge<>('D', 'E'),
            new Edge<>('F', 'G'),
            new Edge<>('G', 'F')
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
                new Edge<>("Christian Bale", "Morgan Freeman"),
                new Edge<>("Morgan Freeman", "Denzel Washington"),
                new Edge<>("Morgan Freeman", "Meryl Streep"),
                new Edge<>("Meryl Streep", "Rashida Jones"),
                new Edge<>("Rashida Jones", "Christian Bale")
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







