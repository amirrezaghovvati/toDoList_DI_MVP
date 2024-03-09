package com.example.ce_todolistmvp.Starter.GetStart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ce_todolistmvp.R;
import com.google.android.material.button.MaterialButton;

import javax.inject.Inject;

public class FragmnetGetStart extends Fragment implements GetStartContract.GetStartView {
    private MaterialButton btnGetStart;
    @Inject
    GetStartContract.GetStartPresenter presenter;
    private GetStartComponent component;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.get_start,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component= DaggerGetStartComponent.builder().build();
        component.injectFields(this);
        //============================================
        btnGetStart=view.findViewById(R.id.btnGetStart);
        //============================================
        btnGetStart.setOnClickListener(v->{
        presenter.onBtnStartClicked();
        });

        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void getStart() {
        Navigation.findNavController(getView()).navigate(FragmnetGetStartDirections.actionFragmnetGetStartToFragmentAuth());
    }
}
