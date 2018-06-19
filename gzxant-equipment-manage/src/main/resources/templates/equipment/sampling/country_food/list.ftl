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
    <div class="col-sm-12">
    	<div class="col-sm-12">
	        <div class="ibox">
	            <div class="ibox-body">
			    	<div id="standardToolbar" role="group">
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
                                    <select id="type_input" name="search_eq_sampling_type" class="form-control _search" style="width:100%;">
                                        <option value="">请选择</option>
                                        <option value="国家食品安全监督抽检(合格)">国家食品安全监督抽检(合格)</option>
                                        <option value="国家食品安全监督抽检(不合格)">国家食品安全监督抽检(不合格)</option>
                                    </select>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label for="type_input" class="control-label">食品类型&nbsp;</label>
                                    <select id="type_input" name="search_eq_food_type" class="form-control _search" style="width:100%;">
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
	            title: '食品名称'
	        },
	        {
	            field: 'foodType',
	            title: '分类'
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
	
	var standardTable = $("#standardTable").iTable({
		toolbar : {
			id : "standardToolbar",
			auto : true
		},
		data : {
			columns : getColumns()
		}
	});

</script>

