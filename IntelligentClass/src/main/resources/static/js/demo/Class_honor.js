$(document).ready(function () {
    $(".i-checks").iCheck({
        checkboxClass:'icheckbox_square-blue',
        radioClass: "iradio_square-blue",
    })
})
var limitcount = 10;
var curnum = 1;
//列表查询方法
function productsearch(start,limitsize,title,subtitle,statue,time1,time2) {
    layui.use(['table','laypage','layer','jquery','form','laydate','upload'], function(){
        var table = layui.table,
            laydate=layui.laydate,
            laypage = layui.laypage,
            layer=layui.layer,
            upload=layui.upload,
            form=layui.form,
            $=layui.jquery,
            form=layui.form;
        table.render({
            elem: '#layui_table_id',
            method: 'post'
            , url: 'back/classHonor/getHonorList'
            ,where:{
                title:title,
                startTime:time1,
                endTime:time2,
                pageNo:start,
                pageSize: limitsize
            }
            ,cols: [[
                {field:'id',type:'checkbox'},
                {field: 'title', title: '标题', minWidth: '100', sort: true}
                , {field: 'pic', title: '内容', minWidth: '120'}
                , {field: 'nj', title: '年级', minWidth: '80', sort: true}
                , {field: 'createTime', title: '创建时间', minWidth: '160'}
                , {field: 'poperation', title: '操作', minWidth: '120', toolbar: '#barDemo'}
            ]]
            , page: false
            , height: 430
            ,id:'idTest'
            ,done: function(res, curr, count){
                laypage.render({
                    elem:'laypage'
                    ,count:count
                    ,curr:curnum
                    ,limit:limitcount
                    ,layout: ['prev', 'page', 'next', 'skip','count','limit']
                    ,jump:function (obj,first) {
                        if(!first){
                            curnum = obj.curr;
                            limitcount = obj.limit;
                           var title=$("input[neme='stitle']").val()
                               ,time1=$("#dateStart").val()
                               ,time2=$("#dateEnd").val();
                            productsearch(curnum,limitcount,title,time1,time2);
                        }
                    }
                });
                //data1日期范围
                var start=laydate.render({
                    elem:"#dateStart",
                    done:function (value,date) {
                        end.config.min=date
                        end.config.min.month = date.month -1;
                    }
                })
                var end=laydate.render({
                    elem:"#dateEnd",
                    done:function (value,date) {

                    }
                })
                $("#search").click(function () {
                    var title=$("input[neme='stitle']").val()
                        ,time1=$("#dateStart").val()
                        ,time2=$("#dateEnd").val();
                    productsearch(curnum,limitcount,title,time1,time2);
                })
                $("#reset").click(function () {

                  window.location.reload()
                })
            }
        })
        //表格操作事件监听
        table.on('tool(test)',function(obj){
            var layData=obj.data;
            if(obj.event=='edit'){
                //编辑操作
                $("#message").modal("show")
                    //图片选择
                    $("input[name='pic']").val(layData.pic)
                    $(".imgList img").click(function(){
                        $(this).addClass("active").siblings().removeClass("active")
                        $("input[name='pic']").val($(this).attr("data-pic"))
                    })
                    $("input[name='title']").val(layData.title);
                   for(var i=0;i<$(".imgList img").length;i++){
                       $(".imgList img").eq(i).removeClass("active")
                       if($(".imgList img").eq(i).attr("data-pic")==layData.pic){
                           $(".imgList img").eq(i).addClass("active")
                       }
                   }
                    //年级班级数据联动
                    $.get("back/XxNjbJ/getNjByXx", function (res) {
                        var data=res.data
                        $("#sel1").html("")
                        for (var i = 0; i < data.length; i++) {
                            $("#sel1").append('<option value="' + data[i].xxNjxxId + '">' + data[i].njmc + '</option>')
                        }
                        $("#sel1 option[value='"+layData.nj+"']").attr("selected","selected")
                    });
                    $.get("back/XxNjbJ/getBjByNj", {nj: layData.nj}, function (res) {
                        var data = res.data;
                        if (data.length == "0") {
                            layer.alert("数据为空")
                            $("#sel2").html("")
                        } else {
                            $("#sel2").html("")
                            for (var i = 0; i < data.length; i++) {
                                $("#sel2").append('<option value="' + data[i].xxBjxxId + '">' + data[i].bjmc + '</option>')
                            }
                            $("#sel2 option[value='"+layData.bj+"']").attr("selected","selected")
                        }
                    })
                    $("#sel1").change(function () {
                        $.get("back/XxNjbJ/getBjByNj", {nj: $("#sel1 option:selected").val()}, function (res) {
                            var data = res.data;
                            if (data.length == "0") {
                                layer.alert("数据为空")
                                $("#sel2").html("")
                            } else {
                                $("#sel2").html("")
                                for (var i = 0; i < data.length; i++) {
                                    $("#sel2").append('<option value="' + data[i].xxBjxxId + '">' + data[i].bjmc + '</option>')
                                }
                            }
                        })
                    })
                    $("#test01").click(function () {
                        $.ajax({
                            type:"POST",
                            url:'back/classHonor/addOrUpHonor',
                            data:{
                                id:layData.id,
                                title:$("#title").val(),
                                pic: $("input[name='pic']").val(),
                                nj:$("#sel1 option:selected").val(),
                                bj:$("#sel2 option:selected").val(),
                            },
                            dataType: 'JSON',
                            success:function (res) {
                                if(res.code==0){
                                    layer.msg("上传成功",{time:1000},function(){
                                      window.location.reload()
                                    })
                                }else{
                                    layer.msg("参数错误,请重新提交",{time:1000},function(){
                                        $("#message").modal('hide')
                                        window.location.reload()
                                    });

                                }
                            }
                        })
                    })
            }else if(obj.event=='delete'){
                layer.confirm("确定要删除吗?",function(index){
                    //数据操作
                    $.get("back/classHonor/falseDelById",{id:layData.id},function (res) {
                        obj.del()
                        layer.close(index);
                        window.location.reload()
                    })
                })
            }
        })
        //事件操作
        var active={
            deleteMore:function(){
                var checkStatus=table.checkStatus('idTest');
                var dataStatus=checkStatus.data;
                var arr=[];
                if (dataStatus.length!=0){
                    for (var i=0;i<dataStatus.length;i++){
                       arr.push(dataStatus[i].id)
                    }
                    console.log(arr)
                    layer.confirm("确定删除吗?",function(index){
                        $.get("back/classHonor/falseDelByIds",{ids:arr.join(",")},function (res) {
                            console.log(res)
                            layer.close(index);
                            window.location.reload()
                        })


                    })
                }else{
                    layer.alert("请选择需要删除的内容")
                }
            },
        }
        $('.btnGroup .btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    })


    //新增 内容
    $("#add").click(function(){
        $(".imgList img").click(function(){
            $(this).addClass("active").siblings().removeClass("active")
            $("input[name='pic']").val($(this).attr("data-pic"))
        })
        //年级班级数据联动
        $.get("back/XxNjbJ/getNjByXx",function(res){
            var data=res.data;
            $("#sel1").html("")
            for(var i=0;i<data.length;i++){
                $("#sel1").append('<option value="'+data[i].xxNjxxId+'">'+data[i].njmc+'</option>')
            }
        });
        $("#sel1").change(function () {
            $.get("back/XxNjbJ/getBjByNj",{nj:$("#sel1 option:selected").val()},function (res) {
                var data=res.data;
                if(data.length=="0") {
                    layer.alert("数据为空")
                    $("#sel2").html("")
                }else{
                    $("#sel2").html("")
                    for (var i=0;i<data.length;i++){
                        $("#sel2").append('<option value="'+data[i].xxBjxxId+'">'+data[i].bjmc+'</option>')
                    }
                }
            })
        })
        //表单提交
        $("#test01").on("click",function(ev){
            $.ajax({
                type:"POST",
                url:'back/classHonor/addOrUpHonor',
                data:{
                    title:$("#title").val(),
                    pic: $("input[name='pic']").val(),
                    nj:$("#sel1 option:selected").val(),
                    bj:$("#sel2 option:selected").val(),
                },
                dataType: 'JSON',
                success:function (res) {
                    if(res.code==0){
                        layer.msg("上传成功",{time:1000},function(){
                            window.location.reload()
                        })
                    }else{
                        layer.msg("参数错误,请重新提交",{time:1000},function(){
                            $("#message").modal('hide')
                            window.location.reload()
                        });

                    }
                }
            })
        })
        $("#message").modal("show");


    })
}
productsearch(curnum, limitcount);


