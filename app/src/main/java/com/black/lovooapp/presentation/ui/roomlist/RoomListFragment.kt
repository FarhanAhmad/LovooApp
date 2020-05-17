package com.black.lovooapp.presentation.ui.roomlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.black.lovooapp.databinding.FragRoomListBinding
import com.black.lovooapp.presentation.model.LovooRoom
import com.black.lovooapp.presentation.ui.FilterType
import com.black.lovooapp.presentation.ui.IActivityInteractor
import com.black.lovooapp.presentation.viewmodel.RoomListViewModelFactory
import com.black.lovooapp.presentation.viewmodel.RoomsListViewModel
import org.koin.android.ext.android.get

/**
 * Created by farhanahmad on 16/5/20.
 */
class RoomListFragment : Fragment(),
        IRoomClickListener {

    lateinit var fragBinding: FragRoomListBinding
    lateinit var viewModel: RoomsListViewModel

    var activityInteractor: IActivityInteractor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IActivityInteractor)
            activityInteractor = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragBinding = FragRoomListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, RoomListViewModelFactory(get())).get(RoomsListViewModel::class.java)

        fragBinding.rvRoomList.apply {
            adapter = RoomListAdapter(this@RoomListFragment)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        fragBinding.viewModel = viewModel

        observeFilterLiveData()
        handleClickListeners()

        return fragBinding.root
    }

    private fun observeFilterLiveData() {
        viewModel.roomDepartments.observe(viewLifecycleOwner, Observer { depArray ->
            val adapter = ArrayAdapter(fragBinding.spTypeFilter.context, android.R.layout.simple_spinner_item, depArray)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fragBinding.spDepartmentFilter.adapter = adapter
        })
        viewModel.roomTypes.observe(viewLifecycleOwner, Observer { typesArray ->
            val adapter = ArrayAdapter(fragBinding.spTypeFilter.context, android.R.layout.simple_spinner_item, typesArray)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fragBinding.spTypeFilter.adapter = adapter
        })
    }

    private fun handleClickListeners() {
        fragBinding.spTypeFilter.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.applyFilter(FilterType.RoomType, fragBinding.spTypeFilter.selectedItem.toString())
            }

        }

        fragBinding.spDepartmentFilter.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.applyFilter(FilterType.RoomDepartment, fragBinding.spDepartmentFilter.selectedItem.toString())
            }

        }

        fragBinding.labelClearFilter.setOnClickListener {
            fragBinding.spDepartmentFilter.setSelection(0)
            fragBinding.spTypeFilter.setSelection(0)
        }
    }

    override fun onRoomClick(item: LovooRoom) {
        activityInteractor?.showRoomDetails(item)
    }
}