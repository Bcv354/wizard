import java.util.Scanner;

public class BigMonster extends Monster {

    private String image = "\uD83D\uDC7E";

    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean taskMonster(int difficultGame, Person person) {
        System.out.println(">>> БИТВА С BIG MONSTER! (Большой монстр) <<<");
        System.out.println("Решите задачу:");

        int x = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int y = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int z = r.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
        int trueAnswer = x * y - z;

        System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (trueAnswer != ans) {
            System.out.println("Ты проиграл! В калькуляторе забанили?");
            return false;
        }

        System.out.println("Ты победил меня! Ухожу плакать в подушку");

        // === ВОПРОС С ПОДВОХОМ (10% ШАНС) ===
        if (r.nextInt(100) < 10) {
            System.out.println("\nБУГАГАШЕНЬКИ!НЕ ОТВЕТИШЬ УМРЕШЬ!!!!");
            System.out.println("У ежика 6 иголок бежа он потерял 1.Сколько домов было у Гуси которая живет у бабушки?)");
            System.out.print("Введи ответ: ");

            // Считываем любой ответ (он не влияет на результат)
            if (sc.hasNextInt()) {
                sc.nextInt();
            } else {
                sc.next();
            }

            System.out.println("Ха-ха-ха.Видел бы ты свое лицо.Иди пока пропускаю");
            return true;
        }


        return true;
    }
}

