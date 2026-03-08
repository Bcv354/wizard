import java.util.Scanner;

public class SmallMonster extends Monster{

    private String image = "\uD83D\uDC79";

    //    @Override
    public String getImage() {
        return image;
    }

    //    @Override
    public void setImage(String image) {
        this.image = image;
    }

    // переопредилим метод:
    @Override
    public boolean taskMonster(int difficultGame, Person person) {
        System.out.println(">>> БИТВА С SMALL MONSTER! (Маленький монстр) <<<");
        System.out.println("Решите задачу:");

        int x = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int y = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int z = r.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
        int otv = x + y - z;

        System.out.println("Реши пример: " + x + " + " + y + " - " + z + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (ans == otv) {
            System.out.println("Ладно проходи");

            // === ШАНС 30% НА БОНУСНЫЙ ВОПРОС ===
            if (r.nextInt(100) < 30) {
                System.out.println("Так просто не сдамся!!! АВТОМОБИЛЬ В СТУДИЮ!");
                int randomAdd = r.nextInt(1, 20);
                System.out.println("Прибавь " + randomAdd + " к " + ans);

                int bonusAns = sc.nextInt();
                int correctBonus = ans + randomAdd;

                if (bonusAns == correctBonus) {
                    System.out.println("Отлично! Ты победил монстра с сильной решимостью!");

                    // Ответ на бонус
                    if (person.getLive() < 3) {
                        person.upLive();
                        System.out.println("Ой ой ой!Не ожидал что сможешь.Дарю жизнь так уж и быть");
                    } else {
                        System.out.println("А немнога ли?3 жизней тебе хватит");
                    }


                    return true;
                } else {
                    System.out.println("Неа.Не все так просто!");
                    return false;
                }
            }

            // Если бонусного вопроса не было (70% шанс)
            System.out.println("Ты победил монстра!");
            return true;
        }

        System.out.println("Бугагашеньки!Ты не смог посчитать всего немножко.");
        return false;
    }

    SmallMonster(int sizeBoard) {
        super(sizeBoard);
    }
}

