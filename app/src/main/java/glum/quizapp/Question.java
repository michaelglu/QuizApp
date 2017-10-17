package glum.quizapp;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by micha on 10/4/2017.
 */

public class Question {
    String question;
    Answer correctAnswer;
    ArrayList<Answer>wrongAnswers;
    public Question()
    {}
    public Question(String questionString, String correctAnswerString, ArrayList<String>wrongAnswerArray)
    {
        question=questionString;
        correctAnswer = new Answer(correctAnswerString,null);
        wrongAnswers=new ArrayList<Answer>();
        for(String wrongAnswer: wrongAnswerArray)
        {
            wrongAnswers.add(new Answer(wrongAnswer,null));
        }
    }
    public Question(String questionString, ArrayList<Object>correctAnswerArray, ArrayList<ArrayList<Object>>wrongAnswerArray)
    {
        question=questionString;
        correctAnswer=new Answer((String)correctAnswerArray.get(0), (String)correctAnswerArray.get(1));
        wrongAnswers=new ArrayList<Answer>();
        for(ArrayList<Object>w:wrongAnswerArray)
        {
            wrongAnswers.add(new Answer((String)w.get(0),(String)w.get(1)));
        }
    }
    public String getQuestion()
    {
        return question;
    }
    public Answer[] getAnswers()
    {
        ArrayList<Answer>a=new ArrayList<Answer>(wrongAnswers);
        a.add(correctAnswer);
        Answer[]answers=new Answer[a.size()];
        answers=a.toArray(answers);
        return answers;
    }
    public Answer getCorrectAnswer()
    {
        return correctAnswer;
    }
}
