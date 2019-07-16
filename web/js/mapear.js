/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var teste = true;
function coordenadas(event) {
    var pto = document.getElementsByClassName("ponto");
    var tipo = document.getElementById("shape").value;
    if (tipo === "rect" && pto.length < 2) {
        colocaPonto(event);
    } else if (tipo === "circle" && pto.length < 2) {
        colocaPonto(event);
    } else if (tipo === "poly") {
        colocaPonto(event);
    } else {
        alert("Não pode colocar mais pontos!")
    }
}

function colocaPonto(event) {
    var div = document.getElementById('imagem');
    var img = document.getElementById('foto');
    
    x = event.clientX+window.pageXOffset;
    
    y = event.clientY+window.pageYOffset;
   
    var xImagem = x - div.offsetLeft;
    var yImagem = y - div.offsetTop;
    
    
    var coords = document.getElementById("coords");
    if (teste) {
        coords.value = xImagem + "," + yImagem;
        teste = false;
    } else {
        coords.value = coords.value + "," + xImagem + "," + yImagem;
    }
    var ponto = document.createElement("span");
    ponto.className = "ponto";
    ponto.style.cssText = "top: " + (parseInt(y) - 2.5) + "px; left: " + (parseInt(x) - 2.5) + "px;";
    div.appendChild(ponto);
}

function criarForm() {
    var form = document.getElementById("formulario");
    var tipo = document.getElementById("shape");
    var coords = document.getElementById("coords");
    if(tipo.value == "circle"){
        var separada = coords.value.split(",");
        var x1 = separada[0];
        var y1 = separada[1];
        var x2 = separada[2];
        var y2 = separada[3];
        var reta1;
        var reta2;
        if(x1<x2){
            reta1 = x2-x1;
        }else{
            reta1 = x1-x2;
        }
        if(y1<y2){
            reta2 = y2-y1;
        }else{
            reta2 = y1-y2;
        }
        var somas = (reta1*reta1)+(reta2*reta2);
        var resultado = Math.sqrt(somas);
        coords.value = x1+","+y1+","+resultado;
    }
    
    var href = document.getElementById("href");
    if (href.value.startsWith("www")) {
        href.value = "http://" + href.value;
    }
    var alt = document.getElementById("alt");
    var title = document.getElementById("title");
    var pto = document.getElementsByClassName("ponto");
    if((tipo.value == "rect" && pto.length == 2)||(tipo.value == "poly" && pto.length > 2)||(tipo.value == "circle" && pto.length == 2)){
        var input = document.createElement("input");
        input.setAttribute("type","hidden");
        input.setAttribute("name","txtArea");
        input.setAttribute("value",tipo.value+";"+coords.value+";"+href.value+";"+alt.value+";"+title.value);
        form.appendChild(input);
        limpaPonto();
        coords.value = "";
        href.value = "";
        alt.value = "";
        title.value = "";
    }else{
        if(tipo.value=="rect"||tipo.value=="circle"){
            alert("Você deve ter 2 pontos selecionados!");
        }else if(tipo.value=="poly"){
            alert("Você deve ter no mínimo 3 pontos selecionados");
        }
    }
    
}

function criarMapa() {
    var tipo = document.getElementById("shape").value;
    var imgMap = document.getElementById("imgMap");
    var foto = document.createElement("img");
    var fotoOriginal = document.getElementById("foto");
    foto.setAttribute("src", fotoOriginal.getAttribute("src"));
    foto.setAttribute("usemap", "#imgmap");
    var mapeamento = document.createElement("map");
    mapeamento.setAttribute("name", "imgmap");
    var area = document.createElement("area");
    var coords = document.getElementById("coords");
    var href = document.getElementById("href");
    var alt = document.getElementById("alt");
    var title = document.getElementById("title");
    if (href.value.startsWith("www")) {
        href.value = "http://" + href.value;
    }
    area.setAttribute("coords", coords.value);
    area.setAttribute("href", href.value);
    area.setAttribute("shape", tipo);
    area.setAttribute("alt", alt.value);
    area.setAttribute("title", title.value);
    mapeamento.appendChild(area);
    imgMap.appendChild(foto);
    imgMap.appendChild(mapeamento);
    alt.value = '';
    href.value = '';
    title.value = '';
    limpaPonto();
}

function limpaPonto() {
    var pto = document.getElementsByClassName("ponto");
    var tam = pto.length;
    for (var i = 0; i < tam; i++) {
        var pto = document.querySelector('#imagem .ponto');
        pto.outerHTML = '';
    }
    var coords = document.getElementById("coords");
    coords.value = "";
    teste = true;
}

document.getElementById("alt").onkeypress = function (e) {
    var chr = String.fromCharCode(e.which);
    if (";".indexOf(chr) == 0)
        return false;
};
document.getElementById("href").onkeypress = function (e) {
    var chr = String.fromCharCode(e.which);
    if (";".indexOf(chr) == 0)
        return false;
};
document.getElementById("shape").onkeypress = function (e) {
    var chr = String.fromCharCode(e.which);
    if (";".indexOf(chr) == 0)
        return false;
};
document.getElementById("title").onkeypress = function (e) {
    var chr = String.fromCharCode(e.which);
    if (";".indexOf(chr) == 0)
        return false;
};
