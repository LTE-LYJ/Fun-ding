<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.kh.mypage.model.vo.Project" %>

<%
    String listName = request.getParameter("listName");
    int index = Integer.parseInt(request.getParameter("index"));
    
    Project project = ((List<Project>) request.getAttribute(listName)).get(index);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date today = new Date();
    Date startDate = sdf.parse(project.getPrjStartDate());
    Date endDate = sdf.parse(project.getPrjEndDate());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fund-ing</title>
    <style>
        .fdc {
            height: 350px;
            width: 250px;
            order-radius: 15px;
            display: inline-block;
            margin-top: 30px;
            margin-left: 30px;
            margin-bottom: 30px;
            position: relative;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            overflow: hidden;
        }
        .fdcHeader {
            width: 100%;
            height: 270px;
            border-radius: 15px 15px 0 0;
            background-size: 100% 280px;
            background-repeat: no-repeat;
            positon: relative;
        }
        .fdcHeaderCl {
            background-color: #EF5A31;
            color: #FFF;
            font-weight: bold;
            text-align: center;
            float: right;
            margin: 15px 15px 0 0;
            border-radius: 50%;
            font-weight: bold;
            padding: 10px 10px;
            line-height: 20px;
            position: absolute;
            right: 0;
        }
        .fdcBody {

        }
        .fdcBodyH {
            line-height: 25px;
            margin: 10px 20px 0px 20px;
        }
        .fdcBodyT1 {
            color: #2478FF;
            font-style: italic;
        }
        .fdcBodyF {
            position: absolute;
            margin-top: 15px;
            margin-bottom: 6px;
            bottom: 0;
            width: 314px;
            font-size: 14px;
            color: #9FA5A8;
            padding: 0 15px;
        }
        .img1 {
            display: inline-block;
            vertical-align: middle;
            margin-right: 2px;
        }
        .imgF {
            width: 25px;
            height: 17px;
            background: no-repeat;
        }
        .imgV {
            margin-left: 5px;
            width: 25px;
            height: 17px;
            background: no-repeat;
        }
        .count {
            float: right;
        }
        h1 {
            font-size: 22px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
    if (today.getTime() < startDate.getTime()) {
%>
<a href="">
        <% } else { %>
    <a href="proInfo.list?num=<%= project.getPrjNo() %>">
        <% } %>

        <div class="fdc">

            <div class="fdcHeader">
                <div class="fdcHeaderCl">
                    <% if (today.getTime() < startDate.getTime()) { %>
                    <div class="fdcHeaderO">공개 예정</div>
                    <div class="fdcHeaderS">
                        D-<%= (startDate.getTime() - today.getTime()) / (24*60*60*1000)%>
                    </div>
                    <% } else { %>
                    <div class="fdcHeaderO">남은 기간</div>
                    <div class="fdcHeaderS"><%= (endDate.getTime() - today.getTime()) / (24*60*60*1000)%>
                        일
                    </div>
                    <% } %>
                </div>
                <img src="resources/upfiles_project/<%= project.getAttachmentName() %>" width="100%" height="100%">
            </div>

            <div class="fdcBody">

                <div class="fdcBodyH">
                    <h1><%= project.getPrjTitle() %>
                    </h1>
                    <p class="fdcBodyT1">#<%= project.getPrjCatName() %>
                    </p>
                    <p class="fdcBodyC"><%= project.getCreName() %>
                    </p>
                </div>

                <div class="fdcBodyF">
                    <hr style="margin-bottom: 8px; opacity: 0.5; border-color: #EF5A31">
                    <i class="img1 imgF"></i>모인 금액
                    <i class="img1 imgV"></i><%= (int) project.getPrjCurrent() %>원
                    <i class="count"><%= (int) (project.getPrjCurrent() / project.getPrjTarget() * 100) %>% </i>
                </div>
            </div>
            
        </div>
    </a>
</body>
</html>
