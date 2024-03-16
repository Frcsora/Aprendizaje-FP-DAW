//https://www.codewars.com/kata/547274e24481cfc469000416
public class Human {
    public String name;

    public Human(String name) {
        this.name = name;
    }

}
class Man extends Human {
        public Man() {
            super("Adam");
        }
    }
class Woman extends Human {
        public Woman() {
            super("Eve");
        }
    }
class God {
  public static Human[] create() {
        Human[] paradise = new Human[2];
        paradise[0] = new Man();
        paradise[1] = new Woman();
        return paradise;
    }  
}
