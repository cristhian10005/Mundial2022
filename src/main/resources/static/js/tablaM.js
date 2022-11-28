window.onload = cargarResultados;

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function cargarResultados() {
    const request = await fetch('api/resultados', {
        method: 'GET',
        headers: getHeaders()
    });
    const partidos = await request.json();
    let listado = '<table class="tabla"> <thead><tr>'
    +'<th>'+partidos[0].partido.equipo1.equipo.nombre+'</th>'
    +'<th>'+partidos[0].partido.equipo2.equipo.nombre+'</th>'
    +'<th>Responsable</th> <th>Puntos</th></tr></thead>';

    for (let restsultado of partidos) {
        let equipo = '<tbody><tr><td>'+restsultado.marcador1+'</td>'
            +'<td>'+restsultado.marcador2+'</td>'
            +'<td>'+restsultado.usuarios.nombres+' '+restsultado.usuarios.apellidos+'</td>'
            +'<td>'+restsultado.partido.puntos+'</td></tr></tbody>'
        listado += equipo;
    }
    listado+='</table>';
    document.getElementById('tabla-detalle').innerHTML = listado;
}
