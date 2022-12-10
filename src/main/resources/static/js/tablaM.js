window.onload = cargarResultados;
function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function cargarResultados() {
    const request = await fetch('../api/tabalResultados', {
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