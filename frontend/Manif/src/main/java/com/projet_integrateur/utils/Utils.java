package com.projet_integrateur.utils;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;

import com.projet_integrateur.Globals;

import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.time.LocalDateTime;
import java.util.Random;


public class Utils
{
    private final static String  TAG = "[" + Utils.class.getSimpleName().toUpperCase() + "]";
    private static ProgressDialog DialogProgress = null;

    public static ProgressDialog getDialog_InProgress()
    {
        if (DialogProgress == null)
            DialogProgress =  new ProgressDialog(Globals.CURRENT_ACTIVTY);
        return DialogProgress;
    }

    public static void Dialog_InProgress_Show(String thisMessage)
    {
       if (thisMessage.isEmpty()) thisMessage = "LOADING...";
       getDialog_InProgress().setMessage(thisMessage);
       getDialog_InProgress().show();
    }

    public static void Dialog_InProgress_Dismiss()   {   getDialog_InProgress().dismiss(); DialogProgress = null; }


        public static void log( String TAG, String Message)
        {
            Log.i(TAG,  Message);   Toast.makeText(Globals.CURRENT_CONTEXT, Message, Toast.LENGTH_SHORT).show();
        }

        public static AlertDialog showAlert(String title,String Message, final String NegButton,  final String posButton)
        {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Globals.CURRENT_CONTEXT);
                alertBuilder.setTitle(title);
                alertBuilder.setMessage(Message);
                if (NegButton != null) {
                        alertBuilder.setNegativeButton(NegButton,
                                new DialogInterface.OnClickListener() {

                                        public void onClick(DialogInterface dialog, int which) {
                                                // TODO Auto-generated method stub

                                        }
                                });
                }
                if (posButton != null) {
                        alertBuilder.setPositiveButton(posButton,
                                new DialogInterface.OnClickListener() {

                                        public void onClick(DialogInterface dialog, int which) {
                                                // TODO Auto-generated method stub

                                        }
                                });
                }
                AlertDialog alert = alertBuilder.create();
                alert.show();
            return alert;
        }
        
    public static String updateTime_Now() { return  LocalDateTime.now().toString();/*.replace('T', ' ').substring(0, 19); */ }


}
