<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css"
          media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <%-- 搜索条件 --%>
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">入住人</label>
                            <div class="layui-input-inline">
                                <input type="text" name="customername" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">身份证号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="idcard" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">手机号码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">房间类型</label>
                            <div class="layui-input-inline">
                                <select name="roomtypeid" autocomplete="off" class="layui-input s_roomTypeId">
                                    <option value="">全部</option>
                                </select>
                            </div>
                        </div>

                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block" style="text-align: center">
                            <button type="submit" class="layui-btn" lay-submit lay-filter="data-search-btn"><i
                                    class="layui-icon layui-icon-search"></i>搜索
                            </button>
                            <button type="reset" class="layui-btn layui-btn-warm"><i
                                    class="layui-icon layui-icon-refresh-1"></i>重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <%-- 表格工具栏 --%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="checkOut"><i
                        class="layui-icon layui-icon-edit"></i>退款申请
                </button>
            </div>
        </script>

        <%-- 数据表格 --%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <%-- 添加和修改窗口 --%>
        <div style="display: none;padding: 5px" id="addOrUpdateWindow">
            <form class="layui-form" style="width:90%;" id="dataFrm" lay-filter="dataFrm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">退款编号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="ordersid" lay-verify="required" autocomplete="off" readonly
                                   placeholder="请选择退款订单" class="layui-input">
                        </div>

                        <div class="layui-form-mid" style="position:relative;bottom:5px;">
                            <button type="button" class="layui-btn layui-btn-sm" id="openOrdersWindow"><i
                                    class="layui-icon layui-icon-add-circle-fine"></i>选择订单
                            </button>
                        </div>
                    </div>

                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">所属房型</label>
                        <div class="layui-input-inline">
                            <input type="hidden" name="roomtypeid">
                            <input type="text" name="roomTypeName" placeholder="请选择房型" lay-verify="required"
                                   autocomplete="off" readonly class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">房间编号</label>
                        <div class="layui-input-inline">
                            <input type="hidden" name="roomid">
                            <input type="text" name="roomnum" placeholder="请输入房间号码" lay-verify="required"
                                   autocomplete="off" readonly class="layui-input">
                        </div>
                    </div>

                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">入住人</label>
                        <div class="layui-input-inline">
                            <input type="text" name="customername" placeholder="请输入入住人姓名" lay-verify="required"
                                   autocomplete="off" readonly class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">手机号码</label>
                        <div class="layui-input-inline">
                            <input type="text" name="phone" placeholder="请输入手机号码" lay-verify="required"
                                   autocomplete="off" readonly class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">入住价格</label>
                        <div class="layui-input-inline">
                            <input type="text" name="payprice" placeholder="请输入入住价格" lay-verify="required"
                                   autocomplete="off" readonly class="layui-input">
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">退款金额</label>
                        <div class="layui-input-inline">
                            <input type="text" id="myprice" name="outPrice" placeholder="请输入申请退款金额" lay-verify="required"
                                   autocomplete="off"  class="layui-input">
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">身份证号</label>
                    <div class="layui-input-block">
                        <input type="text" name="idcard" placeholder="请输入身份证号码" lay-verify="required" autocomplete="off"
                               readonly class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item layui-row layui-col-xs12">
                    <div class="layui-input-block" style="text-align: center;">
                        <button type="button" class="layui-btn" lay-submit lay-filter="doSubmit"><span
                                class="layui-icon layui-icon-add-1"></span>提交
                        </button>
                        <button type="reset" class="layui-btn layui-btn-warm"><span
                                class="layui-icon layui-icon-refresh-1"></span>重置
                        </button>
                    </div>
                </div>
            </form>
        </div>

        <div style="display: none;padding: 5px" id="UpdateOutWindow">
                <form class="layui-form" style="width:90%;" id="Outdata" lay-filter="dataFrm">
                </form>
        </div>

        <%--行工具栏区域
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit"><i
                    class="layui-icon layui-icon-edit"></i>编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete"><i
                    class="layui-icon layui-icon-delete"></i>删除</a>
        </script>--%>

        <!-- 选择预定订单窗口 -->
        <div style="display: none;" id="selectOrdersWindow">
            <%-- 数据表格 --%>
            <table class="layui-hide" id="ordersTableId" lay-filter="ordersTableFilter"></table>
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table', 'laydate', 'jquery', 'layer'], function () {
        var $ = layui.jquery,
            form = layui.form,
            laydate = layui.laydate,
            layer = layui.layer,
            table = layui.table;

        //渲染日期组件
        laydate.render({
            elem: '#startTime', //指定元素
            type: 'datetime'
        });
        laydate.render({
            elem: '#endTime', //指定元素
            type: 'datetime'
        });

        //查询房型列表
        $.get("${pageContext.request.contextPath}/admin/roomType/findAll", function (result) {
            var html = "";
            //循环遍历
            for (var i = 0; i < result.length; i++) {
                html += "<option value='" + result[i].id + "'>" + result[i].typename + "</option>"
            }
            //将网页代码追加到下拉列表中
            $("[name='roomtypeid']").append(html);
            //渲染下拉列表
            form.render("select");
        }, "json");

        //渲染表格组件
        var tableIns = table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/admin/outMoney/list',
            toolbar: '#toolbarDemo',
            cols: [[
                {field: 'id', width: 100, title: '入住编号', align: "center"},
                {
                    field: 'roomType', width: 100, title: '入住房型', align: "center", templet: function (d) {
                        return d.roomType.typename;
                    }
                },
                {
                    field: 'room', width: 80, title: '房间号', align: "center", templet: function (d) {
                        return d.room.roomnum;
                    }
                },
                {field: 'customername', width: 100, title: '入住人', align: "center"},
                {field: 'idcard', minWidth: 120, title: '身份证号', align: "center"},
                {field: 'phone', width: 150, title: '手机号', align: "center"},
                {field: 'payprice', width: 120, title: '支付金额', align: "center"},
                {
                    field: 'outMoney', width: 120, title: '退款金额', align: "center", templet: function (d) {
                        return d.outMoney.outPrice;
                    }
                },
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            page: true,
            done: function (res, curr, count) {
                //判断当前页码是否是大于1并且当前页的数据量为0
                if (curr > 1 && res.data.length == 0) {
                    var pageValue = curr - 1;
                    //刷新数据表格的数据
                    tableIns.reload({
                        page: {curr: pageValue}
                    });
                }
            }
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            tableIns.reload({
                where: data.field,
                page: {
                    curr: 1
                }
            });
            return false;
        });

        //监听头部工具栏事件
        //toolbar是头部工具栏事件
        //currentTableFilter是表格lay-filter过滤器的值
        table.on("toolbar(currentTableFilter)", function (obj) {
            switch (obj.event) {
                case "checkOut"://退房订单按钮
                    openCheckOutWindow();//打开退款申请窗口
                    break;
            }
        });

        //监听行工具栏事件
        table.on("tool(currentTableFilter)", function (obj) {
            switch (obj.event) {
                case "checkout"://退房按钮
                    checkOut(obj.data);
                    break;
            }
        });

        //监听行工具栏事件
        table.on("tool(currentTableFilter)",function (obj){
            switch (obj.event) {
                case "edit"://编辑按钮
                    openUpdateWindow(obj.data);//打开修改窗口
                    break;
                case "delete"://删除按钮
                    deleteById(obj.data);//打开添加窗口
                    break;
            }
        });

        var url;//提交地址
        var mainIndex;//打开窗口的索引

        /**
         * 打开申请退款窗口
         */
        function openCheckOutWindow() {
            mainIndex = layer.open({
                type: 1,//打开类型
                title: "退款申请",//窗口标题
                area: ["800px", "570px"],//窗口宽高
                content: $("#addOrUpdateWindow"),//引用的内容窗口
                success: function () {
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                }
            });
        }

        //选择订单按钮点击事件
        $("#openOrdersWindow").click(function () {
            var index = layer.open({
                type: 1,//打开类型
                title: "选择订单",//窗口标题
                area: ["1300px", "500px"],//窗口宽高
                maxmin: true,//开启最大化和最小化
                content: $("#selectOrdersWindow"),//引用的内容窗口
                success: function () {
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                    //添加的提交请求
                    url = "${pageContext.request.contextPath}/admin/outMoney/addOutMoney";
                    //初始化预订订单列表的表格数据
                    initOrdersTable();
                },
                btn: ["<i class='layui-icon layui-icon-ok'></i>确定", "<i class='layui-icon layui-icon-close'></i>取消"],
                yes: function (index, layero) {
                    //判断使用有选中行
                    var checkStatus = table.checkStatus('ordersTableId');
                    if (checkStatus.data.length > 0) {
                        //获取当前选中行数据
                        var data = checkStatus.data[0];//选中的第一条数据
                        //给登记入住的表单进行数据回显
                        form.val("dataFrm", {
                            //key是form表单的name属性值
                            "ordersid": data.id//订单id
                            , "roomtypeid": data.roomtypeid //房型ID
                            , "roomTypeName": data.roomType.typename //房型名称
                            , "roomnum": data.room.roomnum   //房间号码
                            , "roomid": data.roomid          //房间ID
                            , "customername": data.customername   //预订人姓名
                            , "phone": data.phone    //预订人手机
                            , "payprice": data.payprice  //预订价格
                            , "idcard": data.idcard  //身份证号码
                            , "remark": data.remark //备注
                        });
                        //关闭窗口
                        layer.close(index);
                    } else {
                        layer.msg("请选择一条订单信息！")
                    }
                },
                cancel: function () {

                }
            });
            //默认最大化窗口
            layer.full(index);
        });

        /**
         * 初始化预订订单列表
         */
        function initOrdersTable() {
            table.render({
                elem: '#ordersTableId',
                url: '${pageContext.request.contextPath}/admin/checkin/list?status=2',//只查询已确认的订单列表
                cols: [[
                    {type: "radio", width: 50},
                    {field: 'id', width: 100, title: '订单编号', align: "center"},
                    {
                        field: 'roomType', width: 100, title: '预订房型', align: "center", templet: function (d) {
                            return d.roomType.typename;
                        }
                    },
                    {
                        field: 'room', width: 80, title: '房间号', align: "center", templet: function (d) {
                            return d.room.roomnum;
                        }
                    },
                    {field: 'customername', width: 100, title: '预订人', align: "center"},
                    {field: 'idcard', width: 170, title: '身份证号', align: "center"},
                    {field: 'phone', width: 150, title: '手机号', align: "center"},
                    {
                        field: 'status', width: 80, title: '状态', align: "center", templet: function (d) {
                            if (d.status == 1) {
                                return "待确认";
                            } else if (d.status == 2) {
                                return "已确认";
                            } else if (d.status == 3) {
                                return "已入住";
                            }
                        }
                    },
                    {field: 'payprice', width: 80, title: '支付金额', align: "center"},
                ]],
                page: true
            });
        }

        //监听表单提交事件
        form.on("submit(doSubmit)", function (data) {
            data.field.myprice=data.field.outPrice
            $.post(url, data.field, function (result) {
                if (result.success) {
                    //刷新数据表格
                    tableIns.reload();
                    //关闭窗口
                    layer.close(mainIndex);
                }
                //提示信息
                layer.msg(result.message);
            }, "json");
            //禁止页面刷新
            return false;
        });

    });
</script>

</body>
</html>
