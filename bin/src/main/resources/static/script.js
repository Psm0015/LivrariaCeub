carregatabela()

//SCRIPT DE CARREGAR A TABELA

function carregatabela() {
    $.ajax({
        url: "livros",
        type: "GET",
        success: function (obj) {
            tabela = ''
            for (let i = 0; i < obj.length; i++) {
                const livro = obj[i];
                tabela+=`<tr><td id="l${livro.id}" scope="col">${livro.titulo}</td><td id="a${livro.id}" scope="col">${livro.autor}</td><td>   <i  style="cursor:pointer ;" class="fa-solid fa-pen-to-square" onclick="abremodaleditar(${livro.id})"></i>   <i style="cursor:pointer ;color: red;" class="fa-solid fa-trash" onclick="apagarlivro(${livro.id})"></i></td></tr>`
            }
            $('#tabela').html(tabela)
        }
    });
}

// SCRIPT DE CADASTRO

function abremodalcadastro() {
    $("#modalForm").modal('show');

}
function enviarcadastro() {
    titulo = $('#titulo').val()
    autor = $('#autor').val()

    $.ajax({
        url: "livros",
        type: "POST",
        data: `{\n  \"titulo\": \"${titulo}\",\n  \"autor\": \"${autor}\"\n}`,
        contentType: "application/json",
        success: function(response) {
            $("#modalForm").modal('hide');
            $('#titulo').val('')
            $('#autor').val('')
            carregatabela()
        }
    });
}

// SCRIPT DE EDIÇÃO

function abremodaleditar(id) {
    $("#modalcad").modal('show');
    livro=document.getElementById('l'+id).innerHTML
    autor=document.getElementById('a'+id).innerHTML
    titulo = $('#tituloed').val(livro)
    autor = $('#autored').val(autor)
    sessionStorage.setItem('id',id)
}

function editarcadastro() {
    titulo = $('#tituloed').val()
    autor = $('#autored').val()

    $.ajax({
        url: "livros/"+sessionStorage.getItem('id'),
        type: "PUT",
        data: `{\n  \"titulo\": \"${titulo}\",\n  \"autor\": \"${autor}\"\n}`,
        contentType: "application/json",
        success: function(response) {
            $("#modalcad").modal('hide');
            $('#tituloed').val('')
            $('#autored').val('')
            carregatabela()
        }
    });

}

function apagarlivro(id) {
    $.ajax({
        url: "livros/"+id,
        type: "DELETE",
        success: function(response) {
            carregatabela()
        }
    });
}