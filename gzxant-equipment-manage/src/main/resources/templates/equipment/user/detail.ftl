<#--noinspection ALL-->
<style>
    .error{
        color:red;
    }
</style>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="">

                    <form class="form-horizontal form-bordered" id="gzxantForm" >
                        <input type="hidden" name="id" value="${equipmentMemberUser.id}"/>
                        <input type="hidden" name="photo" value="" id="photo"/>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">头像</label>
                            <div class="col-sm-2">
                                <div id="localImag" style="margin-left:15px;">
                                    <div class="img_box" id="imgBox">
                                        <img id="imgshowdiv" style="width: 60px"
                                             onerror="javascript:errimg()" class="img_file img-rounded"/>

                                    <#--          <div class="img_edit_box">
                                                  <a class="img_desr" href="javascript:doDeleteImg()">删除</a>
                                              </div>-->
                                    </div>
                                </div>
                            </div>
                        <#if action !='detail'>
	                    <script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
	                    <link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
	                    <div class="col-sm-4">
	                        <div id="mydropzone" class="dropzone"></div>
	                    </div>
	                    <script type="text/javascript">
		                    // --------------------------图片上传-------------------------------------------------- //
		                    Dropzone.autoDiscover = false;
						    var myDropzone = new Dropzone("div#mydropzone", {
                                url: base_url + "/file/upload/avatar",
						        filesizeBase: 1024,//定义字节算法 默认1000
						        maxFiles: 2,//最大文件数量
						        maxFilesize: 100, //MB
						        fallback: function () {
						            layer.alert('暂不支持您的浏览器上传!');
						        },
						        uploadMultiple: false,
						        addRemoveLinks: true,
						        dictFileTooBig: '您的文件超过' + 100 + 'MB!',
						        dictInvalidInputType: '不支持您上传的类型',
						        dictMaxFilesExceeded: '您的文件超过1个!',
						        init: function () {
						            this.on('queuecomplete', function (files) {
						                // layer.alert('上传成功');
						            });
						            this.on('success', function (uploadimfo, result) {
						                console.info(result);
						                $("#photo").val(result.message[0].s_url);
                                        $("#imgshowdiv").attr('src', base_url + "/file/image?path=" + encodeURIComponent(result.message[0].s_url));
						                layer.alert('上传成功');
						            });
						            this.on('error', function (a, errorMessage, result) {
						                if (!result) {
						                    layer.alert(result.error || '上传失败');
						                }
						            });
						            this.on('maxfilesreached', function () {
						                this.removeAllFiles(true);
						                layer.alert('文件数量超出限制');
						            });
						            this.on('removedfile', function () {
						                $("#photo").val("${rc.contextPath}${equipmentMemberUser.photo}");
						                $("#imgshowdiv").attr('src', "${rc.contextPath}${equipmentMemberUser.photo}");
						                layer.alert('删除成功');
						            });
						
						        }
						    });
	                    </script>
	               		</#if>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">登录名<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="loginName" placeholder="请输入登录名" value="${equipmentMemberUser.loginName}"/>
                            </div>
                        </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">登录密码：<span class="required">*</span></label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="password"
                                           value="${equipmentMemberUser.password}"  placeholder="请输入登录密码"/>
                                </div>
                            </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮箱：<span class="required">*</span></label>

                            <div class="col-sm-8">
                                <input name="email" type="email" class="form-control"
                                       placeholder="请输入电子邮箱"  value="${equipmentMemberUser.email}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">电话</label>

                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input name="phone" type="text" class="form-control" value="${equipmentMemberUser.phone}"
                                           placeholder="电话">
                                </div>
                            </div>

                            <label class="col-sm-2 control-label" >手机</label>

                            <div class="col-sm-3">
                                <input name="mobile" type="text" class="form-control" value="${equipmentMemberUser.mobile}"
                                       placeholder="手机">
                            </div>
                        </div>




                        <div class="form-group">
                            <label class="col-sm-3 control-label">状态</label>

                            <div class="col-sm-8">
                                <select name="loginFlag" class="form-control">
                                    <#if action =='update'>
                                        <#if "${equipmentMemberUser.loginFlag}"='Y'>
                                          <option value="${equipmentMemberUser.loginFlag}">启动</option>
                                        <#else>
                                          <option value="${equipmentMemberUser.loginFlag}">禁用</option>
                                        </#if>

                                        <option value="Y">启用</option>
                                        <option value="N">禁用</option>
                                    <#else>

                                        <#if "${equipmentMemberUser.loginFlag}"='Y'>
                                          <option value="${equipmentMemberUser.loginFlag}">启动</option>
                                        <#else>
                                          <option value="${equipmentMemberUser.loginFlag}">禁用</option>
                                        </#if>
                                    </#if>


                                </select>
                            </div>
                        </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注</label>

                                <div class="col-sm-8">
                                    <input name="remark" type="text" class="form-control" value=""
                                           placeholder="备注" value="${equipmentMemberUser.remark}">
                                </div>
                            </div>

                    <#if action !='detail'>
                        <div class="form-actions fluid">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" onclick="infoNextStep()" class="btn btn-success">保存</button>
                            </div>
                        </div>
                    </#if>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    //页面加载完启动
    $("#imgshowdiv").attr('src', base_url + "/file/image?path=" + encodeURIComponent("${equipmentMemberUser.photo?replace('\\', '\\\\')}"));

	action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }

    /**
     * 错误图片的默认处理
     */
    function errimg() {
        $("#photo").val("${rc.contextPath}/img/log9.png");
        $("#imgshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
    }

    /**
     * 删除头像
     */
    function doDeleteImg() {
        var name = $("#photo").val();
        layer.confirm('确定要删除头像吗？', {
            btn: ['确定', '取消']
        }, function () {
            $.ajax({
                url: url + "delete/photo",
                type: "POST",
                data: {
                    'name': name
                },
                success: function (r) {
                    if (r.code == 200) {
                        errimg();

                    } else {
                        layer.msg(r.error);
                    }
                }
            });
        })

    }

    function getPath(imgPath) {
        $("#imgshowdiv").attr('src', base_url + "/file/image?path=" + encodeURIComponent(imgPath.s_url));

      // $("#photo").val(result.message[0].s_url);
      //   var imgpaths="";
      //   imgpaths=base_url + "/file/image?path=" + encodeURIComponent(imgPath.s_url);
      //   return imgpaths;
    }
    function infoNextStep() {
        if (info_validate.form()) {
            nextStep();
        }
    }

    var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            loginName: {
                required: true
            },
            password: {
                required: true,
            },
            email: {
                required: true
            }
        },
        messages: {
            loginName:"请输入登录名",
            password: "请输入密码",
            email: "请输入邮箱"
        }
    });

</script>
