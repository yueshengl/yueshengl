package com.nowcoder.community.controller.interceptor;

import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.MessageService;
import com.nowcoder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.PrivateKey;

/**
 * @Author: Dai
 * @Date: 2024/04/29 14:51
 * @Description: MessageInterceptor
 * @Version: 1.0
 */
@Component
public class MessageInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private MessageService messageService;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = hostHolder.getUser();
        if(user!=null && modelAndView != null){
            int letterUnreadCount = messageService.findLetterUnreadCount(user.getId(), null);
            int messageUnreadCount = messageService.findNoticeUnreadCount(user.getId(), null);
            modelAndView.addObject("allUnreadCount",letterUnreadCount+messageUnreadCount);
        }
    }
}
