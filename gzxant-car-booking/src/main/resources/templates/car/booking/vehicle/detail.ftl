<div class="wrapper wrapper-content animated fadeInRight">
		<input type="hidden" name="id" value="${driver.id}" />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">基础信息</h3>
			</div>
			<div class="panel-body">

				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="number_input" class="control-label">车辆编号<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="number_input" name="number" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="brands_input" class="control-label">车辆品牌<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="name_input" name="name" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="licensePlate_input" class="control-label">车辆号码<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="city_input" name="city" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="city_input" class="control-label">服务城市<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="phone_input" name="phone" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="color_input" class="control-label">车辆颜色<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="idCard_input" name="idCard" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="type_input" class="control-label">车辆类型</label> <input
							type="text" class="form-filter form-control datepicker"
							id="birthday_input" name="birthday" />
					</div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                        <label for="type_input" class="control-label">车辆出厂日期</label> <input
                            type="text" class="form-filter form-control datepicker"
                            id="birthday_input" name="birthday" />
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                        <label for="type_input" class="control-label">座位数</label> <input
                            type="text" class="form-filter form-control datepicker"
                            id="birthday_input" name="birthday" />
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                        <label for="type_input" class="control-label">行李数</label> <input
                            type="text" class="form-filter form-control datepicker"
                            id="birthday_input" name="birthday" />
                    </div>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">证件信息</h3>
			</div>
			<div class="panel-body">

				</div>
				<div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group" hidden="hidden">
                        <label for="receive_date_input" class="control-label"><span
                                class="required">*</span></label> <input type="text"
                                 class="form-filter form-control datepicker"
								 id="receive_date_input" name="licenseReceiveDate" />
                    </div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group" hidden="hidden">
						<label for="start_date_input" class="control-label"><span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control datepicker" id="start_date_input"
							name="licenseStartDate" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group" hidden="hidden">
						<label for="end_date_input" class="control-label"><span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control datepicker" id="end_date_input"
							name="licenseEndDate" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 form-group">
                        <label for="start_date_input" class="control-label">驾驶证有效期起始日期<span
                                class="required">*</span></label> <input type="text"
                                                                         class="form-filter form-control datepicker" id="start_date_input"
                                                                         name="licenseStartDate" />
						</div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
						<#if action !='detail'>
                            <script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
                            <link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet" />
						<div id="licenseDropzone" class="dropzone"></div>
						<input type="hidden" id="licensePhoto" name="licensePhoto"
							value="${driver.licensePhoto}" />
						<script type="text/javascript">
		              // --------------------------图片上传-------------------------------------------------- //
		              Dropzone.autoDiscover = false;
		              var licenseDropzone = new Dropzone("div#licenseDropzone", {
		                  url: "/file/upload/DriverLicense",
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
		                          $("#licensePhoto").val(result.message[0].s_url);
		                          $("#licenseshowdiv").attr('src', result.message[0].s_url);
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
		                          $("#licensePhoto").val("${category.licensePhoto}");
		                          $("#licenseshowdiv").attr('src', "${category.licensePhoto}");
		                          layer.alert('删除成功');
		                      });
		
		                  }
		              });
		             </script>
		             </#if>
					</div>
				</div>
			</div>
		</div>

		<#if action !='detail'>
		<div class="form-actions fluid" style="margin-bottom: 20px;">
			<div class="col-sm-12">
				<button type="button" onclick="saveForm()"
					class="btn btn-success btn-block m-t-25">保存</button>
			</div>
		</div>
		</#if>
	</form>
</div>

<script src="${rc.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script type="text/javascript">
	$('.datepicker').datepicker ({ 
	    startDate : '-3d' 
	});

	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }

  	// --------------------------错误图片的默认处理-------------------------------------------------- //
    function errimg() {
    	//$("#avatar").val("${rc.contextPath}/img/log9.png");
        //$("#avatarshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
        //$("#licensePhoto").val("${rc.contextPath}/img/log9.png");
        //$("#licenseshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
    }

    // --------------------------form表单验证-------------------------------------------------- //
    var form = $('#gzxantForm');
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
        	number: {
                required: true,
            },
            name: {
                required: true
            },
            city: {
                required: true
            },
            name: {
                required: true
            },
            phone: {
                required: true
            },
            idCard: {
                required: true
            },
            license: {
                required: true
            },
            licenseReceiveDate: {
                required: true
            },
            licenseStartDate: {
                required: true
            },
            licenseEndDate: {
                required: true
            },
            licensePhoto: {
                required: true
            }
        }
    });

</script>