function showFunction(){
     document.getElementById("spantext").style.display = "block";
}

function hideFunction(){
   document.getElementById("spantext").style.display = "none";  
}

function toggleFunction(){
    var status=document.getElementById("spantext");
    if(status.style.display == "none"){
        status.style.display="block";
    }else{
        status.style.display="none";
    }
}
