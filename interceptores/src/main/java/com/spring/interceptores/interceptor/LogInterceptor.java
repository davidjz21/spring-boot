package com.spring.interceptores.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LogInterceptor implements HandlerInterceptor {

    //metodo a ejecutar antes del controlador
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
    Object handler) throws Exception {
        System.out.println("interceptando peticion..." + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                              Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle ejecutado para: " + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ERROR)
        throws Exception {
        System.out.println("Ejecucion completada para: " + request.getRequestURI());

    }
}
