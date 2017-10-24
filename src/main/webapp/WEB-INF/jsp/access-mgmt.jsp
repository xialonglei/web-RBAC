<%--
  Created by lonely.xia.
  Date: 2017/10/23
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-table.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/toastr.min.css" />
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="/resources/js/access-mgmt.js"></script>
    <script type="text/javascript" src="/resources/js/toastr.min.js"></script>
</head>

<body>
<table id="access-list"></table>

<!-- 添加弹出层 modal -->
<div class="modal right fade" id="addModal" tabindex="-1" access="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">添加权限</h4>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <div class="row">
                        <label class="control-label col-sm-2">权限TITLE</label>
                        <input id="access-name" class="form-control col-sm-9" placeholder="输入权限名..." />
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <label class="control-label col-sm-4">Uris</label>
                        <textarea placeholder="每行一个地址......" id="access-uris" class="form-control col-sm-offset-2 col-sm-9"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <label class="control-label col-sm-3">权限状态</label>
                        <label class="radio-inline col-xs-4 col-sm-4">
                            <input type="radio" name="access-status" value="1" checked>有效
                        </label>
                        <label class="radio-inline col-xs-4 col-sm-4">
                            <input type="radio" name="access-status" value="0">无效
                        </label>
                    </div>
                </div>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary add-access">确定</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑弹出层 modal -->
<div class="modal right fade" id="editModal" tabindex="-1" access="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="editModalLabel">编辑权限</h4>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <div class="row">
                        <label class="control-label col-sm-2">权限名</label>
                        <input id="edit-access-name" class="form-control col-sm-9"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <label class="control-label col-sm-4">Uris</label>
                        <textarea id="edit-access-uris" class="form-control col-sm-offset-2 col-sm-9"></textarea>
                    </div>
                </div>

                <input type="hidden" id="edit-access-id" />

                <div class="form-group">
                    <div class="row">
                        <label class="control-label col-sm-3">权限状态</label>
                        <label class="radio-inline col-xs-4 col-sm-4">
                            <input type="radio" name="edit-access-status" value="1" checked>有效
                        </label>
                        <label class="radio-inline col-xs-4 col-sm-4">
                            <input type="radio" name="edit-access-status" value="0">无效
                        </label>
                    </div>
                </div>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary edit-access">确定</button>
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
                <input type="hidden" id="delete-access-id" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary delete-access">确定</button>
            </div>
        </div>
    </div>
</div>


</body>
</html>

