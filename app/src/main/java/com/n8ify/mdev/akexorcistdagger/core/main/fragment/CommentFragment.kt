package com.n8ify.mdev.akexorcistdagger.core.main.fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.n8ify.mdev.akexorcistdagger.R
import com.n8ify.mdev.akexorcistdagger.common.BaseFragment
import com.n8ify.mdev.akexorcistdagger.core.main.adapter.CommentAdapter
import com.n8ify.mdev.akexorcistdagger.core.main.viewmodel.CommentViewModel
import com.n8ify.mdev.akexorcistdagger.di.Injectable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_comment.*
import retrofit2.Retrofit
import javax.inject.Inject

class CommentFragment : BaseFragment() {

    init {
        TAG = CommentFragment::class.java.simpleName
    }

    val commentViewModel by lazy { ViewModelProviders.of(this@CommentFragment).get(CommentViewModel::class.java) }

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    companion object {
        fun newInstance() : CommentFragment {
            return CommentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        println(retrofit)
        return LayoutInflater.from(context).inflate(R.layout.fragment_comment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this@CommentFragment.commentViewModel.getComments().subscribeBy(
            onSuccess = {
                rv_comment.apply {
                    this.layoutManager = LinearLayoutManager(context)
                    this.adapter = CommentAdapter(it)
                }
            },
            onError = { doOnUnexpectedError(it) }
        )
    }

}