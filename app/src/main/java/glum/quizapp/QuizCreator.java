package glum.quizapp;
import java.util.ArrayList;
/**
 * Created by micha on 10/12/2017.
 */

public class QuizCreator {
    public static Quiz createPokemonQuiz()
    {
        Question[] pokemonQuestions = new Question[2];

        ArrayList<Answer> pokemonWrongAnswers = new ArrayList<Answer>();
        pokemonWrongAnswers.add(new Answer("Alakazam", "https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Alakazam.png?alt=media&token=59193272-a02e-4c66-9245-69820dc70d60"));
        pokemonWrongAnswers.add(new Answer ("Crobat","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Crobat.png?alt=media&token=639bb426-a4c2-48de-a0d8-8d079089f0cf"));
        pokemonWrongAnswers.add(new Answer ("Dragonite","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Dragonite.png?alt=media&token=2057ec54-5b4b-423d-b601-e88da1422e8d"));
        pokemonWrongAnswers.add(new Answer ("Dusknoir","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Dusknoir.png?alt=media&token=e996248a-0ec3-4444-bf1c-752bc480129c"));
        Answer pokemonRightAnswer = new Answer("Aggron", "https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Aggron.png?alt=media&token=7b66b423-e394-4dec-bfc2-c2d5ddbe3577");
        Question pokemonQuestion = new Question();
        pokemonQuestion.wrongAnswers = pokemonWrongAnswers;
        pokemonQuestion.correctAnswer = pokemonRightAnswer;
        pokemonQuestion.question = "Which pokemon is steel type?";
        pokemonQuestions[0] = pokemonQuestion;

        ArrayList<Answer> pokemonWrongAnswers2 = new ArrayList<Answer>();
        pokemonWrongAnswers2.add(new Answer("Electivire","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Electivire.png?alt=media&token=ac117817-d362-4599-b9aa-ccbd8ba57114"));
        pokemonWrongAnswers2.add(new Answer("Exploud","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Exploud.png?alt=media&token=d34b7116-325b-4b35-9a16-af0773414888"));
        pokemonWrongAnswers2.add(new Answer("Garchomp","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Garchomp.png?alt=media&token=67566739-9a31-44aa-b607-d18bf717f30d"));
        pokemonWrongAnswers2.add(new Answer("Gengar", "https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Gengar.png?alt=media&token=e4586d10-b0b0-4c52-8690-2bcd08aa5eb0"));
        pokemonWrongAnswers2.add(new Answer("Golem","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Golem.png?alt=media&token=4301a4ee-6e96-4724-b482-c3098a7b14fb"));
        pokemonWrongAnswers2.add(new Answer("Haxorus", "https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Haxorus.png?alt=media&token=1ec748a2-d338-48b7-9062-d87057f0f5a1"));
        pokemonWrongAnswers2.add(new Answer("Kingdra","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Kingdra.png?alt=media&token=77af2afa-1b14-4b34-81f3-c5db436bb6b4"));
        pokemonWrongAnswers2.add(new Answer("Luxray", "https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Luxray.png?alt=media&token=502310aa-5412-49f6-9909-174ddc83dde5"));
        pokemonWrongAnswers2.add(new Answer("Machamp", "https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Machamp.png?alt=media&token=99299959-817c-46c4-a417-1cb497f17db2"));
        pokemonWrongAnswers2.add(new Answer("Magmortar", "https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Magmortar.png?alt=media&token=029f284f-c08a-4208-9f2e-07385ee2ef0f"));
        Answer pokemonRightAnswer2 = new Answer("Magnezone","https://firebasestorage.googleapis.com/v0/b/quizapp-4ca69.appspot.com/o/Magnezone.png?alt=media&token=bbf6ed11-7796-4751-9b3a-0bbc1311259f");
        Question pokemonQuestion2 = new Question();
        pokemonQuestion2.wrongAnswers = pokemonWrongAnswers2;
        pokemonQuestion2.correctAnswer = pokemonRightAnswer2;
        pokemonQuestion2.question = "Which pokemon is weak to fire?";
        pokemonQuestions[1] = pokemonQuestion2;


        return new Quiz("Pokemon Quiz", pokemonQuestions);
    }
}
