<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">
            	<input type="hidden" name="id" value="${qualification.id}" />
            	<div class="form-group">
                    <label class="col-sm-3 control-label">编号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="code" placeholder="请填写编号（通过时必填）"
                               value="${qualification.code}"/>
                    </div>
                </div>
            	
                <div class="form-group">
                    <label class="col-sm-3 control-label">姓名</label>
                    <div class="col-sm-9">
                    	<input type="text" class="form-control" name="name" placeholder="请输入姓名"
                               value="${qualification.name}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">电话</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="phone" placeholder="请输入电话"
                               value="${qualification.phone}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">企业</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="enterprise" placeholder="请输入企业"
                               value="${qualification.enterprise}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">身份证号码</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="card" placeholder="请输入身份证号码"
                               value="${qualification.card}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">邮箱</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="email" placeholder="请输入邮箱"
                               value="${qualification.email}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">目前经营的品牌或代理</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="brandAgent" placeholder="请输入目前经营的品牌或代理"
                               value="${qualification.brandAgent}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">省份</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="provinces" placeholder="请输入省份"
                               value="${qualification.provinces}" required aria-required="true"/>
                    </div>
                </div>

                <#if qualification.state == null>
	                <div class="form-actions fluid">
	                    <div class="col-sm-4">
	                        <button type="button" onclick="pass()" class="btn btn-success btn-block m-t-25">通过</button>
	                    </div>
                        <div class="col-sm-4">
                            <button type="button" onclick="notForm()" class="btn btn-success btn-block m-t-25">不通过</button>
                        </div>
                        <div class="col-sm-4">
                            <button type="button" onclick="back()" class="btn btn-success btn-block m-t-25">返回</button>
                        </div>
                    </div>
                <#elseif qualification.state == 'N'>
               		<div class="form-actions fluid">
	                    <div class="col-sm-6">
	                        <button type="button" onclick="pass()" class="btn btn-success btn-block m-t-25">审核通过</button>
	                    </div>
                        <div class="col-sm-6">
                            <button type="button" onclick="back()" class="btn btn-success btn-block m-t-25">返回</button>
                        </div>
	                </div>
                <#else>
                	<div class="form-actions fluid">
                        <div class="col-sm-6">
	                        <button type="button" onclick="saveForm()" class="btn btn-success btn-block m-t-25">保存</button>
	                    </div>
                        <div class="col-sm-6">
                            <button type="button" onclick="back()" class="btn btn-success btn-block m-t-25">返回</button>
                        </div>
	                </div>
                </#if>
            </form>

		</div>
	</div>
</div>


<script type="text/javascript">

	function back() {
		window.location.reload();
	}
	
	// 编号验证
    jQuery.validator.addMethod("isCode", function(value, element) {
    	if (value == '') {
    		return true;
    	}
    	
    	var _this = this;
    	var flag = false;
    	$.ajax({
            cache: true,
            type: "POST",
            url: url+"check",
            data: {code : $("input[name=code]").val()},// 你的formid
            async: false,
            dataType : "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            	layer.msg("操作失败，请重试");
            	flag = false;
            },
            success: function (data) {
                if (data.code == 200) {
                	flag = true;
                } else {
                	layer.msg(data.error);
	                flag = false;
                }
            }
        });
    	
    	return flag;
    }, "请填写正确的编号");
	
    /**
     * 提交表单
     */
    function notForm(form_id) {
        cusFunction(); // 回调一个自定义方法，比如修改提交参数。每个form表单都必须定义
        var form;
        if (validate.isEmpty(form_id)) {
            form = $('#' + form_id);
        } else {
            form = $('#gzxantForm');
        }
        
        $("button").attr("disabled", true); 

        $.ajax({
            cache: true,
            type: "POST",
            url: url+"not",
            data: form.serialize(),// 你的formid
            async: false,
            dataType : "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.alert(XMLHttpRequest.responseJSON.error);
                $("button").attr("disabled", false);
            },
            beforeSend: function () {
                start_request_load();
            }, complete: function () {
                stop_request_load();
            },
            success: function (data) {
                if (data.code == 200) {
                	back();
                } else {
                    layer.alert(data.error)
                	$("button").attr("disabled", false);
                }

            }
        });
    }
    
    function pass(form_id) {
        cusFunction(); // 回调一个自定义方法，比如修改提交参数。每个form表单都必须定义
        var form;
        if (validate.isEmpty(form_id)) {
            form = $('#' + form_id);
        } else {
            form = $('#gzxantForm');
        }
        
        $("button").attr("disabled", true); 

        $.ajax({
            cache: true,
            type: "POST",
            url: url + "pass",
            data: form.serialize(),// 你的formid
            async: false,
            dataType : "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.alert(XMLHttpRequest.responseJSON.error);
                $("button").attr("disabled", false);
            },
            beforeSend: function () {
                start_request_load();
            }, complete: function () {
                stop_request_load();
            },
            success: function (data) {
                if (data.code == 200) {
                	back();
                } else {
                    layer.alert(data.error);
                	$("button").attr("disabled", false);
                }
            }
        });
    }



	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }

    // --------------------------form表单验证-------------------------------------------------- //
    var form = $('#gzxantForm');
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
        	parentId: {
                required: true
            },
            name: {
                required: true
            },
            code : {
            	isCode : true
            }
        }
    });

</script>