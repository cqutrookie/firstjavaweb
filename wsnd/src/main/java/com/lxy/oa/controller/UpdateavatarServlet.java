package com.lxy.oa.controller;

import com.lxy.oa.dao.UpdateavatarDao;
import com.lxy.oa.entity.User;
import com.lxy.oa.service.Userservice;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "UpdateavatarServlet", value = "/Updateavatar")
public class UpdateavatarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            List<FileItem> formdata = servletFileUpload.parseRequest(request);
            for (FileItem fi:formdata)
            {
                if(!fi.isFormField())
                {
                    String path = request.getServletContext().getRealPath("/photo");
                    String filename = UUID.randomUUID().toString();
                    String str = fi.getName().substring(fi.getName().lastIndexOf("."));
                    fi.write(new File(path,filename+str));
                    String avatar = "photo/"+filename+str;
                    HttpSession httpSession = request.getSession();
                    User user = (User) httpSession.getAttribute("login user");
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("username",user.getUsername());
                    map.put("avatar",avatar);
                    user.setAvatar(avatar);
                    mybatisUtils.executeQueryUpdate(sqlSession -> {
                        UpdateavatarDao updateavatarDao = sqlSession.getMapper(UpdateavatarDao.class);
                        updateavatarDao.Updateavatar(map);
                        return null;
                    });
                    request.setAttribute("user",user);
                    request.getRequestDispatcher("/index.ftl").forward(request,response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
