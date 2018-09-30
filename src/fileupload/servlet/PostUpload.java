package fileupload.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * post方式提交
 * Created by hongshen on 2018/7/9 0009.
 */
public class PostUpload extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        //设置客户端的解码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        //
        response.setCharacterEncoding("UTF-8");

        String log = request.getHeader("log");
        System.out.println("header log = " + log);

        try {
            BufferedReader br = null;
            PrintWriter out = null;
            br = request.getReader();
            String str, wholeStr = "";
            while((str = br.readLine()) != null){
                wholeStr += str;
            }
            System.out.println(wholeStr);

            out = response.getWriter();
            String result = "success  接收成功！";
            out.write(result);

            System.out.println(result);
            br.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
