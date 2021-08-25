$(document)
		.ready(
				function(e) {

					if ($("#message").val()) {
						console.log("swal");
						swal("", $("#message").val(), "success");
					}
					if ($("#errorMsg").val()) {
						console.log("swal");
						swal("", $("#errorMsg").val(), "warning");
					}

					var errors = 0;
					$("#save-fundraiser").click(
							function(e) {
								e.preventDefault();
								checkFundraiserSetupValid();
								console.log(errors);
								if (errors == 0) {
									$("#frmFundraiser").attr('action',
											'fundraiserManage.html');
									$("#frmFundraiser").submit();
								}
							});

					function checkFundraiserSetupValid() {
						errors = 0;
						var nameErr = checkField("Name", $("#name").val(),
								true, null, null, null);
						var phoneNoErr = checkField("Phone No", $("#phoneNo")
								.val(), true, null, null, null);
						var amountErr = checkField("Amount",
								$("#amount").val(), true, null, null, 'n');
						if (nameErr) {
							$("#nameErrMsg").text(nameErr);
							errors = 1;
						}

						if (phoneNoErr) {
							$("#phoneNoErrMsg").text(phoneNoErr);
							errors = 1;
						}
						if (amountErr) {
							$("#amountErrMsg").text(amountErr);
							errors = 1;
						} else if ($("#amount").val() <= 0) {
							$("#amountErrMsg").text(
									"Amount must be greater than zero");
							errors = 1;
						}

					}

					$("#fundraiser-search").click(
							function(e) {
								$('#pageNo').val(1);
								$("#frmfundraiserSearch").attr('action',
										'fundraiserSearch.html');
								$("#frmfundraiserSearch").submit();
							});

				});