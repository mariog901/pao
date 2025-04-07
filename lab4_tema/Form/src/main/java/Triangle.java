import java.util.Objects;

public class Triangle extends Form{
    private float height;
    private float base;
    public Triangle(){}
    public Triangle(float height, float base,String color){
        super(color);
        this.height=height;
        this.base=base;
    }

    @Override
    public String toString() {
        return "Triunghi: "+
                super.toString()+ " " + (int) this.getArea();
    }



    @Override
    public float getArea(){
        return (int)(0.5 *height*base);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Float.compare(height, triangle.height) == 0 && Float.compare(base, triangle.base) == 0 && this.getColor().equals(triangle.getColor());

    }
    //am ales criteriul de echivalenta al culorii ,
    // deoarece doua triunghiuri nu sunt egale daca au doar aria egala ,
    // trebuie sa fie identice , adica si aceeasi arie , si aceeasi culoare.

    public void printTriangleDimensions(){
        System.out.printf("Baza triunghiului este: "+ base +'\n');
        System.out.println("Inaltimea triunghiului este: "+ height +'\n');

    }



}
