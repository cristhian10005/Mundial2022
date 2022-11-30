window.onload = cargarResultados;
function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function cargarResultados() {
    const request = await fetch('api/prepartido', {
        method: 'GET',
        headers: getHeaders()
    });
    const partidos = await request.json();
    let listado = '';
    let registro = '';
    for (let partido of partidos) {
        if (partido.resultados != null) {
            let equipo = '<table class="tabla"> <thead><tr>'
                + '<th>' + partido.equipo1.equipo.nombre + '</th>'
                + '<th>' + partido.equipo2.equipo.nombre + '</th>'
                + '<th>Responsable</th> <th>Puntos</th></tr></thead><tbody>'
            for (let resultado of partido.resultados) {
                registro += '<tr><td>' + resultado.marcador1 + '</td>'
                    + '<td>' + resultado.marcador2 + '</td>'
                    + '<td>' + resultado.usuarios.nombres + ' ' + resultado.usuarios.apellidos + '</td>'
                    + '<td>' + resultado.puntos + '</td></tr>'
            }
            listado += equipo;
            listado += registro;
            listado += '</tbody></table>';
            registro = '';
        }

    }
    document.getElementById('tabla-detalle').innerHTML = listado;
}

async function cargarResultados() {
    const request = await fetch('api/tabalResultados', {
        method: 'GET',
        headers: getHeaders()
    });
    const posiciones = await request.json();
    let listado = '<table class="tabla"> <thead><tr>'
        + '<th>Nombre</th>'
        + '<th>Puntos</th>';
    let registro = '';
    for (let user of posiciones) {
        registro += '<tr><td>' + user.nombres +' '+user.apellidos+ '</td>'
                    + '<td>' + user.puntos + '</td>';
    }
    listado += registro;
    listado += '</tbody></table>';

    document.getElementById('contenedor-p').innerHTML = listado;
}