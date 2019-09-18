package br.ufrn.eaj.tads.customtabsexample

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var url = "http://tads.eaj.ufrn.br"
            var builder = CustomTabsIntent.Builder()
            var i = Intent()
            var pi = PendingIntent.getActivity (this, 55, i, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setActionButton(resources.getDrawable(R.mipmap.ic_launcher).toBitmap(60,60), "Botton", pi)
            builder.setActionButton(resources.getDrawable(R.mipmap.ic_launcher).toBitmap(90,90), "Home", pi)
            builder.setToolbarColor(resources.getColor(android.R.color.holo_blue_bright))
            var customTabsIntent = builder.build()

            customTabsIntent.launchUrl(this, Uri.parse(url))
        }
    }
}
