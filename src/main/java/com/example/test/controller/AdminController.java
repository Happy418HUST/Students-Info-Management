package com.example.test.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import com.example.test.model.Admin;
import com.example.test.service.AdminService;
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     * 登录跳转
     *
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String loginGet(Model model) {
        return "login";
    }

    /**
     * 登录
     *
     * @param admin
     * @param model
     * @param httpSession
     * @return
     */
    @PostMapping("/login")
    public String loginPost(Admin admin, Model model, HttpSession httpSession) {
        //前台输入的用户名和密码在service中调用sql语句，返回实体类Admin 的对象实例adminRes
        Admin adminRes = adminService.findByNameAndPassword(admin);
        if (adminRes != null) {
            httpSession.setAttribute("admin", adminRes);
            return "redirect:index";   //重定向到dashboard
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

//    /**
//     * 注册
//     *
//     * @param model
//     * @return
//     */
//    @GetMapping("/admin/register")
//    public String register(Model model) {
//        return "register";
//    }
}

