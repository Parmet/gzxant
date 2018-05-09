    <link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/plugins/jsTree/style.min.css"/>
    <style>
        #dict_edit_table .control-label {
            text-align: left !important;
        }

        #dict_edit_table input ,#dict_edit_table select{
            margin-left: -45px;
        }
        #dict_edit_table .row{
          margin-top: 15px!important;
        }

    </style>
<div class="wrapper wrapper-content animated fadeInRight">
<!--数据列表-->
<div class="row" style="margin-right: 0!important;">

    <div class="col-sm-3">
        <div class="portlet box green-haze" style="padding: 15px">
            <div class="portlet-body" id="categoryTree"></div>
        </div>
    </div>

    <div class="col-sm-9">
        <div class="row" style="margin-right: 0!important;">
            <div class="col-md-12">
                <div class="portlet box green-haze" style="padding: 15px">

                    <div class="portlet-title">
                        <button class="btn green btn-parent btn-info">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">新增顶层分类</span>
                        </button>
                        <button type="button" class="btn green btn-children btn-primary" disabled="disabled">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">新增子分类</span>
                        </button>
                        <button type="button" class="btn blue btn-edit btn-success" disabled="disabled">
                            <i class="fa fa-edit"></i>
                            <span class="hidden-480">编辑此分类</span>
                        </button>
                        <button type="button" class="btn red btn-delete btn-danger" disabled="disabled">
                            <i class="fa fa-trash-o"></i>
                            <span class="hidden-480">删除此分类</span>
                        </button>
                    </div>

                    <div class="portlet-body form" id="dict_edit_table">
                        <form class="form-horizontal m-t" action="${rc.requestUri}/insert" method="POST" id="categoryForm">
                            <input type="hidden" name="id"/>
                            <input type="hidden" name="parentId" value="0"/>
                            <input type="hidden" name="path"/>

                            <div class="form-body">
                                <div class="row">
                                    <div class="col-md-4">
                                    	<div class="form-group">
                                            <label class="col-sm-3 control-label">图标<span class="required">*</span></label>

                                            <div class="col-sm-9">
		                                    	<button id="icon" disabled="disabled" name="icon" value="" class="btn btn-white btn-circle btn-lg" type="button">
		                                    	</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5"></div>
                                </div>
                                <div class="row" style="text-align:left">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">名称<span class="required">*</span></label>

                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" name="name"
                                                       placeholder="请录入数据名称" readonly="true" required="required"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">编码<span class="required">*</span></label>

                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" name="number"
                                                       placeholder="请录入数据编码" readonly="true" required="required"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                    
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label col-md-3">状态<span class="required">*</span></label>

                                            <div class="col-md-9">
                                                <select name="invalid" class="form-control" disabled="disabled">
                                                    <option value="Y">有效</option>
                                                    <option value="N">失效</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label col-md-3">排序</label>

                                            <div class="col-md-9">
                                                <input type="text" class="form-control" name="sort"
                                                       placeholder="请录入排序号" readonly="true"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <label class="control-label col-md-2">描述</label>

                                            <div class="col-md-10">
                                                <input type="text" class="form-control" name="remark"
                                                       readonly="true"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions fluid">
                                <div class="row">
                                	<div class="col-md-9"></div>
                                    <div class="col-md-3">
                                        <button type="submit" class="btn btn-success" disabled="disabled">保存</button>
                                        <button type="button" class="btn btn-default btn-cancel" disabled="disabled">取消</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

	
