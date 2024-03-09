package com.example.ce_todolistmvp.Starter.GetStart;

import com.example.ce_todolistmvp.Base.BasePresenter;
import com.example.ce_todolistmvp.Base.BaseView;

public interface GetStartContract {
    interface GetStartView extends BaseView{
        void getStart();
    }
    interface GetStartPresenter extends BasePresenter<GetStartView>{
        void onBtnStartClicked();
    }
}
