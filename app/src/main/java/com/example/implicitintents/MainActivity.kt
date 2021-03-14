package com.example.implicitintents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.example.implicitintents.R.layout.activity_main
import com.example.implicitintents.R.string
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


     fun openWebsite(view: View) {

        val uri = Uri.parse(website_edittext.text.toString())
        startActivity(Intent(Intent.ACTION_VIEW, uri))


        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }}
     fun openLocation(view: View) {
         val loc = location_edittext.text.toString()

        val uri = Uri.parse("geo:0,0?q=" + loc);
         startActivity(Intent(Intent.ACTION_VIEW, uri))


         if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }}
     fun shareText(view: View) {



        val mimeType = "text/plain"
        ShareCompat.IntentBuilder

                .from(this)
                .setText(share_edittext.text.toString())

                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .startChooser();


    }

}
