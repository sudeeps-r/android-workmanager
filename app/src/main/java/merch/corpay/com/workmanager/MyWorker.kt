package merch.corpay.com.workmanager

import android.util.Log
import androidx.work.Worker
import merch.corpay.com.workmanager.util.Util

/**
 * Created by Sudeep SR on 21/06/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class MyWorker:Worker(){

    override fun doWork(): Result {

        //Do your stuff here //NW operation DB etc...
        Util.showNotification(applicationContext,"One time request")
        return Result.SUCCESS;
    }

}