package com.black.lovooapp.presentation.ui.roomdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.databinding.FragRoomDetailsBinding
import com.black.lovooapp.presentation.model.LovooRoom

/**
 * Created by farhanahmad on 17/5/20.
 */
class RoomDetailFragment : Fragment() {

    lateinit var fragBinding: FragRoomDetailsBinding

    var roomObj: LovooRoom? = null

    companion object {
        val TAG = "RoomDetailFragment"
        val KEY_DATA = "data"

        fun instantiate(room: LovooRoom): RoomDetailFragment {
            val fragment = RoomDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(KEY_DATA, room)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragBinding = FragRoomDetailsBinding.inflate(inflater, container, false)

        roomObj = arguments?.getParcelable(KEY_DATA)

        fragBinding.tvFactText.text = roomObj?.roomFact?.text

        handleRoomImages()

        return fragBinding.root
    }

    private fun handleRoomImages() {
        fragBinding.rvRoomImages.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = RoomImagesAdapter(roomObj?.roomFact?.imageList ?: arrayListOf())
        }

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(fragBinding.rvRoomImages)
    }
}