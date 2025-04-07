public class Form {
    private String color;
    public float getArea(){
        return 0;
    }

    @Override
    public String toString() {
        return "Form{" +
                "color='" + color + '\'' +
                '}';
    }
    public Form(){}
    public Form(String color) {
        this.color=color;
    }
    public String getColor() {
        return color;
    }




}
