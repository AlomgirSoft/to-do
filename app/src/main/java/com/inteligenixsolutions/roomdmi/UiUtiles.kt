package com.inteligenixsolutions.roomdmi

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar


fun View.showSnackBar(
   lifecycleOwner: LifecycleOwner,
    snackBarMsg: LiveData<Int>,
    timestampInt: Int= Snackbar.LENGTH_LONG
){
  snackBarMsg.observe(lifecycleOwner){mag->
      Snackbar.make(this,mag,timestampInt).show()
  }


}