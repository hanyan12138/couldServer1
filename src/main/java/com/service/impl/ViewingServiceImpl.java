package com.service.impl;

import com.dao.ViewingDao;
import com.pojo.Viewing;
import com.service.ViewingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ViewingServiceImpl implements ViewingService {


    private ViewingDao viewingDao;

    @Override
    public int add(Viewing viewing) {
        return viewingDao.insert(viewing);
    }

    @Override
    public int deleteById(int id) {
        return viewingDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Viewing viewing) {
        return viewingDao.updateByPrimaryKey(viewing);
    }

    @Override
    public Viewing queryById(int id) {
        return viewingDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Viewing> queryAll() {
      return viewingDao.queryAll();
    }
}
