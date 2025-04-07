import java.text.DecimalFormat;

public class Circle extends Form {
    private float radius;
    public Circle(){}
    public Circle(float radius, String color) {
        super(color);
        this.radius=radius;
    }

    @Override
    public String toString() {
        return "Cerc: " + super.toString() + " " + this.getArea();
    }

    @Override
    public float getArea(){
        double area = Math.PI * radius*radius;
        double truncated = Math.floor(area*100)/100;
        return (float) truncated;
    }
    public void printCircleDimensions(){
        System.out.println("Raza cercului este: " + radius + '\n');
    }


}
