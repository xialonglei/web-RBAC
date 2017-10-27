<%--
  Created by lonely.xia.
  Date: 2017/10/6
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>RBAC</title>
        <!--<link rel="stylesheet" type="text/css" href="common.css" />-->
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-grid.min.css" />
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-reboot.min.css" />
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-select.min.css" />
        <link rel="stylesheet" type="text/css" href="/resources/css/dashboard.css" />
        <link rel="stylesheet" type="text/css" href="/resources/css/jquery-ui.min.css" />
        <script type="text/javascript" src="/resources/jquery/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/bootstrap/js/bootstrap-select.min.js"></script>
        <script type="text/javascript" src="/resources/jquery/jquery-ui.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="javascript:void(0)">RBAC</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/index.jsp">首页</a></li>
                    </ul>
                    <p class="navbar-text navbar-right">Hi

                        <c:if test="${sessionScope.user.isAdmin}">
                            <a href="javascript:void(0)" class="navbar-link">超级管理员(${sessionScope.user.name})</a>
                        </c:if>

                        <c:if test="${sessionScope.user.name != null && !sessionScope.user.isAdmin}">
                            <a href="javascript:void(0)" class="navbar-link">${sessionScope.user.name}</a>
                        </c:if>

                        <c:if test="${sessionScope.user.name == null}">
                            <a href="javascript:void(0)" class="navbar-link">请登录</a>
                        </c:if>

                    </p>
                </div>
            </div>
        </nav>

        <!-- 菜单栏和内容区域 -->
        <div class="container-fluid">
            <div class="col-sm-2 col-md-2 col-lg-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li>权限演示页面</li>
                    <li><a href="javascript:void(0)">测试页面一</a></li>
                    <li><a href="javascript:void(0)">测试页面二</a></li>
                    <li><a href="javascript:void(0)">测试页面三</a></li>
                    <li><a href="javascript:void(0)">测试页面四</a></li>
                    <li>系统设置</li>
                    <li><a href="/user/userMgmt">用户管理</a></li>
                    <li><a href="/role/roleMgmt">角色管理</a></li>
                    <li><a href="/access/accessMgmt">权限管理</a></li>
                </ul>
            </div>

            <div class="col-sm-10 col-sm-offset-2 col-md-10 col-md-offset-2 col-lg-10 col-lg-offset-2">

                <c:if test="${sessionScope.user == null || requestScope.page == -1}">
                    <%@ include file="/WEB-INF/jsp/login-hint.jsp"%>
                </c:if>

                <c:if test="${requestScope.page == 0}">
                    <%@ include file="/WEB-INF/jsp/rbac.jsp"%>
                </c:if>

                <c:if test="${requestScope.page == 10}">
                    <%@ include file="/WEB-INF/jsp/user-mgmt.jsp"%>
                </c:if>

                <c:if test="${requestScope.page == 20}">
                    <%@ include file="/WEB-INF/jsp/role-mgmt.jsp"%>
                </c:if>

                <c:if test="${requestScope.page == 30}">
                    <%@ include file="/WEB-INF/jsp/access-mgmt.jsp"%>
                </c:if>

                <c:if test="${sessionScope.user != null && requestScope.page == null}">
                    <%@ include file="/WEB-INF/jsp/rbac.jsp"%>
                </c:if>

                <hr/>
                <footer>
                    <p class="pull-left">@编程少年夏小龙</p>

                    <p class="pull-right">Power by home www.jld.com</p>

                </footer>
            </div>
        </div>

    </body>
</html>
