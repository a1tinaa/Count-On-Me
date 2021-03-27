package com.example.countdowntoTHPTQG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mQuestionVỉew;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button nextQuestion;
    private String mAnswer;
    private int mQuestionNumber = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        mQuestionVỉew = view.findViewById(R.id.question);
        mButton1 = view.findViewById(R.id.choice1);
        mButton2 = view.findViewById(R.id.choice2);
        mButton3 = view.findViewById(R.id.choice3);
        mButton4 = view.findViewById(R.id.choice4);
        nextQuestion = view.findViewById(R.id.next_question);
        setNextQuestion();

        //Set màu cho button với mỗi lựa chọn đúng hoặc sai
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButton1.getText() == mAnswer){
                    mButton1.setBackgroundResource(R.color.correct_answer);
                }
                else {
                    mButton1.setBackgroundResource(R.color.wrong_answer);
                    if(mButton4.getText() == mAnswer) mButton4.setBackgroundResource(R.color.correct_answer);
                    if(mButton1.getText() == mAnswer) mButton1.setBackgroundResource(R.color.correct_answer);
                    if(mButton2.getText() == mAnswer) mButton2.setBackgroundResource(R.color.correct_answer);
                    if(mButton3.getText() == mAnswer) mButton3.setBackgroundResource(R.color.correct_answer);
                }
            }
        });

        //Set màu cho button với mỗi lựa chọn đúng hoặc sai
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButton2.getText() == mAnswer){
                    mButton2.setBackgroundResource(R.color.correct_answer);
                }
                else{
                    mButton2.setBackgroundResource(R.color.wrong_answer);
                    if(mButton4.getText() == mAnswer) mButton4.setBackgroundResource(R.color.correct_answer);
                    if(mButton1.getText() == mAnswer) mButton1.setBackgroundResource(R.color.correct_answer);
                    if(mButton2.getText() == mAnswer) mButton2.setBackgroundResource(R.color.correct_answer);
                    if(mButton3.getText() == mAnswer) mButton3.setBackgroundResource(R.color.correct_answer);
                }
            }
        });

        //Set màu cho button với mỗi lựa chọn đúng hoặc sai
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButton3.getText() == mAnswer){
                    mButton3.setBackgroundResource(R.color.correct_answer);
                }
                else {
                    mButton3.setBackgroundResource(R.color.wrong_answer);
                    if(mButton4.getText() == mAnswer) mButton4.setBackgroundResource(R.color.correct_answer);
                    if(mButton1.getText() == mAnswer) mButton1.setBackgroundResource(R.color.correct_answer);
                    if(mButton2.getText() == mAnswer) mButton2.setBackgroundResource(R.color.correct_answer);
                    if(mButton3.getText() == mAnswer) mButton3.setBackgroundResource(R.color.correct_answer);
                }
            }
        });

        //Set màu cho button với mỗi lựa chọn đúng hoặc sai
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButton4.getText() == mAnswer){
                    mButton4.setBackgroundResource(R.color.correct_answer);
                }
                else {
                    mButton4.setBackgroundResource(R.color.wrong_answer);
                    if(mButton4.getText() == mAnswer) mButton4.setBackgroundResource(R.color.correct_answer);
                    if(mButton1.getText() == mAnswer) mButton1.setBackgroundResource(R.color.correct_answer);
                    if(mButton2.getText() == mAnswer) mButton2.setBackgroundResource(R.color.correct_answer);
                    if(mButton3.getText() == mAnswer) mButton3.setBackgroundResource(R.color.correct_answer);
                }
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextQuestion();
            }
        });
        return view;
    }

    private void setNextQuestion(){
        mQuestionNumber = mQuestionNumber + 1;
        if(mQuestionNumber == 9) mQuestionNumber = 0;
        mButton1.setBackgroundResource(R.color.bg_button);
        mButton2.setBackgroundResource(R.color.bg_button);
        mButton3.setBackgroundResource(R.color.bg_button);
        mButton4.setBackgroundResource(R.color.bg_button);
        mQuestionVỉew.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButton1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButton2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButton3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButton4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
    }

}