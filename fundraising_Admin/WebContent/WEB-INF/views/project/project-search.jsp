<%@ include file="../../include/importTag.jsp"%>
<%@ include file="../../include/paginationjs.jsp"%>
<style>
.pagination_custom {
	margin: 0px !important;
}
</style>
<div class="row">
	<div class="col-xs-12">
		<div class="card">
			<div class="card-header">
				<h4>
					<span class="d-ib bccolor">${pageTitle}</span>
				</h4>
			</div>
			<div class="card-body">
				<form:form cssClass="form form-horizontal" modelAttribute="projectDTO"
					id="frmProjectSearch" method="POST" action="projectSearch.html"
					enctype="multipart/form-data">
					<form:hidden path="pageNo" id="pageNo" />
					<div class="row">
						<div class="col-xs-12">
							<div class="col-md-4">
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="title">Title: </label>
									<div class="col-sm-8">
										<form:input path="title" class="form-control" id="title" />
										<div class="errMsg text-c-red" id="titleErrMsg"></div>
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="projectStatus">Project
										Status: </label>
									<div class="col-sm-8">
										<form:select path="projectStatus" class="form-control"
											id="projectStatus-select">
											<form:option value="">All</form:option>
											<form:options items="${porjectStatusList }" itemLabel="description"
												itemValue="code" />
										</form:select>
										<div class="errMsg text-c-red" id="projectErrMsg"></div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label">Open From:</label>
									<div class=" form-group col-sm-8">
										<div class="input-with-icon">
											<form:input class="form-control" path="fromDate" type="text"
												data-provide="datepicker" data-date-today-highlight="true"
												data-date-format="dd/mm/yyyy" data-date-autoclose="true" />
											<span class="icon icon-calendar input-icon"></span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label">Open To:</label>
									<div class=" form-group col-sm-8">
										<div class="input-with-icon">
											<form:input class="form-control" path="toDate" type="text"
												data-provide="datepicker" data-date-today-highlight="true"
												data-date-format="dd/mm/yyyy" data-date-autoclose="true" />
											<span class="icon icon-calendar input-icon"></span>
										</div>
									</div>
								</div>
								<div class="form-group form-group-md"></div>
								<div class="form-group form-group-md">
									<div class="col-sm-12" style="text-align: right;">
										<button class="btn btn-sm btn-primary shadow" type="submit"
											id="project-search">Search</button>
										<a href="projectSearch.html" class="btn btn-sm btn-default shadow">
											Clear</a>
										<a href="projectManage.html" class="btn btn-sm btn-warning shadow">
											Add Project</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="col-md-12 row"></div>
				</form:form>
				<div class="row">
					<div class="col-xs-12">
						<hr />
						<span class='bccolor'>${totalRecord}</span>
						<div class="table-flip-scroll">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>No</th>
										<th>Title</th>
										<th class="text-right">Goal Amount</th>
										<th class="text-right">Donated Amount</th>
										<th>Project Status</th>
										<th>Open Date</th>
										<th>Edit</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="project" items="${projectList}" varStatus="status">
										<tr>
											<td width="5%">${(rowPerPage *(page-1))+status.count}</td>
											<td width="30%">${project.title }</td>
											<td class="text-right" width="10%">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${project.goalAmount }" />
											</td>
											<td class="text-right" width="12%">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${project.donatedAmount }" />
											</td>
											<td width="15%">
												<span
													class="${project.projectStatus == 'OPEN' ? 'label label-outline-info' : 'label label-outline-danger' }">${project.projectStatus }</span>
											</td>
											<td width="15%">${project.createdDate }</td>
											<td width="7%">
												<a href="projectManage.html?id=${project.id}" title="Details">
													<span class="icon icon-edit breadScrum"></span>
												</a>
											</td>
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