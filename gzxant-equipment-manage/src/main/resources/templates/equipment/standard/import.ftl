<style>
#dict_edit_table .control-label {
	text-align: left !important;
}

#dict_edit_table input, #dict_edit_table select {
	margin-left: -45px;
}

#dict_edit_table .row {
	margin-top: 15px !important;
}
</style>
<script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet" />
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			<!-- Nav tabs -->
			<ul id="standardTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active">
					<a href="#import" aria-controls="import" role="tab" data-toggle="tab">导入标准</a>
				</li>
				<li role="presentation">
					<a href="#info" aria-controls="info" role="tab" data-toggle="tab">基本信息</a>
				</li>
				<li role="presentation">
					<a href="#content" aria-controls="content" role="tab" data-toggle="tab">耗材设备</a>
				</li>
			</ul>
		
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="import">
					<div class="panel panel-default">
		  				<div class="panel-body">
		  					<div class="row">
		  						<div class="col-lg-4 col-md-4 col-sm-3 col-xs-12">
		  						</div>
			  					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 form-group">
									<div id="pdfDropzone" class="dropzone"></div>
									<input type="hidden" id="uploadUrl" name="uploadUrl" value="${vehicle.uploadUrl}" /> 
									
								</div>
								<div class="col-lg-4 col-md-4 col-sm-3 col-xs-12">
		  						</div>
							</div>
							<div class="row">
			  					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="progress" style="margin-top:10px;">
										<div class="progress-bar progress-bar-success progress-bar-striped active" 
											id="importProgress"
											role="progressbar" aria-valuenow="0" 
											aria-valuemin="0" aria-valuemax="100" 
											style="min-width: 2em;">0%</div>
									</div>
								</div>
							</div>
							<div class="row" style="margin-top:20px;">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<p><b>操作说明：</b></p>
									<ol>
										<li>数据导入必须按照国家发布的标准模板里面的格式；</li>
										<li>必须使用指定的浏览器。</li>
									</ol>
		  						</div>
		  					</div>
						</div>
						<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="nextStep()" class="btn btn-success pull-right">下一步</button>
		  						</div>
		  					</div>
						</div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="info">
					<div class="panel panel-default">
		  				<div class="panel-body">
		  					<div class = "row">
		  						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
		  							<label for="name_input" class="control-label">标准名称<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="name_input" name="name" />
		  						</div>
		  						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
		  							<label for="number_input" class="control-label">国家编号<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="number_input" name="number" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
		  							<label for="first_category_input" class="control-label">一级标准分类<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="first_category_input" name="firstCategory" />
		  						</div>
		  						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
		  							<label for="second_category_input" class="control-label">二级标准分类<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="second_category_input" name="secondCategory" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
		  							<label for="old_stand_input" class="control-label">原标准编号<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="old_stand_input" name="oldStand" />
		  						</div>
		  					</div>
		  				</div>
		  				<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="nextStep()" class="btn btn-success pull-right" style="margin-left: 10px;">下一步</button>
									<button type="button" onclick="lastStep()" class="btn btn-success pull-right">上一步</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="content">
					<div class="panel panel-default">
		  				<div class="panel-body">
		  				</div>
		  				<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="" class="btn btn-success pull-right" style="margin-left: 10px;">保存</button>
									<button type="button" onclick="lastStep()" class="btn btn-success pull-right">上一步</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
			</div>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
			<div class="panel panel-default">
				<div class="panel-heading" id="pdf_name">GB 1886.3-2016 食品安全国家标准 食品添加剂 磷酸氢钙</div>
 				<div class="panel-body">
 					<img src="" />
 				</div>
 			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var tab_num = 0;
    function nextStep() {
    	tab_num = tab_num + 1;
    	changeTab(tab_num);
    }
    
    function lastStep() {
    	tab_num = tab_num - 1;
    	changeTab(tab_num);
    }
    
    function changeTab(num) {
    	$('#standardTab li:eq(' + tab_num + ') a').tab('show');
    }
    
    function back() {
    	layer.confirm('您有未保存数据，是否继续返回', {
    		yes: function(index, layero){
    			window.location.href = url.split("import")[0];
    		}
    	});
    }
    
    var t;
    function progress(num) {
    	if (num < 0 || num > 100) {
    		return ;
    	}
    	
    	$("#importProgress").css("width", num + "%");
    	$("#importProgress").html("");
    	$("#importProgress").html(num + "%");
    	t = setTimeout(progress(num + 1), 1000);
    }
    
	// --------------------------图片上传-------------------------------------------------- //
	Dropzone.autoDiscover = false;
	var licenseDropzone = new Dropzone("div#pdfDropzone", {
		url : base_url + "/file/upload/pdf",
		filesizeBase : 1024,//定义字节算法 默认1000
		maxFiles : 2,//最大文件数量
		maxFilesize : 100, //MB
		fallback : function() {
			layer.alert('暂不支持您的浏览器上传!');
		},
		uploadMultiple : false,
		addRemoveLinks : true,
		acceptedFiles: "application/pdf",
		dictDefaultMessage : '点击上传标准',
		dictFileTooBig : '您的文件超过' + 100 + 'MB!',
		dictInvalidInputType : '不支持您上传的类型',
		dictMaxFilesExceeded : '您的文件超过1个!',
		init : function() {
			this.on('queuecomplete', function(files) {
				// layer.alert('上传成功');
			});
			
			this.on('success', function(uploadimfo, result) {
				console.info(result);
				$("#uploadUrl").val(result.message[0].url);
				progress(0);
				$.post(url, {
					pdfUrl : result.message[0].url
				}, function () {
					
				});
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
				$("#uploadUrl").val("${standard.uploadUrl}");
				layer.alert('删除成功');
			});
	
		}
	});
</script>

