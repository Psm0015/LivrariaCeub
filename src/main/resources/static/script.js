carregatabela()
function carregatabela() {
    $.ajax({
        url: "http://localhost:8080/livros",
        type: "GET",
        success: function (obj) {
            tabela = ''
            for (let i = 0; i < obj.length; i++) {
                const livro = obj[i];
                tabela+=`<tr><td scope="col">${livro.titulo}</td><td scope="col">${livro.autor}</td></tr>`
            }
            $('#tabela').html(tabela)
        }
    });
}
function abremodalcadastro() {
    $("#modalForm").modal('show');
}
function enviarcadastro() {
    titulo = $('#titulo').val
    autor = $('#autor').val
}