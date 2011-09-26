
package com.roman.tweaks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {

    public static final String CUSTOM_INTENT = "com.roman.tweaks.OPEN";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(CUSTOM_INTENT)) {
            Intent i = new Intent(context, Main.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else if (intent.getAction().equals("com.roman.intents.HARD_REBOOT_ACTION")) {
            if (ShellInterface.isSuAvailable()) {
                ShellInterface.runCommand("reboot");
            }
        }
    }

}
