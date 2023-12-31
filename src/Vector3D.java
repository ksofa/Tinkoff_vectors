import java.io.Serializable;

public class Vector3D implements Serializable{
    private String name;
    private double x;
    private double y;
    private double z;

    public Vector3D(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public static double dotProduct(Vector3D v1, Vector3D v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public static Vector3D crossProduct(Vector3D v1, Vector3D v2) {
        return new Vector3D(
                "",
                v1.y * v2.z - v1.z * v2.y,
                v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x
        );
    }

    public static double angle(Vector3D v1, Vector3D v2) {
        return Math.acos(dotProduct(v1, v2) / (v1.length() * v2.length()));
    }

    @Override
    public String toString() {
        return name + ": [" + x + ", " + y + ", " + z + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


}

