<%--
  Created by lonely.xia.
  Date: 2017/10/18
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-table.css" />
        <link rel="stylesheet" type="text/css" href="/resources/css/toastr.min.css" />
        <script type="text/javascript" src="/resources/bootstrap/js/bootstrap-table.js"></script>
        <script type="text/javascript" src="/resources/bootstrap/js/bootstrap-table-zh-CN.js"></script>
        <script type="text/javascript" src="/resources/js/user-mgmt.js"></script>
        <script type="text/javascript" src="/resources/js/toastr.min.js"></script>
    </head>

    <body>
        <table id="user-list"></table>

        <!-- 添加弹出层 modal -->
        <div class="modal right fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">添加用户</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-2">用户名</label>
                                <input id="user-name" class="form-control col-sm-9" placeholder="输入用户名..." />
                                <p class="name-img"></p>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-3">管理员</label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="is-admin" value="1" checked>是
                                </label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="is-admin" value="0">否
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-2">邮箱</label>
                                <input type="email" id="user-email" class="form-control col-sm-9"/>
                                <p class="email-img"></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-3">用户状态</label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="user-status" value="1" checked>有效
                                </label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="user-status" value="0">无效
                                </label>
                            </div>
                        </div>

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary add-user">确定</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 编辑弹出层 modal -->
        <div class="modal right fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="editModalLabel">编辑用户</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-2">用户名</label>
                                <input id="edit-user-name" class="form-control col-sm-9"/>
                                <p class="edit-name-img"></p>
                            </div>
                        </div>

                        <input type="hidden" id="edit-user-id" />

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-3">管理员</label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="edit-is-admin" value="1" checked>是
                                </label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="edit-is-admin" value="0">否
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-2">邮箱</label>
                                <input type="email" id="edit-user-email" class="form-control col-sm-9"/>
                                <p class="edit-email-img"></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-3">用户状态</label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="edit-user-status" value="1" checked>有效
                                </label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="edit-user-status" value="0">无效
                                </label>
                            </div>
                        </div>

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default edit-close" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary edit-user">确定</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 删除弹出层 modal -->
        <div class="modal fade" id="delcfmModel">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">提示信息</h4>
                    </div>
                    <div class="modal-body">
                        <p>您确认要删除吗？</p>
                        <input type="hidden" id="delete-user-id" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary delete-user">确定</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
