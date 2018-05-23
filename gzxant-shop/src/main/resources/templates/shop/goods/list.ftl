<link rel="stylesheet" type="text/css" href="${rc.contextPath}/css/plugins/jsTree/style.min.css"/>
<style>
    #dict_edit_table .control-label {
        text-align: left !important;
    }

    #dict_edit_table input ,#dict_edit_table select{
        margin-left: -45px;
    }
    
    #dict_edit_table .row{
      margin-top: 15px!important;
    }

</style>
<div class="wrapper wrapper-content animated fadeInRight">
<!--数据列表-->
<div class="row" style="margin-right: 0!important;">

    <div class="col-sm-3">
        <div class="portlet box green-haze" style="padding: 15px">
            <div class="portlet-body" id="categoryTree"></div>
        </div>
    </div>

    <div class="col-sm-9">
    	<div id="goodsToolbar" role="group">
    		<!-- 查询条件 -->
    		<!-- <div class="container-fluid">
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
    		</div> -->
	    </div>
	    
        <table class="table" id="goodsTable" data-mobile-responsive="true">
        </table>
    </div>
</div>

	
</div>
<script src="${rc.contextPath}/js/plugins/jsTree/jstree.min.js" type="text/javascript"></script>
<script src="${rc.contextPath}/js/plugins/iTable/iTable.js" type="text/javascript"></script>
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
	                return table.dt_edit_button(row) 
			           	   + table.dt_detail_button(row) 
			           	   + table.dt_delete_button(row);
	            }
	        }];
	
	    return c;
	}
	
	var table = $("#goodsTable").iTable({
		toolbar: {
			id: "goodsToolbar",
			auto: true,
		},
		table : {
			data: {
	    		columns : getcolumns()
	    	}
		}
	});

    var form = $('#categoryForm'), id = 0, pid = 0, text;
    $("#categoryTree").jstree({
        "core": {
            "animation": 0,
            "themes": {
                theme: "classic",
                "dots": true,
                "icons": true
            },
            "check_callback": true,
            'data': ${categoryTrees!''}
        },
        "types": {
            "default": {
                "valid_children": ["default", "file"]
            }
        },
        "plugins": ["types", "wholerow"]
    }).on("select_node.jstree", function (node, selectd) {
        id = selectd.node.id;
        pid = selectd.node.parent;
        text = selectd.node.text;
        if (id) {
            $.ajax({
                url: '${rc.requestUri}/select/' + id,
                type: 'GET',
                success: function (obj) {
                    var data = obj.goods;
                }
            });
        }
    });
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: false,
        rules: {
            name: {
                minlength: 2,
                maxlength: 50,
                required: true
            },
            icon: {
                required: true
            },
            number: {
                required: true
            },
            invalid: {
                required: true
            }
        },
        invalidHandler:function(event,validator){
            error.show();
        },
        highlight:function(element){
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight:function(element){
            $(element).closest('.form-group').removeClass('has-error');
        },
        success:function(label){
            label.closest('.form-group').removeClass('has-error');
        },
        submitHandler:function(form){
            error.hide();
            form.submit();
        }
    });

    /**
     * 提示信息显示
     * */
    jQuery(function ($) {
        var message = "${message}";
        if (null == message || '' == message) {
            $(".alert").alert('close');
        } else {
            $('#message').addClass('alert-success');
            $('#message').removeClass('alert-danger');
            setInterval(alertClose, 3 * 1000);
        }
    });

    /**
     * 关闭提示信息
     * */
    function alertClose() {
        $(".alert").alert('close');
    }
    
    
</script>

