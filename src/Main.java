import java.io.*;
import java.util.*;

public class Main {
    private static Map<String, Vector3D> vectors = new HashMap<>();
    private static final Map<String, Command> commands = new HashMap<>();
    static {
        commands.put("create", new CreateCommand(vectors));
        commands.put("read", new ReadCommand(vectors));
    }
    public static void main(String[] args) {
        printInstructions();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            Command command = commands.get(parts[0].toLowerCase());
            if (command != null) {
                command.execute(parts);
            } else {
                System.out.println("Неизвестная команда");
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
