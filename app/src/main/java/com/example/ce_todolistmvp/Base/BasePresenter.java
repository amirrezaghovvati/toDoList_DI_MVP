package com.example.ce_todolistmvp.Base;

public interface BasePresenter <T extends BaseView>{
    void onAttach(T view);
    void onDetach();
}
