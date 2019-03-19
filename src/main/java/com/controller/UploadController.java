package com.controller;


import com.pojo.Img;
import com.service.ImgService;
import com.util.ImgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ImgService imgService;

    /**
     * 添加用户信息
     * @param img，封装表单中除图片地址以外的其他数据（要求<input>中的name跟实体类中的属性一致）
     * @param request，用来获取文件的存储位置等
     * @param pictureFile，封装上传图片的信息如大小、文件名、扩展名等,（要求<input>中的name跟次命名一致）。
     * @return
     * 注意：图片提交input输入框的name属性值要与Controller中MultipartFile
     * 接口所声明的形参名一致，不然需要用@RequestParam注解绑定
     */

    @RequestMapping(path = "/addImg")
    public String addUser(Img img, HttpServletRequest request, MultipartFile pictureFile) {

        // 得到上传图片的地址
        String imgPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImgUtils.upload(request, pictureFile);
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                img.setImg(imgPath);
                img.setName("ceshi");//img.setName(pictureFile.getOriginalFilename());
                img.setId(1);
                System.out.println("-----------------图片上传成功！");
            }else{
                System.out.println("-----------------图片上传失败！");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
        //将数据提交到数据库（包含文件和普通表单数据）
        //int rowNo =
        imgService.addImg(img);
        return "upload";
//        if (rowNo > 0) {
//            System.out.println("----------------------添加成功！");
//            // 转发：forword，重定向：redirect
//            return "upload";
//        } else {
//            System.out.println("----------------------添加失败！");
//            return "upload";
//        }
    }

}
