package com.example.firebasewithmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainView extends AppCompatActivity implements IMainView {

    private TextView textViewFirstName;
    private TextView textviewLastName;
    private TextView textViewEmail;
    private CheckBox checkBoxActive;
    IMainPresenter presenter = new MainPresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFirstName = findViewById(R.id.textViewFirstName);
        textviewLastName = findViewById(R.id.textViewLastName);
        textViewEmail = findViewById(R.id.textVieweEmail);
        checkBoxActive = findViewById(R.id.checkBoxActive);
    }


    public void btnLoadClick(View view) {
        presenter.onButtonClicked(this);
    }

    public void SetTextViewFirstName(String firstName) {
        textViewFirstName.setText(firstName);
    }

    public void SetTextViewLastName(String lastName) {
        textviewLastName.setText(lastName);
    }

    public void SetTextViewEmail(String email) {
        textViewEmail.setText(email);
    }

    @Override
    public void SetAllViews(String firstName, String lastName, String email) {
        textViewFirstName.setText(firstName);
        textviewLastName.setText(lastName);
        textViewEmail.setText(email);
        SendLog(firstName +" "+ lastName +" "+ email);
    }
    String TAG="MyLog_View";
    public void SendLog(String Message){
        Log.i(TAG,Message);
    }
}
