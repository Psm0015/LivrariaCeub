carregatabela()
function carregatabela() {
    $.ajax({
        url: "livros",
        type: "GET",
        success: function (obj) {
            tabela = ''
            for (let i = 0; i < obj.length; i++) {
                const livro = obj[i];
                tabela+=`<tr><td scope="col">${livro.titulo}</td><td scope="col">${livro.autor}</td><td><i class="fa fa-pencil-square-o" aria-hidden="true"></i></td></tr>`
            }
            $('#tabela').html(tabela)
        }
    });
}
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