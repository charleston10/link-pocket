package com.linkpocket.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.linkpocket.R
import com.linkpocket.databinding.ActivityMainBinding
import com.linkpocket.screen.links.adapter.LinkKeeperAdapter
import com.presentation.IPreviewViewModel
import com.presentation.PreviewState
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val viewModel: IPreviewViewModel by inject { parametersOf(AndroidSchedulers.mainThread()) }

    private lateinit var databinding: ActivityMainBinding
    private val listAdapter = LinkKeeperAdapter()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupList()
        observerViewModel()
    }

    override fun onDestroy() {
        viewModel.input.disposable()
        super.onDestroy()
    }

    @SuppressLint("CheckResult")
    private fun observerViewModel() {
        viewModel.output.stateObservable.subscribe {
            handlerState(it)
        }
    }

    private fun setupList() {
        databinding.includeContentSuccess.recyclerCardsLinks.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = listAdapter
        }
    }

    private fun handlerState(state: PreviewState) {
        if (state is PreviewState.Success) {
            listAdapter.addList(state.list)
        }

        databinding.run {
            this.state = state
            executePendingBindings()
        }
    }
}