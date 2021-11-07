package com.yurich.graphqlmonstrousity.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yurich.graphqlmonstrousity.R
import com.yurich.graphqlmonstrousity.domain.Post
import com.yurich.graphqlmonstrousity.presentation.list.adapter.PostsListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(), PostsListAdapter.OnPostClickListener {

    private val listViewModel: ListViewModel by viewModels()

    private lateinit var postsList: RecyclerView
    private lateinit var postsAdapter: PostsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeList(view)
        initializeViewModel()
    }

    private fun initializeList(view: View) {
        postsList = view.findViewById(R.id.vehicle_list)
        postsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        postsList.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )

        postsAdapter = PostsListAdapter(this)

        postsList.adapter = postsAdapter
    }

    private fun initializeViewModel() {

    }

    override fun onPostClicked(post: Post) {
        findNavController().navigate(
            ListFragmentDirections
                .actionListFragmentToDetailFragment(post.id)
        )
    }

}