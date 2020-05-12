package driver;

import graphs.DirectedALGraph;
import graphs.IGraph;

import java.util.Set;

public class DriverProgram
{
    public static void main(String[] args)
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
    }
}
