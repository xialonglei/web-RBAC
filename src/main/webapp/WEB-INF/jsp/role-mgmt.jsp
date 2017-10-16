<%--
  Created by lonely.xia.
  Date: 2017/10/12
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-table.css" />
        <script type="text/javascript" src="/resources/bootstrap/js/bootstrap-table.js"></script>
        <script type="text/javascript" src="/resources/bootstrap/js/bootstrap-table-zh-CN.js"></script>
        <script type="text/javascript" src="/resources/js/role-mgmt.js"></script>
    </head>

    <body>
        <table id="role-list"></table>


        <!-- 弹出层 modal -->
        <div class="modal right fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">添加角色</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-2">角色名</label>
                                <input id="role-name" class="form-control col-sm-9" placeholder="输入角色名..." />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <label class="control-label col-sm-3">角色状态</label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="role-status" value="1" checked>有效
                                </label>
                                <label class="radio-inline col-xs-4 col-sm-4">
                                    <input type="radio" name="role-status" value="0">无效
                                </label>
                            </div>
                        </div>

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary">确定</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
