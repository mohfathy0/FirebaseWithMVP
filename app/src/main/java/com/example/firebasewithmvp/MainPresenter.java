package com.example.firebasewithmvp;

import android.util.Log;

public class MainPresenter implements IMainPresenter {

    IMainRepository iMainRepository = new MainRepository();


    @Override
    public void onButtonClicked(final IMainView mainview) {
//        MainModel model = new MainModel();
//        model = iMainRepository.LoadData();


     iMainRepository.LoadData(new MainRepository.DatabaseCallback() {
         @Override
         public void onCallback(MainModel model) {
             mainview.SetAllViews(model.getFirstName(),model.getLastName(),model.getEmail());
             SendLog(model.getFirstName()  +" "+ model.getLastName() +" "+ model.getEmail());
         }
     });



//        SendLog(model.getFirstName()  +" "+ model.getLastName() +" "+ model.getEmail());
//        mainview.SetAllViews(model.getFirstName(),model.getLastName(),model.getEmail());

    }
    String TAG="MyLog_Presenter";
    public void SendLog(String Message){
        Log.i(TAG,Message);
    }
}
