package com.service.impl;

import com.dao.ViewDao;
import com.pojo.View;
import com.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    private ViewDao viewDao;

    @Override
    public int addView(View view) {
        return viewDao.addView(view);
    }

    @Override
    public int deleteViewById(int id) {
        return viewDao.deleteViewById(id);
    }

    @Override
    public int updateView(View view) {
        return viewDao.updateView(view);
    }

    @Override
    public View queryById(int id) {
        return viewDao.queryById(id);
    }

    @Override
    public List<View> queryAllView() {
        return viewDao.queryAllView();
    }
}
