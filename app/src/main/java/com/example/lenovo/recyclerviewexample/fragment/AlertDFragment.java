package com.example.lenovo.recyclerviewexample.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.lenovo.recyclerviewexample.R;


public class AlertDFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(final Bundle savedInstancestate){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Allert Dialog");
        builder.setMessage("Hello Dialog");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Ok","It's OK");
            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("No","It's not OK");
                    }
                });
        //Created Dialog
        return builder.create();
    }

    public void show(FragmentManager fm, String s) {
    }
}
