package com.example.permissions_prep

import android.os.Build
import android.os.Build.VERSION_CODES.M
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import android.Manifest
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var  button : Button


    private val cameraResultLancher : ActivityResultLauncher<String> =
registerForActivityResult(
    ActivityResultContracts.RequestPermission())
    {
        isGranted ->
        if(isGranted)
        {
            Toast.makeText(this," permission granted ",Toast.LENGTH_LONG).
                show()
        }else
        {
            Toast.makeText(this,"  not granted ",Toast.LENGTH_LONG).
            show()
        }

    }

    private val cameraandLocationResultLancher : ActivityResultLauncher<Array<String>> =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions())
        {
               // it gives map
            permissions->
            permissions.entries.forEach {

                val permissionname= it.key
                val isGranted =it.value
                 if (isGranted)
                 {
                     if(permissionname==Manifest.permission.ACCESS_COARSE_LOCATION)
                     {
                         Toast.makeText(this,"granted course loc ",Toast.LENGTH_LONG).show()

                     }else  if(permissionname==Manifest.permission.ACCESS_FINE_LOCATION)
                     {
                         Toast.makeText(this,"granted FIne  loc",Toast.LENGTH_LONG).show()

                     }else  if(permissionname==Manifest.permission.CAMERA)
                     {
                         Toast.makeText(this,"granted for camera",Toast.LENGTH_LONG).show()

                     }

                 }else
                 {

                     if(permissionname==Manifest.permission.ACCESS_COARSE_LOCATION)
                     {
                         Toast.makeText(this,"granted  not course loc ",Toast.LENGTH_LONG).show()

                     }else  if(permissionname==Manifest.permission.ACCESS_FINE_LOCATION)
                     {
                         Toast.makeText(this,"granted  not FIne  loc",Toast.LENGTH_LONG).show()

                     }else  if(permissionname==Manifest.permission.CAMERA)
                     {
                         Toast.makeText(this,"granted not for camera",Toast.LENGTH_LONG).show()

                     }
                 }
            }

        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.b_click)

        button.setOnClickListener{

if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M &&
        shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)
        )
{
    showRationaleDialog("permisison demo camrea access " ,
        "camera access is vdenied ")


}else
{
    cameraandLocationResultLancher.launch(
        arrayOf(Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,

            )
    )

}


        }



    }

    private fun showRationaleDialog(
        title: String,
        message: String,
    ) {
        val builder: androidx.appcompat.app.AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel") { dialog, _ ->

                // for one permission
          //      cameraResultLancher.launch(Manifest.permission.CAMERA)


                dialog.dismiss()
            }
        builder.create().show()
    }
}