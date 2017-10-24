/**
 * Created by Lenovo on 2017/10/12.
 */

$(function () {

    var $table = $('#access-list');

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
           url: '/access/getAccessList',
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
               title: '权限ID' ,
               formatter: function (value, row, index) {
                   return row.id;
               }
           },{
               field: 'title',
               title: '权限'
           },{
               field: 'uris',
               title: 'Uris'
           },{
               field: 'status',
               title: '权限状态' ,
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
                   return '<button class="btn btn-xs btn-blue" ' +
                       'onclick="modify(\'' + id + '\')">' + '编辑' +
                       '</button>&nbsp;&nbsp;&nbsp;&nbsp;' +
                       '<button class="btn btn-xs btn-danger" ' +
                       'onclick="deleteAccess(\'' + id + '\')">' + '删除' + '</button>';
               }
           }]
       });
    };

    function initClick() {

        $('.add-access').click(function () {

            var accessName = $('#access-name').val();
            var status = $("input[name='access-status']:checked").val();

            if (accessName == undefined || accessName == "") {
                toastr.warning("角色名不能为空!");
                return;
            }

            $('#addModal').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/access/add' ,
                data: JSON.stringify({
                    name : accessName ,
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

        $('.edit-access').click(function () {

            var accessName = $('#edit-access-name').val();
            var status = $("input[name='edit-access-status']:checked").val();
            var id = $('#edit-access-id').val();

            if (accessName == undefined || accessName == "") {
                toastr.warning("角色名不能为空!");
                return;
            }

            $('#editModal').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/access/update' ,
                data: JSON.stringify({
                    id : id ,
                    name : accessName ,
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

        $('.delete-access').click(function () {

            var id = $('#delete-access-id').val();

            $('#delcfmModel').modal('hide');

            $.ajax({
                type: 'POST' ,
                url: '/access/delete' ,
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
        url: '/access/getById' ,
        data: JSON.stringify({
            id : id
        }) ,
        contentType : 'application/json' ,
        dataType: 'json' ,
        success: function (res) {
            if (res.code != 200) {
                toastr.error(res.msg);
            } else {
                $('#edit-access-name').val(res.data.name);
                $('#edit-access-id').val(res.data.id);
                if (res.data.status) {
                    $("input[name='edit-access-status'][value='1']").attr("checked",true);
                } else {
                    $("input[name='edit-access-status'][value='0']").attr("checked",true);
                }

                $('#editModal').modal('show');
            }
        }
    });
}

function deleteAccess(id) {
    $('#delete-access-id').val(id);
    $('#delcfmModel').modal('show');
}
