public class Connection {
    private Neuron connectedFrom;
    private Neuron connectedTo;

    private double weight;

    public Connection(double weight) {
        this.weight = weight;
    }

    public void setConnection(Neuron connectedFrom, Neuron connectedTo){
        this.connectedFrom = connectedFrom;
        this.connectedTo = connectedTo;
    }

    public void setConnectedFrom(Neuron connectedFrom) {
        this.connectedFrom = connectedFrom;
    }

    public void setConnectedTo(Neuron connectedTo) {
        this.connectedTo = connectedTo;
    }

    public Neuron getConnectedFrom() {
        return connectedFrom;
    }

    public Neuron getConnectedTo() {
        return connectedTo;
    }

    public double getWeight() {
        return weight;
    }
}
