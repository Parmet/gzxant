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

.txt_box {
	height:500px; 
	overflow-y: scroll;
}

.card {
	padding-top: 10px;
	margin-top: 20px;
	width: 95%;
	background-color: #1c84c6;
	float: left;
	border-radius: 10px;
	margin-left: 10px; 
	text-align: center;
	color: black;
}

.card .span_tip {
	line-height: 80px;
}

.card span {
	color: white;
}

.pdf_box {
	height:500px; 
	overflow-y: scroll;
}

.pdf_box img {
	background-size:contain|cover;
	width:100%;
	height: auto;
}

.box_shadow {
	box-shadow: 5px 5px 5px;
}

.a_del {
	color:red;
	margin-left:10px;
	margin-right:10px;
}

.a_del span {
	color:red;
}

.a_add {
	color: white;
	margin-left:10px;
}

.btn_inline {
	width: 60%; 
	display: inline;
}
</style>
<script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet" />
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
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
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
		  						</div>
			  					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 form-group">
									<div id="pdfDropzone" class="dropzone"></div>
									<input type="hidden" id="uploadUrl" name="uploadUrl" value="${vehicle.uploadUrl}" /> 
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
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
										<li>必须使用指定的浏览器，chrome（谷歌）、火狐、IE9+。</li>
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
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="name_input" class="control-label">标准名称<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="name_input" name="name" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="number_input" class="control-label">国家编号<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="number_input" name="number" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="first_category_input" class="control-label">一级标准分类<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="first_category_input" name="firstCategory" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="second_category_input" class="control-label">二级标准分类<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="second_category_input" name="secondCategory" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="old_stand_input" class="control-label">原标准编号<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="old_stand_input" name="oldStand" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="publish_date_input" class="control-label">发布时间<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="publish_date_input" name="publishDate" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="implement_date_input" class="control-label">实施时间<span class="required">*</span></label>
		                            <input type="text" class="form-filter form-control" id="implement_date_input" name="implementDate" />
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
						<div id="item-box" class="panel-body" style="height:500px;overflow: scroll;">
							<div class="panel panel-success">
								<div class="panel-heading form-group">
									<input type="text" class="form-control btn_inline" style="color:black;" placeholder="请选择输入检验项" />
									<a class="pull-right a_del" onclick="removeItem(this)"><span class="glyphicon glyphicon-remove"></span></a>
									<a class="pull-right a_add" onclick="addItem()"><span class="glyphicon glyphicon-plus"></span></a>
									<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div class="panel-body form-group">
									<div class="card box_shadow" data-type="耗材" onclick="itemClick(this);">
										<span class="glyphicon glyphicon-plus span_tip"></span><span class="span_tip">耗材</span>
									</div>
									<div class="card box_shadow" data-type="设备" onclick="itemClick(this);">
										<span class="glyphicon glyphicon-plus span_tip"></span><span class="span_tip">设备</span>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="saveStandard()" class="btn btn-success pull-right" style="margin-left: 10px;">保存</button>
									<button type="button" onclick="lastStep()" class="btn btn-success pull-right">上一步</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
			</div>
		</div>
		
		<div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
			<ul id="PDFTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active">
					<a href="#txt" aria-controls="txt" role="tab" data-toggle="tab">解析结果</a>
				</li>
				<li role="presentation">
					<a href="#pdf" aria-controls="pdf" role="tab" data-toggle="tab">PDF源文件</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="txt">
					<div class="panel panel-default">
			  			<div class="panel-body">
				  			<div id="txt_box" class="txt_box">
				  				<span>请上传PDF文件</span>
				  			</div>
						</div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="pdf">
					<div class="panel panel-default">
			  			<div class="panel-body">
			  				<div id="pdf_box" class="pdf_box">
				  				<span>请上传PDF文件</span>
				  			</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var txt_url, upload_date;
	function saveStandard() {
		var data = {
			info: getInfo(),
			item: getItems()
		};
		
		console.log(data);
		$.ajax({
		    type: 'POST',
		    dataType:'json',
		    url: base_url + "/back/standard/create",
		    async: true,
		    data: data,
		    success: function (data) {
		    	layer.msg("保存成功");
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
	            layer.alert(XMLHttpRequest.responseJSON.error);
	        }
		});
	}
	
	function getInfo() {
		var info = {
			name: $('[name=name]').val(),
			firstCategory: $('[name=firstCategory]').val(),
			secondCategory: $('[name=secondCategory]').val(),
			number: $('[name=number]').val(),
			oldStand: $('[name=oldStand]').val(),
			pdfUrl: $("#uploadUrl").val(),
			txtUrl: txt_url,
			publishDate: $('[name=publishDate]').val(),
			uploadDate: upload_date,
			implementDate: $('[name=implementDate]').val()
		}
		
		return info;
	}
	
	function getItems() {
		var items = [];
		var item_divs = $("#item-box").children();
		item_divs.each(function(index, item_div) {
			items.push({
				name: getItemName(item_div),
				sub: getItemSub(item_div)
			});
		});
		
		return items;
	}

	function getItemName(item_div) {
		return $(item_div).find(".panel-heading").find("input").val();
	}
	
	function getItemSub(item_div) {
		var subs = [];
		var materials = $(item_div).find(".panel-body").children("div[data-type='耗材']").find('input');
		var equipments = $(item_div).find(".panel-body").children("div[data-type='设备']").find('input');
		materials.each(function(index, item) {
			subs.push({
				name: $(item).val(),
				type: "MATERIAL" // MATERIAL: 耗材， EQUIPMENT：设备
			});
		});
		
		equipments.each(function(index, item) {
			subs.push({
				name: $(item).val(),
				type: "EQUIPMENT" // MATERIAL: 耗材， EQUIPMENT：设备
			});
		});
		
		return subs;
	}
	
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
    function progress(num, tar) {
    	if (num < 0 || num > 100) {
    		return ;
    	}
    	
    	if (num === tar) {
    		clearTimeout(t);
            return;
        } 
    	
        t = setTimeout(function() {
        	$("#importProgress").css("width", num + "%");
        	$("#importProgress").html("");
        	$("#importProgress").html(num + "%");
        	progress(++num, tar);
        }, 300);
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
				clearTimeout(t);
				progress(0, 100);
				$("#txt_box").html("");
				$("#txt_box").html("PDF上传成功，正在解析中&nbsp;<img src='${rc.contextPath}/img/loading-upload.gif' />");
				$("#pdf_box").html("");
				$("#pdf_box").html("PDF上传成功，正在解析中&nbsp;<img src='${rc.contextPath}/img/loading-upload.gif' />");
				
				$("#uploadUrl").val(result.message[0].url);
				upload_date = result.message[0].date;
				
				$.ajax({
				    type: 'POST',
				    url: url,
				    async: true,
				    data: {
						pdfUrl : result.message[0].url
					},
				    success: function (data) {
						if (data.code == 200) {
							txt_url = data.message.txtPath;
							var txts = data.message.txts;
							var imgs = data.message.imgs;
							var html = "";
							$.each(txts, function (index, item){
								html = html + '<div class="row">';
								html = html + '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">';
								html = html + '<a onclick="addTxt(this);">';
								html = html + '<span class="fa fa-plus-square" style="margin-right:5px;"></span>';
								html = html + '<span>';
								html = html + item;
								html = html + '</span>';
								html = html + '</a>';
								html = html + '</div>';
								html = html + '</div>';
							});
							
							
							$("#txt_box").html("");
							$("#txt_box").html(html);
							html = "";
							$.each(imgs, function (index, item){
								html = html + '<div class="row">';
								html = html + '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">';
								html = html + '<img src="' + base_url + '/file/image?path=' + encodeURIComponent(item) + '" />';
								//html = html + '----' + index + '----------------------------------------------------------------------------';
								html = html + '</div>';
								html = html + '</div>';
							});
							
							$("#pdf_box").html("");
							$("#pdf_box").html(html);
							layer.msg("解析成功，结果仅供参考");
							clearTimeout(t);
							progress(100, 101);
						}
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						$("#txt_box").html("");
						$("#txt_box").html("系统繁忙，请重试!");
						$("#pdf_box").html("");
						$("#pdf_box").html("系统繁忙，请重试!");
			            layer.alert(XMLHttpRequest.responseJSON.error);
			        }
				});
			});
			
			this.on('error', function(a, errorMessage, result) {
				if (!result) {
					layer.alert(result.error || '上传失败');
				}
			});
			
			this.on('maxfilesreached', function() {
				this.removeAllFiles(true);
				$("#txt_box").html("");
				$("#txt_box").html("请上传PDF文件");
				$("#pdf_box").html("");
				$("#pdf_box").html("请上传PDF文件");
				progress(0, 1);
				layer.alert('文件数量超出限制');
			});
			
			this.on('removedfile', function() {
				$("#txt_box").html("");
				$("#txt_box").html("请上传PDF文件");
				$("#pdf_box").html("");
				$("#pdf_box").html("请上传PDF文件");
				$("#uploadUrl").val("${standard.uploadUrl}");
				progress(0, 1);
				layer.alert('删除成功');
			});
		}
	});
	
	function addTxt(obj) {
		var txt = getTxt(obj);
		var tar_input = getTarInput();
		tar_input.val(txt);
	}
	
	function getTxt(obj) {
		return $(obj).children("span").eq(1).html();
	}
	
	function getTarInput() {
		var cur_page = $("#standardTab").children(".active");
		var page_id = cur_page.children("a").attr("href");
		cur_page = $(page_id);
		var tar_input;
		cur_page.find("input").each(function() {
			if ($.trim($(this).val()) == "") {
				tar_input = $(this);
				return false;
			}
		});
		
		return tar_input
	}
	
	$("#standardTab li a").click(function() {
		return false;
	});
	
	function itemClick(obj) {
		if ($(obj).parent().prev().find("input").val() == '') {
			layer.msg("请选择或填写检测项");
			return ;
		}
		
		$(obj).html("");
		addItemInput(obj);
		$(obj).removeAttr('onclick');
	}
	
	function addItemInput(obj) {
		var html = "";
		html = html + '<div class="form-group">';
		html = html + '<input type="text" class="form-filter form-control btn_inline"  placeholder="请选择输入' + $(obj).attr("data-type") + '"/>';
		html = html + '<a class="pull-right a_del" onclick="removeItemInput(this)"><span class="glyphicon glyphicon-remove"></span></a>';
		html = html + '<a class="pull-right a_add" onclick="addItemInputFormA(this)"><span class="glyphicon glyphicon-plus"></span></a>';
		html = html + '</div>';
		$(obj).append(html);
	}
	
	function addItemInputFormA(obj) {
		addItemInput($(obj).parent().parent());
	}
	
	function removeItemInput(obj) {
		if ($(obj).parent().next().length > 0
			|| $(obj).parent().prev().length > 0) {
			$(obj).parent().remove();
		} else {
			var div = $(obj).parent().parent();
			div.html('<span class="glyphicon glyphicon-plus span_tip"></span><span class="span_tip">' + div.attr("data-type") + '</span>');
			div.attr('onclick', 'itemClick(this)');
		}
	}
	
	function removeItem(obj) {
		layer.confirm('是否删除该检测项？', {
			btn: ['确定','取消'] //按钮
		}, function(){
			if ($("#item-box").children().length > 1) {
				$(obj).parent().parent().remove();
			} else {
				$(obj).parent().parent().remove();
				addItem();
			}
			
			layer.closeAll('dialog');
			layer.msg("删除成功");
		}, function(){});
	}
	
	function addItem() {
		var html = '';
		html = html + '<div class="panel panel-success">';
		html = html + '<div class="panel-heading form-group">';
		html = html + '<input type="text" class="form-control btn_inline" style="color:black;" placeholder="请选择输入检验项" />';
		html = html + '<a class="pull-right a_del" onclick="removeItem(this)"><span class="glyphicon glyphicon-remove"></span></a>';
		html = html + '<a class="pull-right a_add" onclick="addItem()"><span class="glyphicon glyphicon-plus"></span></a>';
		html = html + '<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>';
		html = html + '</div>';
		html = html + '<div class="panel-body form-group">';
		html = html + '<div class="card box_shadow" data-type="耗材" onclick="itemClick(this);">';
		html = html + '<span class="glyphicon glyphicon-plus span_tip"></span><span class="span_tip">耗材</span>';
		html = html + '</div>';
		html = html + '<div class="card box_shadow" data-type="设备" onclick="itemClick(this);">';
		html = html + '<span class="glyphicon glyphicon-plus span_tip"></span><span class="span_tip">设备</span>';
		html = html + '</div>';
		html = html + '</div>';
		html = html + '</div>';
		$("#item-box").append(html);
	}
	
	function changeItem(obj) {
		var item_body = $(obj).parent().next();
		var display_val = item_body.css("display");
		if (display_val == 'none') {
			item_body.show();
			$(obj).children("span").attr("class", "glyphicon glyphicon-chevron-up");
		} else {
			item_body.hide();
			$(obj).children("span").attr("class", "glyphicon glyphicon-chevron-down");
		}
	}
</script>

