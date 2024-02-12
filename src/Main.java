import java.util.Scanner;

/**
 * Программа для подсчета количества способов поставить крестик в матрице,
 * учитывая условия: крестик можно поставить только в ячейку, соседние с которой не заняты.
 */
public class Main {

    /**
     * Основной метод программы.
     *
     * @param args Аргументы командной строки (не используются в данной программе).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Шаг 1: Запрос чисел N и M у пользователя
        System.out.print("Введите количество строк (N): ");
        int n = scanner.nextInt();

        System.out.print("Введите количество столбцов (M): ");
        int m = scanner.nextInt();

        // Шаг 2: Запрос матрицы у пользователя
        char[][] matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Введите символ для [" + i + "][" + j + "] (минус(-) или звездочка(*)): ");
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        // Шаг 3: Подсчет количества способов поставить крестик
        int waysToPlaceCross = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (matrix[i][j] == '-' &&
                        matrix[i - 1][j] == '-' &&
                        matrix[i + 1][j] == '-' &&
                        matrix[i][j - 1] == '-' &&
                        matrix[i][j + 1] == '-') {
                    waysToPlaceCross++;
                }
            }
        }

        // Вывод результата
        System.out.println("Количество способов поставить крестик: " + waysToPlaceCross);
    }
}