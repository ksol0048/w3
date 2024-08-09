package kroryi.w3.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Log4j2
public class UTF8Filter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        log.info("UTF8Filter.....");

        HttpServletRequest request = (HttpServletRequest) req;

        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(req, res);
    }
}
