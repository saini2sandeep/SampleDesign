package com.example.sandeepsaini.multitaskapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Sandeep Saini on 10/22/2018
 */
public class AlertUtils {

    private AlertDialog.Builder builder;
    private AlertDialogListener alertDialogListener;

    // Interface to send back the response of click
    interface AlertDialogListener {
        void onClick(int a);
    }

    public AlertUtils(Context context, AlertDialogListener alertDialogListener) {
        builder = new AlertDialog.Builder(context);
        this.alertDialogListener = alertDialogListener;
    }

    //    Two button alert dialog
    public void showAlertWithTwoButtons(String title, String message, String positiveButtonText,
                                        String negativeButtonText) {
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // if you want to pass the actual value of i,then pass the i in onClick or if you want 1 on
                // positive button click then pass 1 here.
                if (alertDialogListener != null)
                    alertDialogListener.onClick(1);
            }
        });

        builder.setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // if you want to pass the actual value of i, then pass the i in onClick or if you want 1 on
                // negative button click then pass 0 here.
                if (alertDialogListener != null)
                    alertDialogListener.onClick(0);
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    //    One button alert dialog
    public void showAlertDialogWithOneButton(String title, String message, String buttonText) {
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (alertDialogListener != null)
                    alertDialogListener.onClick(1);
            }
        });
        builder.show();
    }
}

