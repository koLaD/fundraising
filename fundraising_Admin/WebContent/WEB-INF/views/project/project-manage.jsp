<%@ include file="../../include/importTag.jsp"%>
<script
	src="<%=request.getContextPath()%>/resources/plugins/jquery/js/jquery.min.js"></script>
<style>
.img-thumbnail {
	max-height: 180px !important;
}

.card-header {
	text-align: center;
}

.breadScrum {
	color: #0288d1
}
</style>
<body>
	<c:if test="${ not empty message }">
		<div class="alert alert-info alert-dismissible mr-3" style="margin-top: 7px;">
			<button class="close" aria-hidden="true" data-dismiss="alert" type="button">x</button>${message}
		</div>
	</c:if>
	<c:if test="${ not empty errorMsg }">
		<div class="alert alert-danger alert-dismissible mr-3"
			style="margin-top: 7px;">
			<button class="close" aria-hidden="true" data-dismiss="alert" type="button">x</button>${errorMsg}
		</div>
	</c:if>
	<div class="layout-content-body">
		<h5 class='breadScrum'>${activeMenuDesc} &nbsp&nbsp   >> &nbsp&nbsp   ${activeSubMenuDesc}</h5>
		<div class="row">
			<div class="col-sm-12">
				<div class="card">
					<div class="card-header">
						<h4>
							<span class="d-ib">${pageTitle}</span>
						</h4>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-12">
								<form:form cssClass="form form-horizontal" modelAttribute="projectDTO"
									id="frmProject" method="POST" action="projectSetup.html"
									enctype="multipart/form-data">
									<form:hidden path="id" value="${projectDTO.id}" />
									<input type="hidden" id="successMsg" value="${successMsg }" />
									<input type="hidden" id="errorMsg" value="${errorMsg }" />
									<div class="col-md-6 row">
										<div class="form-group form-group-md">
											<label class="col-sm-4 control-label" for="title">Title: </label>
											<div class="col-sm-8">
												<form:input path="title" class="form-control" id="title" />
												<div class="errMsg text-c-red" id="titleErrMsg"></div>
											</div>
										</div>
										<div class="form-group form-group-md">
											<label class="col-sm-4 control-label" for="shortDescription">Short
												Description: </label>
											<div class="col-sm-8">
												<form:textarea path="shortDescription" class="form-control"
													onkeyup="textAreaAdjust(this)" maxlength="2000" id="shortDesc"
													rows="3" />
												<div class="errMsg text-c-red" id="shortDescErrMsg"></div>
											</div>
										</div>
										<div class="form-group form-group-md">
											<label class="col-sm-4 control-label" for="description">Description:
											</label>
											<div class="col-sm-8">
												<form:textarea path="description" class="form-control" id="desc"
													onkeyup="textAreaAdjust(this)" maxlength="8000" rows="5" />
												<div class="errMsg text-c-red" id="descErrMsg"></div>
											</div>
										</div>
									</div>
									<div class="col-md-6 row">
										<div class="form-group form-group-md">
											<label class="col-sm-4 control-label" for="projectStatus">Project
												Status: </label>
											<div class="col-sm-8">
												<form:select path="projectStatus" class="form-control"
													id="projectStatus-select">
													<form:options items="${porjectStatusList }" itemLabel="description"
														itemValue="code" />
												</form:select>
												<div class="errMsg text-c-red" id="projectErrMsg"></div>
											</div>
										</div>
										<div class="form-group form-group-md">
											<label class="col-sm-4 control-label" for="goalAmount">Goal
												Amount: </label>
											<div class="col-sm-8">
												<form:input path="goalAmount" type="number" step="any"
													class="form-control bg-white"
													onkeydown="return event.keyCode !== 69 && event.keyCode !== 189"
													id="goalAmount" />
												<div class="errMsg text-c-red" id="goalAmountErrMsg"></div>
											</div>
										</div>
										<div class="form-group form-group-md">
											<label class="col-sm-4 control-label">Project Image :</label>
											<div class="custom-file col-sm-8">
												<input type="file" class="custom-file-input form-control"
													id="projectImageFile" name="projectImageFile" accept="image/*">
											</div>
										</div>
										<div class="form-group form-group-md">
											<div class="col-sm-4"></div>
											<div class="col-sm-8">
												<c:if test="${projectDTO.image != null }">
													<a href="${imagePath}${projectDTO.image}" data-lightbox="1"
														data-title="">
														<img class="img-fluid img-thumbnail project-image"
															src="${imagePath}${projectDTO.image}" alt="Project Image">
													</a>
												</c:if>
												<img class="project-image-preview">
											</div>
										</div>
										<div class="form-group form-group-md">
											<div class="col-sm-12">
												<button class="btn btn-sm btn-primary shadow" id="save-project"
													name="project" style="margin-left: 15px; float: right">Save</button>
												<a href="project-list.html" style="float: right"
													class="btn btn-sm btn-primary shadow"> Go To List</a>
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
	</div>
</body>
<script
	src="<%=request.getContextPath()%>/resources/js/project/project-manage.js"></script>
<script>
	function textAreaAdjust(o) {
		o.style.height = "1px";
		o.style.height = (o.scrollHeight) + "px";
	}
</script>
