<style>
.panel-body.parent-box {
	height:450px;
	overflow: scroll;
}

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
	position:  relative;
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
		<div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
			<!-- Nav tabs -->
			<ul id="standardTab" class="nav nav-tabs" role="tablist">
				<li role="presentation">
					<a href="#pdf" aria-controls="pdf" role="tab" data-toggle="tab">PDF源文件</a>
				</li>
				<li role="presentation">
					<a href="#info" aria-controls="info" role="tab" data-toggle="tab">基本信息</a>
				</li>
				<li role="presentation">
					<a href="#tech" aria-controls="tech" role="tab" data-toggle="tab">技术要求</a>
				</li>
				<li role="presentation">
					<a href="#content" aria-controls="content" role="tab" data-toggle="tab">耗材设备</a>
				</li>
			</ul>
		
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="pdf">
					<div class="panel panel-default">
			  			<div class="panel-body parent-box">
			  				<div id="pdf_box" class="pdf_box">
			  				
				  			</div>
						</div>
						<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="nextStep()" class="btn btn-success pull-right" style="margin-left: 10px;">下一步</button>
		  						</div>
		  					</div>
		  				</div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="info">
					<div class="panel panel-default">
		  				<div class="panel-body parent-box">
		  					<form id="info_form" action="#">
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="number_input" class="control-label">标准编号（格式：GB 2018.01-1995 或 GB/T 2018.01-1995）&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="number_input" 
		                            	name="number" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" value="${standard.number}" disabled="disabled" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="type_input" class="control-label">标准类别&nbsp;<span class="required">*</span></label>
		  							<select id="type_input" name="type" class="form-control" style="width:100%;">
		  								<option value="">请选择</option>
		  								<#list types as type>
		  									<option value="${type.jvalue}" <#if (standard.type??) && (standard.type == type.jvalue)>selected="selected"</#if>>${type.jvalue}</option>
		  								</#list>
		  							</select>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="category_input" class="control-label">标准大类&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="category_input" name="category" placeholder="请输入标准大类" value="${standard.category}" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="name_input" class="control-label">标准名称&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="name_input" name="name" placeholder="请输入标准名称" value="${standard.name}" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="english_name_input" class="control-label">英文名称</label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="english_name_input" name="englishName" placeholder="请输入英文名称" value="${standard.englishName}" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="publish_date_input" class="control-label">发布时间（格式：2008-01-01）&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="publish_date_input" name="publishDate" placeholder="格式：2008-01-01" value="${standard.publishDate}" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="implement_date_input" class="control-label">实施时间（格式：2008-01-01）&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="implement_date_input" name="implementDate" placeholder="格式：2008-01-01" value="${standard.implementDate}" />
		  						</div>
		  					</div>
			  				<table class="table" id="replace_table">
				  				<thead>
				  					<tr>
				  						<th></th>
				  						<th>代替标准编号（格式：GB 2018.01-1995 或 GB/T 2018.01-1995）</th>
				  					</tr>
				  				</thead>
				  				<tbody>
			  						<#if standard.replaceStandard?? && (standard.replaceStandard != "")>
			  						<#list standard.replaceStandard?split(",") as code>
				  					<tr>
			  							<td style="text-align:center;">
				  						<#if (code != "")>
			  								<a style="color:red;" onclick="removeTrInput(this)"><span class="glyphicon glyphicon-remove"></span></a>
			  							<#else>
			  								<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
			  							</#if>
			  							</td>
			  							<td>
			  								<input onclick="addTxt(this);" type="text" class="form-filter form-control" id="replace_standard_input" onblur="checkNumberByObj(this);"
			  									name="replaceStandard" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" value="${code}" />
			  							</td>
			  						</tr>
		  							</#list>
		  							<#else>
		  							<tr>
			  							<td style="text-align:center;">
			  								<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
			  							</td>
			  							<td>
			  								<input onclick="addTxt(this);" type="text" class="form-filter form-control" id="replace_standard_input" onblur="checkNumberByObj(this);"
			  									name="replaceStandard" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" />
			  							</td>
		  							</tr>
		  							</#if>
				  				</tbody>
							</table>
							<table class="table" id="import_table">
				  				<thead>
				  					<tr>
				  						<th></th>
				  						<th>引用标准编号（格式：GB 2018.01-1995 或 GB/T 2018.01-1995）</th>
				  					</tr>
				  				</thead>
				  				<tbody>
				  					<#if standard.importStandard?? && (standard.importStandard != "")>
			  						<#list standard.importStandard?split(",") as code>
				  					<tr>
			  							<td style="text-align:center;">
				  						<#if (code != "")>
			  								<a style="color:red;" onclick="removeTrInput(this)"><span class="glyphicon glyphicon-remove"></span></a>
			  							<#else>
			  								<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
			  							</#if>
			  							</td>
			  							<td>
			  								<input onclick="addTxt(this);" type="text" class="form-filter form-control" id="import_standnard_input" onblur="checkNumberByObj(this);"
				  									name="importStandard" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" value="${code}" />
			  							</td>
			  						</tr>
		  							</#list>
		  							<#else>
		  							<tr>
			  							<td style="text-align:center;">
			  								<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
			  							</td>
			  							<td>
			  								<input onclick="addTxt(this);" type="text" class="form-filter form-control" id="import_standnard_input" onblur="checkNumberByObj(this);"
			  									name="importStandard" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" />
			  							</td>
			  						</tr>
		  							</#if>
				  				</tbody>
							</table>
							</form>
		  				</div>
		  				<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="infoNextStep()" class="btn btn-success pull-right" style="margin-left: 10px;">下一步</button>
									<button type="button" onclick="lastStep()" class="btn btn-success pull-right">上一步</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="tech">
					<div class="panel panel-default">
						<form id="tech_form" action="#">
						<div id="tech_box" class="panel-body parent-box">
							<#if standard.techs?? && (standard.techs?size > 0)>
							<#list standard.techs as tech>
							<div class="panel panel-success">
								<div class="panel-heading form-group">
									<input onclick="addTxt(this);" type="text" class="form-control btn_inline" style="color:black;" placeholder="请选择输入技术要求" value="${tech.name}" />
									<a class="pull-right a_del" onclick="removeItem(this)"><span class="glyphicon glyphicon-remove"></span></a>
									<a class="pull-right a_add" onclick="addItem(this)"><span class="glyphicon glyphicon-plus"></span></a>
									<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th></th>
												<th>项目</th>
												<th>指标/要求</th>
												<th>检验方法</th>
											</tr>
										</thead>
										<tbody>
											<#if tech.subs?? && (tech.subs?size > 0)>
					  						<#list tech.subs as sub>
						  					<tr>
					  							<td style="text-align:center;">
						  						<#if (sub_index+1 == tech.subs?size)>
					  								<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
					  							<#else>
					  								<a style="color:red;" onclick="removeTrInput(this)"><span class="glyphicon glyphicon-remove"></span></a>
					  							</#if>
					  							</td>
					  							<td>
													<input onclick="addTxt(this);" type="text" data-name="project" class="form-filter form-control"  placeholder="请选择输入项目" value="${sub.project}" />
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="require" class="form-filter form-control"  placeholder="请选择输入指标/要求" value="${sub.require}" />
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="function" class="form-filter form-control"  placeholder="请选择输入检验方法" value="${sub.function}" />
												</td>
					  						</tr>
				  							</#list>
				  							<#else>
				  							<tr>
												<td style="text-align:center;">
													<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="project" class="form-filter form-control"  placeholder="请选择输入项目"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="require" class="form-filter form-control"  placeholder="请选择输入指标/要求"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="function" class="form-filter form-control"  placeholder="请选择输入检验方法"/>
												</td>
											</tr>
				  							</#if>
										</tbody>
									</table>
								</div>
							</div>
							</#list>
							<#else>
							<div class="panel panel-success">
								<div class="panel-heading form-group">
									<input onclick="addTxt(this);" type="text" class="form-control btn_inline" style="color:black;" placeholder="请选择输入技术要求" />
									<a class="pull-right a_del" onclick="removeItem(this)"><span class="glyphicon glyphicon-remove"></span></a>
									<a class="pull-right a_add" onclick="addItem(this)"><span class="glyphicon glyphicon-plus"></span></a>
									<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th></th>
												<th>项目</th>
												<th>指标/要求</th>
												<th>检验方法</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td style="text-align:center;">
													<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="project" class="form-filter form-control"  placeholder="请选择输入项目"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="require" class="form-filter form-control"  placeholder="请选择输入指标/要求"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="function" class="form-filter form-control"  placeholder="请选择输入检验方法"/>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							</#if>
						</div>
						</form>
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
						<form id="item_form" action="#">
						<div id="item-box" class="panel-body parent-box">
							<#if standard.items?? && (standard.items?size > 0)>
							<#list standard.items as item>
							<div class="panel panel-success">
								<div class="panel-heading form-group">
									<input onclick="addTxt(this);" type="text" class="form-control btn_inline" style="color:black;" placeholder="请选择输入检验项" value="${item.name}" />
									<a class="pull-right a_del" onclick="removeItem(this)"><span class="glyphicon glyphicon-remove"></span></a>
									<a class="pull-right a_add" onclick="addItem(this)"><span class="glyphicon glyphicon-plus"></span></a>
									<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th>耗材</th>
												<th>名称（如：无水甲醇。请勿填写编号）</th>
												<th>属性</th>
											</tr>
										</thead>
										<tbody>
											<#if item.materials?? && (item.materials?size > 0)>
					  						<#list item.materials as material>
						  					<tr>
					  							<td style="text-align:center;">
						  						<#if (material_index+1 == item.materials?size)>
					  								<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
					  							<#else>
					  								<a style="color:red;" onclick="removeTrInput(this)"><span class="glyphicon glyphicon-remove"></span></a>
					  							</#if>
					  							</td>
					  							<td>
													<input onclick="addTxt(this);" type="text" data-name="material_name" class="form-filter form-control" placeholder="请选择输入耗材名称" value="${material.name}" />
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="material_remark" class="form-filter form-control"  placeholder="" value="${material.remark}" />
												</td>
					  						</tr>
				  							</#list>
				  							<#else>
				  							<tr>
												<td style="text-align:center;">
													<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="material_name" class="form-filter form-control"  placeholder="请选择输入耗材名称"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="material_remark" class="form-filter form-control"  placeholder=""/>
												</td>
											</tr>
				  							</#if>
										</tbody>
									</table>
									<table class="table">
										<thead>
											<tr>
												<th>设备</th>
												<th>名称（如：锥形瓶。请勿填写编号）</th>
												<th>属性</th>
											</tr>
										</thead>
										<tbody>
											<#if item.equipments?? && (item.equipments?size > 0)>
					  						<#list item.equipments as equipment>
						  					<tr>
					  							<td style="text-align:center;">
						  						<#if (equipment_index+1 == item.equipments?size)>
					  								<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
					  							<#else>
					  								<a style="color:red;" onclick="removeTrInput(this)"><span class="glyphicon glyphicon-remove"></span></a>
					  							</#if>
					  							</td>
					  							<td>
													<input onclick="addTxt(this);" type="text" data-name="equipment_name" class="form-filter form-control" placeholder="请选择输入设备名称" value="${equipment.name}" />
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="equipment_remark" class="form-filter form-control"  placeholder=""value="${equipment.remark}" />
												</td>
					  						</tr>
				  							</#list>
				  							<#else>
				  							<tr>
												<td style="text-align:center;">
													<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="equipment_name" class="form-filter form-control"  placeholder="请选择输入设备名称"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="equipment_remark" class="form-filter form-control"  placeholder=""/>
												</td>
											</tr>
				  							</#if>
										</tbody>
									</table>
									
								</div>
							</div>
							</#list>
							<#else>
							<div class="panel panel-success">
								<div class="panel-heading form-group">
									<input onclick="addTxt(this);" type="text" class="form-control btn_inline" style="color:black;" placeholder="请选择输入检验项" />
									<a class="pull-right a_del" onclick="removeItem(this)"><span class="glyphicon glyphicon-remove"></span></a>
									<a class="pull-right a_add" onclick="addItem(this)"><span class="glyphicon glyphicon-plus"></span></a>
									<a class="pull-right a_add" onclick="changeItem(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th>耗材</th>
												<th>名称（如：无水甲醇。请勿填写编号）</th>
												<th>属性</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td style="text-align:center;">
													<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="material_name" class="form-filter form-control"  placeholder="请选择输入耗材名称"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="material_remark" class="form-filter form-control"  placeholder=""/>
												</td>
											</tr>
										</tbody>
									</table>
									<table class="table">
										<thead>
											<tr>
												<th>设备</th>
												<th>名称（如：锥形瓶。请勿填写编号）</th>
												<th>属性</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td style="text-align:center;">
													<a onclick="addTrInuput(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="equipment_name" class="form-filter form-control"  placeholder="请选择输入设备名称"/>
												</td>
												<td>
													<input onclick="addTxt(this);" type="text" data-name="equipment_remark" class="form-filter form-control"  placeholder=""/>
												</td>
											</tr>
										</tbody>
									</table>
									
								</div>
							</div>
							</#if>
						</div>
						</form>
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
		
		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
			<ul id="PDFTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active">
					<a href="#txt" aria-controls="txt" role="tab" data-toggle="tab">解析结果</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="txt">
					<div class="panel panel-default">
			  			<div class="panel-body parent-box">
				  			<div id="txt_box" class="txt_box">
				  				<#list txts as txt>
				  				<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<input type="checkbox" style="margin: 5px;" value="${txt}"/><a onclick="clickTxt(this);">${txt}</a>
								</div>
								</div>
				  				</#list>
				  			</div>
						</div>
						<div class="panel-footer">
		  					<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button class="btn btn-success" onclick="dealCode(this);">乱码处理</button>
		  						</div>
		  					</div>
		  				</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