</div>
<script src="${rc.contextPath}/js/plugins/jsTree/jstree.min.js" type="text/javascript"></script>
<script src="${rc.contextPath}/js/plugins/iIcon/iIcon.js" type="text/javascript"></script>
<script type="text/javascript">
	var icon = $("#icon").iIcon({});

    var form = $('#categoryForm'), id = 0, pid = 0, text;
    $("#categoryTree").jstree({
        "core": {
            "animation": 0,
            "themes": {
                theme: "classic",
                "dots": true,
                "icons": true
            },
            "check_callback": true,
            'data': ${categoryTrees!''}
        },
        "types": {
            "default": {
                "valid_children": ["default", "file"]
            }
        },
        "plugins": ["types", "wholerow"]
    }).on("select_node.jstree", function (node, selectd) {
        id = selectd.node.id;
        pid = selectd.node.parent;
        text = selectd.node.text;
        if (id) {
            $.ajax({
                url: '${rc.requestUri}/select/' + id,
                type: 'GET',
                success: function (msg) {
                    var data = msg.categorys;
                    icon.editIcon(data.icon);
                    $('input[name=id]').val(data.id);
                    $('input[name=parentId]').val(data.parentId);
                    $('input[name=number]').val(data.number);
                    $('input[name=name]').val(data.name);
                    $('input[name=sort]').val(data.sort);
                    $('input[name=path]').val(data.path);
                    $('input[name=remark]').val(data.remark);

                    $("select[name=invalid] option[value='" + data.invalid + "']").attr("selected", "selected");
                    $("select[name=invalid] option[value!='" + data.invalid + "']").attr("selected", false);

                    $('#categoryForm :input').each(function (a) {
                        $(this).attr('disabled', "disabled");
                        $(this).attr("readonly", "true");
                    });
                    $('.btn-children').enable();
                    $('.btn-edit').enable();
                    $('.btn-delete').enable();
                }
            });
        }
    });
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: false,
        rules: {
            name: {
                minlength: 2,
                maxlength: 50,
                required: true
            },
            icon: {
                required: true
            },
            number: {
                required: true
            },
            invalid: {
                required: true
            }
        },
        invalidHandler:function(event,validator){
            error.show();
        },
        highlight:function(element){
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight:function(element){
            $(element).closest('.form-group').removeClass('has-error');
        },
        success:function(label){
            label.closest('.form-group').removeClass('has-error');
        },
        submitHandler:function(form){
            error.hide();
            form.submit();
        }
    });
    $('.btn-parent').click(function () {
    	icon.init();
        form.resetForm();
        $('input[name=id]').val("");
        $('input[name=parentId]').val(0);
        $('#categoryForm :input').each(function (a) {
            $(this).enable();
            $(this).attr("readonly", false);
        });
        $('.btn-edit').attr('disabled', "disabled");
        $('.btn-delete').attr('disabled', "disabled");

    });
    $('.btn-children').click(function () {
    	icon.init();
        form.resetForm();
        $('input[name=id]').val("");
        $('input[name=parentId]').val(id);
        $('#categoryForm :input').each(function (a) {
            $(this).enable();
            $(this).attr("readonly", false);
        });
        $('.btn-edit').attr('disabled', "disabled");
        $('.btn-delete').attr('disabled', "disabled");
    });
    $('.btn-edit').click(function () {
        $('#categoryForm :input').each(function (a) {
            $(this).enable();
            $(this).attr("readonly", false);
        });
    });
    $('.btn-cancel').click(function () {
    	icon.init();
        form.resetForm();
        $('#categoryForm :input').each(function (a) {
            $(this).attr('disabled', "disabled");
            $(this).attr("readonly", "true");
        });
    });
    $('.btn-delete').click(function () {
    	icon.init();
        layer.confirm('是否要删除此分类及其下级？', {
            btn: ['是', '否']
        },function () {
            $.ajax({
                url: '${rc.requestUri}/delete/' + dic_id,
                type: 'DELETE',
                success: function (data) {
                    if (data.success) {
                        location.reload();
                        /*   bootbox.alert(data.message);*/
                    } else {
                        bootbox.alert(data.message);
                    }
                }
            });
        });

    });

    $('.btn-rush').click(function () {

        $.ajax({
            url: '${rc.requestUri}/rush',
            type: 'GET',
            success: function (data) {
               layer.msg('刷新成功');
            }
        });
    });

    /**
     * 提示信息显示
     * */
    jQuery(function ($) {
        var message = "${message}";
        if (null == message || '' == message) {
            $(".alert").alert('close');
        } else {
            $('#message').addClass('alert-success');
            $('#message').removeClass('alert-danger');
            setInterval(alertClose, 3 * 1000);
        }
    });

    /**
     * 关闭提示信息
     * */
    function alertClose() {
        $(".alert").alert('close');
    }
    
    
</script>

