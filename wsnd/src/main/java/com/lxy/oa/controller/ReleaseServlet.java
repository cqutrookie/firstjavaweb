package com.lxy.oa.controller;

import com.lxy.oa.dao.ReleaseDao;
import com.lxy.oa.dao.SearchreleaseDao;
import com.lxy.oa.dao.UpdateavatarDao;
import com.lxy.oa.entity.Release;
import com.lxy.oa.entity.User;
import com.lxy.oa.service.datetostring;
import com.lxy.oa.utils.mybatisUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "ReleaseServlet", urlPatterns = "/Release")
public class ReleaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        try {
            List<FileItem> formdata = servletFileUpload.parseRequest(request);
            Map<String,Object> map = new HashMap<String,Object>();
            for(FileItem fi:formdata) {
                if (fi.isFormField()) {
                    map.put(fi.getFieldName(), fi.getString("UTF-8"));
                }
                if (!fi.isFormField()) {
                    String path = request.getServletContext().getRealPath("/photo");
                    String filename = UUID.randomUUID().toString();
                    String str = fi.getName().substring(fi.getName().lastIndexOf("."));
                    fi.write(new File(path, filename + str));
                    String photo = "photo/" + filename + str;
                    HttpSession httpSession = request.getSession();
                    User user = (User) httpSession.getAttribute("login user");
                    map.put("gameid", user.getGameid());
                    map.put("photo", photo);
                    Date d=new Date();
                    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date=df.format(d);
                    java.util.Date udate=df.parse(date);
                    long restime=udate.getTime();
                    java.sql.Date sdate=new java.sql.Date(restime);
                    map.put("releasetime",sdate);
                    map.put("userid",user.getUserid());
                    mybatisUtils.executeQueryUpdate(sqlSession -> {
                        ReleaseDao releaseDao = sqlSession.getMapper(ReleaseDao.class);
                        releaseDao.insertrelease(map);
                        return null;
                    });
                }
            }
            List<Release> list = new ArrayList<>();
            list = (List<Release>) mybatisUtils.executeQuery(sqlSession -> {
                SearchreleaseDao searchreleaseDao= sqlSession.getMapper(SearchreleaseDao.class);
                return searchreleaseDao.searchrelease();
            });
            Collections.reverse(list);
            for(int i=0;i<list.size();i++)
            {
                String str = datetostring.dateToString(list.get(i).getReleasetime());
                list.get(i).setReleasetime1(str);
            }
            request.setAttribute("release_list",list);
            request.getRequestDispatcher("/infosquare.ftl").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
