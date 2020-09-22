package com.linkpocket.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.linkpocket.R
import com.linkpocket.databinding.ActivityMainBinding
import com.presentation.IPreviewViewModel
import com.presentation.PreviewState
import com.presentation.PreviewViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private lateinit var databinding : ActivityMainBinding
    private val viewModel: IPreviewViewModel by inject { parametersOf(AndroidSchedulers.mainThread()) }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.output.stateObservable.subscribe {
            handlerState(it)
        }
    }

    override fun onDestroy() {
        viewModel.input.disposable()
        super.onDestroy()
    }

    private fun handlerState(state: PreviewState){
        databinding.run {
            this.state = state
            executePendingBindings()
        }
    }
}