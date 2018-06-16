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
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>标准名称：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9"><p>${standard.name}</p></div>
		  					</div>
		  					<div class="row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>英文名称：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9"><p>${standard.englishName}</p></div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>标准编号：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9"><p>${standard.number}</p></div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>标准大类：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9"><p>${standard.category}</p></div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>标准类别：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9"><p>${standard.type}</p></div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>发布时间：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9"><p>${standard.publishDate}</p></div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p>实施时间：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9"><p>${standard.implementDate}</p></div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"><p style="line-height: 40px;">实施时间：</p></div>
		  						<div class="col-lg-9 col-md-9col-sm-9 col-xs-9">
		  							<a onclick="downloadPDF()">
		  								<img src="${rc.contextPath}\img\pdf-download.jpg" style="width:50px; height: auto;" />
		  							</a>
		  						</div>
		  					</div>
		  					<table class="table" id="replace_table">
				  				<thead>
				  					<tr>
				  						<th>代替标准编号</th>
				  					</tr>
				  				</thead>
				  				<tbody>
			  						<#list standard.replaceStandard?split(",") as code>
			  						<#if (code != "")>
				  					<tr>
			  							<td>${code}</td>
			  						</tr>
			  						</#if>
		  							</#list>
				  				</tbody>
							</table>
							<table class="table" id="import_table">
				  				<thead>
				  					<tr>
				  						<th>引用标准编号</th>
				  					</tr>
				  				</thead>
				  				<tbody>
			  						<#list standard.importStandard?split(",") as code>
				  					<#if (code != "")>
				  					<tr>
			  							<td>${code}</td>
			  						</tr>
			  						</#if>
		  							</#list>
				  				</tbody>
							</table>
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
							<#list standard.items as item>
							<div class="panel panel-success">
								<div class="panel-heading form-group">
									<span>${item.name}</span>
									<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div class="panel-body form-group">
									<#if (item.materials?size > 0)>
									<table class="table">
										<thead>
											<tr>
												<th width="10%">耗材</th>
												<th width="45%">名称</th>
												<th width="45%">属性</th>
											</tr>
										</thead>
										<tbody>
											<#list item.materials as sub>
											<tr>
												<td style="text-align:center;"></td>
												<td>${sub.name}</td>
												<td>${sub.remark}</td>
											</tr>
											</#list>
										</tbody>
									</table>
									</#if>
									<#if (item.equipments?size > 0)>
									<table class="table">
										<thead>
											<tr>
												<th width="10%">设备</th>
												<th width="45%">名称</th>
												<th width="45%">属性</th>
											</tr>
										</thead>
										<tbody>
											<#list item.equipments as sub>
											<tr>
												<td style="text-align:center;"></td>
												<td>${sub.name}</td>
												<td>${sub.remark}</td>
											</tr>
											</#list>
										</tbody>
									</table>
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
		var url = '${standard.pdfUrl?replace("\\", "\\\\")?replace("/", "//")}';
		url = base_url + "/back/standard/download?pdfUrl=" + encodeURIComponent(url) 
				+ "&name=" + encodeURIComponent("${standard.number} ${standard.category} ${standard.type} ${standard.name}");
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

