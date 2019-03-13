package com.service;

import com.pojo.View;

import java.util.List;

public interface ViewService {
    int addPaper(View view);

    int deletePaperById(int id);

    int updatePaper(View view);

    View queryById(int id);

    List<View> queryAllPaper();
}
