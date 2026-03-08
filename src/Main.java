import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String castle = "\uD83C\uDFF0";
        String wall = "\uD83E\uDDB1";
        int sizeBoard = 5;



        Person person = new Person(sizeBoard);


        int step = 0;

        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }


        int countMonster = sizeBoard * sizeBoard - sizeBoard - 5;
        Random r = new Random();

        // для работы сбольшим количеством монстров воспользуемся массивом
        Monster[] arrMonster = new Monster[countMonster + 1];
        int count = 0;
        Monster test;
        while (count <= countMonster){
            int type = r.nextInt(3);

            if (type == 0) {
                test = new Monster(sizeBoard);
            } else if (type == 1) {
                test = new SmallMonster(sizeBoard);
            } else {
                test = new BigMonster(sizeBoard);
            }

            if (board[test.getY()][test.getX()].equals("  ")) {
                board[test.getY()][test.getX()] = test.getImage();
                arrMonster[count] = test;
                count++; // Увеличиваем счетчик только если монстр успешно поставлен
            }

        }

        int castleX = r.nextInt(sizeBoard);
        int castleY = 0;


        board[castleY][castleX] = castle;

        int wallCount = 3;
        int w = 0;
        while (w < wallCount) {
            int wx = r.nextInt(sizeBoard);
            int wy = r.nextInt(sizeBoard);
            // Ставим стену, только если клетка пустая и это не старт игрока
            if (board[wy][wx].equals("  ") && !(wx == person.getX() - 1 && wy == person.getY() - 1)) {
                board[wy][wx] = wall;
                w++;
            }
        }

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА(YES) или НЕТ(NO))");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);




        switch (answer) {
            case "ДА","YES" -> {
                System.out.println("Выбери сложность игры(от 1 до 5):");
                int difficultGame = sc.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);
                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();
                    outputBoard(board, person.getLive());
                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    // проверка
                    if (person.moveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                    "\nХод номер: " + step);
                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        } else if (next.equals(wall)) {
                            System.out.println("⛔ ХА-ХА-ХА!Ты врезался попробуй обойти.");
                        }else {
                            for (Monster monster : arrMonster) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster(difficultGame,person)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);

                                    } else {
                                        person.downLive();

                                    }if (person.getLive() <= 0){
                                        System.out.println("И все же ты не смог... Никаких 2 шансов тебе не будет.");
                                        return;
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Неккоректный ход");
                    }
                }
            }
            case "НЕТ","NO" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }

    static void outputBoard(String[][] board, int live) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);


        System.out.println("Количество жизней:\t" + live + "\n");
    }
}