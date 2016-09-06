function addRow(tablename) {
    var table = document.getElementById(tablename);
    var row = table.insertRow(1);

	var cell0 = row.insertCell(0);
    var cell1 = row.insertCell(1);
    var cell2 = row.insertCell(2);
    var cell3 = row.insertCell(3);
    var cell4 = row.insertCell(4);
    var cell5 = row.insertCell(5);
    var cell6 = row.insertCell(6);

    var element0 = document.createElement("input");
    element0.type = "text";
    element0.name = "textbox";
    cell0.appendChild(element0);

    var element1 = document.createElement("input");
    element1.type = "text";
    element1.name = "textbox";
    cell1.appendChild(element1);

    var element2 = document.createElement("input");
    element2.type = "text";
    element2.name = "textbox";
    cell2.appendChild(element2);

    var element3 = document.createElement("input");
    element3.type = "text";
    element3.name = "textbox";
    cell3.appendChild(element3);

    var element4 = document.createElement("input");
    element4.type = "text";
    element4.name = "textbox";
    cell4.appendChild(element4);

    var element5 = document.createElement("input");
    element5.type = "text";
    element5.name = "textbox";
    cell5.appendChild(element5);

    var element6 = document.createElement("input");
    element6.type = "text";
    element6.name = "textbox";
    cell6.appendChild(element6);
}

function deleteRow(tablename) {
    document.getElementById(tablename).deleteRow(1);
}

function displayPMInstructionTable(tablename) {
    var table = getElementById(tablename);

    console.log(table.rows.length);
    var columns = table.column[7].cells;

    console.log(test);

    for (var i = 0; i < table.rows.length; i++) {
        columns[i].innerHTML = "NEW CONTENT";
    }
};


//if there's a row show the buttons