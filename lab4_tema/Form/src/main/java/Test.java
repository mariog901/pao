package org.Form;

public class Test {
    public static void main(String[] args) {
        Form[] forms=new Form[5];
        forms[0]=new Triangle(5,4,"rosu");
        forms[1]=new Triangle(6,3,"verde");
        forms[2]=new Circle(2,"albastru");
        forms[3]=new Circle(4,"maro");
        forms[4]=new Triangle(3,8,"alb");

        for (Form form : forms) {
            System.out.println(form.toString()); //observ ca se apeleaza metoda toString() specifica fiecarei clase(triangle,circle) ,
            // nu metoda din clasa de baza Form , si observ si polimorfismul
        }
//varianta cu instanceof
//        for (Form form : forms) {
//            if (form instanceof Triangle){
//                Triangle triunghi = (Triangle) form;
//                triunghi.printTriangleDimensions();
//            }
//            if (form instanceof Circle){
//                Circle cerc = (Circle) form;
//                cerc.printCircleDimensions();
//            }
//        }

        //varianta fara instanceof , in care fac try-catch
          for(Form form : forms){
              try{
                  Triangle triunghi= (Triangle) form;
                  triunghi.printTriangleDimensions();
              }catch(ClassCastException exception1){
                  try {
                      Circle cerc = (Circle) form;
                      cerc.printCircleDimensions();
                  }catch(ClassCastException exception2){
                      System.out.println("Forma noastra nu este nici triunghi , nici cerc");
                  }
              }
          }
    }

}
