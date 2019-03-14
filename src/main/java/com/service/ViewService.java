package com.service;

import com.pojo.View;

import java.util.List;

public interface ViewService {
    int addView(View view);

    int deleteViewById(int id);

    int updateView(View view);

    View queryById(int id);

    List<View> queryAllView();
}
