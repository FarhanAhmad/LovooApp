package com.black.lovooapp.presentation.ui.roomdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.databinding.FragRoomDetailsBinding
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.viewmodel.RoomDetailViewModel
import com.black.lovooapp.presentation.viewmodel.RoomDetailViewModelFactory
import org.koin.android.ext.android.get

/**
 * Created by farhanahmad on 17/5/20.
 */
class RoomDetailFragment : Fragment() {

    lateinit var fragBinding: FragRoomDetailsBinding

    var viewModel: RoomDetailViewModel? = null
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragBinding = FragRoomDetailsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, RoomDetailViewModelFactory(get())).get(RoomDetailViewModel::class.java)

        roomObj = arguments?.getParcelable(KEY_DATA)
        viewModel?.setRoomData(roomObj)

        fragBinding.obj = roomObj

        observeRoomFact()
        observeRoomBookings()
        handleClickListner()

        return fragBinding.root
    }

    private fun observeRoomFact() {
        viewModel?.lovooRoomFact?.observe(viewLifecycleOwner, Observer {

            fragBinding.roomFactContainer.visibility = View.VISIBLE

            fragBinding.tvFactText.text = it?.text

            fragBinding.rvRoomImages.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = RoomImagesAdapter(it?.imageList ?: arrayListOf())
            }

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(fragBinding.rvRoomImages)
        })
    }

    private fun observeRoomBookings() {

        viewModel?.lovooRoomBookings?.observe(viewLifecycleOwner, Observer { bookingList ->

            fragBinding.roomBookingsContainer.visibility = View.VISIBLE

            fragBinding.rvRoomBookings.apply {
                layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
                adapter = RoomBookingAdapter(bookingList)
            }
        })
    }

    private fun handleClickListner(){
        fragBinding.btBookRoom.setOnClickListener {
            viewModel?.bookRoom()
        }
    }

}