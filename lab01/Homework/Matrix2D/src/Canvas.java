public class Canvas {
    private int size;
    private int[][] matrix;
    private String[][] matrixUnicode;

    public Canvas(int size) {
        this.size = size;
        this.matrix = new int[this.size][this.size];
        this.matrixUnicode = new String[this.size][this.size];
    }

    public void setBackground(int selectedColor) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = selectedColor;
            }
        }
    }

    public void printCanvas() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] == 255 ? "255 " : " 0  ");
            }
            System.out.print("\n");
        }
        System.out.println("\n\n\n\n");
    }

    public void exampleRectangle() {
        setBackground(255);
        for (int i = 0; i < size; i++) {
            matrix[0][i] = 0;
            matrix[size - 1][i] = 0;
        }
        for (int i = 1; i < size - 1; i++) {
            matrix[i][0] = 0;
            matrix[i][size - 1] = 0;
        }
        printCanvas();
    }

    public void exampleCircle() {
        setBackground(0);

        double center = (size - 1) / 2.0;
        double radius = (size - 1) / 2.0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double distance = Math.sqrt(Math.pow(i - center, 2) + Math.pow(j - center, 2));

                if (Math.abs(distance - radius) < 0.6) {
                    matrix[i][j] = 255;
                }
            }
        }
        printCanvas();
    }
}
