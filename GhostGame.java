import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GhostGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;

        while (true) {

            int attempts = 5;
            int step_score = 10;
            int round_score = 0;
            int totalScore = 0;

            System.out.println("Обери одну з трьох дверей, за якою знаходиться привид. Кількість спроб обмежена" + attempts);

            while (attempts > 0) {
                if (random.nextDouble() < 0.5) {
                    System.out.print("Унікальна моливість: вгадай двері та отримай в 3 разів більше поінтів: ");
                    int extraGuess = scanner.nextInt();

                    if(extraGuess >= 1 && extraGuess <= 3) {
                        int extraGhost = random.nextInt(1) + 1;
                        if(extraGuess == extraGhost){
                            System.out.println("Молодець ти вгадав, приз в тричі більше поінтів "); //придумати щось цікаве і нове для гри
                            step_score *= 3;
                            totalScore += step_score;
                            System.out.println("Кількість поінтів: " + totalScore);
                            step_score += 5;

                        }else{
                            System.out.println("Ти не вгадав,пощастить в наступний раз");

                        }
                    }
                }

                int doorGhost = random.nextInt(1) + 1;
                System.out.print("Введи свій вибір: ");
                int playerGues = scanner.nextInt();

                if (playerGues < 1 || playerGues > 3) {
                    System.out.println("Некоректний формат відповіді. Спробуй щен раз. ");
                    continue;
                }

                if (doorGhost == playerGues) {
                    System.out.println("Молодець,ти вгадав! ");
                    totalScore += step_score;
                    System.out.println("Кількість поінтів: " + totalScore);
                    step_score += 5;

                } else {
                    System.out.println("Вибір не првильний. Спробуй щераз! ");
                    --attempts;
                    System.out.println("Кількість спрб: " + attempts);
                }
            }



            System.out.println("Спроби закінчились. Хочеш продовжити гру? (так / ні)");
            String playAgain = scanner.next();

            if (playAgain.equals( "ні")) {
                System.out.println("Дякую за гру! ");
                break;


            }
        }
        scanner.close();
    }
}
