/**
 * Created by Lenovo on 2017/10/12.
 */

$(function () {

    var $table = $('#role-list');

    initToastr();

    initTable();

    initClick();

    initModal();
    
    function initToastr() {
        toastr.options = {
            "closeButton": false , //是否显示关闭按钮
            "debug": false , //是否使用debug模式
            "positionClass": "toast-top-center" , //弹出窗的位置
            "showDuration": "300" , //显示的动画时间
            "hideDuration": "1000" , //消失的动画时间
            "timeOut": "2000" , //展现时间
            "extendedTimeOut": "1000" , //加长展示时间
            "showEasing": "swing" ,  //显示时的动画缓冲方式
            "hideEasing": "linear" , //消失时的动画缓冲方式
            "showMethod": "fadeIn" , //显示时的动画方式
            "hideMethod": "fadeOut"  //消失时的动画方式
        };
    }

    function initTable() {
       $table.bootstrapTable({
           url: '/role/getRoleList',
           method: 'post',
           dataType: 'json',
           contentType:'application/json',
           pagination: true,
           striped: true,
           clickToSelect: false,
           sidePagination: 'server',
           pageNumber: 1,
           pageSize: 5,
           height:500,
           pageList: [5 , 10 , 20 , 50],
           singleSelect: false,
           columns: [{
               field: 'state',
               checkbox: true
           },{
               field: 'id' ,
               title: '角色ID' ,
               formatter: function (value, row, index) {
                   return row.id;
               }
           },{
               field: 'name',
               title: '角色名'
           },{
               field: 'status',
               title: '角色状态' ,
               formatter:function(value , row , index) {
                   if (value) {
                       return "有效";
                   } else {
                       return "无效";
                   }

               }
           },{
               field:'createTime',
               title:'创建日期',
               formatter:function (value , row , index) {
                   return formatDate(value);
               }

           }, {
               field: 'updateTime',
               title: '更新日期',
               formatter:function (value , row , index) {
                   return formatDate(value);
               }
           } , {
               title: '<span>操作</span>&nbsp;&nbsp;&nbsp;&nbsp;' +
               '<button class="btn btn-xs btn-blue" data-toggle="modal" data-target="#addModal">添加</button>',

               formatter:function (value , row , index) {
                   var id = row.id;
                   var roleName = row.name;
                   return '<button class="btn btn-xs btn-blue" ' +
                       'onclick="modify(\'' + id + '\')">' + '编辑' +
                       '</button>&nbsp;&nbsp;&nbsp;&nbsp;' +
                       '<button class="btn btn-xs btn-danger" ' +
                       'onclick="deleteRole(\'' + id + '\')">' + '删除' + '</button>&nbsp;&nbsp;&nbsp;&nbsp;' +
                       '<button class="btn btn-xs btn-default" ' +
                       'onclick="setAccess(\'' + id + '\',\'' + roleName + '\')">' + '设置权限' + '</button>';
               }
           }]
       });
    };

    function initClick() {

        $('.close-btn').click(function () {
            $('.access-modal-body').empty();
            $('.set-access-title').empty();
        });

        $('.add-role').click(function () {

            var roleName = $('#role-name').val();
            var status = $("input[name='role-status']:checked").val();

            if (roleName == undefined || roleName == "") {
                toastr.warning("角色名不能为空!");
                return;
            }

            $('#addModal').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/role/add' ,
                data: JSON.stringify({
                    name : roleName ,
                    status : status == 1 ? true : false
                }) ,
                contentType : 'application/json' ,
                dataType: 'json' ,
                success: function (res) {
                    if (res.code != 200) {
                        toastr.error(res.msg);
                    } else {
                        toastr.info(res.msg);
                        $table.bootstrapTable('refresh');
                    }
                }
            });
        });

        $('.edit-role').click(function () {

            var roleName = $('#edit-role-name').val();
            var status = $("input[name='edit-role-status']:checked").val();
            var id = $('#edit-role-id').val();

            if (roleName == undefined || roleName == "") {
                toastr.warning("角色名不能为空!");
                return;
            }

            $('#editModal').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/role/update' ,
                data: JSON.stringify({
                    id : id ,
                    name : roleName ,
                    status : status == 1 ? true : false
                }) ,
                contentType : 'application/json' ,
                dataType: 'json' ,
                success: function (res) {
                    if (res.code != 200) {
                        toastr.error(res.msg);
                    } else {
                        toastr.info(res.msg);
                        $table.bootstrapTable('refresh');
                    }
                }
            });
        });

        $('.delete-role').click(function () {

            var id = $('#delete-role-id').val();

            $('#delcfmModel').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/role/delete' ,
                data: JSON.stringify({
                    id : id
                }) ,
                contentType : 'application/json' ,
                dataType: 'json' ,
                success: function (res) {
                    if (res.code != 200) {
                        toastr.error(res.msg);
                    } else {
                        toastr.info(res.msg);
                        $table.bootstrapTable('refresh');
                    }
                }
            });

        });

        $('.role-access').click(function () {
            var roleId = $('#role-id').val();
            var inputs = $("input[name='access']");

            var accessIds = new Array();
            for(var k in inputs){
                if(inputs[k].checked)
                    accessIds.push(inputs[k].value);
            }

            $('#accessModel').modal('hide');
            $('.access-modal-body').empty();

            $.ajax({
                type: 'POST' ,
                url: '/role_access/setAccess' ,
                data: {
                    roleId : roleId ,
                    accessIds : accessIds
                } ,
                dataType: 'json' ,
                success: function (res) {
                    if (res.code != 200) {
                        toastr.error(res.msg);
                    } else {
                        toastr.info(res.msg);
                    }
                }
            });
        });

    }

    function initModal() {

        $('#addModal').draggable({
            cursor: "move",
            handle: '.modal-header'
        });

        $('#editModal').draggable({
            cursor: "move",
            handle: '.modal-header'
        });
    }

    function formatDate(time) {
        var time = new Date(time);
        var y = time.getFullYear();
        var m = time.getMonth() + 1;
        var d = time.getDate();
        var h = time.getHours();
        var mm = time.getMinutes();
        var s = time.getSeconds();
        return y + '-' + add0(m) + '-' + add0(d) + ' ' + add0(h) + ':' + add0(mm) + ':' + add0(s);
    }

    function add0(m) {
        return m < 10 ? '0' + m : m;
    }
});

