package com.dao;

import com.pojo.Img;

import java.util.List;

public interface ImgDao {

    int addImg(Img img);

    int deleteImgById(int id);

    int updateImg(Img img);

    Img queryById(int id);

    List<Img> queryAllImg();

}
