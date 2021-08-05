GET: $(document).ready(
		function() {

			$("#SwiftsEntrant").click(function(event) {
				
				event.preventDefault();
				ajaxGetSwiftsBySens("Entrant");
			});

			$("#SwiftsSortant").click(function(event) {
				
				event.preventDefault();
				ajaxGetSwiftsBySens("Sortant");
			});

		function ajaxGetSwiftsBySens(sens) {
				$.ajax({
					type : "GET",
					url : "get-swifts-sens?sens=" + sens,

					success : function(result) {

						$('#myTable tbody').empty();
						var custListts = "";
						$.each(result.data, function(i, swift) {
							var ts = '<tr><td>' + swift.dateInsertion
									+ '</td><td>' + swift.sens + '</td><td>'
								+ swift.typeSwift.libelle + '</td><td>'
									+ swift.messageSwift+ '</td><td>'
									+'<a href="/swifts/showDetails/{idSwift}?swiftId='
									+swift.idSwift+'"\" class=\"btn btn-info btn-sm\"> Consulter les details du swift  </a>'
							'</td></tr>';
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