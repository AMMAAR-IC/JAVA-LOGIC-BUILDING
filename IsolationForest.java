import java.util.*;

public class IsolationForest {
    static class TreeNode {
        int feature;
        double splitValue;
        TreeNode left, right;
        boolean isLeaf = false;
        int size;

        TreeNode(int size) {
            this.size = size;
            this.isLeaf = true;
        }

        TreeNode(int feature, double splitValue, TreeNode left, TreeNode right) {
            this.feature = feature;
            this.splitValue = splitValue;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode buildTree(List<double[]> data, int height, int maxHeight) {
        if (height >= maxHeight || data.size() <= 1) return new TreeNode(data.size());

        int feature = new Random().nextInt(data.get(0).length);
        double min = Double.MAX_VALUE, max = -Double.MAX_VALUE;
        for (double[] row : data) {
            min = Math.min(min, row[feature]);
            max = Math.max(max, row[feature]);
        }

        if (min == max) return new TreeNode(data.size());

        double split = min + new Random().nextDouble() * (max - min);
        List<double[]> left = new ArrayList<>(), right = new ArrayList<>();
        for (double[] row : data) {
            if (row[feature] < split) left.add(row);
            else right.add(row);
        }

        return new TreeNode(feature, split,
                buildTree(left, height + 1, maxHeight),
                buildTree(right, height + 1, maxHeight));
    }

    static double pathLength(TreeNode node, double[] point, int depth) {
        if (node.isLeaf) return depth + c(node.size);
        if (point[node.feature] < node.splitValue)
            return pathLength(node.left, point, depth + 1);
        return pathLength(node.right, point, depth + 1);
    }

    static double c(int n) {
        return n > 2 ? 2 * (Math.log(n - 1) + 0.5772156649) - (2 * (n - 1) / (double) n) : 1;
    }

    public static void main(String[] args) {
        List<double[]> dataset = Arrays.asList(
                new double[]{1.0, 2.0},
                new double[]{1.2, 2.1},
                new double[]{10.0, 20.0}, // outlier
                new double[]{1.1, 1.9},
                new double[]{1.3, 2.2}
        );

        int trees = 50;
        int sampleSize = 4;
        int heightLimit = (int) Math.ceil(Math.log(sampleSize) / Math.log(2));

        List<TreeNode> forest = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < trees; i++) {
            Collections.shuffle(dataset, rand);
            List<double[]> sample = dataset.subList(0, sampleSize);
            forest.add(buildTree(sample, 0, heightLimit));
        }

        for (double[] point : dataset) {
            double pathSum = 0;
            for (TreeNode tree : forest) {
                pathSum += pathLength(tree, point, 0);
            }
            double avgPath = pathSum / trees;
            double score = Math.pow(2, -avgPath / c(sampleSize));
            System.out.printf("Point %s -> Anomaly Score: %.3f\n", Arrays.toString(point), score);
        }
    }
}
