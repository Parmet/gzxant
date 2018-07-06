	// 数据
	var info = {
		id: "",
		data: {
			"name": "",
			"englishName": "",
			"number": "",
			"category": "",
			"type": "",
			"replaceStandard": "",
			"importStandard": "",
			"pdfUrl": "",
			"txtUrl": "",
			"imgsPath": "",
			"pageSize": "",
			"publishDate": "",
			"uploadDate": "",
			"implementDate": ""
		},
		get : function () {
			var _this = this;
			var info = {
				"name": $('[name=name]').val().trim(),
				"englishName": $('[name=englishName]').val().trim(),
				"number": $('[name=number]').val().trim(),
				"category": $('[name=category]').val().trim(),
				"type": $('[name=type]').val().trim(),
				"replaceStandard": _this.getReplaceStandard(),
				"importStandard": _this.getImportStandard(),
				"publishDate": $('[name=publishDate]').val().trim(),
				"implementDate": $('[name=implementDate]').val().trim()
			};
			
			var data = $.extend(true, {}, this.data, info);
			return data;
		}, 
		check : function (info) {
			if (!info_validate.form()) {
				return false;
			}
			
			if (!info) {
				info = this.get();
			}
			
			if (!code.checkFormat(info.number) 
				|| !code.checkExists(info.number)) {
				return false;
			}
			
			if (info.pdfUrl == "") {
				layer.msg("请上传PDF文件");
				return false;
			}
			
			if (info.txtUrl == "") {
				layer.msg("PDF文件解析错误，请重新上传PDF文件");
				return false;
			}
			
			return true;
		},
		save : function (btn_obj) {
			var load_index = layer.load(1, {shade: [0.8, '#000']});
			var data = this.get();
			if (!this.check(data)) {
				layer.close(load_index);
				return ;
			}
			
			//data = JSON.stringify(data);
			console.log(data);
			
			$.ajax({
			    type: 'POST',
			    url: base_url + "/back/standard/",
			    async: true,
			    data: data,
			    dataType: "json",
			    success: function (data) {
			    	if (data.code == 200) {
			    		layer.close(load_index);
			    		info.id = data.message;
				    	layer.msg("保存成功");
				    	$("#info_form").find("input,radio,select").attr("disabled", "disabled");
				    	$("#info_form").find("a").remove();
				    	$(btn_obj).remove();
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
		},
		update : function (btn_obj) {
			var _this = this;
			var load_index = layer.load(1, {shade: [0.8, '#000']});
			var data = this.get();
			if (!this.check(data)) {
				return ;
			}
			
			data = JSON.stringify(data);
			console.log(data);
			
			$.ajax({
			    type: 'PUT',
			    url: base_url + "/back/standard/" + _this.id,
			    async: true,
			    data: {
			    	data: data
			    },
			    success: function (data) {
			    	if (data.code == 200) {
			    		layer.close(load_index);
			    		standard_id = data.message;
				    	layer.msg("保存成功");
				    	//changeInfoBtn(btn_obj, "CREATE");
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
		},
		getReplaceStandard : function () {
			var input = $("#replace_table").find("input");
			var stanards = "";
			input.each(function (index, item) {
				if ($(item).val().trim() != "") {
					stanards = stanards + $(item).val() + ",";
				}
			});
			
			return stanards;
		},
		getImportStandard : function () {
			var input = $("#import_table").find("input");
			var stanards = "";
			input.each(function (index, item) {
				if ($(item).val().trim() != "") {
					stanards = stanards + $(item).val() + ",";
				}
			});
			
			return stanards;
		}
	}
	
	var code = {
		checkFormat : function (number) {
			if (!number) {
				number = $("[name=number]").val().trim();
			}
			
			if (number == "") {
				return true;
			}
			
			var regExp = new RegExp("^GB(\/T)? [0-9]+\.?[0-9]+(\-[0-9]+\.?[0-9]+)?$");
			if (!regExp.test(number)) {
			　　return false;
			}
			
			return true;
		}, 
		checkExists : function () {
			var number = $("[name=number]").val().trim();
			if (number == "") {
				layer.alert("请输入标准编号！");
				return false;
			}
			
			var flag = false;
			if (this.checkFormat(number)) {
				$.ajax({
					type: 'GET',
				    url: base_url + "/back/standard/check/" + number,
				    async: false,
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
	}
	
	var tech = {
		get : function () {
			var _this = this;
			var techs = [];
			var tech_divs = $("#tech_box").children();
			tech_divs.each(function(index, tech_div) {
				var tech_name = $(tech_div).find(".panel-heading").find("input").val().trim();
				if (tech_name != "") {
					techs.push({
						"name": tech_name,
						"subs": _this.getSub(tech_div)
					});
				}
			});
			
			return techs;
		}, 
		save : function () {
			var load_index = layer.load(1, {shade: [0.8, '#000']});
			var data = this.get();
//			data = JSON.stringify(data);
			console.log(data);
			
			$.ajax({
			    type: 'POST',
			    url: base_url + "/back/standard/tech/",
			    async: true,
			    data: {
			    	data: data
			    },
			    success: function (data) {
			    	if (data.code == 200) {
			    		layer.close(load_index);
			    		info.id = data.message;
				    	layer.msg("保存成功");
				    	$("#info_form").find("input,radio,select").attr("disabled", "disabled");
				    	$("#info_form").find("a").remove();
				    	$(btn_obj).remove();
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
		},
		getSub : function (obj) {
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
	}
	
	var item = {
		get : function (box_obj) {
			if ($(box_obj).length <= 0) {
				return null;
			}
			
			var _this = this;
			var items = [];
			var item_divs = $(box_obj).children();
			item_divs.each(function(index, item_div) {
				var item_name = $(item_div).find(".panel-heading").find("input").val().trim();
				if (item_name != "") {
					items.push({
						"name": item_name,
						"subs" : _this.get($(box_obj).find("#item-sub-box")), 
						"materials": _this.getMaterial(item_div), 
						"equipments": _this.getEquipment(item_div)
					});
				}
			});
			
			return items;
		},
		getMaterial : function (item_div) {
			var subs = [];
			var materials = $(item_div).children("table").find('input[data-name="material_name"]');
			materials.each(function(index, item) {
				if ($(item).val().trim() != "") {
					subs.push({
						"name": $(item).val().trim(),
						"type": "M", // M: 耗材， E：设备
						"remark": $(item).parent("td").next().children("input").val().trim()
					});
				}
			});
			
			return subs;
		},
		getEquipment : function (item_div) {
			var subs = [];
			var equipments = $(item_div).children("table").find('input[data-name="equipment_name"]');
			equipments.each(function(index, item) {
				if ($(item).val().trim() != "") {
					subs.push({
						"name": $(item).val().trim(),
						"type": "E", // M: 耗材， E：设备
						"remark": $(item).parent("td").next().children("input").val().trim()
					});
				}
			});
			
			return subs;
		}
	}
	
	// 页面交互
	var txt = {
		deal : function () {
			if (!txt_url) {
				layer.alert("请上传PDF文件！");
				return ;
			}
			
			var _this = this;
			var load_index = layer.load(1, {shade: [0.8, '#000']});
			$.ajax({
				type: 'PUT',
			    url: base_url + "/back/standard/update/txt",
			    async: true,
			    data: {
			    	txtUrl : txt_url,
			    	imgsPath: imgs_path,
			    	pageSize: page_size
				},
			    success: function (data) {
			    	if (data.code != 200) {
			    		layer.close(load_index);
			    		layer.alert("乱码处理失败，请重试！");
			    	} else {
			    		_this.load(data.message);
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
		},
		load : function (txts) {
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
			
			$("#txt_box").html(html);
		},
		click : function (obj) {
			var checkbox_dom = $(obj).prev(":checkbox")
			if (checkbox_dom.is(':checked')) {
				checkbox_dom.removeAttr("checked");
			} else {
				checkbox_dom.prop("checked", true);
			}
		},
		get : function () {
			var txt = "";
			var check_input = $("#txt_box").find("input[type='checkbox']:checked");
			check_input.each(function(index, item){
				txt = txt + $(item).val();
			});
			
			check_input.attr("checked", false);
			return txt;
		}
	}

	var tr = {
		add : function (obj) {
			var tr_dom = $(obj).parent("td").parent("tr");
			tr_dom = tr_dom.after(tr_dom.clone(true));
			var copy_tr_dom = tr_dom.next();
			copy_tr_dom.find("input").val("");
			$(obj).parent().html('<a style="color:red;" onclick="tr.remove(this)"><span class="glyphicon glyphicon-remove"></span></a>');
		},
		remove : function (obj) {
			$(obj).parent("td").parent("tr").remove();
		}
	}

	var panel = {
		page : 0,
		init : function () {
			$("#standardTab li a").click(function() {
				return false;
			});
		},
		next : function () {
			this.page = this.page + 1;
			this.change();
		}, 
		last : function () {
			this.page = this.page - 1;
			this.change();
		},
		change : function () {
			$('#standardTab li:eq(' + this.page + ') a').tab('show');
		},
		back : function () {
			layer.confirm('是否确定返回', {
	    		yes: function(index, layero){
	    			window.location.href = url.split("jcreate")[0];
	    		}
	    	});
		}
	}

	var item_box = {
		add : function (obj) {
			var box = $(obj).parent("div").parent("div");
			box = box.after(box.clone(true));
			var copy_box = box.next();
			copy_box.find("input").val("");
			copy_box.find(".panel").each(function(index, item){
				if (index > 0) {
					$(item).remove();
				}
			});
			copy_box.find("span.glyphicon-remove").each(function(){
				$(this).parent("a").parent("td").parent("tr").remove();
			});
			
			copy_box.find(":hidden").show();
			copy_box.find(".glyphicon-chevron-down").attr("class", "glyphicon glyphicon-chevron-up");
		},
		remove : function (obj) {
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
		}, 
		change : function (obj) {
			var item_body = $(obj).parent().nextAll();
			var display_val = item_body.css("display");
			if (display_val == 'none') {
				item_body.show();
				$(obj).children("span").attr("class", "glyphicon glyphicon-chevron-up");
			} else {
				item_body.hide();
				$(obj).children("span").attr("class", "glyphicon glyphicon-chevron-down");
			}
		}
	}
	
	var progress = {
		t : null,
		num : 0,
		init : function () {
			var _this = this;
			$.fn["progress"] = function (tar) {
				_this.load(tar, this);
			}
		},
		load : function (tar, obj) {
			var _this = this;
			clearTimeout(_this.t);
			if (tar == 0) {
				$(obj).css("width", "0%");
	        	$(obj).html("0%");
			}
			
			if (_this.num < 0 || _this.num > 100) {
	    		return ;
	    	}
	    	
	    	if (_this.num === tar) {
	    		clearTimeout(_this.t);
	            return;
	        } 
	    	
	        _this.t = setTimeout(function() {
	        	$(obj).css("width", _this.num + "%");
	        	$(obj).html(_this.num + "%");
	        	_this.num = _this.num + 1;
	        	_this.load(tar, obj);
	        }, 300);
		}
	}

	// 初始化
	panel.init();
	progress.init();

	// 表单校验
	jQuery.validator.addMethod("checkNumber", function (value, element, param) {
		return code.checkFormat(value);
	}, "请输入正确的编号格式！正确格式为：GB 2757-2012 或  GB/T 5413.34-2010");
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
	
	// 图片上传
	Dropzone.autoDiscover = false;
	var licenseDropzone = new Dropzone("div#pdfDropzone", {
		url : base_url + "/file/upload/pdf",
		filesizeBase : 1024,// 定义字节算法 默认1000
		maxFiles : 2,// 最大文件数量
		maxFilesize : 200, // MB
		fallback : function() {
			layer.alert('暂不支持您的浏览器上传!');
		},
		uploadMultiple : false,
		addRemoveLinks : true,
		acceptedFiles : "application/pdf",
		dictDefaultMessage : '点击上传标准',
		dictFileTooBig : '您的文件超过' + 100 + 'MB!',
		dictInvalidInputType : '不支持您上传的类型',
		dictMaxFilesExceeded : '您的文件超过1个!',
		init : function() {
			this.on('queuecomplete', function(files) {
				// layer.alert('上传成功');
			});
			
			this.on('success', function(uploadimfo, result) {
				$("#importProgress").progress(100);
				$("#txt_box").html("");
				$("#txt_box").html("PDF上传成功，拼命解析中&nbsp;<img src='" + base_url + "/img/loading-upload.gif' style='width:auto;' />");
				$("#pdf_box").html("");
				$("#pdf_box").html("PDF上传成功，拼命解析中&nbsp;<img src='" + base_url + "/img/loading-upload.gif' style='width:auto;' />");
				
				info.data.pdfUrl = result.message[0].url;
				info.data.uploadDate = result.message[0].date;
				
				$.ajax({
				    type: 'POST',
				    url: base_url + "/back/standard/import",
				    async: true,
				    data: {
						pdfUrl : result.message[0].url
					},
				    success: function (data) {
						if (data.code == 200) {
							info.data.txtUrl = data.message.txtPath;
							var txts = data.message.txts;
							var imgs = data.message.imgs;
							var html = "";
							
							txt.load(txts);
							if (imgs.length > 0) {
								info.data.imgsPath = imgs[0].substring(0, imgs[0].indexOf('0.jpg'));
								info.data.pageSize = imgs.length;
							}
							
							html = "";
							$.each(imgs, function (index, item){
								html = html + '<div class="row">';
								html = html + '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">';
								html = html + '<img src="' + base_url + '/file/image?path=' + encodeURIComponent(item) + '" />'; //
								html = html + '</div>';
								html = html + '</div>';
							});
							
							$("#pdf_box").html(html);
							$("#importProgress").progress(101);
							layer.msg("解析成功，结果仅供参考");
						} else {
							layer.msg("PDF文件解析错误，请重新上传PDF文件");
							$("#txt_box").html("PDF文件解析错误，请重新上传PDF文件!");
							$("#pdf_box").html("PDF文件解析错误，请重新上传PDF文件!");
						}
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						$("#txt_box").html("PDF文件解析错误，请重新上传PDF文件!");
						$("#pdf_box").html("PDF文件解析错误，请重新上传PDF文件!");
			            layer.alert(XMLHttpRequest.responseJSON.error);
			        }
				});
			});
			
			this.on('error', function(a, errorMessage, result) {
				if (!result) {
					layer.alert(result.error || '上传失败');
				}
			});
			
			this.on('maxfilesreached', function() {
				this.removeAllFiles(true);
				$("#txt_box").html("请上传PDF文件");
				$("#pdf_box").html("请上传PDF文件");
				$("#importProgress").progress(0);
				layer.alert('文件数量超出限制');
			});
			
			this.on('removedfile', function() {
				$("#txt_box").html("请上传PDF文件");
				$("#pdf_box").html("请上传PDF文件");
				info.data.pdfUrl = result.message[0].url;
				$("#importProgress").progress(0);
				layer.alert('删除成功');
				window.location.reload();
			});
		}
	});
	
	// 页面其他方法
	function checkNumberByObj(obj) {
		if (!code.checkFormat($(obj).val().trim())) {
			layer.msg("编号：’" + $(obj).val().trim() + "‘，格式错误，请检查!");
			$(obj).focus();
		}
	}
	
	function infoNextStep() {
		if (info_validate.form()) {
			if (info.id == "") {
				layer.msg("请保存信息！");
				return ;
			}

			panel.next();
		}
	}
	
	function saveStandard() {
		var load_index = layer.load(1, {shade: [0.8, '#000']});
		var data = {
			"name": $('[name=name]').val().trim(),
			"englishName": $('[name=englishName]').val().trim(),
			"number": $('[name=number]').val().trim(),
			"category": $('[name=category]').val().trim(),
			"type": $('[name=type]').val().trim(),
			"replaceStandard": getReplaceStandard(),
			"importStandard": getImportStandard(),
			"pdfUrl": $("#uploadUrl").val().trim(),
			"txtUrl": txt_url,
			"imgsPath": imgs_path,
			"pageSize": page_size,
			"publishDate": $('[name=publishDate]').val().trim(),
			"uploadDate": upload_date,
			"implementDate": $('[name=implementDate]').val().trim(),
			"techs": getTechs(),
			"items": getItems($("#item-box"))
		};
		
		data = JSON.stringify(data);
		console.log(data);
		layer.close(load_index);
		return ;
		
		if (!checkNumber(data.number) 
			|| !checNnumberExists(data.number)) {
			layer.close(load_index);
			return ;
		}
		
/* 		if (data.items.length <= 0) {
			layer.close(load_index);
			layer.msg("请填写检测项信息");
			return ;
		}
 */		
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
		    url: base_url + "/back/standard/create",
		    async: true,
		    data: {
		    	data: data
		    },
		    success: function (data) {
		    	if (data.code == 200) {
			    	layer.msg("保存成功");
			    	window.location.href = url.split("import")[0];
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
    
	function addTxt(obj) {
		var _txt = txt.get();
		if (_txt != "") {
			$(obj).val(_txt);
		}
	}