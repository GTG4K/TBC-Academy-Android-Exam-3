package com.example.shemajamebeli3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shemajamebeli3.data.GameData
import com.example.shemajamebeli3.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var adapter: XOAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterSetup()
    }

    private fun adapterSetup() {
        adapter = XOAdapter()
        adapter.differ.submitList(GameData.generateGameData(GameType.GAME9))
        binding.rvXO.adapter = adapter
    }

    companion object {
        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }
}