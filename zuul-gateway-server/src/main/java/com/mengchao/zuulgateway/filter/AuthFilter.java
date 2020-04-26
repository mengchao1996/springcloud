package com.mengchao.zuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @ClassName ZuulFilter
 * @Author MengChao
 * @Date 2020/4/23  15:45
 **/
@Component
public class AuthFilter extends ZuulFilter {


    /*
     * @Name:过滤的类型  pre路由之前
     * @Author: MengChao
     * @Date:
     **/
    public String filterType() {
        return "pre";
    }

    /*
     * @Name:在zuul网关有过个过滤器，设置过滤信息
     * @Author: MengChao
     * @Date:
     **/
    public int filterOrder() {
        return 0;
    }

    /*
     * @Name:添加过滤条件
     * @Author: MengChao
     * @Date:
     **/
    public boolean shouldFilter() {
        //业务逻辑判断
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //放行USER
        if (requestURI.startsWith("/user")){
            return false;
        }
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     * 可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            /** 表示不进行路由,不会被zuul转发到后端服务器 **/
            currentContext.setSendZuulResponse(false);
            /** http状态码，标识未授权 **/
            currentContext.setResponseStatusCode(401);
            HttpServletResponse response = currentContext.getResponse();
            /** 设置返回的内容类型 **/
            response.setContentType("application/json;charset=utf-8");
            try {
                /** 输出返回结果 **/
                response.getWriter().write("{\"message\":\"未授权\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
