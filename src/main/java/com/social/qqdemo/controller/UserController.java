package com.social.qqdemo.controller;

import com.social.qqdemo.api.QQUserInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
    /**
     * 查询所用用户
     *
     * @return
     */
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_USER')")  // 指定角色权限才能操作方法
    public ModelAndView list(Map<String, Object> map) {
        List<QQUserInfo> list = new ArrayList<QQUserInfo>();    // 当前所在页面数据列表
        QQUserInfo qqUserInfo1 = new QQUserInfo();
        qqUserInfo1.setNickname("张三");
        qqUserInfo1.setYear("1985-1-1");
        list.add(qqUserInfo1);
        QQUserInfo qqUserInfo2 = new QQUserInfo();
        qqUserInfo2.setNickname("李四");
        qqUserInfo2.setYear("1989-7-1");
        list.add(qqUserInfo2);
        map.put("title", "用户管理");
        map.put("userList", list);
        return new ModelAndView("users/list", map);
    }
}
