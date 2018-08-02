package merch.corpay.com.workmanager.util

import android.content.Context
import android.support.v4.app.NotificationCompat
import merch.corpay.com.workmanager.R
import android.support.v4.app.NotificationManagerCompat
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build
import android.app.PendingIntent
import android.content.Intent
import android.support.v4.app.TaskStackBuilder
import merch.corpay.com.workmanager.MainActivity


/**
 * Created by Sudeep SR on 01/08/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class Util {
    companion object {
        fun showNotification(context: Context,message:String ){
            val channelId = "channel-01"
            val channelName = "Channel Name"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val mBuilder = NotificationCompat.Builder(context,channelId)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(message)
                    .setContentText(message)
                    .setStyle(NotificationCompat.BigTextStyle()
                            .bigText(message))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId,
                        channelName,
                        importance)
                notificationManager.createNotificationChannel(channel)

            }

            notificationManager.notify(1,mBuilder.build())
        }
    }
}