
function clickSearch(){
    document.getElementById("createWallet").style.display = 'none';
    document.getElementById("wallet").style.display = 'none';
    var player_id = document.getElementById("player_id_input").value;
    $.ajax({
        type: 'POST',
        async: true,
        url:"/getWallet",
        data: {'player_id' : player_id},
        success: function (result) {
            console.log(result);
            displayResult(result);
        }
    });
}

function displayResult(result){
    if(result == "Not Found"){
        document.getElementById("createWallet").style.display = 'block';
    }else{
        document.getElementById("wallet").style.display = 'block';
        document.getElementById("balance").innerHTML = result;
    }

}

function createNewWallet(){
    var player_id = document.getElementById("player_id_input").value;
    $.ajax({
        type: 'POST',
        async: true,
        url:"/createWallet",
        data: {'player_id' : player_id},
        success: function (result) {
            clickSearch();
        }
    });
}

function doTransfers(){
    var player_id = document.getElementById("player_id_input").value;
    var operationType =  document.getElementById("operationType").value;
    var amount =  document.getElementById("operation_amount").value;
    $.ajax({
        type: 'POST',
        async: true,
        url:"/" + operationType,
        data: {'player_id' : player_id, 'amount':amount},
        success: function (result) {
            alert(result);
            clickSearch();
        }
    });
}

