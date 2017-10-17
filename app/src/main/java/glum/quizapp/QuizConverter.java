package glum.quizapp;

import java.util.ArrayList;

/**
 * Created by micha on 10/12/2017.
 */

public class QuizConverter {

    public static FireBaseQuiz toFireBaseQuiz(Quiz quiz) {
        FireBaseQuiz fireBaseQuiz = new FireBaseQuiz();
        fireBaseQuiz.title = quiz.title;
        fireBaseQuiz.fireBaseQuestions = new ArrayList<>();
        for (Question q : quiz.questions) {
            fireBaseQuiz.fireBaseQuestions.add(toFireBaseQuestion(q));
        }
        return fireBaseQuiz;
    }

    public static Quiz toQuiz(FireBaseQuiz fireBaseQuiz)
    {
        Quiz quiz = new Quiz();
        quiz.title=fireBaseQuiz.title;
        quiz.questions=new ArrayList<>();
        for(FireBaseQuestion fbq: fireBaseQuiz.fireBaseQuestions)
        {
            quiz.questions.add(toQuestion(fbq));
        }
        return quiz;
    }

    public static FireBaseQuestion toFireBaseQuestion(Question q)
    {
        FireBaseQuestion fbq = new FireBaseQuestion();
        fbq.correctAnswer=q.correctAnswer;
        fbq.question=q.question;
        fbq.wrongAnswers=q.wrongAnswers;
        return fbq;
    }
    public static Question toQuestion(FireBaseQuestion fbq)
    {
        Question q = new Question();
        q.correctAnswer=fbq.correctAnswer;
        q.wrongAnswers=fbq.wrongAnswers;
        q.question=fbq.question;
        return q;
    }
}
