import java.io.*;
import java.util.*;

public class Main {
    private static Map<String, Vector3D> vectors = new HashMap<>();

    public static void main(String[] args) {
        printInstructions();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            switch (parts[0].toLowerCase()) {
                case "create":
                    vectors.put(parts[1], new Vector3D(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
                    System.out.println("Вектор " + parts[1] + " создан.");
                    break;

                case "read":
                    vectors.forEach((k, v) -> System.out.println(v));
                    break;

                case "range":
                    System.out.println("Длина вектора: " + vectors.get(parts[1]).length());
                    break;

                case "angle":
                    double angle = Vector3D.angle(vectors.get(parts[1]), vectors.get(parts[2]));
                    System.out.println("Угол между векторами: " + angle);
                    break;

                case "product":
                    if ("dot".equals(parts[1])) {
                        double dotProduct = Vector3D.dotProduct(vectors.get(parts[2]), vectors.get(parts[3]));
                        System.out.println("Скалярное произведение: " + dotProduct);
                    }
                    if ("cross".equals(parts[1])) {
                        Vector3D crossProduct = Vector3D.crossProduct(vectors.get(parts[2]), vectors.get(parts[3]));
                        System.out.println("Векторное произведение: " + crossProduct);
                    }
                    break;

                case "save":
                    saveToFile(parts[1]);
                    break;

                case "load":
                    loadFromFile(parts[1]);
                    break;

                case "exit":
                    System.out.println("Программа завершена.");
                    return;

                default:
                    System.out.println("Неизвестная команда.");
                    printInstructions();
            }
        }
    }

    private static void printInstructions() {
        System.out.println("Доступные команды:");
        System.out.println("create $название $x $y $z - создать вектор");
        System.out.println("read - вывести все векторы");
        System.out.println("range $название - вывести длину вектора");
        System.out.println("angle $вектор1 $вектор2 - найти угол между векторами");
        System.out.println("product $типПроизведения $вектор1 $вектор2 - результат произведения");
        System.out.println("save $имяФайла - сохранить коллекцию в файл");
        System.out.println("load $имяФайла - прочитать коллекцию из файла");
        System.out.println("exit - завершить программу");
    }

    private static void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(vectors);
            System.out.println("Векторы сохранены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    private static void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            vectors = (Map<String, Vector3D>) ois.readObject();
            System.out.println("Векторы загружены из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }
}
