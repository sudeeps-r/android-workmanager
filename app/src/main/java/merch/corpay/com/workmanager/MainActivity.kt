package merch.corpay.com.workmanager

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Toast
import androidx.work.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var networkReqId:UUID;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun oneTimeWorker(view: View){
        showToast("One time worker started")
        val myWorkReq: OneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).build();
        WorkManager.getInstance().enqueue(myWorkReq)

    }

   fun networkWorkerRepeat(view:View){
       if(::networkReqId.isInitialized){
           showToast("Cancelling the nw request")
           WorkManager.getInstance().cancelWorkById(networkReqId)
       }

       showToast("Network worker repeat")
       val constraintBuild = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
       val periodWorkRequest : PeriodicWorkRequest = PeriodicWorkRequest.Builder(MyNetworkWorker::class.java,10,TimeUnit.SECONDS).setConstraints(constraintBuild).build();
       networkReqId= periodWorkRequest.id
       WorkManager.getInstance().enqueue(periodWorkRequest)
   }
    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()



    }

    fun repeatTillSuccess(view:View){
        showToast("Repeat till success")
        val myData: Data = Data.Builder().putInt("KEY_X_ARG", 42).build()


        val oneTimeRequest  = OneTimeWorkRequest.Builder(MyWorkerRepeatWithInputData::class.java).setInputData(myData).build()
        WorkManager.getInstance().enqueue(oneTimeRequest)

        //You can implement own retry mechanism also able to club multiple work instance and define the order
       // https@ //developer.android.com/topic/libraries/architecture/workmanager
    }

    override fun onDestroy() {
        super.onDestroy()
        WorkManager.getInstance().cancelAllWork()
    }
}
