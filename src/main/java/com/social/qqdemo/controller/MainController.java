package com.social.qqdemo.controller;

import com.social.qqdemo.api.QQ;
import com.social.qqdemo.api.QQUserInfo;
import org.springframework.social.connect.Connection;
import org.springframework.social.security.SocialAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Principal principal, Model model) {
        if(principal == null ){
            return "index";
        }
        System.out.println(principal.toString());
        SocialAuthenticationToken socialPrincipal = (SocialAuthenticationToken)principal;
        Connection<QQ> connection = (Connection<QQ>)socialPrincipal.getConnection();
        QQ qqImpl = connection.getApi();
        QQUserInfo userInfo = qqImpl.getUserInfo();
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("qqUserAuthentication", ((SocialAuthenticationToken) principal).getAuthorities());
        return "index";
    }

    @GetMapping("/403")
    public String accesssDenied() {
        return "403";
    }
}
