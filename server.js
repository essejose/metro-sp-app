var express = require('express'),
    app = express(),
    azul = require('./azul'),
    linhas = require('./linhas');

app.use(express.static('public'));

app.use('/linhas', linhas);

app.use('/linhas', azul);

var server = app.listen(3000);

console.log('Servidor Express iniciado na porta %s', server.address().port);