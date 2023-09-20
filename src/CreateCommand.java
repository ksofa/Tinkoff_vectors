import java.io.*;
import java.util.*;
class CreateCommand implements Command {
    private final Map<String, Vector3D> vectors;

    public CreateCommand(Map<String, Vector3D> vectors) {
        this.vectors = vectors;
    }

    @Override
    public void execute(String[] args) {
        vectors.put(args[1], new Vector3D(args[1], Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4])));
        System.out.println("Вектор " + args[1] + " создан.");
    }
}
