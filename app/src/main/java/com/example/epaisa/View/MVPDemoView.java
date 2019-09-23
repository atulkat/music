package com.example.epaisa.View;

import com.example.epaisa.Model.SongResponse;

import java.util.List;

public interface MVPDemoView {

    void notificationData(List<SongResponse.Result> notificationList);

    void LoginError(String data);
}
