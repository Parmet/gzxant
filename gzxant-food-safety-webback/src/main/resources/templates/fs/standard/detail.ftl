<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">
                <input type="hidden" name="id" value="${fsInformation.id}"/>

                <#--<div class="form-group">-->
                    <#--<label class="col-sm-3 control-label">创建时间<span class="required">*</span></label>-->
                    <#--<div class="col-sm-3">-->
                        <#--<input type="text" class="form-control" name="createDate" placeholder="请输入创建时间"-->
                               <#--value="${fsInformation.createDate}" required aria-required="true"/>-->
                    <#--</div>-->
                <#--</div>-->

                <div class="form-group">
                    <label class="col-sm-3 control-label">标题<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="title" placeholder="请输入标题"
                               value="${fsInformation.title}" required aria-required="true"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">作者<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="author" placeholder="请输入作者"
                               value="${fsInformation.author}" required aria-required="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">类型<span class="required">*</span></label>
                    <div class="col-sm-6">
                        <select class="select2" name="parentId" required aria-required="true">
					    <#if categoryTree>
					    <#list categoryTree as r>
					    <option value="${r.id}" <#if (r.id == category.parentId)>selected</#if>>${r.name}</option>
                        </#list>
                        <#else>
					    <option value="0" selected>类型</option>
                        </#if>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">文章<span class="required">*</span></label>
                    <div class="col-sm-3">
                    <#--<input type="text" class="form-control" name="name" placeholder="请输入作者"-->
                    <#--value="${category.name}" required aria-required="true"/>-->
                        <textarea rows="10" cols=65" name="content" id="fs_content">${fsInformation.content}</textarea>
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
    </div>
</div>


<script type="text/javascript">
    action = "${action}";
    //$('#fs_content').val(${fsInformation.content});
   // this.txtArea.InnerHtml = "${fsInformation.content};
  // document.getElementById("#fs_content").value=${fsInformation.content};
    function cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }
   // var createDate=new Date().format{fsInformation.createDate}
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
    load_data( null, {});
</script>