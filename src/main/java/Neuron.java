import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private double bias;
    private List<Connection> connectionsFrom = new ArrayList<>();
    private List<Connection> connectionsTo = new ArrayList<>();
    private double value;

    public double activate(List<List<Double>> input) {
        for (Connection connection : connectionsFrom) {
            value += (connection.getConnectedFrom().value * connection.getWeight());
        }
        value += bias;
        return sigmoid(value);
    }

    private double sigmoid(double x) {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
    }

    public Neuron(double bias) {
        this.bias = bias;
    }

    public List<Connection> getConnectionsFrom() {
        return connectionsFrom;
    }

    public void setConnectionsFrom(List<Connection> connectionsFrom) {
        this.connectionsFrom = connectionsFrom;
    }

    public List<Connection> getConnectionsTo() {
        return connectionsTo;
    }

    public void setConnectionsTo(List<Connection> connectionsTo) {
        this.connectionsTo = connectionsTo;
    }

    public double getValue() {
        return value;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "bias=" + bias +
                ", connectionsFrom=" + connectionsFrom +
                ", connectionsTo=" + connectionsTo +
                '}';
    }
}
