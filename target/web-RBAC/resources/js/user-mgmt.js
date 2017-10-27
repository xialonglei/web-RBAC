/**
 * Created by Lenovo on 2017/10/12.
 */

$(function () {

    var $table = $('#user-list');

    var insertCheck = true;

    var updateCheck = true;

    initToastr();

    initTable();

    initClick();

    initEvent();

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
           url: '/user/getUserList',
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
               title: '用户ID' ,
               formatter: function (value, row, index) {
                   return row.id;
               }
           },{
               field: 'name',
               title: '用户名'
           },{
               field: 'email',
               title: '邮箱'
           },{
               field: 'isAdmin',
               title: '管理员',
               formatter:function (value , row , index) {
                   if (value) {
                       return "是";
                   } else {
                       return "否";
                   }
               }
           },{
               field: 'status',
               title: '用户状态' ,
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
                   return '<button class="btn btn-xs btn-sm btn-blue" ' +
                       'onclick="modify(\'' + id + '\')">' + '编辑' +
                       '</button>&nbsp;&nbsp;&nbsp;&nbsp;' +
                       '<button class="btn btn-xs btn-sm btn-danger" ' +
                       'onclick="deleteUser(\'' + id + '\')">' + '删除' + '</button>';
               }
           }]
       });
    };

    function initClick() {

        $('#role-select-1').on('show.bs.select' , function () {
           $.ajax({
               type: 'GET' ,
               url: '/role/getAll' ,
               dataType: 'json' ,
               success: function (res) {
                   if (res.code != 200) {
                       toastr.error(res.msg);
                   } else {
                       $('#role-select-1').append('<option value="0">请选择</option>');
                        for (var index in res.data) {
                            var role = res.data[index];
                            var id = role.id;
                            var name = role.name;
                            $('#role-select-1').append("<option value='" + id + "'>" + name + "</option>");
                        }
                       $('.selectpicker').selectpicker('refresh');
                   }
               }
           });
        });

        $('#role-select-1').on('hide.bs.select' , function () {
           $('#role-select-1').empty();
        });

        $('.add-user').click(function () {

            if (!insertCheck) {
                toastr.warning('参数校验不通过！');
                return;
            }

            var userName = $('#user-name').val();
            var isAdmin = $("input[name='is-admin']:checked").val();
            var status = $("input[name='user-status']:checked").val();
            var email = $('#user-email').val();

            if (userName == undefined || userName == "") {
                toastr.warning('用户名不能为空!');
                return;
            }

            if (email == undefined || email == "") {
                toastr.warning('用户邮箱不能为空!');
                return;
            }

            $('#addModal').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/user/add' ,
                data: JSON.stringify({
                    name : userName ,
                    status : status == 1 ? true : false ,
                    email : email ,
                    isAdmin : isAdmin == 1 ? true : false
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

        $('.edit-user').click(function () {

            if (!updateCheck) {
                toastr.warning('参数校验不通过！');
                return;
            }

            var name = $('#edit-user-name').val();
            var status = $("input[name='edit-user-status']:checked").val();
            var id = $('#edit-user-id').val();
            var isAdmin = $("input[name='edit-is-admin']:checked").val();
            var email = $('#edit-user-email').val();

            if (name == undefined || name == "") {
                toastr.warning("用户名不能为空!");
                return;
            }

            if (email == undefined || email == "") {
                toastr.warning("用户邮箱不能为空!");
                return;
            }

            $('#editModal').modal('hide');

            $('.edit-name-img').empty();
            $('.edit-email-img').empty();

            $.ajax({
                type: 'POST' ,
                url: '/user/update' ,
                data: JSON.stringify({
                    id : id ,
                    name : name ,
                    status : status == 1 ? true : false ,
                    isAdmin : isAdmin == 1 ? true : false ,
                    email : email
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

        $('.delete-user').click(function () {

            var id = $('#delete-user-id').val();

            $('#delcfmModel').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/user/delete' ,
                data: {id : id} ,
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

        $('.edit-close').click(function () {
            $('.edit-name-img').empty();
            $('.edit-email-img').empty();
        });

    }
    
    function initEvent() {

        $('#user-name').blur(function () {

            $('.name-img').empty();

            var name = $('#user-name').val();

            if (name == undefined || name == null || name == '') {
               return;
            }

            $.ajax({
               type: 'POST' ,
               url: '/user/getByName' ,
               data: {name : name},
               dataType: 'json' ,
               success: function (res) {
                   if (res.code != 200) {
                       insertCheck = false;
                       $('.name-img').append('<img src="/resources/images/wrong.png" width="20px" height="20px"/>');
                       toastr.error(res.msg);
                   } else {
                       insertCheck = true;
                       $('.name-img').append('<img src="/resources/images/right.png" width="20px" height="20px"/>');
                   }
               }
            });

        });

        $('#user-email').blur(function () {

            $('.email-img').empty();

            var email = $('#user-email').val();


            if (email == undefined || email == null || email == '') {
                return;
            }

            if (!isEmail(email)) {
                toastr.warning("邮箱格式不正确！");
                return;
            }

            $.ajax({
                type: 'POST' ,
                url: '/user/getByEmail' ,
                data: {email : email},
                dataType: 'json' ,
                success: function (res) {
                    if (res.code != 200) {
                        insertCheck = false;
                        $('.email-img').append('<img src="/resources/images/wrong.png" width="20px" height="20px"/>');
                        toastr.error(res.msg);
                    } else {
                        insertCheck = true;
                        $('.email-img').append('<img src="/resources/images/right.png" width="20px" height="20px"/>');
                    }
                }
            });

        });

        $('#edit-user-name').blur(function () {

            $('.edit-name-img').empty();

            var name = $('#edit-user-name').val();
            var id = $('#edit-user-id').val();

            if (name == undefined || name == null || name == '') {
                return;
            }

            $.ajax({
                type: 'POST' ,
                url: '/user/checkUpdateName' ,
                data: {name : name , id : id},
                dataType: 'json' ,
                success: function (res) {
                    if (res.code != 200) {
                        updateCheck = false;
                        $('.edit-name-img').append('<img src="/resources/images/wrong.png" width="20px" height="20px"/>');
                        toastr.error(res.msg);
                    } else {
                        updateCheck = true;
                        $('.edit-name-img').append('<img src="/resources/images/right.png" width="20px" height="20px"/>');
                    }
                }
            });

        });

        $('#edit-user-email').blur(function () {

            $('.edit-email-img').empty();

            var email = $('#edit-user-email').val();
            var id = $('#edit-user-id').val();

            if (email == undefined || email == null || email == '') {
                return;
            }

            if (!isEmail(email)) {
                toastr.warning("邮箱格式不正确！");
                return;
            }

            $.ajax({
                type: 'POST' ,
                url: '/user/checkUpdateEmail' ,
                data: {email : email , id : id},
                dataType: 'json' ,
                success: function (res) {
                    if (res.code != 200) {
                        updateCheck = false;
                        $('.edit-email-img').append('<img src="/resources/images/wrong.png" width="20px" height="20px"/>');
                        toastr.error(res.msg);
                    } else {
                        updateCheck = true;
                        $('.edit-email-img').append('<img src="/resources/images/right.png" width="20px" height="20px"/>');
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

    function isEmail(strEmail) {

        if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) {
            return true;
        }
        return false;
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
        url: '/user/getById' ,
        data: {id : id} ,
        dataType: 'json' ,
        success: function (res) {
            if (res.code != 200) {
                toastr.error(res.msg);
            } else {
                $('#edit-user-name').val(res.data.name);
                $('#edit-user-email').val(res.data.email);
                $('#edit-user-id').val(res.data.id);
                if (res.data.status) {
                    $("input[name='edit-user-status'][value='1']").attr("checked",true);
                } else {
                    $("input[name='edit-user-status'][value='0']").attr("checked",true);
                }

                if (res.data.isAdmin) {
                    $("input[name='edit-is-admin'][value='1']").attr("checked",true);
                } else {
                    $("input[name='edit-is-admin'][value='0']").attr("checked",true);
                }

                $('#editModal').modal('show');
            }
        }
    });
}

function deleteUser(id) {
    $('#delete-user-id').val(id);
    $('#delcfmModel').modal('show');
}
