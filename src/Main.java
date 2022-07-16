public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, KataAcademy!");

        MathOperation adding = MathOperation.ADD;
        MathOperation dividing = MathOperation.DIVIDE;

        int a = 10;
        int b = 3;

        System.out.println(adding.calculate(a,b));
        System.out.println(dividing.calculate(a,b));



    }
}
