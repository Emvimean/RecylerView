package com.example.lenovo.recyclerviewexample.activity;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.recyclerviewexample.R;
import com.example.lenovo.recyclerviewexample.fragment.AlertDFragment;

/**
 *
 */
public class LoginActivity extends AppCompatActivity {
    FragmentManager fragmentManagerm = getSupportFragmentManager();
    Button btnLogin, btnCancel, button;
    EditText edtEmail, edtPassword;
    private ProgressBar spinner;
    TextView txtView;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.button);
        edtEmail = (EditText) findViewById(R.id.editText);
        edtPassword = (EditText) findViewById(R.id.editText2);
        btnCancel = (Button) findViewById(R.id.button2);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDFragment alertDFragment = new AlertDFragment();
                alertDFragment.show(fragmentManagerm,"Hello Dialog");
            }
        });

        // Click on Login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtEmail.getText().toString().equals("admin") &&
                        edtPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),"Successful..!", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(in);

                }else {
                    if (edtEmail.getText().toString().isEmpty() &&
                            edtPassword.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),"Please input your name and password first..!", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Please try again Thanks..!", Toast.LENGTH_LONG).show();
                        /*Intent in = new Intent(LoginActivity.this, DetailActivity.class);
                        startActivity(in);*/
                    }
                }
                //pushNotification();
            }
        });

        // Click on Cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(view);
            }
        });
    }

    /**
     *
     * @param view
     */
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure, You wanted to close this screen?");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(LoginActivity.this,
                                        " Screen close successfully !",Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(LoginActivity.this," Close Screen rejected successfully !", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    /**
     *
     * @param title
     * @param subject
     */
    public void pushNotification(String title, String subject){
        title = edtEmail.getText().toString().trim();
        subject = edtPassword.getText().toString().trim();
        NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notify = new Notification.Builder(getApplicationContext()).setContentTitle(title).setContentText(subject)
                    .setSmallIcon(R.drawable.abc).build();
        }

        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.notify(0, notify);
    }
}
