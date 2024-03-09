package com.example.ce_todolistmvp.Starter.GetStart;

import javax.inject.Inject;

public class GetStartPresenter implements GetStartContract.GetStartPresenter{
    private GetStartContract.GetStartView view;
    @Inject
    public GetStartPresenter(){}
    @Override
    public void onAttach(GetStartContract.GetStartView view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void onBtnStartClicked() {
        this.view.getStart();
    }
}
