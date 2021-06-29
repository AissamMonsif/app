GET: $(document).ready(
		function() {

			$('#detailsTbl').hide();
			
			$("#MT103").click(function(event) {
				event.preventDefault();
				//$('#detailsTbl').show();
				//$('#myTable').hide();
				ajaxGetSwiftDetails("MT103");
			});

			$("#MT202").click(function(event) {
				event.preventDefault();
//				$('#detailsTbl').show();
//				$('#myTable').hide();
				ajaxGetSwiftDetails("MT202");
			});

			$("#MT400").click(function(event) {
				event.preventDefault();
//				$('#detailsTbl').show();
//				$('#myTable').hide();
				ajaxGetSwiftDetails("MT400");
			});

			$("#MT700").click(function(event) {
				event.preventDefault();
//				$('#detailsTbl').show();
//				$('#myTable').hide();
				ajaxGetSwiftDetails("MT700");
			});

			function ajaxGetSwiftDetails(typeSwift) {
				$.ajax({
					type : "GET",
					url : "get-details?type=" + typeSwift,

					success : function(result) {

						$('#myTable tbody').empty();
						var custListts = "";
						$.each(result.data, function(i, swiftDetails) {
							var ts = '<tr><td>'
									+ swiftDetails.typeChamp.description
									+ '</td><td>'
									+ swiftDetails.swift.typeSwift.libelle
									+ '</td><td>' + swiftDetails.value
									+ '</td></tr>';
							$('#myTable tbody').append(ts)

						});
					}

					,
					error : function(e) {
						console.log("ERROR: ", e);
					}
				});
			}

		})