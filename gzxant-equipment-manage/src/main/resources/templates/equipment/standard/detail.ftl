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
		<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
		</div>
		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
			<!-- Nav tabs -->
			<ul id="standardTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active">
					<a href="#info" aria-controls="info" role="tab" data-toggle="tab">基本信息</a>
				</li>
				<li role="presentation">
					<a href="#content" aria-controls="content" role="tab" data-toggle="tab">耗材设备</a>
				</li>
			</ul>
		
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="info">
					<div class="panel panel-default">
		  				<div class="panel-body">
		  					<div class="row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="name_input" class="control-label" style="width: 30%;">标准名称：</label><span>${standard.name?split(" ")[standard.name?split(" ")?size - 1]}</span>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="number_input" class="control-label" style="width: 30%;">标准编号：</label><span>${standard.number}</span>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="first_category_input" class="control-label" style="width: 30%;">一级标准分类：</label><span>${standard.name?split(" ")[0]}</span>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="second_category_input" class="control-label" style="width: 30%;">二级标准分类：</label><span>${standard.name?split(" ")[1]}</span>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="old_stand_input" class="control-label" style="width: 30%;">原标准编号：</label><span>${standard.oldStand}</span>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="publish_date_input" class="control-label" style="width: 30%;">发布时间：</label><span>${standard.publishDate}</span>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="implement_date_input" class="control-label" style="width: 30%;">实施时间：</label><span>${standard.implementDate}</span>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="implement_date_input" class="control-label" style="width: 30%;">PDF文件：</label>
		  							<a onclick="downloadPDF()"><img src="${rc.contextPath}\img\pdf-download.jpg" style="width:50px; height: auto;" /></a>
		  						</div>
		  					</div>
		  				</div>
		  				<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="content">
					<div class="panel panel-default">
						<div id="item-box" class="panel-body" style="height:400px;overflow: scroll;">
							<#list items?keys as item>
							<div class="panel panel-success">
								<div class="panel-heading form-group">
									<span>${item}</span>
									<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div class="panel-body form-group">
									<#if (items[item]?split("|")[0] != '')>
									<div class="card box_shadow" data-type="耗材">
										<div class="form-group">
											<p style="font-size: 16px;"><b>耗材</b></p>
											<ul style="text-align: left;">
												<#list items[item]?split("|")[0]?split(",") as sub>
												<li>${sub}</li>
												</#list>
											</ul>
										</div>
									</div>
									</#if>
									<#if (items[item]?split("|")[1] != '')>
									<div class="card box_shadow" data-type="设备">
										<div class="form-group">
											<p style="font-size: 16px;"><b>设备</b></p>
											<ul style="text-align: left;">
												<#list items[item]?split("|")[1]?split(",") as sub>
												<li>${sub}</li>
												</#list>
											</ul>
										</div>
									</div>
									</#if>
								</div>
							</div>
							</#list>
						</div>
						<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
				
			</div>
		</div>
		
		<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
		</div>
	</div>
	
</div>
<script type="text/javascript">
	function downloadPDF() {
		var url = '${standard.pdfUrl}';
		url = base_url + "/back/standard/download?pdfUrl=" + encodeURIComponent(url) 
				+ "&name=" + encodeURIComponent("${standard.number} ${standard.name}");
		window.open(url);
	}

    function back() {
    	window.location.reload();
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
