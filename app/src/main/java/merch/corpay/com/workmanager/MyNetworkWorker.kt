package merch.corpay.com.workmanager

import androidx.work.Worker
import merch.corpay.com.workmanager.util.Util

/**
 * Created by Sudeep SR on 02/08/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class MyNetworkWorker : Worker(){
    override fun doWork(): Result {
        Util.showNotification(applicationContext,"Repeat network worker")
        return Result.SUCCESS
    }

}