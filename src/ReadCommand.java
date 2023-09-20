import java.io.*;
import java.util.*;
class ReadCommand implements Command {
    private final Map<String, Vector3D> vectors;

    public ReadCommand(Map<String, Vector3D> vectors) {
        this.vectors = vectors;
    }

    @Override
    public void execute(String[] args) {
        vectors.forEach((k, v) -> System.out.println(v));
    }
}
