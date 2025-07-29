public class Perceptron {
    static double[] weights = {0, 0};
    static double bias = 0;
    static double lr = 0.1;
    static int[][] inputs = {{0,0}, {0,1}, {1,0}, {1,1}};
    static int[] outputs = {0, 0, 0, 1}; // AND operation

    public static void main(String[] args) {
        for (int epoch = 0; epoch < 10; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                int prediction = predict(inputs[i]);
                int error = outputs[i] - prediction;
                for (int j = 0; j < weights.length; j++)
                    weights[j] += lr * error * inputs[i][j];
                bias += lr * error;
            }
        }

        System.out.println("Trained weights:");
        for (double w : weights) System.out.print(w + " ");
        System.out.println("\nBias: " + bias);

        System.out.println("Predictions:");
        for (int[] in : inputs) {
            System.out.println(in[0] + "," + in[1] + " => " + predict(in));
        }
    }

    static int predict(int[] input) {
        double sum = bias;
        for (int i = 0; i < input.length; i++) sum += weights[i] * input[i];
        return sum >= 0.5 ? 1 : 0;
    }
}