function modify(id) {

    $.ajax({
        type: 'POST' ,
        url: '/role/getById' ,
        data: JSON.stringify({
            id : id
        }) ,
        contentType : 'application/json' ,
        dataType: 'json' ,
        success: function (res) {
            if (res.code != 200) {
                toastr.error(res.msg);
            } else {
                $('#edit-role-name').val(res.data.name);
                $('#edit-role-id').val(res.data.id);
                if (res.data.status) {
                    $("input[name='edit-role-status'][value='1']").attr("checked",true);
                } else {
                    $("input[name='edit-role-status'][value='0']").attr("checked",true);
                }

                $('#editModal').modal('show');
            }
        }
    });
}

function deleteRole(id) {
    $('#delete-role-id').val(id);
    $('#delcfmModel').modal('show');
}

function setAccess(id , roleName) {

    $('.set-access-title').prop('innerHTML', '设置 <span style="color:red;font-size:16px;font-weight: bold">' + roleName + '</span> 权限');
    $('#role-id').val(id);
    $('#accessModel').modal('show');

    $.ajax({
        type: 'GET' ,
        url: '/access/getAllAccess' ,
        dataType: 'json' ,
        success: function (res) {
            if (res.code != 200) {

                toastr.error(res.msg);

            } else {

                var accessList = res.data;

                $.ajax({
                    type: 'POST' ,
                    url: '/role_access/getAccessIdsByRoleId' ,
                    dataType: 'json' ,
                    data: {roleId : id} ,
                    success: function (res) {

                        var accessIds = res.data;

                        for (var index in accessList) {

                            var accessId = accessList[index].id;
                            var title = accessList[index].title;

                            if ($.inArray(accessId , accessIds) != -1) {
                                $('.access-modal-body').append('<div><input type="checkbox" checked name="access" value="' + accessId + '"> ' + title + '</div>');
                            } else {
                                $('.access-modal-body').append('<div><input type="checkbox" name="access" value="' + accessId + '"> ' + title + '</div>');

                            }
                        }

                    }
                });
            }
        }
    });
}
