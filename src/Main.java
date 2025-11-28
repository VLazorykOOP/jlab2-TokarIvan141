import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readIntInput();

            switch (choice) {
                case 0:
                    System.out.println("Вихід з програми...");
                    return;
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                default:
                    System.out.println("Некоректний вибір! Спробуйте ще раз.");
            }
            System.out.println("\n" + "=".repeat(40) + "\n");
        }
    }

    private static void printMenu() {
        System.out.println("Головне меню");
        System.out.println("1. Робота з точками");
        System.out.println("2. Квадратні рівняння");
        System.out.println("3. Робота з масивами");
        System.out.println("0. Вийти");
    }

    private static int readIntInput() {
        System.out.print("Оберіть завдання (1-2) або 0 для виходу: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Некоректне введення! Введіть ціле число: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private static void task1() {
        System.out.println("\n=== Демонстрація роботи з точками ===");

        Point p1 = new Point(3, 4);
        Point p2 = new Point(1, 1);

        System.out.println("Початкові точки:");
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        p1.moveX(2);
        p1.moveY(-1);
        System.out.println("\nПісля переміщення p1 на (2, -1): " + p1);

        System.out.println("\nВідстань від p1 до початку координат: " + p1.distanceFromOrigin());
        System.out.println("Відстань між p1 та p2: " + p1.distanceTo(p2));

        double[] polar = p1.toPolar();
        System.out.printf("Полярні координати p1: (r=%.2f, θ=%.2f)%n", polar[0], polar[1]);

        Point p3 = new Point(5, 3);
        System.out.println("\nПорівняння:");
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));

        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(5, 2));
        points.add(new Point(3, 1));
        points.add(p1);
        points.add(p2);

        System.out.println("\nВсі точки в списку:");
        points.forEach(System.out::println);

        Set<Point> pointSet = new HashSet<>(points);
        System.out.println("\nУнікальні точки:");
        pointSet.forEach(System.out::println);
    }

    private static void task2() {
        System.out.println("\n=== Квадратні рівняння ===");

        SquareEquation eq1 = new SquareEquation(1, -3, 2);
        SquareEquation eq2 = new SquareEquation(1, -2, 1);
        SquareEquation eq3 = new SquareEquation(1, 0, 1);

        System.out.println("Рівняння 1: " + eq1);
        System.out.println("Кількість коренів: " + eq1.getRootCount());
        System.out.println("Корені: " + Arrays.toString(eq1.getRoots()));

        System.out.println("\nРівняння 2: " + eq2);
        System.out.println("Кількість коренів: " + eq2.getRootCount());
        System.out.println("Корені: " + Arrays.toString(eq2.getRoots()));

        System.out.println("\nРівняння 3: " + eq3);
        System.out.println("Кількість коренів: " + eq3.getRootCount());
        System.out.println("Корені: " + Arrays.toString(eq3.getRoots()));

        System.out.println("\n--- Введення рівняння з клавіатури ---");
        System.out.print("Введіть a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть b: ");
        double b = scanner.nextDouble();
        System.out.print("Введіть c: ");
        double c = scanner.nextDouble();
        scanner.nextLine();

        SquareEquation userEq = new SquareEquation(a, b, c);
        System.out.println("Ваше рівняння: " + userEq);
        System.out.println("Кількість коренів: " + userEq.getRootCount());
        System.out.println("Корені: " + Arrays.toString(userEq.getRoots()));
    }


    private static void task3() {
        System.out.println("\n=== Робота з масивами ===");

        int[] array1 = ArrayOperations.generateRandomArray(5, 1, 50);
        int[] array2 = ArrayOperations.generateRandomArray(5, 1, 50);

        System.out.println("Перший масив: " + Arrays.toString(array1));
        System.out.println("Другий масив: " + Arrays.toString(array2));

        ArrayOperations.bubbleSort(array1);
        ArrayOperations.bubbleSort(array2);

        System.out.println("Відсортований перший масив: " + Arrays.toString(array1));
        System.out.println("Відсортований другий масив: " + Arrays.toString(array2));

        int[] mergedArray = ArrayOperations.mergeSortedArrays(array1, array2);
        System.out.println("Об'єднаний відсортований масив: " + Arrays.toString(mergedArray));
    }
}