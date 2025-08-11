import java.util.Random;

public class NeuralNet {
    double[][] weights1 = new double[2][2];
    double[] weights2 = new double[2];
    double[] hidden = new double[2];
    double lr = 0.1;
    Random rand = new Random();

    NeuralNet() {
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) weights1[i][j] = rand.nextDouble()*2-1;
            weights2[i] = rand.nextDouble()*2-1;
        }
    }

    double sigmoid(double x) { return 1/(1+Math.exp(-x)); }
    double dsigmoid(double y) { return y*(1-y); }

    void train(double[][] inputs, double[] outputs, int epochs) {
        for (int e=0; e<epochs; e++) {
            for (int i=0; i<inputs.length; i++) {
                // forward pass
                for (int j=0; j<2; j++) hidden[j] = sigmoid(inputs[i][0]*weights1[0][j] + inputs[i][1]*weights1[1][j]);
                double out = sigmoid(hidden[0]*weights2[0] + hidden[1]*weights2[1]);

                // backprop
                double err = outputs[i] - out;
                double delta2 = err * dsigmoid(out);

                for (int j=0; j<2; j++) {
                    double errHidden = delta2 * weights2[j];
                    weights2[j] += lr * delta2 * hidden[j];
                    for (int k=0; k<2; k++) weights1[k][j] += lr * errHidden * dsigmoid(hidden[j]) * inputs[i][k];
                }
            }
        }
    }

    double predict(double[] in) {
        for (int j=0; j<2; j++) hidden[j] = sigmoid(in[0]*weights1[0][j] + in[1]*weights1[1][j]);
        return sigmoid(hidden[0]*weights2[0] + hidden[1]*weights2[1]);
    }

    public static void main(String[] args) {
        NeuralNet nn = new NeuralNet();
        double[][] X = {{0,0},{0,1},{1,0},{1,1}};
        double[] Y = {0,1,1,0};
        nn.train(X, Y, 5000);

        for (double[] in : X) {
            System.out.printf("%d XOR %d = %.4f%n", (int)in[0], (int)in[1], nn.predict(in));
        }
    }
}
