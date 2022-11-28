window.onload = cargarEquipos;

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}
async function cargarEquipos() {
    const request = await fetch('../api/equipos', {
        method: 'GET',
        headers: getHeaders()
    });
    const equipos = await request.json();
    let listado = '';
    for (let equp of equipos) {
        let equipo = '<option value="' + equp.id + ',' + equp.nombre + '">' + equp.nombre + '</option>';
        listado += equipo;
    }
    document.getElementById('equipo1').innerHTML = listado;
    document.getElementById('equipo2').innerHTML = listado;
}

async function crearPartido() {
    event.preventDefault();
    let datos = [];
    let equ1 = dividirCadena(document.getElementById("equipo1").value, ",");
    let equ2 = dividirCadena(document.getElementById("equipo2").value, ",");


    if(equ1[0] == equ2[0]){
        alert("Equipos repetidos");
        return;
    }
    datos =[
        {
            "id": equ1[0],
            "nombre": equ1[1]
        },
        {
            "id": equ2[0],
            "nombre": equ2[1]
        }
    ];

    const request = await fetch('../api/asigEquipos', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
    

    if(!confirm("¿Seguro desea crear este partido?")) return;
        request = await fetch('../api/regPartido', {
        method: 'GET',
        headers: getHeaders()
      });
}


function dividirCadena(cadenaADividir, separador) {
    let arrayDeCadenas = cadenaADividir.split(separador);
    return arrayDeCadenas;
}