import $ from 'jquery';

$('#makeatradeinstructions__table tbody tr td input.checkbox').on('change', function (e) {
    if( $(this).is(':not(:checked)')){
    	return false;
    }
     var row = $(this).closest('tr').clone();
     $('#maketradetable > tbody:last-child').append(row);
});