</div>
<script type="text/javascript">
	var html = "";
	<#list 0..(standard.pageSize?number - 1) as i>
		html = html + '<div class="row">';
		html = html + '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">';
		html = html + '<img src="' + base_url + '/file/image?path=' + encodeURIComponent("${standard.imgsPath?replace('\\', '\\\\')}${i}.jpg") + '" />'; //
		html = html + '</div>';
		html = html + '</div>';
	</#list>
	$("#pdf_box").html("");
	$("#pdf_box").html(html);
	
	function dealCode(obj) {
		if ("${standard.txtUrl?replace('\\', '\\\\')}" == "") {
			layer.alert("请上传PDF文件！");
			return ;
		}
		
		//$("<div id='shade' style='opacity: 0.8;background: white;position: absolute;top: 0px;left: 0px;z-index: 300;height: 100%;width: 100%;'><img src='${rc.contextPath}/img/loading-upload.gif' style='width: auto;position: absolute;top: 50%;left: 50%;z-index: 300;height: auto;' /></div>").appendTo('#txt_box');
		var load_index = layer.load(1, {shade: [0.8, '#000']});
		$.ajax({
			type: 'PUT',
		    url: base_url + "/back/standard/update/txt",
		    async: true,
		    data: {
		    	txtUrl : "${standard.txtUrl?replace('\\', '\\\\')}",
		    	imgsPath: "${standard.imgsPath?replace('\\', '\\\\')}",
		    	pageSize: "${standard.pageSize}"
			},
			success: function (data) {
		    	if (data.code != 200) {
		    		layer.close(load_index);
		    		layer.alert("乱码处理失败，请重试！");
		    	} else {
		    		loadTxt(data.message);
		    		layer.close(load_index);
		    		layer.msg("乱码处理成功");
		    	}
		    }, 
		    error: function (XMLHttpRequest, textStatus, errorThrown) {
	            layer.alert(XMLHttpRequest.responseJSON.error);
	            layer.close(load_index);
	            layer.alert("乱码处理失败，请重试！");
	        }
		});
	}

	function loadTxt(txts) {
		var html = "";
		$.each(txts, function (index, item){
			html = html + '<div class="row">';
			html = html + '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">';
			html = html + '<input type="checkbox" style="margin: 5px;" value="' + item +'"/>';//class="fa fa-plus-square"
			html = html + '<a onclick="clickTxt(this);">';
			html = html + item;
			html = html + '</a>';
			html = html + '</div>';
			html = html + '</div>';
		});
		
		$("#txt_box").html("");
		$("#txt_box").html(html);
	}
	
	function clickTxt(obj) {
		var checkbox_dom = $(obj).prev(":checkbox")
		if (checkbox_dom.is(':checked')) {
			checkbox_dom.removeAttr("checked");
		} else {
			checkbox_dom.prop("checked", true);
		}
	}
	
	function addTrInuput(obj) {
		var tr_dom = $(obj).parent("td").parent("tr");
		tr_dom = tr_dom.after(tr_dom.clone(true));
		var copy_tr_dom = tr_dom.next();
		copy_tr_dom.find("input").val("");
		$(obj).parent().html('<a style="color:red;" onclick="removeTrInput(this)"><span class="glyphicon glyphicon-remove"></span></a>');
	}
	
	function removeTrInput(obj) {
		$(obj).parent("td").parent("tr").remove();
	}
	
	function checkNumberByObj(obj) {
		if (!checkNumber($(obj).val().trim())) {
			layer.msg("编号：’" + $(obj).val().trim() + "‘，格式错误，请检查!");
			$(obj).focus();
		}
	}
	
	$("input[name=number]").blur(function() {
		checNnumberExists($(this).val().trim());
	});
	
	var info_validate = $("#info_form").validate({
	    rules: {
	    	name: "required",
	    	category: "required",
	    	type: "required",
	    	number: {
	    		required: true,
	    		checkNumber: true
	    	},
	    	publishDate: {
	    		required: true,
	    		dateISO: true
	    	},
	    	implementDate: {
	    		required: true,
	    		dateISO: true
	    	}
	    },
	    messages: {
	    	name: "请输入名称",
	    	category: "请输入标准大类",
	    	type: "请选择标准类别",
	    	number: {
	    		required: "请输入标准编号"
	    	},
	    	publishDate: {
	    		required: "请输入发布时间",
	    		dateISO: "请输入正确的日期格式！正确格式为：2008-01-01"
	    	},
	    	implementDate: {
	    		required: "请输入实施时间",
	    		dateISO: "请输入正确的日期格式！正确格式为：2008-01-01"
	    	}
	    }
	});
	
	jQuery.validator.addMethod("checkNumber", function (value, element, param) {
		return checkNumber(value);
	}, "请输入正确的编号格式！正确格式为：GB 2757-2012 或  GB/T 5413.34-2010");
	
	function checkNumber(number) {
		if (number == "") {
			return true;
		}
		
		var regExp = new RegExp("^GB(\/T)? [0-9]+\.?[0-9]+(\-[0-9]+\.?[0-9]+)?$");
		if(!regExp.test(number)){
		　　return false;
		}
		
		return true;
	}
	
	function checNnumberExists(number) {
		if (number == "") {
			layer.alert("请输入标准编号！");
			return false;
		}
		
		var flag = false;
		if(checkNumber(number)){
			$.ajax({
				type: 'GET',
			    url: base_url + "/back/standard/check",
			    async: false,
			    data: {
					number : number
				},
			    success: function (data) {
			    	if (data.code != 200) {
			    		layer.alert(data.error);
			    		flag = false;
			    	} else {
			    		flag = true;
			    	}
			    	
			    }, 
			    error: function (XMLHttpRequest, textStatus, errorThrown) {
		            layer.alert(XMLHttpRequest.responseJSON.error);
		            flag = false;
		        }
			});
		} else {
			layer.alert("请输入正确的编号格式！正确格式为：GB 2757-2012 或  GB/T 5413.34-2010");
			flag = false;
		}
		
		return flag;
	}
	
	function infoNextStep() {
		if (info_validate.form()) {
			nextStep();
		}
	}
	
	function saveStandard() {
		var load_index = layer.load(1, {shade: [0.8, '#000']});
		var data = {
			"id": "${standard.id}",
			"name": $('[name=name]').val().trim(),
			"englishName": $('[name=englishName]').val().trim(),
			"number": $('[name=number]').val().trim(),
			"category": $('[name=category]').val().trim(),
			"type": $('[name=type]').val().trim(),
			"replaceStandard": getReplaceStandard(),
			"importStandard": getImportStandard(),
			"pdfUrl": "${standard.pdfUrl?replace('\\', '\\\\')}",
			"txtUrl": "${standard.txtUrl?replace('\\', '\\\\')}",
			"imgsPath": "${standard.imgsPath?replace('\\', '\\\\')}",
			"pageSize": "${standard.pageSize}",
			"publishDate": $('[name=publishDate]').val().trim(),
			"uploadDate": "${standard.uploadDate}",
			"implementDate": $('[name=implementDate]').val().trim(),
			"techs": getTechs(),
			"items": getItems()
		};
		
		if (!checkNumber(data.number)) {
			layer.close(load_index);
			return ;
		}
		
	/* 	if (data.items.length <= 0) {
			layer.close(load_index);
			layer.msg("请填写检测项信息");
			return ;
		} */
		
		if (data.pdfUrl == "") {
			layer.close(load_index);
			layer.msg("请上传PDF文件");
			return ;
		}
		
		if (data.txtUrl == "") {
			layer.close(load_index);
			layer.msg("PDF文件解析错误，请重新上传PDF文件");
			return ;
		}
		
		data = JSON.stringify(data);
		console.log(data);
		$.ajax({
		    type: 'POST',
		    url: base_url + "/back/standard/update",
		    async: true,
		    data: {
		    	data: data
		    },
		    success: function (data) {
		    	if (data.code == 200) {
			    	layer.msg("保存成功");
			    	window.location.href = url.split("jupdate")[0];
		    	} else {
		    		layer.close(load_index);
		    		layer.msg("保存失败");
		    	}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
				layer.close(load_index);
	            layer.alert(XMLHttpRequest.responseJSON.error);
	        }
		});
	}
	
	function getTechs() {
		var techs = [];
		var tech_divs = $("#tech_box").children();
		tech_divs.each(function(index, tech_div) {
			var tech_name = getItemName(tech_div);
			if (tech_name != "") {
				techs.push({
					"name": tech_name,
					"subs": getTechSubs(tech_div)
				});
			}
		});
		
		return techs;
	}
	
	function getTechSubs(obj) {
		var subs = [];
		var rows = $(obj).find("table").children("tbody").children("tr");
		rows.each(function(index, row) {
			subs.push({
				"project": $(row).children("td").children("input[data-name='project']").val().trim(),
				"require": $(row).children("td").children("input[data-name='require']").val().trim(),
				"function": $(row).children("td").children("input[data-name='function']").val().trim()
			});
		});
		
		return subs;
	}
	
	function getReplaceStandard() {
		var input = $("#replace_table").find("input");
		var stanards = "";
		input.each(function (index, item) {
			if ($(item).val().trim() != "") {
				stanards = stanards + $(item).val() + ",";
			}
		});
		
		return stanards;
	}
	
	function getImportStandard() {
		var input = $("#import_table").find("input");
		var stanards = "";
		input.each(function (index, item) {
			if ($(item).val().trim() != "") {
				stanards = stanards + $(item).val() + ",";
			}
		});
		
		return stanards;
	}
	
	function getItems() {
		var items = [];
		var item_divs = $("#item-box").children();
		item_divs.each(function(index, item_div) {
			var item_name = getItemName(item_div);
			if (item_name != "") {
				items.push({
					"name": item_name,
					"materials": getItemSub(item_div, "M"),
					"equipments": getItemSub(item_div, "E")
				});
			}
		});
		
		return items;
	}

	function getItemName(item_div) {
		return $(item_div).find(".panel-heading").find("input").val().trim();
	}
	
	function getItemSub(item_div, type) {
		var subs = [];
		if (type == "M") {
			var materials = $(item_div).find(".panel-body").find('input[data-name="material_name"]');
			materials.each(function(index, item) {
				if ($(item).val().trim() != "") {
					subs.push({
						"name": $(item).val().trim(),
						"type": "M", // M: 耗材， E：设备
						"remark": getSubRemark(item)
					});
				}
			});
			
			return subs;
		} else if (type == "E") {
			var equipments = $(item_div).find(".panel-body").find('input[data-name="equipment_name"]');
			equipments.each(function(index, item) {
				if ($(item).val().trim() != "") {
					subs.push({
						"name": $(item).val().trim(),
						"type": "E", // M: 耗材， E：设备
						"remark": getSubRemark(item)
					});
				}
			});
			
			return subs;
		}
		
		return subs;
	}
	
	function getSubRemark(obj) {
		return $(obj).parent("td").next().children("input").val().trim();
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
    			window.location.href = url.split("jupdate")[0];
    		}
    	});
    }
    
	function addTxt(obj) {
		var txt = getTxt();
		if (txt != "") {
			$(obj).val(txt);
		}
	}
	
	function getTxt(obj) {
		var txt = "";
		var check_input = $("#txt_box").find("input[type='checkbox']:checked");
		check_input.each(function(index, item){
			txt = txt + $(item).val();
		});
		
		check_input.attr("checked", false);
		return txt;
	}
	
	function getTarInput() {
		var cur_page = $("#standardTab").children(".active");
		var page_id = cur_page.children("a").attr("href");
		cur_page = $(page_id);
		var tar_input;
		cur_page.find("input").each(function() {
			if ($.trim($(this).val().trim()) == "") {
				tar_input = $(this);
				return false;
			}
		});
		
		return tar_input
	}
	
	$("#standardTab li a").click(function() {
		layer.msg("请不要按我");
		return false;
	});
	
	function removeItem(obj) {
		layer.confirm('是否删除该检测项？', {
			btn: ['确定','取消'] //按钮
		}, function(){
			var box = $(obj).parent("div").parent("div").parent("div");
			if (box.children().length > 1) {
				$(obj).parent().parent().remove();
			} else {
				addItem(obj);
				$(obj).parent().parent().remove();
			}
			
			layer.closeAll('dialog');
			layer.msg("删除成功");
		}, function(){});
	}
	
	function addItem(obj) {
		var box = $(obj).parent("div").parent("div");
		box = box.after(box.clone(true));
		var copy_box = box.next();
		copy_box.find("input").val("");
		copy_box.find("span.glyphicon-remove").each(function(){
			$(this).parent("a").parent("td").parent("tr").remove();
		});
		
		if (copy_box.children(".panel-body").css("display") == 'none') {
			copy_box.children(".panel-body").show();
			$(obj).children("span").attr("class", "glyphicon glyphicon-chevron-up");
		}
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

