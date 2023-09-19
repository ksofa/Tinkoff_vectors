import java.util.*;

public class Main {
    private static Map<String, Vector3D> vectors = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0].toLowerCase()) {
                case "create":
                    vectors.put(parts[1], new Vector3D(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
                    System.out.println("Вектор " + parts[1] + " создан.");
                    break;

                case "read":
                    vectors.values().forEach(System.out::println);
                    break;

                case "range":
                    System.out.println(vectors.get(parts[1]).length());
                    break;

                case "angle":
                    System.out.println(Vector3D.angle(vectors.get(parts[1]), vectors.get(parts[2])));
                    break;

                case "product":
                    if (parts[1].equalsIgnoreCase("dot")) {
                        System.out.println(Vector3D.dotProduct(vectors.get(parts[2]), vectors.get(parts[3])));
                    } else if (parts[1].equalsIgnoreCase("cross")) {
                        System.out.println(Vector3D.crossProduct(vectors.get(parts[2]), vectors.get(parts[3])));
                    }
                    break;

                case "exit":
                    return;

                // Дополнительные команды save и load

                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }
}
