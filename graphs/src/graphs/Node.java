package graphs;

public class Node<V>
{
    private V dest;
    private Node<V> next;
    private double weight;

    public Node(V dest, double weight)
    {
        this.dest = dest;
        this.weight = weight;
    }

    public Node(V dest, Node<V> next, double weight)
    {
        this.dest = dest;
        this.next = next;
        this.weight = weight;
    }

    public V getDest()
    {
        return dest;
    }

    public void setDest(V dest)
    {
        this.dest = dest;
    }

    public Node<V> getNext()
    {
        return next;
    }

    public void setNext(Node<V> next)
    {
        this.next = next;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return dest.toString();
    }
}
