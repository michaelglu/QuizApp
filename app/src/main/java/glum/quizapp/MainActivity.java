package glum.quizapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static glum.quizapp.R.id.quizlistView;

public class MainActivity extends AppCompatActivity {

    TextView mFireBaseStatusTextView;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mStatusReference = mRootRef.child("status");
    DatabaseReference mQuizzesReference = mRootRef.child("Quizzes");
    DatabaseReference mPokemonQuiz = mQuizzesReference.child("PokemonQuiz");

    int n;
    Quiz quiz;
    int index;
    Integer numCorrect = 0;
    Integer numWrong = 0;
    boolean load;
    ListView mQuizlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFireBaseStatusTextView = (TextView) findViewById(R.id.fireBaseStatus);
        mFireBaseStatusTextView.setText("Loading...");
        mQuizlistView = (ListView) findViewById(quizlistView);

        mPokemonQuiz.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FireBaseQuiz data = dataSnapshot.getValue(FireBaseQuiz.class);
                System.out.println("Hey there");

                System.out.println(data);

                quiz = QuizConverter.toQuiz(data);
                load = true;
                if(n >= quiz.questions.size()){
                    makeEnd();
                }else {
                    makeList();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        n = sharedPref.getInt("n", 0);
        numCorrect = sharedPref.getInt("numCorrect", 0);
        numWrong = sharedPref.getInt("numWrong", 0);
        if(load){
            if(n >= quiz.questions.size()){
                makeEnd();
            }else {
                makeList();
            }
        }

        mStatusReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String text = dataSnapshot.getValue(String.class);
                //mFireBaseStatusTextView.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                mFireBaseStatusTextView.setText("Firebase Connection Unsuccessful");
            }
        });
        mPokemonQuiz.setValue(QuizConverter.toFireBaseQuiz(QuizCreator.createPokemonQuiz()));

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("n", n);
        editor.putInt("numCorrect", numCorrect.intValue());
        editor.putInt("numWrong", numWrong.intValue());
        editor.commit();
    }

    public void makeList(){
        Question q = quiz.questions.get(n);
        int size = q.wrongAnswers.size() + 1;
        final String[] answersArray = new String[size];
        String[] imageArray = new String[size];
        answersArray[0] = q.correctAnswer.answerText;
        imageArray[0] = q.correctAnswer.answerImage;
        for(int i =1; i<answersArray.length;  i++){
            answersArray[i] = q.wrongAnswers.get(i-1).answerText;
            imageArray[i] = q.wrongAnswers.get(i-1).answerImage;
        }
        mFireBaseStatusTextView.setText(q.question);
        CustomList adapter = new
                CustomList(MainActivity.this, answersArray, imageArray);
        System.out.println(adapter);
        mQuizlistView.setAdapter(adapter);
        mQuizlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +answersArray[position], Toast.LENGTH_SHORT).show();
                if(position == 0){
                    numCorrect++;
                }else{
                    numWrong++;
                }
                n++;
                if(n >= quiz.questions.size()){
                    makeEnd();
                }else{
                    makeList();
                }


            }
        });

    }

    public void makeEnd() {
        String[] optionsArray = new String[4];
        String[] imageArray = new String[4];
        optionsArray[0] = "       Number correct: " + numCorrect.toString();
        optionsArray[1] = "       Number wrong: " + numWrong.toString();
        optionsArray[2] = "       Thanks for playing!";
        optionsArray[3] = "       Play Again (Please Click!)";
        imageArray[0] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/success.png?alt=media&token=23ed29cb-a16f-4a0d-a76d-a8ddf4199b02";
        imageArray[1] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/x-mark.png?alt=media&token=6b6903a0-bcce-45c0-a031-46943ba03eff";
        imageArray[2] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/blank.png?alt=media&token=5af928de-9426-460f-b4e6-05bfd808ce41";
        imageArray[3] = "https://firebasestorage.googleapis.com/v0/b/quizapp-26149.appspot.com/o/replay.png?alt=media&token=20a088c3-e6bd-488b-be33-a684d1c54d14";
        CustomList adapter = new
                CustomList(MainActivity.this, optionsArray, imageArray);
        System.out.println(adapter);
        mQuizlistView.setAdapter(adapter);

        mQuizlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position == 3) {
                    Toast.makeText(MainActivity.this, "Started New Quiz", Toast.LENGTH_SHORT).show();
                    n = 0;
                    numCorrect = 0;
                    numWrong = 0;
                    makeList();
                }


            }
        });


    }
}