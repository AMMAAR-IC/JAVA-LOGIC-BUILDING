import java.util.*;

public class PCAJava {
    public static double[][] centerData(double[][] data) {
        int rows = data.length, cols = data[0].length;
        double[] means = new double[cols];
        for (int j = 0; j < cols; j++)
            for (int i = 0; i < rows; i++)
                means[j] += data[i][j];
        for (int j = 0; j < cols; j++) means[j] /= rows;

        double[][] centered = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                centered[i][j] = data[i][j] - means[j];
        return centered;
    }

    public static double[][] covarianceMatrix(double[][] data) {
        int n = data.length;
        int d = data[0].length;
        double[][] cov = new double[d][d];
        for (int i = 0; i < d; i++)
            for (int j = 0; j < d; j++)
                for (int k = 0; k < n; k++)
                    cov[i][j] += data[k][i] * data[k][j];
        for (int i = 0; i < d; i++)
            for (int j = 0; j < d; j++)
                cov[i][j] /= (n - 1);
        return cov;
    }

    public static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double val : row)
                System.out.printf("%.3f ", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] data = {
                {2.5, 2.4},
                {0.5, 0.7},
                {2.2, 2.9},
                {1.9, 2.2},
                {3.1, 3.0}
        };

        double[][] centered = centerData(data);
        double[][] cov = covarianceMatrix(centered);

        System.out.println("Covariance Matrix:");
        printMatrix(cov);
        System.out.println("\nApply Eigen Decomposition separately (e.g., in Python) to get PCs.");
    }
}
