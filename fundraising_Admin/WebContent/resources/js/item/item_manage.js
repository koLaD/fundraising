$(document).ready(function() {

	$("#new_color_section").click(function() {
		var colorSectionCount = $(".card").length;
		colorSectionCount = colorSectionCount - 2;
		console.log('>>>' + colorSectionCount);
		
		var color = {
			id : $("#color_section_id").children("option:selected").val(),
			name : $("#color_section_id").children("option:selected").text()
		}

		// size template
		var sizes = [];
		$.each($("#demo-select2-2 option:selected"), function() {
			var size = {
				id : $(this).val(),
				name : $(this).text()
			}
			sizes.push(size);
		});
		console.log(sizes);
		
		// check duplicated color template
		var duplicateColorTemplate = 0;
		$.each($("div .color_section_data"), function(i){
			console.log(">>> Current Div >>> " + $("#color_section_" + i).val());
			if(color.id == $(this).attr("data-color-tem-id")){
				duplicateColorTemplate = 1;
				return false;
			}
		});
		
		if(sizes.length > 0 && duplicateColorTemplate == 0){
			let color_section_div = '<div id="color_section_'+ colorSectionCount +'" class="card color_section_data" data-color-tem-id="'+ color.id+'">'
			+ '<div class="card-body">'
			+ '<div class="form-row">'
			+ '<div class="form-group col-md-6" id="color_name_data">'
			+ '<label for="colorName">Color Family :</label>'
			+ '<input type="hidden" name="prodcutColorList['+ colorSectionCount +'].colorTemplateId" value="'+ color.id +'"/>'
			+ '<input type="hidden" name="prodcutColorList['+ colorSectionCount +'].colorTemplateDTO.id" value="'+ color.id +'"/>'
			+ '<input type="hidden" name="prodcutColorList['+ colorSectionCount +'].colorTemplateDTO.name" value="'+ color.name +'"/>'
			+ '<input value="'+ color.name +'" class="form-control" autocomplete="off" readonly="readonly"/>'
			+ '<div class="errMsg" id="errMsg"></div>'
			+ '</div>'
			+ '</div>'
			+ '<div class="form-row">'
			+ '<div class="form-group col-md-12">'
			+ '<label for="itemImage">Item Image :  (750 x 680) </label>'
			+ '</div>'
			+ '</div>'
			+ '<div class="form-row">'
			+ '<div class="form-group col-md-2">'
			+ '<input name="prodcutColorList['+ colorSectionCount +'].mainImageFile" type="file" id="mainImageFile" accept="image/x-png, image/jpeg" />'
			+ '</div>'
			
			+ '<div class="form-group col-md-2">'
			+ '<input name="prodcutColorList['+ colorSectionCount +'].imageFile1" type="file" id="imageFile1" accept="image/x-png, image/jpeg" />'
			+ '</div>'
			
			+ '<div class="form-group col-md-2">'
			+ '<input name="prodcutColorList['+ colorSectionCount +'].imageFile2" type="file" id="imageFile2" accept="image/x-png, image/jpeg" />'
			+ '</div>'
			
			+ '<div class="form-group col-md-2">'
			+ '<input name="prodcutColorList['+ colorSectionCount +'].imageFile3" type="file" id="imageFile3" accept="image/x-png, image/jpeg" />'
			+ '</div>'
			
			+ '<div class="form-group col-md-2">'
			+ '<input name="prodcutColorList['+ colorSectionCount +'].imageFile4" type="file" id="imageFile4" accept="image/x-png, image/jpeg" />'
			+ '</div>'
			
			+ '</div>'
			+ '</div>'
			+ '</div>'
			
			
			$("#color_section_append").append(color_section_div);
		}
		
		var tableRow = '';
		var totalRowCount = $("#item_list_table tr").length;
		totalRowCount = totalRowCount - 1;
		console.log("table row >>>" + totalRowCount);
		let currentRowCount = totalRowCount == 0 ? 0 : totalRowCount;
		
		$.each(sizes, function(index, value) {
			console.log("current row >>>" + totalRowCount);
			let colorFamilyHtml = '<input type="text" name="itemList['+currentRowCount+'].color" value="'+color.name+'" class="form-control" readonly="readonly"/>';
			let colorFamilyId = '<input type="hidden" name="itemList['+currentRowCount+'].colorId" value="'+color.id+'"/>';
			let sizeHtml = '<input type="text" name="itemList['+currentRowCount+'].size" value="'+value.name+'" class="form-control" readonly="readonly"/>';
			let sizeId = '<input type="hidden" name="itemList['+currentRowCount+'].sizeId" value="'+value.id+'"/>';
			let nameHtml = '<input type="text" name="itemList['+currentRowCount+'].name" value="" class="form-control" required="required"/>';
			let codeNumberHtml = '<input type="text" name="itemList['+currentRowCount+'].codeNumber" value="" class="form-control" required="required"/>';
			let priceHtml = '<input type="number" name="itemList['+currentRowCount+'].sellPrice" value="" class="form-control" required="required"/>';
			let quantityHtml = '<input type="number" name="itemList['+currentRowCount+'].quantity" value="" class="form-control" required="required"/>';
			
			// check duplicate item row
			let duplicateRow = 0;
			$.each($("#item_list_table tr"), function(i){
				console.log(">>> TD Color >>> " + $(this).attr("data-color-id") +" >>> " + color.id);
				console.log(">>> TD Size >>> " + $(this).attr("data-size-id") + " >>> " + value.id);
				if(color.id == $(this).attr("data-color-id") && value.id == $(this).attr("data-size-id")){
					console.log(">>> Duplicate Row >>>");
					duplicateRow = 1;
					return false;
				}
			});
			
			if(duplicateRow == 0){
				console.log(">>> Create Row >>>");
				tableRow ='<tr id="item_row_'+currentRowCount+'" data-color-id="'+color.id+'" data-size-id="'+value.id+'">'
				+ '<td><span style="color:red;"> <i class="icon icon-trash-o icon-2x item_delete_modal" data-item-id="'+currentRowCount+'"></i></span></td>'
				+ '<td> <select name="itemList['+currentRowCount+'].status" class="form-control">'
				+ '<option value="1">Active</option>'
				+ '<option value="2">Inactive</option>'
				+ '</select>'
				+ '</td>'
				+'<td>'+ colorFamilyHtml +'</td>'
				+'<td>'+ sizeHtml +'</td>'
				+'<td>'+ nameHtml +'</td>'
				+'<td>'+ codeNumberHtml +'</td>'
				+'<td>'+ priceHtml +'</td>'
				+'<td>'+ quantityHtml +'</td>'
				+ '<td> <select name="itemList['+currentRowCount+'].isNewArrival" class="form-control">'
				+ '<option value="1">New Arrival</option>'
				+ '<option value="2">Not New Arrival</option>'
				+ '</select>'
				+ '</td>'
				
				+ colorFamilyId
				+ sizeId
				+ '</tr>'
				
				$("#item_list_table").append(tableRow);
			currentRowCount++;
			}
			
		});
	});
	
	$('input[type=radio][name=sizeTemplateId]').change(function() {
	    console.log(this.value);
	    var sizeTemplateId = this.value;
	    $.ajax({
			type : "POST",
			contentType : 'application/json',
			url : "getSizeTemplateItemList.json",
			dataType : 'json',
			async : true,
			data : sizeTemplateId,
			success : function(data) {
				$("#demo-select2-2").html("");
				var options = '';
				$.each(data, function(i, d) {
					options += '<option selected="selected" value="'+d.id+'">' + d.name+'</option>';
				});
				
				$('#demo-select2-2').html(options);
			},
			error: function() {
				var options = '';
				if(typeof sizeTemplateId !== 'undefined') {
					options += '<option value="-1">--All--</option>';
					$('#demo-select2-2').html(options);
				}
			}
		});
	});
	
	$("body").on("click", ".item_delete_modal", function(){
		console.log(">>> Delete Item Id >>> " + $(this).attr("data-item-id"));
		$("#item_delete").attr("data-item-del-id", $(this).attr("data-item-id"));
		$("#itemDeleteModal").modal('show');
	});

	$("#item_delete").click(function(){
		let item_id = $("#item_delete").attr("data-item-del-id") == '' ? 0 : $("#item_delete").attr("data-item-del-id");
		console.log("Item Id >>> " + item_id);
		if(item_id == 0){
			 $("#item_row_" + item_id).remove();
			createdToastr('success', 'Item record has been deleted successfully!', 'Success');
		}else{
			$.ajax({
				type : "POST",
				contentType : 'application/json',
				url : "delete_item.json",
				dataType : 'json',
				async : true,
				data : item_id,
				success : function(data) {
					if(data.successMessage == 'success'){
						 createdToastr('success', 'Item record has been deleted successfully!', 'Success');
						 $("#item_row_" + item_id).remove();
					}else{
						createdToastr('error', 'Cannot delete this item!', 'Fail');
					}
				},
				error: function() {
					createdToastr('error', 'Sorry, error occurred while processing remove item!', 'Fail');
				}
			});
		}
		
		
		
		$("#itemDeleteModal").modal('hide');
	});
	
	function createdToastr(desc, message, title){
		toastr.options = {
			"closeButton": true,
			"progressBar": true
		}
		toastr[desc](message, title);
	}
	
	var initSelectedValue = $('#item_template_select :selected');
	if(initSelectedValue.val() == 2){
		$("#size_chart_image").show();
	}else{
		$("#size_chart_image").hide();
	}
	
	$("#item_template_select").on("change", function(){
		let selectedValue = $('#item_template_select :selected');
		console.log(">>> Selected Value >>> " + selectedValue.val());
		if(selectedValue.val() == 2){
			$("#size_chart_image").show();
		}else{
			$("#size_chart_image").hide();
		}
	});
	
	
	$("#add_new_template_item").on("click", function(){
		if($("#tbody-template-item").length){
			$('#tbody-template-item').append(templateItemRow());
		}
	});
	
	// create new template item
	var templateItemRow = function() {
		var count = $('#tbody-template-item > tr').length;
		return '<tr>'
				+'<th class="col-1">'+(count + 1 )+'</td>'
				+ '<td class="col-3">'
				+ '<input name="sizeTemplateItemList['+count+'].name" class="form-control" type="text" required="required" />'
				+ '</td>'
				+ '<td class="col-5">'
				+ '<input name="sizeTemplateItemList['+count+'].description" class="form-control" type="text" required="required" />'
				+ '</td>'
				+ '<td class="col-1">'	
			    + '<a href="#" data-id="1" class="delete_template_item">'
			    + '<span class="text-danger icon icon-trash-o"></span></a></td>'
			    + '</tr>';
	};
	
	// remove size template item
	$(document).on('click', '.delete_template_item', function(){
		let count = $('#tbody-template-item > tr').length;
		if(count > 1){
			$(this).closest('tr').remove();
		}
	});

});