package com.black.lovooapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.black.lovooapp.R
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.ui.roomdetail.RoomDetailFragment
import com.black.lovooapp.presentation.ui.roomlist.RoomListFragment

class MainActivity : AppCompatActivity(), IActivityInteractor {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            // activity restarting because it was killed by system
        } else {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, RoomListFragment(), RoomListFragment::class.java.name)
                    .commit()
        }

    }

    override fun showRoomDetails(room: LovooRoom) {

        supportFragmentManager.findFragmentByTag(RoomListFragment::class.java.name)?.apply {
            supportFragmentManager.beginTransaction().hide(this).commit()
        }
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, RoomDetailFragment.instantiate(room))
                .addToBackStack(RoomDetailFragment::class.java.name)
                .commit()
    }

    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            supportFragmentManager.findFragmentByTag(RoomListFragment::class.java.name)?.apply {
                supportFragmentManager.beginTransaction().show(this).commit()
            }
        } else
            super.onBackPressed()
    }
}
