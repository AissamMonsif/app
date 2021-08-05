GET: $(document)
		.ready(
				function() {

					$('#fields').hide();

					$("#MT103").click(function(event) {
						event.preventDefault();
						$('#fields').show();
						// $('#myTable').hide();
						ajaxGetFields("MT103");
						ajaxGetSwiftDetails("MT103");
					});

					$("#MT202").click(function(event) {
						event.preventDefault();
						$('#fields').show();
						// $('#myTable').hide();
						ajaxGetFields("MT202");
						ajaxGetSwiftDetails("MT202");
					});

					$("#MT400").click(function(event) {
						event.preventDefault();
						$('#fields').show();
						// $('#myTable').hide();
						ajaxGetFields("MT400");
						ajaxGetSwiftDetails("MT400");
					});

					$("#MT700").click(function(event) {
						event.preventDefault();
						$('#fields').show();
						// $('#myTable').hide();
						ajaxGetFields("MT700");
						ajaxGetSwiftDetails("MT700");
					});
					//
					// $("#submit").click(function(event) {
					// event.preventDefault();
					// $('#fields').show();
					// ajaxGetSwiftDetailsFromTypeChamp(typeChamp);
					// });

					function ajaxGetSwiftDetails(typeSwift) {
						$
								.ajax({
									type : "GET",
									url : "get-details?type=" + typeSwift,

									success : function(result) {

										$('#table_id tbody').empty();
										var custListts = "";
										$
												.each(
														result.data,
														function(i,
																swiftDetails) {
															var ts = '<tr><td>'
																	+ swiftDetails.typeChamp.libelle
																	+ '</td><td>'
																	+ swiftDetails.swift.typeSwift.libelle
																	+ '</td><td>'
																	+ swiftDetails.value
																	+ '</td><td>'
																	+ '<a href="/details/showSwift/{id}?swiftId='
																	+ swiftDetails.swift.idSwift
																	+ '"\" class=\"btn btn-info btn-sm\"> Editer le swift </a>'
																	+ '</td></tr>';
															$('#table_id tbody')
																	.append(ts)

														});
									}

									,
									error : function(e) {
										console.log("ERROR: ", e);
									}
								});
					}

					function ajaxGetSwiftDetailsFromTypeChamp(typeChamp) {
						$
								.ajax({
									type : "GET",
									url : "get-details-from-type-champ?type="
											+ typeChamp,

									success : function(result) {

										$('#table_id tbody').empty();
										var custListts = "";
										$
												.each(
														result.data,
														function(i,
																swiftDetails) {
															var ts = '<tr><td>'
																	+ swiftDetails.typeChamp.libelle
																	+ '</td><td>'
																	+ swiftDetails.swift.typeSwift.libelle
																	+ '</td><td>'
																	+ swiftDetails.value
																	+ '</td><td>'
																	+ '<a href="/details/showSwift/{id}?swiftId='
																	+ swiftDetails.swift.idSwift
																	+ '"\" class=\"btn btn-info btn-sm\"> Editer le swift </a>'
																	+ '</td></tr>';
															$('#table_id tbody')
																	.append(ts)

														});
									}

									,
									error : function(e) {
										console.log("ERROR: ", e);
									}
								});
					}

					function ajaxGetFields(typeSwift) {
						$
								.ajax({
									type : "GET",
									url : "get-fields?type=" + typeSwift,

									success : function(result) {

										$('#fields').empty();
										var custListts = "";
										$
												.each(
														result.data,
														function(i, typeChamp) {

															var ts = '<div class="form-check form-check-inline"><input class="ch form-check-input" type="checkbox" name="ch" value="'
																	+ typeChamp.libelle
																	+ '" id = " '
																	+ typeChamp.idTypeChamp
																	+ ' ">'
																	+ typeChamp.libelle
															'</input><label class="form-check-label" for="'
																	+ typeChamp.idTypeChamp
																	+ '">'
																	+ typeChamp.libelle
																	+ '</label></div>';
															$('#fields')
																	.append(ts)

														});
									}

									,
									error : function(e) {
										console.log("ERROR: ", e);
									}
								});
					}

				})