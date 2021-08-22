$(document).ready(function(){
	
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