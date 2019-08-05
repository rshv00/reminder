package com.example.reminder;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 1;

    private Button btnCreateNotification = findViewById(R.id.btn_create_notification);
    private ImageButton minus = findViewById(R.id.minus);
    private ImageButton plus = findViewById(R.id.plus);
    private TextView number = findViewById(R.id.num);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setText(changeNum(number.getText(), Action.MINUS));
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setText(changeNum(number.getText(), Action.ADD));
            }
        });

        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "1")
                        .setSmallIcon(R.drawable.blue)
                        .setContentTitle("You created a notification")
                        .setContentText("Notification " + number.getText())
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());

                notificationManager.notify(NOTIFICATION_ID, builder.build());
            }
        });

    }

    private int changeNum(CharSequence cs, Action a) {
        int num = Integer.valueOf((String) cs);
        switch (num) {
            case 1: {
                if (a == Action.ADD) {
                    num++;
                }
                break;
            }
            case 2: {
                if (a == Action.ADD) {
                    num++;
                } else {
                    num--;
                }
                break;
            }
            case 3:
                if (a == Action.MINUS) {
                    num--;
                }
            default:
                break;
        }
        return num;
    }

}
