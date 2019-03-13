package com.service;


import com.pojo.Viewing;

import java.util.List;

public interface ViewingService {

        int add(Viewing viewing);

        int deleteById(int id);

        int update(Viewing viewing);

        Viewing queryById(int id);

        List<Viewing> queryAll();
}

