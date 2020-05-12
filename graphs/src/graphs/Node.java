package graphs;

public class Node<V>
{
    private V dest;

    public Node(V dest)
    {
        this.dest = dest;
    }

    public V getDest()
    {
        return dest;
    }

    public void setDest(V dest)
    {
        this.dest = dest;
    }

    @Override
    public String toString()
    {
        return dest.toString();
    }
}
