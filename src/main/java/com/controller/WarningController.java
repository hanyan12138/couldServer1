package com.controller;


import com.pojo.Paper;
import com.pojo.User;
import com.pojo.View;
import com.service.UserService;
import com.service.ViewService;
import com.task.UpdateDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/warning")
public class WarningController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String get(Model model) {
        return "login";
    }

    @RequestMapping("/base")
    public String list(Model model) {
        List<View> list = viewService.queryAllView();
        model.addAttribute("list", list);
        return "basePage";
    }

    @RequestMapping("/logining")
    public String mv(User user) {
        User getUser=userService.queryByName(user.getUserName());
        if(getUser!=null){
            String password = user.getUserPassword();
            String passwordGet = getUser.getUserPassword();
            if(password.equals(passwordGet)){
                return "redirect:/warning/base";
            }
            return "login";
        }else {
            return "login";
        }
    }
}
