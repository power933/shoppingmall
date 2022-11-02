package com.tj.shoppingmall.user.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetAlert {

    public static void setResponse(HttpServletResponse response) {
        response.setContentType("text/html; charset=euc-kr");
        response.setCharacterEncoding("euc-kr");
    }

    public static void alert(HttpServletResponse response, String text) throws IOException {
        setResponse(response);
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + text + "');history.go(-1)</script> ");
        out.flush();
    }
    public static void alertAndMovePage(HttpServletResponse response, String alertText, String nextPage) throws IOException {
        setResponse(response);
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + alertText + "'); location.href='" + nextPage + "';</script> ");
        out.flush();
    }
}
