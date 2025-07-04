package quizapp;

import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // ✅ 25 Diverse Questions
        questions.add(new Question("Which data structure uses LIFO order?",
                new String[]{"Queue", "Stack", "Array", "Tree"}, 1));
        questions.add(new Question("What does AI stand for?",
                new String[]{"Artificial Integration", "Automated Intelligence", "Artificial Intelligence", "Advanced Interface"}, 2));
        questions.add(new Question("What is the result of 9 * 8?",
                new String[]{"72", "81", "64", "98"}, 0));
        questions.add(new Question("What keyword is used to create a subclass in Java?",
                new String[]{"implement", "extends", "inherits", "subclass"}, 1));
        questions.add(new Question("What is the capital of Japan?",
                new String[]{"Tokyo", "Seoul", "Beijing", "Osaka"}, 0));
        questions.add(new Question("Which sorting algorithm has average time complexity O(n log n)?",
                new String[]{"Bubble Sort", "Quick Sort", "Selection Sort", "Insertion Sort"}, 1));
        questions.add(new Question("Which vitamin is most commonly found in citrus fruits?",
                new String[]{"Vitamin A", "Vitamin D", "Vitamin C", "Vitamin B12"}, 2));
        questions.add(new Question("What is the square root of 144?",
                new String[]{"10", "11", "12", "13"}, 2));
        questions.add(new Question("What is Git primarily used for?",
                new String[]{"Design", "Version Control", "Compiling Code", "Debugging"}, 1));
        questions.add(new Question("Which AI model is used for image generation?",
                new String[]{"ChatGPT", "DALL·E", "BERT", "GPT-3"}, 1));
        questions.add(new Question("What is the full form of CPU?",
                new String[]{"Central Power Unit", "Control Processing Unit", "Central Processing Unit", "Compute Performance Unit"}, 2));
        questions.add(new Question("Who developed Python?",
                new String[]{"James Gosling", "Dennis Ritchie", "Guido van Rossum", "Linus Torvalds"}, 2));
        questions.add(new Question("Which planet is called the ‘Morning Star’?",
                new String[]{"Mars", "Venus", "Mercury", "Jupiter"}, 1));
        questions.add(new Question("What does HTTP stand for?",
                new String[]{"HyperText Transfer Protocol", "Hyper Terminal Transport Protocol", "High Tech Text Protocol", "High Transfer Transport Protocol"}, 0));
        questions.add(new Question("What is 15 mod 4?",
                new String[]{"3", "2", "1", "4"}, 0));
        questions.add(new Question("Which cuisine is known for sushi?",
                new String[]{"Chinese", "Korean", "Japanese", "Thai"}, 2));
        questions.add(new Question("Which country is famous for the Eiffel Tower?",
                new String[]{"Germany", "Italy", "France", "Spain"}, 2));
        questions.add(new Question("What is the most common emotion experienced in love?",
                new String[]{"Jealousy", "Happiness", "Anger", "Fear"}, 1));
        questions.add(new Question("Which psychological need is most important according to Maslow?",
                new String[]{"Esteem", "Love", "Safety", "Physiological"}, 3));
        questions.add(new Question("Which logical gate returns true only when inputs differ?",
                new String[]{"AND", "OR", "XOR", "NAND"}, 2));
        questions.add(new Question("What is the binary of decimal 5?",
                new String[]{"101", "110", "1001", "111"}, 0));
        questions.add(new Question("Which AI field deals with teaching computers to learn from data?",
                new String[]{"Machine Learning", "Robotics", "Expert Systems", "Vision"}, 0));
        questions.add(new Question("Which number comes next in the pattern: 2, 4, 8, 16, ?",
                new String[]{"18", "20", "32", "24"}, 2));
        questions.add(new Question("Which Indian dish is made with rice and lentils?",
                new String[]{"Biryani", "Dosa", "Khichdi", "Pav Bhaji"}, 2));
        questions.add(new Question("Which hormone is responsible for love bonding?",
                new String[]{"Adrenaline", "Dopamine", "Oxytocin", "Cortisol"}, 2));

        int score = 0;

        System.out.println("🎯 Welcome to the Online Quiz App!");
        System.out.println("====================================\n");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Q" + (i + 1) + ":");
            questions.get(i).displayQuestion();
            System.out.print("Your answer (1-4): ");
            int userAnswer = sc.nextInt();

            if (questions.get(i).isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer is: " +
                        (questions.get(i).correctAnswerIndex + 1) + ". " +
                        questions.get(i).options[questions.get(i).correctAnswerIndex] + "\n");
            }
        }

        System.out.println("🎉 Quiz Over!");
        System.out.println("Your Score: " + score + " out of " + questions.size());
        double percentage = (score * 100.0) / questions.size();
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("🏆 Excellent!");
        } else if (percentage >= 50) {
            System.out.println("👍 Good effort!");
        } else {
            System.out.println("🔁 Try Again to Improve!");
        }

        sc.close();
    }
}
