package com.example.zihuame.ui.guardados;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.zihuame.R;
import com.example.zihuame.databinding.FragmentNotificationsBinding;

public class GuardadosFragment extends Fragment {

    private GuardadosViewModel guardadosViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        guardadosViewModel =
                new ViewModelProvider(this).get(GuardadosViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final NavController navController = NavHostFragment.findNavController(this);


        Button btn = binding.gRegistro;

        btn.setOnClickListener(view -> navController.navigate(R.id.guardados_to_perfil));


        final TextView textView;
        guardadosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}