window.onload = cargarResultados;
function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function cargarResultados() {
    const request = await fetch('../api/resultados', {
        method: 'GET',
        headers: getHeaders()
    });
    const partidos = await request.json();
    let listado = '';
    let registro = '';
    for (let partido of partidos) {
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
    document.getElementById('tabla-detalle').innerHTML = listado;
}