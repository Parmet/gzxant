<script src="${rc.contextPath}/js/plugins/iTable/iTable.js" type="text/javascript"></script>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="col-sm-12">
		<div class="ibox">
			<div class="ibox-body">
				<div id="exampleToolbar" role="group">
					<div class="row">

						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
							<label for="nameInput" class="control-label">文章名称</label>
							<input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_name" />
						</div>

					</div>
				</div>

				<table class="table" id="exampleTable" data-mobile-responsive="true">
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function getColumns() {
		var c = [{
				checkbox: true
			},
			{
				field: 'id', // 列字段名
				title: '序号' // 列标题
			},
			{
				field: 'name',
				title: '文章名称'
			},
			{
				field: 'state',
				title: '发布状态',
				formatter: function(value, row, index) {
					var select = '<select id="state_select" class="select2" onchange="changeState(this);">'
						+ '<option value="Y" ';
					if (value == 'Y') {
						select = select + 'selected="selected"';
					}
					
					select = select + '>发布</option>'
						+ '<option value="N" ';
						if (value == 'N') {
							select = select + 'selected="selected"';
						}
					select = select + '>取消发布</option>'
						+ '<option value="Y">优先发布</option>'
						+ '</select>';
						
					return select;
				}
			},
			{
				title: '操作',
				field: 'id',
				align: 'center',
				formatter: function(value, row, index) {
					var editO = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="rowBtnClick(\'edit\', \'' +
					row.id + '\')"><i class="fa fa-edit"></i></a>';
					var detailO = '<a class="btn btn-success btn-sm" href="#" style="margin-left:3px;" title="详情"  mce_href="#" onclick="rowBtnClick(\'view\', \'' +
					row.id + '\')"><i class="fa fa-info-circle"></i></a> ';
					var deleteO = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" ' +
					'onclick="iTable.remove(\'' + row.id +
					'\')"><i class="fa fa-remove"></i></a> ';
					return editO + detailO + deleteO;
				}
			}
		];

		return c;
	}
	
	function rowBtnClick(action, id) {
		window.location.href = "${rc.contextPath}" + "/article/" + action + "/" + id;
	}
	
	function changeState(obj) {
		var state = $(obj).val();
		var id = $(obj).parents("tr").children('td').eq(1).html();
		$.ajax({
            cache: true,
            type: "POST",
            url: url + "push/" + state + "/" + id,
            async: false,
            dataType : "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.alert(XMLHttpRequest.responseJSON.error);
            },
            success: function (data) {
                if (data.code == 200) {
                	if (state == 'Y') {
                    	layer.msg("发布成功！");
                	} else {
                		layer.msg("已取消发布！");
                	}
                } else {
                    layer.alert(data.error)
                }

            }
        });
	}

	var standardTable = $("#exampleTable").iTable({
		toolbar: {
			id: "exampleToolbar",
			auto: true,
			btn: {
				dt_insert : {
					url : url + "add",
					open_type : 2
				},
				exclude : ["dt_insert"],
	            include : [
	                {
	                    id : "btn_insert",
	                    className : "btn-info",
	                    icon : "fa fa-plus-square",
	                    title : "添加",
	                    click: function() {
	                        window.location.href = url + "add";
	                    }
	                }
	            ]
			}
		},
		table : {
			data: {
				columns: getColumns()
			}, 
			btn : {
				detail : {
					open_type : 2
				},
				update : {
					open_type : 2
				}
			}
		}
	});
	//$(".bars").css("width", "100%");
</script>