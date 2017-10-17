/**
 * Created by Lenovo on 2017/10/12.
 */

$(function () {
    var $table = $('#role-list');

    initTable();

    initClick();

   
    function initTable() {
       $table.bootstrapTable({
           url: '/role/getRoleList',
           method: 'post',
           dataType: 'json',
           contentType:'application/json',
           pagination: true,
           striped: true,
           clickToSelect: true,
           sidePagination: 'server',
           pageNumber: 1,
           pageSize: 2,
           height:300,
           pageList: [2, 4, 6, 8],
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
                   return '<button class="btn btn-xs btn-blue" ' +
                       'onclick="modify(\'' + id + '\')">' + '编辑' +
                       '</button>&nbsp;&nbsp;&nbsp;&nbsp;' +
                       '<button class="btn btn-xs btn-danger" ' +
                       'onclick="delete(\'' + id + '\')">' + '删除' + '</button>';
               }
           }]
       });
    };

    function initClick() {

        $('add-role').click(function () {
            var roleName = $('#role-name').val();
            var status = $("input[name='role-status']:checked").val();
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
