package glum.quizapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by micha on 10/4/2017.
 */

public class Quiz {
    ArrayList<Question>questions;
    String title;
    public Quiz()
    {

    }
    public Quiz(String title , Question[]questions)
    {
        title=title;
        this.questions=new ArrayList<>(Arrays.asList(questions));

    }
    public String getTitle()
    {
        return title;
    }
    public int size()
    {
        return questions.size();
    }
    public Question getQuestion(int index)
    {
        if(0<=index&&index<questions.size())
        {
        return questions.get(index);
        }
        throw new IndexOutOfBoundsException("bad index"+ index);
    }
}
