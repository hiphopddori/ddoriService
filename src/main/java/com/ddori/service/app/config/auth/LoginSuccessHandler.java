package com.ddori.service.app.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        //String accept = request.getHeader("accept");
        ObjectMapper mapper = new ObjectMapper();
        /*
        ResultInfo rs = new ResultInfo();
        rs.setFlag(ResultInfo.RESULT_SUCCESS);
        rs.setDesc("로그인 성공하였습니다.");
        */
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        //out.print(mapper.writeValueAsString(rs));
        out.print("login success");
        out.flush();
        out.close();

        //super.onAuthenticationSuccess(request, response, authentication);
    }


}
