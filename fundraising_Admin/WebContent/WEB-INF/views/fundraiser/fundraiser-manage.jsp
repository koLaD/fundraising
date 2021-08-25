<%@ include file="../../include/importTag.jsp"%>
<script
	src="<%=request.getContextPath()%>/resources/plugins/jquery/js/jquery.min.js"></script>
<!-- <body> -->
<div class="row">
	<div class="col-sm-12">
		<div class="card">
			<div class="card-header">
				<h4>
					<span class="d-ib bccolor">${pageTitle}</span>
				</h4>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12">
						<form:form cssClass="form form-horizontal" modelAttribute="fundraiserDTO"
							id="frmFundraiser" method="POST" action="fundraiserSetup.html"
							enctype="multipart/form-data">
							<form:hidden path="id" value="${fundraiserDTO.id}" />
							<input type="hidden" id="message" value="${message }" />
							<input type="hidden" id="errorMsg" value="${errorMsg }" />
							<div class="col-md-6 row">
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="name">Name: </label>
									<div class="col-sm-8">
										<form:input path="name" class="form-control" id="name" />
										<div class="errMsg text-c-red" id="nameErrMsg"></div>
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="phoneNo">Phone No: </label>
									<div class="col-sm-8">
										<form:input path="phoneNo" class="form-control" id="phoneNo" />
										<div class="errMsg text-c-red" id="phoneNoErrMsg"></div>
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="amount">Amount: </label>
									<div class="col-sm-8">
										<form:input path="amount" type="number" step="any"
											class="form-control bg-white"
											onkeydown="return event.keyCode !== 69 && event.keyCode !== 189"
											id="amount" />
										<div class="errMsg text-c-red" id="amountErrMsg"></div>
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="address">Address : </label>
									<div class="col-sm-8">
										<form:textarea path="address" class="form-control"
											onkeyup="textAreaAdjust(this)" maxlength="2000" id="address" rows="2" />
										<div class="errMsg text-c-red" id="addressErrMsg"></div>
									</div>
								</div>
							</div>
							<div class="col-md-6 row">
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="projectStatus">Fund
										Project: </label>
									<div class="col-sm-8">
										<form:select path="projectDTO.id" class="form-control"
											id="project-select">
											<form:options items="${projectList }" itemLabel="title"
												itemValue="id" />
										</form:select>
										<div class="errMsg text-c-red" id="projectErrMsg"></div>
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-sm-4 control-label" for="remark">Remark: </label>
									<div class="col-sm-8">
										<form:textarea path="remark" class="form-control" id="remark"
											onkeyup="textAreaAdjust(this)" maxlength="8000" rows="3" />
										<div class="errMsg text-c-red" id="remarkErrMsg"></div>
									</div>
								</div>
								<div class="form-group form-group-md">
									<div class="col-sm-12">
										<button class="btn btn-sm btn-primary shadow" id="save-fundraiser"
											name="fundraiser" style="margin-left: 15px; float: right">Save</button>
										<a href="fundraiserSearch.html" style="float: right"
											class="btn btn-sm btn-warning shadow"> Search</a>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	function textAreaAdjust(o) {
		o.style.height = "1px";
		o.style.height = (o.scrollHeight) + "px";
	}
</script>
