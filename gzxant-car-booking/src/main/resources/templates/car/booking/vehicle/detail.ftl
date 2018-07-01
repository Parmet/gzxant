<#if action !='detail'>
<script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet" />
</#if>		
<div class="wrapper wrapper-content animated fadeInRight">
		<input type="hidden" name="id" value="${vehicle.id}" />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">基础信息</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="number_input" class="control-label">车辆编号<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="number_input" name="number" value="${vehicle.number}" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="brands_input" class="control-label">车辆品牌<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="brands_input" name="brands" value="${vehicle.brands}" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="licensePlate_input" class="control-label">车辆号码<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="licensePlate_input" name="licensePlate" value="${vehicle.licensePlate}" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="city_input" class="control-label">服务城市<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="city_input" name="city" value="${vehicle.city}" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="color_input" class="control-label">车辆颜色<span
							class="required">*</span></label> <input type="text"
							class="form-filter form-control" id="color_input" name="color" value="${vehicle.color}" />
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						<label for="type_input" class="control-label">车辆类型</label> <input
							type="text" class="form-filter form-control datepicker"
							id="type_input" name="type" value="${vehicle.type}" />
					</div>
				</div>
				<div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                        <label for="produceDate_input" class="control-label">车辆出厂日期</label> <input
                            type="text" class="form-filter form-control datepicker"
                            id="produceDate_input" name="produceDate" value="${vehicle.produceDate}" />
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                        <label for="vehicleCount_input" class="control-label">座位数</label> <input
                            type="text" class="form-filter form-control datepicker"
                            id="vehicleCount_input" name="vehicleCount" value="${vehicle.vehicleCount}" />
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                        <label for="luggageCount_input" class="control-label">行李数</label> <input
                            type="text" class="form-filter form-control datepicker"
                            id="luggageCount_input" name="luggageCount" value="${vehicle.luggageCount}" />
                    </div>
				</div>
				<div class="row">
					
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">证件信息</h3>
			</div>
			<div class="panel-body">
				<div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
						<#if action == 'detail'>
						<div id="localImag" style="margin-left: 15px;">
							<div class="img_box" id="imgBox">
								<img id="vehiclePhotoShowDiv" style="width: 60px" src="${vehicle.vehiclePhoto}"
									onerror="javascript:errimg(this)" class="img_file img-rounded" />
							</div>
						</div>
						<#else>
						<div id="vehiclePhotoDropzone" class="dropzone"></div>
						<input type="hidden" id="vehiclePhoto" name="vehiclePhoto" value="${vehicle.vehiclePhoto}" /> 
						<script type="text/javascript">
							// --------------------------图片上传-------------------------------------------------- //
							Dropzone.autoDiscover = false;
							var licenseDropzone = new Dropzone("div#vehiclePhotoDropzone", {
								url : "/file/upload/CarBookingVehiclePhoto",
								filesizeBase : 1024,//定义字节算法 默认1000
								maxFiles : 2,//最大文件数量
								maxFilesize : 100, //MB
								fallback : function() {
									layer.alert('暂不支持您的浏览器上传!');
								},
								uploadMultiple : false,
								addRemoveLinks : true,
								dictDefaultMessage : '点击上传车辆照片',
								dictFileTooBig : '您的文件超过' + 100 + 'MB!',
								dictInvalidInputType : '不支持您上传的类型',
								dictMaxFilesExceeded : '您的文件超过1个!',
								init : function() {
									this.on('queuecomplete', function(files) {
										// layer.alert('上传成功');
									});
									
									this.on('success', function(uploadimfo, result) {
										console.info(result);
										$("#vehiclePhoto").val(result.message[0].s_url);
										$("#vehiclePhotoShowDiv").attr('src', result.message[0].s_url);
										layer.alert('上传成功');
									});
									
									this.on('error', function(a, errorMessage, result) {
										if (!result) {
											layer.alert(result.error || '上传失败');
										}
									});
									
									this.on('maxfilesreached', function() {
										this.removeAllFiles(true);
										layer.alert('文件数量超出限制');
									});
									
									this.on('removedfile', function() {
										$("#vehiclePhoto").val("${vehicle.vehiclePhoto}");
										$("#vehiclePhotoShowDiv").attr('src', "${vehicle.vehiclePhoto}");
										layer.alert('删除成功');
									});
	
								}
							});
						</script>
						</#if>
                    </div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                        <label for="owner_input" class="control-label">车辆所属人</label> 
                        <input type="text" class="form-filter form-control datepicker"
                            id="owner_input" name="owner" value="${vehicle.owner}" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
						<#if action == 'detail'>
						<div id="localImag" style="margin-left: 15px;">
							<div class="img_box" id="imgBox">
								<img id="operationsPhotoShowDiv" style="width: 60px" src="${vehicle.operationsPhoto}"
									onerror="javascript:errimg(this)" class="img_file img-rounded" />
							</div>
						</div>
						<#else>
						<div id="operationsPhotoDropzone" class="dropzone"></div>
						<input type="hidden" id="operationsPhoto" name="operationsPhoto" value="${vehicle.operationsPhoto}" /> 
						<script type="text/javascript">
							// --------------------------图片上传-------------------------------------------------- //
							Dropzone.autoDiscover = false;
							var licenseDropzone = new Dropzone("div#operationsPhotoDropzone", {
								url : "/file/upload/CarBookingOperationsPhoto",
								filesizeBase : 1024,//定义字节算法 默认1000
								maxFiles : 2,//最大文件数量
								maxFilesize : 100, //MB
								fallback : function() {
									layer.alert('暂不支持您的浏览器上传!');
								},
								uploadMultiple : false,
								addRemoveLinks : true,
								dictDefaultMessage : '点击上传运营证照片',
								dictFileTooBig : '您的文件超过' + 100 + 'MB!',
								dictInvalidInputType : '不支持您上传的类型',
								dictMaxFilesExceeded : '您的文件超过1个!',
								init : function() {
									this.on('queuecomplete', function(files) {
										// layer.alert('上传成功');
									});
									
									this.on('success', function(uploadimfo, result) {
										console.info(result);
										$("#operationsPhoto").val(result.message[0].s_url);
										$("#operationsPhotoShowDiv").attr('src', result.message[0].s_url);
										layer.alert('上传成功');
									});
									
									this.on('error', function(a, errorMessage, result) {
										if (!result) {
											layer.alert(result.error || '上传失败');
										}
									});
									
									this.on('maxfilesreached', function() {
										this.removeAllFiles(true);
										layer.alert('文件数量超出限制');
									});
									
									this.on('removedfile', function() {
										$("#operationsPhoto").val("${vehicle.operationsPhoto}");
										$("#operationsPhotoShowDiv").attr('src', "${vehicle.operationsPhoto}");
										layer.alert('删除成功');
									});
	
								}
							});
						</script>
						</#if>
                    </div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                        <label for="operationsEndDate_input" class="control-label">营运证有效期</label> 
                        <input type="text" class="form-filter form-control datepicker"
                            id="operationsEndDate_input" name="operationsEndDate" value="${vehicle.operationsEndDate}" />
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
						<#if action == 'detail'>
						<div id="localImag" style="margin-left: 15px;">
							<div class="img_box" id="imgBox">
								<img id="licenseShowDiv" style="width: 60px" src="${vehicle.license}"
									onerror="javascript:errimg(this)" class="img_file img-rounded" />
							</div>
						</div>
						<#else>
						<div id="licenseDropzone" class="dropzone"></div>
						<input type="hidden" id="license" name="license" value="${vehicle.license}" /> 
						<script type="text/javascript">
							// --------------------------图片上传-------------------------------------------------- //
							Dropzone.autoDiscover = false;
							var licenseDropzone = new Dropzone("div#licenseDropzone", {
								url : "/file/upload/CarBookingLicense",
								filesizeBase : 1024,//定义字节算法 默认1000
								maxFiles : 2,//最大文件数量
								maxFilesize : 100, //MB
								fallback : function() {
									layer.alert('暂不支持您的浏览器上传!');
								},
								uploadMultiple : false,
								addRemoveLinks : true,
								dictDefaultMessage : '点击上传行驶证照片',
								dictFileTooBig : '您的文件超过' + 100 + 'MB!',
								dictInvalidInputType : '不支持您上传的类型',
								dictMaxFilesExceeded : '您的文件超过1个!',
								init : function() {
									this.on('queuecomplete', function(files) {
										// layer.alert('上传成功');
									});
									
									this.on('success', function(uploadimfo, result) {
										console.info(result);
										$("#license").val(result.message[0].s_url);
										$("#licenseShowDiv").attr('src', result.message[0].s_url);
										layer.alert('上传成功');
									});
									
									this.on('error', function(a, errorMessage, result) {
										if (!result) {
											layer.alert(result.error || '上传失败');
										}
									});
									
									this.on('maxfilesreached', function() {
										this.removeAllFiles(true);
										layer.alert('文件数量超出限制');
									});
									
									this.on('removedfile', function() {
										$("#license").val("${vehicle.license}");
										$("#licenseShowDiv").attr('src', "${vehicle.license}");
										layer.alert('删除成功');
									});
	
								}
							});
						</script>
						</#if>
                    </div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                        <label for="licenseEndDate_input" class="control-label">行驶证截至日期</label> 
                        <input type="text" class="form-filter form-control datepicker"
                            id="licenseEndDate_input" name="licenseEndDate" value="${vehicle.licenseEndDate}" />
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
						<#if action == 'detail'>
						<div id="localImag" style="margin-left: 15px;">
							<div class="img_box" id="imgBox">
								<img id="chackPhotoShowDiv" style="width: 60px" src="${vehicle.chackPhoto}"
									onerror="javascript:errimg(this)" class="img_file img-rounded" />
							</div>
						</div>
						<#else>
						<div id="chackPhotoDropzone" class="dropzone"></div>
						<input type="hidden" id="chackPhoto" name="chackPhoto" value="${vehicle.chackPhoto}" /> 
						<script type="text/javascript">
							// --------------------------图片上传-------------------------------------------------- //
							Dropzone.autoDiscover = false;
							var licenseDropzone = new Dropzone("div#chackPhotoDropzone", {
								url : "/file/upload/CarBookingChackPhoto",
								filesizeBase : 1024,//定义字节算法 默认1000
								maxFiles : 2,//最大文件数量
								maxFilesize : 100, //MB
								fallback : function() {
									layer.alert('暂不支持您的浏览器上传!');
								},
								uploadMultiple : false,
								addRemoveLinks : true,
								dictDefaultMessage : '点击上传年检证照片',
								dictFileTooBig : '您的文件超过' + 100 + 'MB!',
								dictInvalidInputType : '不支持您上传的类型',
								dictMaxFilesExceeded : '您的文件超过1个!',
								init : function() {
									this.on('queuecomplete', function(files) {
										// layer.alert('上传成功');
									});
									
									this.on('success', function(uploadimfo, result) {
										console.info(result);
										$("#chackPhoto").val(result.message[0].s_url);
										$("#chackPhotoShowDiv").attr('src', result.message[0].s_url);
										layer.alert('上传成功');
									});
									
									this.on('error', function(a, errorMessage, result) {
										if (!result) {
											layer.alert(result.error || '上传失败');
										}
									});
									
									this.on('maxfilesreached', function() {
										this.removeAllFiles(true);
										layer.alert('文件数量超出限制');
									});
									
									this.on('removedfile', function() {
										$("#chackPhoto").val("${vehicle.chackPhoto}");
										$("#chackPhotoShowDiv").attr('src', "${vehicle.chackPhoto}");
										layer.alert('删除成功');
									});
	
								}
							});
						</script>
						</#if>
                    </div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                        <label for="chackEndDate_input" class="control-label">车辆年检证截至日期</label> 
                        <input type="text" class="form-filter form-control datepicker"
                            id="chackEndDate_input" name="chackEndDate" value="${vehicle.chackEndDate}" />
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
						<#if action == 'detail'>
						<div id="localImag" style="margin-left: 15px;">
							<div class="img_box" id="imgBox">
								<img id="insurancePhotoShowDiv" style="width: 60px" src="${vehicle.insurancePhoto}"
									onerror="javascript:errimg(this)" class="img_file img-rounded" />
							</div>
						</div>
						<#else>
						<div id="insurancePhotoDropzone" class="dropzone"></div>
						<input type="hidden" id="insurancePhoto" name="insurancePhoto" value="${vehicle.insurancePhoto}" /> 
						<script type="text/javascript">
							// --------------------------图片上传-------------------------------------------------- //
							Dropzone.autoDiscover = false;
							var licenseDropzone = new Dropzone("div#insurancePhotoDropzone", {
								url : "/file/upload/CarBookingiInsurancePhoto",
								filesizeBase : 1024,//定义字节算法 默认1000
								maxFiles : 2,//最大文件数量
								maxFilesize : 100, //MB
								fallback : function() {
									layer.alert('暂不支持您的浏览器上传!');
								},
								uploadMultiple : false,
								addRemoveLinks : true,
								dictDefaultMessage : '点击上传保险证明照片',
								dictFileTooBig : '您的文件超过' + 100 + 'MB!',
								dictInvalidInputType : '不支持您上传的类型',
								dictMaxFilesExceeded : '您的文件超过1个!',
								init : function() {
									this.on('queuecomplete', function(files) {
										// layer.alert('上传成功');
									});
									
									this.on('success', function(uploadimfo, result) {
										console.info(result);
										$("#insurancePhoto").val(result.message[0].s_url);
										$("#insurancePhotoShowDiv").attr('src', result.message[0].s_url);
										layer.alert('上传成功');
									});
									
									this.on('error', function(a, errorMessage, result) {
										if (!result) {
											layer.alert(result.error || '上传失败');
										}
									});
									
									this.on('maxfilesreached', function() {
										this.removeAllFiles(true);
										layer.alert('文件数量超出限制');
									});
									
									this.on('removedfile', function() {
										$("#insurancePhoto").val("${vehicle.insurancePhoto}");
										$("#insurancePhotoShowDiv").attr('src', "${vehicle.insurancePhoto}");
										layer.alert('删除成功');
									});
	
								}
							});
						</script>
						</#if>
                    </div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                        <label for="insuranceEndDate_input" class="control-label">车辆保险证明截至日期</label> 
                        <input type="text" class="form-filter form-control datepicker"
                            id="insuranceEndDate_input" name="insuranceEndDate" value="${vehicle.insuranceEndDate}" />
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