package com.controller;


import com.pojo.Paper;
import com.pojo.User;
import com.pojo.View;
import com.service.UserService;
import com.service.ViewService;
import com.task.UpdateDatabase;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
        String s =  JSONArray.fromObject(list).toString();
        int[] yali = new int[5];
        int[] wendu = new int[5];
        int[] shidu = new int[5];
        int[] co2 = new int[5];
        int[] c2h2 = new int[5];
        Date[] time = new Date[5];
        for(int i=0 ;i<list.size(); i++){
            yali[i] = list.get(list.size()-i-1).getPressure();
            wendu[i] = list.get(list.size()-i-1).getTemperature();
            shidu[i] = list.get(list.size()-i-1).getHumidity();
            co2[i] = list.get(list.size()-i-1).getCo2();
            c2h2[i] = list.get(list.size()-i-1).getC2h2();
            time[i] = list.get(list.size()-i-1).getTime();
        }
        String ss =  JSONArray.fromObject(time).toString();
        model.addAttribute("list", list);
        model.addAttribute("yali",yali);
        model.addAttribute("wendu",wendu);
        model.addAttribute("shidu",shidu);
        model.addAttribute("co2",co2);
        model.addAttribute("c2h2",c2h2);
        model.addAttribute("time",ss);
        model.addAttribute("s",s);
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
    @RequestMapping("/control")
    public String base() {
        return "control";
    }

    @RequestMapping(path = "/upload")
    public String getIn(){
        return "upload";
    }

    @RequestMapping(path = "/frame")
    public String test(){
        return "frame";
    }
}
