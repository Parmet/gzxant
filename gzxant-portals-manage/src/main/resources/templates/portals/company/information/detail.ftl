<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">
            	<input type="hidden" name="id" value="${portalsCompanyInformation.id}" />
                <#if portalsCompanyInformation.logo == null>
            	<input type="hidden" name="logo" value="/img/log9.png" />
                </#if>

                <#if portalsCompanyInformation.shuffling == null>
            	<input type="hidden" name="shuffling" value="/img/log9.png" />
                </#if>

                <div class="form-group">
                    <label class="col-sm-3 control-label">公司名称<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="name" placeholder="请输入公司名称"
                               value="${portalsCompanyInformation.name}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">公司官网logo</label>
                    <div class="col-sm-3">
                        <div id="localImag" style="margin-left:15px;">
                            <div class="img_box" id="imgBox">
                                <img id="imgshowdiv" style="width: 60px" src="${rc.contextPath}${portalsCompanyInformation.logo}"
                                     onerror="javascript:errimg()"  class="img_file img-rounded"/>
                            </div>
                        </div>
                    </div>
                <#if action !='detail'>
                    <script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
                    <link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
                    <div class="col-sm-4">
                        <div id="logoDropzone" class="dropzone"></div>
                    </div>
                    <script type="text/javascript">
                        // --------------------------图片上传-------------------------------------------------- //
                        Dropzone.autoDiscover = false;
                        var logoDropzone = new Dropzone("div#logoDropzone", {
                            url: "/file/upload/logo",
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
                                    $("#imgshowdiv").attr('src', result.message[0].s_url);
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
                                    $("#photo").val("${portalsCompanyInformation.logo}");
                                    $("#imgshowdiv").attr('src', "${portalsCompanyInformation.logo}");
                                    layer.alert('删除成功');
                                });

                            }
                        });
                    </script>
                </#if>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">公司官网轮播图</label>
                    <div class="col-sm-3">
                        <div id="localImag" style="margin-left:15px;">
                            <div class="img_box" id="imgBox">
                                <img id="imgshowdiv" style="width: 60px" src="${rc.contextPath}${portalsCompanyInformation.shuffling}"
                                     onerror="javascript:shufflingErrimg()"  class="img_file img-rounded"/>
                            </div>
                        </div>
                    </div>
                <#if action !='detail'>
                    <script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
                    <link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
                    <div class="col-sm-4">
                        <div id="shufflingDropzone" class="dropzone"></div>
                    </div>
                    <script type="text/javascript">
                        // --------------------------图片上传-------------------------------------------------- //
                        Dropzone.autoDiscover = false;
                        var shufflingDropzone = new Dropzone("div#shufflingDropzone", {
                            url: "/file/upload/shuffling",
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
                                    $("#photoShuffling").val(result.message[0].s_url);
                                    $("#imgshowdivShuffling").attr('src', result.message[0].s_url);
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
                                    $("#photoShuffling").val("${portalsCompanyInformation.shuffling}");
                                    $("#imgshowdivShuffling").attr('src', "${portalsCompanyInformation.shuffling}");
                                    layer.alert('删除成功');
                                });

                            }
                        });
                    </script>
                </#if>
                </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">公司地理位置<span class="required">*</span></label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="address" placeholder="请输入公司地理位置"
                                   value="${portalsCompanyInformation.address}" required aria-required="true"/>
                        </div>
                    </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">公司座右铭标题<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="portalsMotto" placeholder="请输入公司座右铭标题"
                               value="${portalsCompanyInformation.portalsMotto}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">公司座右铭内容<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="mottoContent" placeholder="请输入公司座右铭内容"
                               value="${portalsCompanyInformation.mottoContent}" required aria-required="true"/>
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