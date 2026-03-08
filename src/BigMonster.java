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

        // Убрали проверку if (difficultGame == 1), чтобы избежать ошибок и рекурсии
        // Теперь просто генерируем пример в зависимости от сложности

        int x = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int y = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int z = r.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
        int trueAnswer = x * y - z;

        System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (trueAnswer == ans) {
            System.out.println("Ты победил меня! Мои братья отомстят тебе!!!");
            return true;
        }
        System.out.println("Ты проиграл эту битву! Я даже не напрягся.");
        return false;
    }

    // Метод taskMonster() без параметров лучше удалить, так как он больше не нужен
    // и вызывает конфликт сигнатур.
}
