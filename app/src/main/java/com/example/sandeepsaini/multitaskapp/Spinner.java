package com.example.sandeepsaini.multitaskapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Spinner extends AppCompatActivity {


    @BindView(R.id.new_password_et)
    EditText newPasswordET;
    @BindView(R.id.confirm_password_et)
    EditText confirmPasswordET;
    @BindView(R.id.password_error_tv)
    TextView passwordErrorTV;
    @BindView(R.id.confirm_password_tv)
    TextView confirmPasswordTV;

    @BindView(R.id.security_ques_1_spinner)
    android.widget.Spinner spinnerQuestion1;
    @BindView(R.id.security_question_1_et)
    EditText answerET1;
    @BindView(R.id.security_ques_2_spinner)
    android.widget.Spinner spinnerQuestion2;
    @BindView(R.id.security_question_2_et)
    EditText answerET2;

    @BindView(R.id.next_button)
    Button nextButton;
    @BindView(R.id.back_button)
    Button backButton;
    @BindView(R.id.spin_kit)
    SpinKitView spinKitView;

    List<String> questionArray;

    String newPasswordString;
    String confirmPasswordString;

    String question1;
    String question2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);


        populateSecurityQuestions();

        spinnerQuestion1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (adapterView != null && adapterView.getItemAtPosition(position) != null) {
                    question1 = adapterView.getItemAtPosition(position).toString();
                    spinnerQuestion1.setSelection(position, true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerQuestion2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (adapterView != null && adapterView.getItemAtPosition(position) != null) {
                    question2 = adapterView.getItemAtPosition(position).toString();
                    spinnerQuestion2.setSelection(position, true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @OnClick(R.id.back_button)
    void onBackButtonClicked() {
        finish();
    }

    @OnClick(R.id.next_button)
    void onNextButtonClick() {
        checkPasswordMatching();
    }

    private void populateSecurityQuestions() {

        String[] questions = getResources().getStringArray(R.array.security_questions);
        questionArray = Arrays.asList(questions);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, questionArray);

        spinnerQuestion1.setAdapter(new NothingSelectedSpinnerAdapter(adapter,
                R.layout.layout_nothing_selected, this));
        spinnerQuestion1.setPrompt("Select Question");

        spinnerQuestion2.setAdapter(new NothingSelectedSpinnerAdapter(adapter,
                R.layout.layout_nothing_selected, this));
        spinnerQuestion2.setPrompt("Select Question");

    }

    private void checkPasswordMatching() {

        confirmPasswordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passwordErrorTV.setVisibility(View.GONE);
                confirmPasswordET.setBackground(getResources().getDrawable(R.drawable.rounded_corner_border_gray));
                confirmPasswordTV.setTextColor(Color.BLACK);
                confirmPasswordET.setTextColor(Color.BLACK);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        if (TextUtils.isEmpty(newPasswordET.getText().toString())) {
            showShortToast("Enter New Password");
            return;
        } else if (TextUtils.isEmpty(confirmPasswordET.getText().toString()) &&
                newPasswordET.getText().toString().length() > 6) {
            showShortToast("Enter Confirm Password");
            return;
        } else if (newPasswordET.getText().toString().length() < 6) {
            showLongToast("Password must be more than 6 character");
            newPasswordET.setText("");
            confirmPasswordET.setText("");
            return;
        }


        if ((newPasswordET.getText().toString()).equals((confirmPasswordET.getText().toString()))) {
            newPasswordString = newPasswordET.getText().toString();
            confirmPasswordString = confirmPasswordET.getText().toString();

            Log.d("Sandy", "New Password : " + newPasswordString);
            Log.d("Sandy", "Confirm Password : " + confirmPasswordString);
            checkQuestionsAnswers(confirmPasswordString);
        } else {
            passwordErrorTV.setVisibility(View.VISIBLE);
            confirmPasswordET.setBackground(getResources().getDrawable(R.drawable.rounded_corner_border_red));
            confirmPasswordTV.setTextColor(getResources().getColor(R.color.red_error));
            confirmPasswordET.setTextColor(getResources().getColor(R.color.red_error));
        }
    }


    private void checkQuestionsAnswers(String password) {

        if (TextUtils.isEmpty(answerET1.getText().toString()) || TextUtils.isEmpty(answerET2.getText().toString())) {
            showLongToast("Answer Both the questions");
        } else {
            String answerQuestion1 = answerET1.getText().toString().trim();
            String answerQuestion2 = answerET2.getText().toString().trim();
            Log.d("Sandy", "Answer 1 : " + answerQuestion1);
            Log.d("Sandy", "Answer 2 : " + answerQuestion2);

            Log.d("Sandy", "Question 1 : " + question1);
            Log.d("Sandy", "Question 2 : " + question2);

            showLongToast("This is Done !");
            // createPasswordFragmentPresenter.updateNewPassword(Encrypter.md5(password));
            //inflateButtons(false);
        }
    }


    void showShortToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    void showLongToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    //Steps to clear the prefrences

//    @Override
//    public void logoutSuccess(BaseResponseModel baseResponseModel) {
//        if (baseResponseModel.status.equalsIgnoreCase("success")) {
//            gcfPreferences.clear();
//            Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK |
//                    Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//            getActivity().finish();
//        }
//    }

}
