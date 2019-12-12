package com.example.epaisa.Presenter;


import com.example.epaisa.Model.SongResponse;
import com.example.epaisa.Service.MVPDemoService;
import com.example.epaisa.View.MVPDemoView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MVPDemoPresenter {

    private MVPDemoService countryService;
    private MVPDemoView countryView;


    public MVPDemoPresenter(MVPDemoView view) {
        this.countryView = view;

        if (this.countryService == null) {
            this.countryService = new MVPDemoService();
        }
    }

    public void getSongList() {

        countryService
                .getAPIS()
                .getSongList()
                .enqueue(new Callback<SongResponse>() {
                    @Override
                    public void onResponse(Call<SongResponse> call, Response<SongResponse> response) {
                        SongResponse data = response.body();


                        if (data.getResults().size() > 0) {

                            countryView.notificationData(data.getResults());

                        } else {
                            countryView.LoginError("Data not available");
                        }
                    }

                    @Override
                    public void onFailure(Call<SongResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
