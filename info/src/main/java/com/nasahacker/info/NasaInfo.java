package com.nasahacker.info;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/**
 * NasaInfo
 *
 * @developer Tamim Hossain
 * @mail tamimh.dev@gmail.com
 */
public class NasaInfo {
    private static int CURRENT_COUNT = 0;
    private static int MAX_COUNT = 50;
    private static String DIALOG_TITLE = "Developer Info!";
    private static String APP_NAME = "";
    private static final String MAIL = "tamimh.dev@gmail.com";

    public static void setMaxCount(int maxCount) {
        MAX_COUNT = maxCount;
    }

    public static void setListener(Context context, String appName) {
        APP_NAME = appName;
        if (CURRENT_COUNT >= MAX_COUNT) {
            showDialog(context);
            CURRENT_COUNT = 0;
        } else {
            increaseCount();
        }
    }

    private static void increaseCount() {
        CURRENT_COUNT++;
    }

    private static void showDialog(Context context) {
        String dialogMessage = "Hey there!\n\nThis app named " + APP_NAME + " was developed by Tamim Hossain, an Android and Backend Developer with experience in Java, Kotlin, and PHP. He developed this app, " + APP_NAME + ".\n\nTamim also has experience in reverse engineering and API extraction and has identified security issues in popular VPN apps like I2VPN, XCom VPN, Instant VPN, and Dubai VPN, each with more than 500k downloads on Google Play Store.\n\nSome of his existing projects include Rojo VPN, Huge VPN, Fly2rayVPN, AtomX VPN, Art Of CMD,Nasa Editor and more !\n\nYou can contact him via email at " + MAIL + " for any information or project inquiries.\n\nThank You !";

        new MaterialAlertDialogBuilder(context)
                .setTitle(DIALOG_TITLE)
                .setMessage(dialogMessage)
                .setPositiveButton("Contact him", (dialog, which) -> {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + MAIL));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Contacting from " + APP_NAME);
                    intent.putExtra(Intent.EXTRA_TEXT, "Hi Tamim, I wanted to...");
                    context.startActivity(intent);
                })
                .setNegativeButton("Close", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
