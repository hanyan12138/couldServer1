package com.service.impl;

import com.dao.ImgDao;
import com.pojo.Img;
import com.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgDao imgDao;

    @Override
    public int addImg(Img img) {
        return imgDao.addImg(img);
    }

    @Override
    public int deleteImgById(int id) {
        return imgDao.deleteImgById(id);
    }

    @Override
    public int updateImg(Img img) {
        return imgDao.updateImg(img);
    }

    @Override
    public Img queryById(int id) {
        return imgDao.queryById(id);
    }

    @Override
    public List<Img> queryAllImg() {
        return imgDao.queryAllImg();
    }
}
