package com.example.lcl;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lcl.databinding.FragmentTeamBinding;


public class TeamFragment extends Fragment {


    FragmentTeamBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_team, container, false);
        View view = binding.getRoot();
        return view;
    }
}