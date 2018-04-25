<!DOCTYPE html>
<html>
<head>
    <title>商城分类列表</title>
    <link href="${rc.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${rc.contextPath}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${rc.contextPath}/css/animate.css" rel="stylesheet">
    <script>
        var url = "${rc.requestUri}" + "/";
    </script>
</head>


<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">
                <div id="exampleToolbar" role="group">
	                <div class="panel panel-default">
					  	<div class="panel-heading">
					  		<h3 class="panel-title">查询条件</h3>
					  	</div>
					  	<div class="panel-body">
					  		<div class="row">
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="parentSelect" class="control-label">父分类</label>
								    <select class="form-filter form-control _search" id="parentSelect" name="search_eq_parent_id">
								    	<option value="0">-- 请选择 --</option>
								    </select>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="nameInput" class="control-label">名称</label>
								    <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_name"  />
								</div>
		                    </div>
					  	</div>
					  	<div class="panel-footer">
					  		<button type="button" class="btn btn-success" onclick="re_load()">
	                            <i class="fa fa-search" aria-hidden="true"></i> 查询
	                        </button>
	                        <button type="button" class="btn btn-primary" onclick="reset()">
	                            <i class="fa fa-circle-thin" aria-hidden="true"></i> 重置
	                        </button>
	                        <button type="button" class="btn btn-danger" onclick="batch_remove()">
	                            <i class="fa fa-trash" aria-hidden="true"></i> 删除
	                        </button>
	                        <button type="button" class="btn btn-info" onclick="dt_insert()">
	                            <i class="fa fa-plus-square" aria-hidden="true"></i> 添加
	                        </button>
					  	</div>
					</div>
                </div>
                
                <table class="table" id="exampleTable" data-mobile-responsive="true">
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap table -->
<script src="${rc.contextPath}/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${rc.contextPath}/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${rc.contextPath}/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<script src="${rc.contextPath}/js/slife/datatable.js"></script>
<script type="text/javascript">

    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'id', // 列字段名
                title: '序号' // 列标题
            },
            {
                title: '图标',
                field: 'icon',
                align: 'center',
                formatter: function (value, row, index) {
                    return '<img style="width:30px" src="${rc.contextPath}'+value+'"/>';
                }
            },
            {
                field: 'name',
                title: '名称'
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter: function (value, row, index) {
                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {});
    
    $(".bars").css("width", "100%");
</script>
</body>
</html>