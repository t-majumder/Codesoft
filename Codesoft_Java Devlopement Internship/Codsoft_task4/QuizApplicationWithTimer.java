import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class QuizApplicationWithTimer {
    private List<Question> questions;
    private int score;
    private int currentQuestionIndex;
    private Timer timer;

    public QuizApplicationWithTimer() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;
        timer = new Timer();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        displayQuestion();

        // Set up a timer to limit the time for each question
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    displayQuestion();
                } else {
                    endQuiz();
                }
            }
        }, 30000); // Timer duration: 30 seconds (adjust as needed)

        Scanner scanner = new Scanner(System.in);
        while (currentQuestionIndex < questions.size()) {
            System.out.print("Your choice: ");
            int userChoice = scanner.nextInt();

            if (questions.get(currentQuestionIndex).isCorrect(userChoice)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + questions.get(currentQuestionIndex).getOptions().get(questions.get(currentQuestionIndex).correctOption - 1) + "\n");
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questions.size()) {
                displayQuestion();
            } else {
                endQuiz();
            }
        }
        scanner.close();
    }

    private void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);

        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestionText());

        List<String> options = currentQuestion.getOptions();
        for (int j = 0; j < options.size(); j++) {
            System.out.println((j + 1) + ". " + options.get(j));
        }
    }

    private void endQuiz() {
        timer.cancel();
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.size());
    }

    public static void main(String[] args) {
        QuizApplicationWithTimer quiz = new QuizApplicationWithTimer();

        List<String> options1 = new ArrayList<>();
        options1.add("A) 72");
        options1.add("B) 70");
        options1.add("C) 69");

        Question question1 = new Question("What is 65 + 4?", options1, 3); // Correct option is "Option C"

        List<String> options2 = new ArrayList<>();
        options2.add("A) Albert Einstein ");
        options2.add("B) Richand Feynman");
        options2.add("C) Julius Robert Oppenjeimer");

        Question question2 = new Question("Whice scientist first theorised quantum computers?", options2, 2); // Correct option is "Option Y"

        quiz.addQuestion(question1);
        quiz.addQuestion(question2);

        quiz.startQuiz();
    }
}

class Question {
    private String questionText;
    private List<String> options;
    public int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }
}