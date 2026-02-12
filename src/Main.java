import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     int step = 0;
     int personX;
     int personY;
     int personLive = 3;
     int sizeBoard = 5;
        personX = 1 + sizeBoard / 2;
        personY = 1 + sizeBoard / 2;
        step = step + 1;
        String person = "\uD83E\uDDD9";
        String monster = "\uD83D\uDC7E";
        String gamingField = "+ —— + —— + —— +\n"
                + "|    |    |    |\n"
                + "+ —— + —— + —— +\n"
                + "|    | " + monster + " |    |\n"
                + "+ —— + —— + —— +\n"
                + "| " + person + " |    |    |\n"
                + "+ —— + —— + —— +";
        System.out.println("Количество жизней: " + personLive + " " + person);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);
    }
}