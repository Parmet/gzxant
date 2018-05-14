<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">
                <input type="hidden" name="id" value="${portalsMessage.id}" />

                <div class="form-group">
                    <label class="col-sm-3 control-label">姓名<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="name" placeholder="请输入姓名"
                               value="${portalsMessage.name}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">电话<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="phone" placeholder="请输入电话"
                               value="${portalsMessage.phone}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">邮箱<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="email" placeholder="请输入邮箱"
                               value="${portalsMessage.email}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">留言内容<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="messageContent" placeholder="请输入留言内容"
                               value="${portalsMessage.messageContent}" required aria-required="true"/>
                    </div>
                </div>


            	<#if action != 'detail'>
                <div class="form-actions fluid">
                    <div class="col-sm-12">
                        <button type="button" onclick="saveForm()" class="btn btn-success btn-block m-t-25">保存</button>
                    </div>
                </div>
            	</#if>
            </form>

		</div>
        <table class="table" id="exampleTable" data-mobile-responsive="true">
        </table>
	</div>
</div>


<script type="text/javascript">
	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }

  	// --------------------------错误图片的默认处理-------------------------------------------------- //
    function errimg() {
        $("#photo").val("${rc.contextPath}/img/log9.png");
        $("#imgshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
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