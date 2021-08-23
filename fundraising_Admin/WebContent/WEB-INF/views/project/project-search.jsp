<%@ include file="../../include/importTag.jsp"%>
<%@ include file="../../include/paginationjs.jsp"%>
<style>
.pagination_custom {
	margin: 0px !important;
}
</style>
<body>
	<div class="layout-content-body">
		<h5 class='breadScrum'>${activeMenuDesc}&nbsp&nbsp>>&nbsp&nbsp
			${activeSubMenuDesc}</h5>
		<div class="row">
			<div class="col-xs-12">
				<div class="card">
					<div class="card-header">
						<h4>
							<span class="d-ib">${pageTitle}</span>
						</h4>
					</div>
					<form:form cssClass="form form-horizontal" modelAttribute="projectDTO"
						id="frmProjectSearch" method="POST" action="projectSearch.html"
						enctype="multipart/form-data">
						<div class="col-xs-12">
							<div class="card"></div>
						</div>
					</form:form>
					<div class="card-body">
						<div class="row">
							<div class="col-xs-12">
								<hr />
								<span class='breadScrum'>${totalRecord}</span>
								<div class="table-flip-scroll">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>No</th>
												<th>Title</th>
												<th>Short Desc</th>
<!-- 												<th>Description</th> -->
												<th>Category</th>
												<th class="text-right">Goal Amount</th>
												<th>Project Status</th>
												<th>Created Date</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="project" items="${projectList}" varStatus="status">
												<tr>
													<td>${(rowPerPage *(page-1))+status.count}</td>
													<td>${project.title }</td>
													<td>${project.shortDescription }</td>
<%-- 													<td>${project.description }</td> --%>
													<td></td>
													<td class="text-right">${project.goalAmount }</td>
													<td>${project.projectStatus }</td>
													<td>${project.createdDate }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="row">
									<div class="pagination pagination_custom align-center"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	var pageCount = "${pageCount}";
	var page = "${page}";
	$('.pagination').twbsPagination({
		totalPages : pageCount,
		visiblePages : 5,
		next : 'Next',
		prev : 'Prev',
		startPage : parseInt(page),// active page
		initiateStartPageClick : false,
		onPageClick : function(event, page) {
			$('#pageNo').val(page);
			$('#frmProjectSearch').submit();
		}
	});
</script>