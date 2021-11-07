package com.yurich.graphqlmonstrousity.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yurich.graphqlmonstrousity.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    @Inject
    lateinit var detailViewModelAssistedFactory: DetailViewModel.DetailViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels {
        DetailViewModel.provideFactory(detailViewModelAssistedFactory, args.postId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

}