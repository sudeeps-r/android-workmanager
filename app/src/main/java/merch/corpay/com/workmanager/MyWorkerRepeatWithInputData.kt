package merch.corpay.com.workmanager

import androidx.work.Worker
import merch.corpay.com.workmanager.util.Util

/**
 * Created by Sudeep SR on 02/08/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class MyWorkerRepeatWithInputData : Worker(){

    companion object {
        var value:Int=0
    }
    override fun doWork(): Result {

       val va= inputData.getInt("KEY_X_ARG",0)
        Util.showNotification(applicationContext,"Exponential retry"+va)
        value++
        if(value>2){
            Util.showNotification(applicationContext,"Exponential retry end"+va)
            return Result.SUCCESS
        }
        return Result.RETRY;
    }

}