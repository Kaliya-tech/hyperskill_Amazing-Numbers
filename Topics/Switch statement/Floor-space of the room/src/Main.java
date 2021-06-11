import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();

        switch (figure) {
            case "triangle":
                double a = scanner.nextInt();
                double b = scanner.nextInt();
                double c = scanner.nextInt();
                double p = (a + b + c) / 2;
                double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println(s);
                break;

            case "rectangle":
                double d = scanner.nextInt();
                double e = scanner.nextInt();
                System.out.println(d * e);
                break;

            default:
                double r = scanner.nextInt();
                System.out.println((r * r) * 3.14);
                break;
        }
    }
}