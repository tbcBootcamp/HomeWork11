package com.example.homework11


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.homework11.adapters.ImagesAdapter
import com.example.homework11.data.ImagesList
import com.example.homework11.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var adapter: ImagesAdapter
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ImagesAdapter()
        binding.rvImages.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rvImages.adapter = adapter
        adapter.submitList(ImagesList().getList())

        binding.etSearch.doOnTextChanged { text, start, before, count ->
            text?.let { input ->
                val filtered = ImagesList().getList().filter { it.name.contains(input) }
                adapter.submitList(filtered)
            }

        }

        adapter.onItemClick = {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                    it
                )
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
