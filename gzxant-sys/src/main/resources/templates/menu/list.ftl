<link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/plugins/jsTree/style.min.css"/>
<style>
    #menu_edit_table .control-label {
        text-align: left !important;
    }

    #menu_edit_table input, #menu_edit_table select {
        margin-left: -45px;
    }

    #menu_edit_table .row {
        margin-top: 15px !important;
    }

</style>
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">

        <div class="col-md-3">
            <div class="portlet box green-haze" style="padding: 15px">
                <div class="portlet-body" id="resTree"></div>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row" style="margin-right: 0!important;">
                <div class="col-md-12">

                    <div class="portlet box green-haze" style="padding: 15px">
                        <div class="portlet-title">

                            <button type="button" class="btn green btn-parent btn-info">
                                <i class="fa fa-plus-square" aria-hidden="true"></i>
                                <span class="hidden-480">新增父菜单</span>
                            </button>

                            <button type="button" class="btn green btn-children btn-success" disabled="disabled">
                                <i class="fa fa-plus"></i>
                                <span class="hidden-480">新增子菜单</span>
                            </button>

                            <button type="button" class="btn blue btn-edit btn-primary" disabled="disabled">
                                <i class="fa fa-edit"></i>
                                <span class="hidden-480">编辑此菜单</span>
                            </button>

							<button type="button" class="btn red btn-delete btn-danger" disabled="disabled">
                                <i class="fa fa-trash-o"></i>
                                <span class="hidden-480">禁用此菜单</span>
                            </button>
                            <button type="button" class="btn red btn-delete btn-danger" disabled="disabled">
                                <i class="fa fa-trash-o"></i>
                                <span class="hidden-480">删除此菜单</span>
                            </button>
                        </div>
                        <div class="portlet-body form" id="menu_edit_table">
                            <form id="menuForm" action="${rc.contextPath}/sys/menu/insert" class="form-horizontal form-bordered"
                                  method="POST">
                                <input type="hidden" name="id"/>
                                <input type="hidden" name="parentId" value="0"/>
                                <input type="hidden" name="path"/>

                                <div class="form-body">

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">菜单名称<span
                                                        class="required">*</span></label>

                                                <div class="col-md-10">
                                                    <input type="text" class="form-control" name="name"
                                                           readonly="true"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">权限标识<span
                                                        class="required">*</span></label>

                                                <div class="col-md-10">
                                                    <input type="text" class="form-control" name="permission"
                                                           readonly="true"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
	                                            <label class="col-sm-3 control-label">图标<span class="required">*</span></label>
	
	                                            <div class="col-sm-9">
			                                    	<button id="icon" disabled="disabled" name="icon" value="" class="btn btn-white btn-circle btn-lg" type="button">
			                                    	</button>
	                                            </div>
	                                        </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">类型&nbsp;<span
                                                        class="required">*</span></label>

                                                <div class="col-md-10">
                                                    <select name="type" class="form-control" disabled="disabled">
                                                    <#list menuTypes as rt>
                                                        <option value="${rt}">${rt}</option>
                                                    </#list>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">URL&nbsp;<span
                                                        class="required">*</span></label>

                                                <div class="col-md-10">
                                                    <input type="text" class="form-control" name="href"
                                                           readonly="true"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">排序&nbsp;<span
                                                        class="required">*</span></label>

                                                <div class="col-md-10">
                                                    <div class="input-icon right">
                                                        <input type="text" class="form-control" name="sort"
                                                               readonly="true"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">状态&nbsp;<span class="required">*</span></label>

                                                <div class="col-md-10">
                                                    <div class="input-icon right">
                                                        <select name="showFlag" class="form-control" disabled="disabled">
                                                            <option value="Y">启用</option>
                                                            <option value="N">不启用</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-actions fluid">
                                    <div class="row">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button type="submit" class="btn green" disabled="disabled">保存</button>
                                            <button type="button" class="btn default btn-cancel" disabled="disabled">取消</button>
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

    var form = $('#menuForm'), menuid, text;
    $("#resTree").jstree({
        "core": {
            "animation": 0,
            "themes": {
                theme: "classic",
                "dots": true,
                "icons": true
            },
            "check_callback": true,
            'data':${menuTree}
        },
        "types": {
            "default": {
                "valid_children": ["default", "file"]
            }
        },
        "plugins": ["wholerow"]
    }).on("select_node.jstree", function (node, selectd) {
        menuid = selectd.node.id;
        text = selectd.node.text;
        if (menuid) {
            $.ajax({
                url: '${rc.contextPath}/sys/menu/select/' + menuid,
                type: 'GET',
                success: function (data) {
                    data=data.menu;
                    $('input[name=id]').val(data.id);
                    $('input[name=parentId]').val(data.parentId);
                    $('input[name=name]').val(data.name);
                    $('input[name=permission]').val(data.permission);
                    $('input[name=icon]').val(data.icon);
                    $('#iconImg').attr("class", data.icon)

                    $('input[name=path]').val(data.path);

                    $("select[name=type] option[value='" + data.type + "']").attr("selected", "selected");
                    $("select[name=type] option[value!='" + data.type + "']").attr("selected", false);

                    $('input[name=href]').val(data.href);
                    $('input[name=sort]').val(data.sort);

                    $("select[name=showFlag] option[value='" + data.showFlag + "']").attr("selected", "selected");
                    $("select[name=showFlag] option[value!='" + data.showFlag + "']").attr("selected", false);

                    $('#menuForm :input').each(function (a) {
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



    var error=$('.alert-danger',form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        ignore: "",
        focusInvalid: false,
        rules: {
            name: {
                minlength: 2,
                maxlength: 30,
                required: true
            },
            permission: {
                required: true
            },
            type: {
                required: true
            },
            href: {
                required: true
            },
            sort: {
                required: true,
                number: true
            },
            showFlag: {
                required: true
            },
            icon: {
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
        form.resetForm();
        $('input[name=id]').val("");
        $('input[name=parentId]').val(0);
        $('#menuForm :input').each(function (a) {
            $(this).enable();
            $(this).attr("readonly", false);
        });
        $('.btn-edit').attr('disabled', "disabled");
        $('.btn-delete').attr('disabled', "disabled");

    });
    $('.btn-children').click(function () {
        form.resetForm();
        $('input[name=id]').val("");
        $('input[name=parentId]').val(menuid);
        $('#menuForm :input').each(function (a) {
            $(this).enable();
            $(this).attr("readonly", false);
        });
        $('.btn-edit').attr('disabled', "disabled");
        $('.btn-delete').attr('disabled', "disabled");
    });
    $('.btn-edit').click(function () {
        $('#menuForm :input').each(function (a) {
            $(this).enable();
            $(this).attr("readonly", false);

        });
    });
    $('.btn-cancel').click(function () {
        $('#menuForm :input').each(function (a) {
            $(this).attr('disabled', "disabled");
            $(this).attr("readonly", "true");
        });
        $('div.form-group ').removeClass('has-error');
        $('div.alert-danger').css('display', 'none');
    });
    $('.btn-delete').click(function () {
        if (menuid){
            layer.confirm('确认要删除此菜单及其下级所有资源吗？', {
                btn: ['确定', '取消']
            }, function () {
                $.ajax({
                    url: '${rc.contextPath}/sys/menu/delete/' + menuid,
                    type: "DELETE",

                    success: function (r) {
                        window.location.reload();
                    }
                });
            })
        }

    });
</script>
