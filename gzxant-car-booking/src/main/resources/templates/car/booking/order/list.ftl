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
								    <label for="order_state_select" class="control-label">订单状态</label>
								    <select class="form-filter form-control _search" id="order_state_select" name="search_eq_order_state">
								    	<option value="">请选择</option>
								    	<#if orderStates??>
								    	<#list orderStates as state>
								    	<option value="${state.jkey}">${state.jvalue}</option>
								    	</#list>
								    	</#if>
								    </select>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="number_input" class="control-label">订单编号</label>
								    <input type="text" class="form-filter form-control _search" id="number_input" name="search_like_number"  />
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="city_input" class="control-label">用车城市</label>
								    <input type="text" class="form-filter form-control _search" id="city_input" name="search_like_city"  />
								</div>
								<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
								    <label for="guest_phone_input" class="control-label">客人联系方式</label>
								    <input type="text" class="form-filter form-control _search" id="guest_phone_input" name="search_like_guest_phone"  />
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
                title: '订单编号' // 列标题
            },
            {
                title: '订单类型',
                field: 'orderType',
                align: 'center'
            },
            {
                field: 'productType',
                title: '产品类型'
            },
            {
                field: 'carType',
                title: '车型类型'
            },
            {
                field: 'city',
                title: '用车城市'
            },
            {
                field: 'useTime',
                title: '用车时间'
            },
            {
                field: 'bookingTime',
                title: '预定时间'
            },
            {
                field: 'orderState',
                title: '订单状态'
            },
            {
                field: 'payState',
                title: '收银状态'
            },
            {
                field: 'remark',
                title: '备注'
            }];

        return c;
    }

    load_data( getcolumns(), {});
</script>
