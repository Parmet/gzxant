<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">
            	<input type="hidden" name="id" value="${qualification.id}" />
                <div class="form-group">
                    <label class="col-sm-3 control-label">姓名<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="name" placeholder="请输入姓名"
                               value="${qualification.name}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">电话<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="phone" placeholder="请输入电话"
                               value="${qualification.phone}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">企业<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="enterprise" placeholder="请输入企业"
                               value="${qualification.enterprise}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">身份证号码<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="card" placeholder="请输入身份证号码"
                               value="${qualification.card}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">邮箱<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="email" placeholder="请输入邮箱"
                               value="${qualification.email}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">目前经营的品牌或代理<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="brandAgent" placeholder="请输入目前经营的品牌或代理"
                               value="${qualification.brandAgent}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">省份<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="provinces" placeholder="请输入省份"
                               value="${qualification.provinces}" required aria-required="true"/>
                    </div>
                </div>

                <#if qualification.state == null>
                <div class="form-actions fluid">
                    <div class="col-sm-5">
                        <button type="button" onclick="saveForm()" class="btn btn-success btn-block m-t-25">通过</button>
                    </div>
                </div>

                    <div class="form-actions fluid">
                        <div class="col-sm-5">
                            <button type="button" onclick="notForm()" class="btn btn-success btn-block m-t-25">不通过</button>
                        </div>
                    </div>
                <#else>
                <div class="form-actions fluid">
                        <div class="col-sm-5">
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

        $.ajax({
            cache: true,
            type: "POST",
            url: url+"not",
            data: form.serialize(),// 你的formid
            async: false,
            dataType : "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                parent.layer.alert(XMLHttpRequest.responseJSON.error);
            },
            beforeSend: function () {
                start_request_load();
            }, complete: function () {
                stop_request_load();
            },
            success: function (data) {
                if (data.code == 200) {
                    parent.re_load();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);
                    parent.layer.msg("操作成功");
                } else {
                    parent.layer.alert(data.error)
                }

            }
        });
    }



	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }

  	// --------------------------错误图片的默认处理-------------------------------------------------- //
    function errimg() {
        $("#photo").val("${rc.contextPath}/img/log9.png");
        $("#imgshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
    }
    function shufflingErrimg() {
        $("#photoShuffling").val("${rc.contextPath}/img/log9.png");
        $("#imgshowdivShuffling").attr('src', "${rc.contextPath}/img/log9.png");
    }
    function customerLogoErrimg() {
        $("#photoCustomerLogo").val("${rc.contextPath}/img/log9.png");
        $("#imgshowdivCustomerLogo").attr('src', "${rc.contextPath}/img/log9.png");
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
                required: true,
            },
            name: {
                required: true
            }
        }
    });

</script>