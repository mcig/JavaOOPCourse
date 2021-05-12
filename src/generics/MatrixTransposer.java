package generics;

public class MatrixTransposer<T> {
    T[][] matrix;

    public MatrixTransposer(T[][] matrix) {
        this.matrix = matrixCopy(matrix);
    }

    public void transpose() {
        T[][] backupMatrix = matrixCopy(matrix);
        for (int i = 0; i < matrix.length; i++) { //rows
            for (int j = 0; j < matrix[i].length; j++) { //values
                matrix[i][j] = backupMatrix[j][i];
            }
        }
    }

    private T[][] matrixCopy(T[][] matrix) {
        T[][] copy = (T[][]) new Object[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) { //rows
            //values
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix[i].length);
        }
        return copy;
    }

    @Override
    public String toString() {
        String matrixStr = "";
        for (T[] row : matrix) { //rows
            for (T value : row) { //values
                matrixStr += value.toString() + " ";
            }
            matrixStr += "\n";
        }


        return "Matrix:\n"
                + matrixStr;
    }
}
