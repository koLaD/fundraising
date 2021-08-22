$(document).ready(
		function(e) {

			// for banner image
			$("#projectImageFile").change(
					function(e) {
						e.preventDefault();
						console.log(this);
						$(".project-image").hide();
						$(".custom-file-label").text("program_image.jpg");
						$(".project-image-preview").addClass(
								"img-fluid img-thumbnail");
						readURL(this, $(".project-image-preview"));
					});

			var errors = 0;
			$("#save-project").click(function(e) {
				e.preventDefault();
				checkProjectSetupValid();
				console.log(errors);
				if (errors == 0) {
					$("#frmProject").attr('action', 'projectManage.html');
					$("#frmProject").submit();
				}
			});

			function checkProjectSetupValid() {
				errors = 0;
				var titleErr = checkField("Title", $("#title").val(), true,
						null, null, null);
				var descErr = checkField("Description", $("#desc").val(), true,
						null, null, null);
				var shortDescErr = checkField("Short Description", $(
						"#shortDesc").val(), true, null, null, null);
				var projectStatusErr = checkField("Project Status", $(
						"#projectStatus-select").val(), true, null, null, 's');
				var goalAmountErr = checkField("Goal Amount", $("#goalAmount")
						.val(), true, null, null, 'n');
				if (titleErr) {
					$("#titleErrMsg").text(titleErr);
					errors = 1;
				}

				if (descErr) {
					$("#descErrMsg").text(descErr);
					errors = 1;
				}
				if (shortDescErr) {
					$("#shortDescErrMsg").text(shortDescErr);
					errors = 1;
				}
				if (projectStatusErr) {
					$("#projectErrMsg").text(projectStatusErr);
					errors = 1;
				}
				if (goalAmountErr) {
					$("#goalAmountErrMsg").text(goalAmountErr);
					errors = 1;
				} else if ($("#goalAmount").val() <= 0) {
					$("#goalAmountErrMsg").text(
							"Goal Amount must be greater than zero");
					errors = 1;
				}

			}
		});