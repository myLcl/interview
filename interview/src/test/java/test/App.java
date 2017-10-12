package test;

public class App {

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        }catch (Exception e) {
            System.out.println("11111");
        }

    }

}
