<link href="${rc.contextPath}/equipment/css/standard.css" rel="stylesheet" />
<script src="${rc.contextPath}/js/plugins/dropzone/dropzone.min.js"></script>
<link href="${rc.contextPath}/css/plugins/dropzone/dropzone.css" rel="stylesheet" />
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
			<!-- Nav tabs -->
			<ul id="standardTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active disabled">
					<a href="#import" class="disabled" aria-controls="import" role="tab" data-toggle="tab">导入标准</a>
				</li>
				<li role="presentation" class="disabled">
					<a href="#pdf" class="disabled" aria-controls="pdf" role="tab" data-toggle="tab">PDF源文件</a>
				</li>
				<li role="presentation" class="disabled">
					<a href="#info" class="disabled" aria-controls="info" role="tab" data-toggle="tab">基本信息</a>
				</li>
				<li role="presentation" class="disabled">
					<a href="#tech" class="disabled" aria-controls="tech" role="tab" data-toggle="tab">理化标准</a>
				</li>
				<li role="presentation" class="disabled">
					<a href="#content" class="disabled" aria-controls="content" role="tab" data-toggle="tab">检验项</a>
				</li>
			</ul>
		
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="import">
					<div class="panel panel-default">
		  				<div class="panel-body parent-box">
		  					<div class="row">
		  						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
		  						</div>
			  					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 form-group">
									<div id="pdfDropzone" class="dropzone"></div>
									<input type="hidden" id="uploadUrl" name="uploadUrl" value="" /> 
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
		  					<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="panel.back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="panel.next()" class="btn btn-success pull-right">下一步</button>
		  						</div>
		  					</div>
						</div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="pdf">
					<div class="panel panel-default">
			  			<div class="panel-body parent-box">
			  				<div id="pdf_box" class="pdf_box">
				  				<span>请上传PDF文件</span>
				  			</div>
						</div>
						<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="panel.back()" class="btn btn-success pull-left">返回</button>
									<button type="button" onclick="panel.next()" class="btn btn-success pull-right" style="margin-left: 10px;">下一步</button>
									<button type="button" onclick="panel.last()" class="btn btn-success pull-right">上一步</button>
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
		                            <input onclick="addTxt(this);" onblur="code.checkExists()" type="text" class="form-filter form-control" id="number_input" name="number" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="type_input" class="control-label">标准类别&nbsp;<span class="required">*</span></label>
		  							<select id="type_input" name="type" class="form-control" style="width:100%;">
		  								<option value="">请选择</option>
		  								<#list types as type>
		  									<option value="${type.jvalue}">${type.jvalue}</option>
		  								</#list>
		  							</select>
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="category_input" class="control-label">标准大类&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="category_input" name="category" placeholder="请输入标准大类" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="name_input" class="control-label">标准名称&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="name_input" name="name" placeholder="请输入标准名称" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="english_name_input" class="control-label">英文名称</label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="english_name_input" name="englishName" placeholder="请输入英文名称" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="publish_date_input" class="control-label">发布时间（格式：2008-01-01）&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="publish_date_input" name="publishDate" placeholder="格式：2008-01-01" />
		  						</div>
		  					</div>
		  					<div class = "row">
		  						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
		  							<label for="implement_date_input" class="control-label">实施时间（格式：2008-01-01）&nbsp;<span class="required">*</span></label>
		                            <input onclick="addTxt(this);" type="text" class="form-filter form-control" id="implement_date_input" name="implementDate" placeholder="格式：2008-01-01" />
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
				  					
				  					<tr>
			  							<td style="text-align:center;">
			  								<a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
			  							</td>
			  							<td>
			  								<input onclick="addTxt(this);" type="text" class="form-filter form-control" id="replace_standard_input" onblur="checkNumberByObj(this);"
			  									name="replaceStandard" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" />
			  							</td>
			  						</tr>
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
				  					<tr>
			  							<td style="text-align:center;">
			  								<a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
			  							</td>
			  							<td>
			  								<input onclick="addTxt(this);" type="text" class="form-filter form-control" id="import_standnard_input" onblur="checkNumberByObj(this);"
			  									name="importStandard" placeholder="格式：GB 2018.01-1995 或 GB/T 2018.01-1995" />
			  							</td>
			  						</tr>
				  				</tbody>
							</table>
							</form>
		  				</div>
		  				<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="info.save(this)" class="btn btn-success pull-left">保存</button>
									<button type="button" onclick="panel.back()" class="btn btn-success pull-left" style="margin-left: 10px;">返回</button>
									<button type="button" onclick="infoNextStep()" class="btn btn-success pull-right" style="margin-left: 10px;">下一步</button>
									<button type="button" onclick="panel.last()" class="btn btn-success pull-right">上一步</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="tech">
					<div class="panel panel-default">
			  			<div id="tech_box" class="panel-body parent-box">
			  				<div class="panel panel-success">
								<!-- <div class="panel-heading form-inline">
									<div class="form-group" style="color:black;">
										<input onclick="addTxt(this);" onblur="tech.save()" type="text" class="form-control" placeholder="请选择输入技术要求" />
									</div>
									<a class="pull-right a_del" onclick="item_box.remove(this)"><span class="glyphicon glyphicon-remove"></span></a>
									<a class="pull-right a_add" onclick="item_box.add(this)"><span class="glyphicon glyphicon-plus"></span></a>
									<a class="pull-right a_add" onclick="item_box.change(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div> -->
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
												<a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
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
						<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="tech.save(this)" class="btn btn-success pull-left">保存</button>
									<button type="button" onclick="panel.back()" class="btn btn-success pull-left" style="margin-left: 10px;">返回</button>
									<button type="button" onclick="panel.next()" class="btn btn-success pull-right" style="margin-left: 10px;">下一步</button>
									<button type="button" onclick="panel.last()" class="btn btn-success pull-right">上一步</button>
		  						</div>
		  					</div>
		  				</div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="content">
					<div class="panel panel-default">
						<div id="item-box" class="panel-body parent-box form-inline">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="form-group" style="color:black;">
										<input onclick="addTxt(this);" type="text" class="form-control" placeholder="请选择输入检验项" />
									</div>
									<a class="pull-right a_del" onclick="item_box.remove(this)"><span class="glyphicon glyphicon-remove"></span></a>
									<a class="pull-right a_add" onclick="item_box.add(this)"><span class="glyphicon glyphicon-plus"></span></a>
									<a class="pull-right a_add" onclick="item_box.change(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
								</div>
								<div id="item-sub-box" class="panel-body">
									<div class="panel panel-primary">
										<!-- Default panel contents -->
										<div class="panel-heading">
											<div class="form-group" style="color:black;">
												<input onclick="addTxt(this);" type="text" class="form-control" placeholder="（选填）检验方法" />
											</div>
											<a class="pull-right a_del" onclick="item_box.remove(this)"><span class="glyphicon glyphicon-remove"></span></a>
											<a class="pull-right a_add" onclick="item_box.add(this)"><span class="glyphicon glyphicon-plus"></span></a>
											<a class="pull-right a_add" onclick="item_box.change(this)"><span class="glyphicon glyphicon-chevron-up"></span></a>
										</div>
										<table class="table">
											<thead>
												<tr>
													<th>耗材</th>
													<th>名称（如：无水甲醇。请勿填写编号）</th>
													<th>备注</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td style="text-align:center;">
														<a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
													</td>
													<td>
														<input onclick="addTxt(this);" type="text" data-name="material_name" class="form-filter form-control"  placeholder="请选择输入耗材名称"/>
													</td>
													<td>
														<input onclick="addTxt(this);" type="text" data-name="material_remark" class="form-filter form-control"  placeholder="请选择输入属性"/>
													</td>
												</tr>
											</tbody>
										</table>
										<table class="table">
											<thead>
												<tr>
													<th>设备</th>
													<th>名称（如：锥形瓶。请勿填写编号）</th>
													<th>备注</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td style="text-align:center;">
														<a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
													</td>
													<td>
														<input onclick="addTxt(this);" type="text" data-name="equipment_name" class="form-filter form-control"  placeholder="请选择输入设备名称"/>
													</td>
													<td>
														<input onclick="addTxt(this);" type="text" data-name="equipment_remark" class="form-filter form-control"  placeholder="请选择输入属性"/>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<table class="table">
									<thead>
										<tr>
											<th>耗材</th>
											<th>名称（如：无水甲醇。请勿填写编号）</th>
											<th>备注</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td style="text-align:center;">
												<a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
											</td>
											<td>
												<input onclick="addTxt(this);" type="text" data-name="material_name" class="form-filter form-control"  placeholder="请选择输入耗材名称"/>
											</td>
											<td>
												<input onclick="addTxt(this);" type="text" data-name="material_remark" class="form-filter form-control"  placeholder="请选择输入属性"/>
											</td>
										</tr>
									</tbody>
								</table>
								<table class="table">
									<thead>
										<tr>
											<th>设备</th>
											<th>名称（如：锥形瓶。请勿填写编号）</th>
											<th>备注</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td style="text-align:center;">
												<a onclick="tr.add(this)"><span class="glyphicon glyphicon-plus span_tip"></span></a>
											</td>
											<td>
												<input onclick="addTxt(this);" type="text" data-name="equipment_name" class="form-filter form-control"  placeholder="请选择输入设备名称"/>
											</td>
											<td>
												<input onclick="addTxt(this);" type="text" data-name="equipment_remark" class="form-filter form-control"  placeholder="请选择输入属性"/>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="panel-footer">
		  					<div class = "row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button type="button" onclick="panel.back()" class="btn btn-success pull-left" style="margin-left: 10px;">返回</button>
									<button type="button" onclick="panel.last()" class="btn btn-success pull-right" style="margin-left: 10px;">确认</button>
									<button type="button" onclick="panel.last()" class="btn btn-success pull-right">上一步</button>
		  						</div>
		  					</div>
		  				</div>
		  			</div>
				</div>
			</div>
		</div>
		
		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
			<ul id="PDFTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="disabled">
					<a href="#txt" class="disabled" aria-controls="txt" role="tab" data-toggle="tab">解析结果</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="txt">
					<div class="panel panel-default">
			  			<div class="panel-body parent-box">
				  			<div id="txt_box" class="txt_box">
				  				<span>请上传PDF文件</span>
				  			</div>
						</div>
						<div class="panel-footer">
		  					<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<button class="btn btn-success" onclick="txt.deal(this);">乱码处理</button>
		  						</div>
		  					</div>
		  				</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
</div>
<script src="${rc.contextPath}/equipment/js/standard.js"></script>
