package com.black.lovooapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.databinding.FragRoomListBinding
import com.black.lovooapp.presentation.viewmodel.RoomListViewModelFactory
import com.black.lovooapp.presentation.viewmodel.RoomsListViewModel
import org.koin.android.ext.android.get

/**
 * Created by farhanahmad on 16/5/20.
 */
class RoomListFragment : Fragment() {

    lateinit var fragBinding: FragRoomListBinding
    lateinit var viewModel: RoomsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragBinding = FragRoomListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, RoomListViewModelFactory(get())).get(RoomsListViewModel::class.java)

        fragBinding.rvRoomList.apply {
            adapter = RoomListAdapter()
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        fragBinding.viewModel = viewModel

        return fragBinding.root
    }

}