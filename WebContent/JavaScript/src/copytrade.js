import $ from 'jquery';

$(()=> {
	$('#addbutton').click(()=>{
		addRow();
	});
})

function addRow() {
    var row = $('#tablerow').clone();
    $('#tablebody').append(row);
};


$('#makeatradeinstructions__table tbody tr td input.checkbox').on('change', function (e) {
    if( $(this).is(':not(:checked)')){
    	return false;
    }
    var row = $(this).closest('tr').clone();
    $('#maketradetable > tbody:last-child').append(row);
	$(this).closest('tr').remove();
});


$('#maketradetable tbody tr td clone input.checkbox').on('change', function (d) {
    console.log("true");
    if($(this).is(':not(:checked)')){
    	var row = $(this).closest('tr').clone();
	    $('#makeatradeinstructions__table > tbody:last-child').append(row);
		$(this).closest('tr').remove();
    }
});