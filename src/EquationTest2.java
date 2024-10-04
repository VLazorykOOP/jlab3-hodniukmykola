// Інтерфейс Root
interface Root {
    void calculateRoots();

    void printResult();
}

class Linear implements Root {
    private double a, b;  // коефіцієнти рівняння
    private double root;  // корінь рівняння

    public Linear(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void calculateRoots() {
        if (a != 0) {
            root = -b / a;
        } else {
            System.out.println("Це не рівняння, бо a = 0");
        }
    }

    @Override
    public void printResult() {
        if (a != 0) {
            System.out.println("Корінь лінійного рівняння: x = " + root);
        } else {
            System.out.println("Неможливо обчислити корінь, бо це не рівняння.");
        }
    }

    @Override
    public String toString() {
        return "Linear equation: " + a + "x + " + b + " = 0";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Linear linear = (Linear) obj;
        return Double.compare(linear.a, a) == 0 && Double.compare(linear.b, b) == 0;
    }
}

class Square implements Root {
    private double a, b, c;  // коефіцієнти рівняння
    private double root1, root2;  // корені рівняння
    private boolean hasRoots;  // чи є рівняння дійсні корені

    public Square(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void calculateRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            hasRoots = true;
        } else if (discriminant == 0) {
            root1 = root2 = -b / (2 * a);
            hasRoots = true;
        } else {
            hasRoots = false;
        }
    }

    @Override
    public void printResult() {
        if (hasRoots) {
            if (root1 == root2) {
                System.out.println("Корінь квадратного рівняння: x = " + root1);
            } else {
                System.out.println("Корені квадратного рівняння: x1 = " + root1 + ", x2 = " + root2);
            }
        } else {
            System.out.println("Рівняння не має дійсних коренів.");
        }
    }

    @Override
    public String toString() {
        return "Square equation: " + a + "x^2 + " + b + "x + " + c + " = 0";
    }

    // Перевантажений метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Square square = (Square) obj;
        return Double.compare(square.a, a) == 0 && Double.compare(square.b, b) == 0 && Double.compare(square.c, c) == 0;
    }
}

public class EquationTest2 {
    public static void main(String[] args) {
 
        Root[] equations = new Root[2];

        equations[0] = new Linear(2, -4);  // 2x - 4 = 0
        equations[1] = new Square(1, -3, 2);  // x^2 - 3x + 2 = 0

        for (Root equation : equations) {
            System.out.println(equation.toString());
            equation.calculateRoots();
            equation.printResult();
            System.out.println();
        }
    }
}
