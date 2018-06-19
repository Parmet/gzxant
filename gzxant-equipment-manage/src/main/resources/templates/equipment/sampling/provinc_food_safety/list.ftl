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

    <#--<div class="col-sm-2">-->
        <#--<div type="hidden" class="portlet box green-haze" style="padding: 15px">-->
            <#--<div class="portlet-body" id="samplingType"></div>-->
        <#--</div>-->
    <#--</div>-->

    <div class="col-sm-12">
    	<div class="col-sm-12">
	        <div class="ibox">
	            <div class="ibox-body">
			    	<div id="standardToolbar" role="group">
			    		<#--<input type="hidden" class="form-filter form-control _search" id="path" name="search_like_category_path" value="0." />-->
			    		<#--<input type="hidden" class="form-filter form-control _search" id="del-flag" name="search_eq_del_flag" value="Y"  />-->
			    		<div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="numberInput" class="control-label">标称生产企业名称</label>
                                <input type="text" class="form-filter form-control _search" id="numberInput" name="search_like_enterprise_name"  />
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                <label for="nameInput" class="control-label">食物名称</label>
                                <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_food_name"  />
                            </div>
                        </div>
                            <div class = "row">
                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="type_input" class="control-label">抽检类型&nbsp;</label>
                                    <select id="type_input" name="search_eq_sampling_type" class="select2 _search" style="width:100%;">
                                        <option value="">请选择</option>
                                        <option value="国家食品安全监督抽检(合格)">国家食品安全监督抽检(合格)</option>
                                        <option value="国家食品安全监督抽检(不合格)">国家食品安全监督抽检(不合格)</option>
                                    </select>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="type_input" class="control-label">食品类型&nbsp;</label>
                                    <select id="type_input" name="search_eq_food_type" class="select2 _search" style="width:100%;">
                                        <option value="">请选择</option>
		  								<#list foodType as type>
		  									<option value="${type.jvalue}">${type.jvalue}</option>
										</#list>
                                    </select>
                                </div>
                            </div>
			    	</div>
			    	
			    	<table class="table" id="standardTable" data-mobile-responsive="true">
					</table>
			    </div>
		    </div>
	    </div>
    </div>
</div>

	
</div>
<script src="${rc.contextPath}/js/plugins/jsTree/jstree.min.js" type="text/javascript"></script>
<script src="${rc.contextPath}/js/plugins/iTable/iTable.js" type="text/javascript"></script>
<script type="text/javascript">
	function getColumns() {
	    var c = [
	        {
	            checkbox: true
	        },
	        {
	            field: 'enterpriseName',
	            title: '标称生产企业名称',

	        },
	        {
	            field: 'announcementNumber',
	            title: '公告号'
	        },
	        {
	            field: 'foodName',
	            title: '食品名称',
	            // formatter: function (value, row, index) {
	            // 	return value.split(" ")[0];
	            // }
	        },
	        {
	            field: 'foodType',
	            title: '分类',
	            // formatter: function (value, row, index) {
	            // 	return value.split(" ")[1];
	            // }
	        },
	        {
	            field: 'province',
	            title: '省份'
	        },
	        {
	            field: 'produceDate',
	            title: '生产日期',

	        },

	        {
	            field: 'id',
	            title: '操作',
	            align: 'center',
                formatter: function (value, row, index) {
                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
	        }];
	
	    return c;
	}
	
	function updateStandard(id) {
		window.location.href = url + "jupdate/" + id;
	}
	
	var standardTable = $("#standardTable").iTable({
		toolbar : {
			id : "standardToolbar",
			auto : true,
			exclude_btn : ["dt_insert"],
			include_btn : [
				{
					id : "btn_import",
					className : "btn-info",
					icon : "glyphicon glyphicon-cloud-upload",
					title : "导入",
					click: function() {
						window.location.href = url + "import";
				    }
				}
			]
		},
		data : {
			columns : getColumns()
		}
	});

    <#--$("#samplingType").jstree({-->
        <#--"core": {-->
            <#--"animation": 0,-->
            <#--"themes": {-->
                <#--theme: "classic",-->
                <#--"dots": true,-->
                <#--"icons": true-->
            <#--},-->
            <#--"check_callback": true,-->
            <#--'data': ${samplingTypes!''}-->
        <#--},-->
        <#--"types": {-->
            <#--"default": {-->
                <#--"valid_children": ["default", "file"]-->
            <#--}-->
        <#--},-->
        <#--"plugins": ["types", "wholerow"]-->
    <#--}).on("select_node.jstree", function (node, selectd) {-->
        <#--id = selectd.node.id;-->
        <#--pid = selectd.node.parent;-->
        <#--text = selectd.node.text;-->
        <#--$('#path').val(id + ".");-->
        <#--standardTable.re_load();-->
    <#--});-->
    
</script>

