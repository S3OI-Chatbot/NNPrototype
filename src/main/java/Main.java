import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<List<Integer>> matrix1 = new ArrayList<List<Integer>>();
    static List<List<Integer>> matrix2 = new ArrayList<List<Integer>>();

    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    static List<List<Integer>> expected = new ArrayList<List<Integer>>();

    static List<List<Neuron>> network = new ArrayList<List<Neuron>>();

    public static void main(String... args) {
        testNN();
    }

    private static void testNN(){
        List<Integer> layers = Arrays.asList(768, 5, 10);

        for (int i = 0; i < layers.size(); i++) {
            List<Neuron> layer = new ArrayList<>();
            for (int j = 0; j < layers.get(i); j++) {
                layer.add(new Neuron(0));
            }
            network.add(layer);
        }

        for (int i = network.size()-2; i >= 0; i--) {

            for (Neuron neuron: network.get(i)) {
                for (int j = 0; j < network.get(i+1).size(); j++) {
                    Connection conn = new Connection(0);
                    conn.setConnection(neuron,network.get(i+1).get(j));
                    neuron.getConnectionsTo().add(conn);
                }
            }
        }

        network.forEach(System.out::println);

    }

    private static void matrixMult(){
        matrix1.add(Arrays.asList(3,4,2,6));

        matrix2.add(Arrays.asList(13,9,7,15));
        matrix2.add(Arrays.asList(8,7,4,6));
        matrix2.add(Arrays.asList(6,4,0,3));
        matrix2.add(Arrays.asList(5,4,0,3));

        result.add(new ArrayList<Integer>());

        expected.add(Arrays.asList(83,63,37,75));

        for (int i = 0; i < matrix1.size(); i++) {
            for (int j = 0; j < matrix2.get(i).size(); j++) {
                int cell = 0;
                for (int k = 0; k < matrix2.size(); k++) {
                    cell += matrix1.get(i).get(k) * matrix2.get(k).get(j);
                }

                result.get(0).add(cell);
            }
        }

        System.out.println("Input "+matrix1);
        System.out.println("Input "+matrix2);
        System.out.println("Result "+result);
        System.out.println("Expected "+expected);

        System.out.println(result.equals(expected));
    }
}
