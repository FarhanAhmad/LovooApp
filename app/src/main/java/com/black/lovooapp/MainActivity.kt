package com.black.lovooapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.black.lovooapp.presentation.ui.RoomListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            // activity restarting because it was killed by system
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, RoomListFragment()).commit()
        }

    }
}
