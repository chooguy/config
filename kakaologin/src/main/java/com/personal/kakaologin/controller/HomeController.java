package com.personal.kakaologin.controller;
 
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.personal.kakaologin.domain.model.entity.UserInfo;
import com.personal.kakaologin.repository.UserInfoRepo;
import com.personal.kakaologin.service.KakaoAPI;
 
@Controller
public class HomeController {
	
	@Autowired
    private KakaoAPI kakao;
	
	@Autowired
	private UserInfoRepo UserInfoRepo;
 
    @RequestMapping(value="/")
    public String index() {
        
        return "index";
    }
    
    @SuppressWarnings("null")
	@RequestMapping(value="/login")
    public String login(@RequestParam("code") String code, HttpSession session) {
        String access_Token = kakao.getAccessToken(code);
        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
        
        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
        }
        
        UserInfo addData = new UserInfo();
        addData.setId((String) userInfo.get("id"));
        UserInfo insertData = UserInfoRepo.save(addData);

        return "index";
    }
    
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        kakao.kakaoLogout((String)session.getAttribute("access_Token"));
        session.removeAttribute("access_Token");
        session.removeAttribute("userId");
        return "index";
    }
    
    @RequestMapping(value="/list")
	public String list(Model model) {
		List<UserInfo> UserInfoList = UserInfoRepo.findAll();
		System.out.println("UserInfoList : " + UserInfoList);
		return "index";
	}
}
