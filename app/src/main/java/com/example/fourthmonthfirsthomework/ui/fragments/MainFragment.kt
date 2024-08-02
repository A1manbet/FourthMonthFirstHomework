package com.example.fourthmonthfirsthomework.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fourthmonthfirsthomework.data.models.User
import com.example.fourthmonthfirsthomework.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.apply {
            btnSend.setOnClickListener{
                val user = User(
                    etName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString().toInt()
                )
                val direction = MainFragmentDirections.actionMainFragmentToSecondFragment(user)
                findNavController().navigate(direction)
            }
        }
    }
}