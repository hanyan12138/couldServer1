package com.service.impl;

import com.dao.ViewDao;
import com.pojo.View;
import com.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ViewServiceImpl implements ViewService {

    @Autowired
    private ViewDao viewDao;

    @Override
    public int addPaper(View view) {
        return viewDao.addPaper(view);
    }

    @Override
    public int deletePaperById(int id) {
        return viewDao.deletePaperById(id);
    }

    @Override
    public int updatePaper(View view) {
        return viewDao.updatePaper(view);
    }

    @Override
    public View queryById(int id) {
        return viewDao.queryById(id);
    }

    @Override
    public List<View> queryAllPaper() {
        return viewDao.queryAllPaper();
    }
}
