function changeSelection(){
    const selectedElement = document.getElementById("country"); // 선택한 option의 value, 텍스트
    const currency = selectedElement.options[selectedElement.selectedIndex].value;
    const country = selectedElement.options[selectedElement.selectedIndex].text;

    fetch('/exchange/'+currency,{
        method : 'get'
    }).then (res=>{
        return res.json();
    }).then (data=>{
        console.log(data);
        document.getElementById("money").innerText = addComma(data);
        document.getElementById("rateCurrency").innerText = " "+currency+"/USD";

    }).catch( error =>{
        console.log(error);
    });
}

function submit() {
    const usd = document.getElementById("transferMoney").value;

    if (usd === "" || usd < 0 || 10000 < usd || isNaN(usd)) {
        alert("송금액이 바르지 않습니다.");
        return;
    }

    const selectedElement = document.getElementById("country");
    const currency = selectedElement.options[selectedElement.selectedIndex].value;
    const money = removeComma(document.getElementById("money").innerText);
    const totalMoney = addComma((usd * money).toFixed(2));

    document.getElementById("exchangeResultText").innerText = "수취금액은 "+totalMoney+" "+currency+"입니다.";


}

function removeComma(number){
    return number.replace(/\,/g,'');
}
function addComma(number){
    return number.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}



