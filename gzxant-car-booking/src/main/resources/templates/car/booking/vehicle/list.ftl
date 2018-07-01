<div class="wrapper animated fadeInRight">
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
								    <label for="number_input" class="control-label">车辆编号</label>
								    <input type="text" class="form-filter form-control _search" id="number_input" name="search_like_number"  />
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="city_input" class="control-label">车牌号码</label>
								    <input type="text" class="form-filter form-control _search" id="city_input" name="search_like_licensePlate"  />
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="name_input" class="control-label">品牌</label>
								    <input type="text" class="form-filter form-control _search" id="name_input" name="search_like_brands"  />
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="phone_input" class="control-label">车型</label>
                                    <select class="form-filter form-control _search" id="order_state_select" name="search_eq_order_state">
                                        <option value="">请选择</option>
								    	<#if orderStates??>
                                            <#list orderStates as state>
								    	<option value="${state.jkey}">${state.jvalue}</option>
                                            </#list>
                                        </#if>
                                    </select>
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

<script type="text/javascript">

    function getcolumns() {
        var c = [
            {
                field: 'number', // 列字段名
                align: 'center',
                title: '车辆编号' // 列标题
            },
            {
                title: '车牌号码',
                field: 'licensePlate',
                align: 'center'
            },
            {
                field: 'color',
                align: 'center',
                title: '车辆颜色'
            },
            {
                field: 'type',
                align: 'center',
                title: '车型'
            },
            {
                field: 'vehicleCount',
                align: 'center',
                title: '座位数'
            },
            {
                field: 'luggageCount',
                align: 'center',
                title: '行李数'
            },
            {
                field: 'city',
                align: 'center',
                title: '服务城市'
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
</script>
