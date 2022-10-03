package com.example.applicationtp2;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.CalendarContract;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.applicationtp2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    Button showMe,longText,calender;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText)findViewById(R.id.inputText);
        showMe = (Button)findViewById(R.id.showMe);
        longText = (Button)findViewById(R.id.longText);
        calender = (Button)findViewById(R.id.calender);
        showMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                String message = txt.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        longText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
        calender.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, "19/11/2022");
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, "20/11/2022");
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
                startActivity(Intent.createChooser(intent, "Add to calendar"));
            }
        });

    }
}