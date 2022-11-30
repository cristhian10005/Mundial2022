
window.onload = cargarformPartidos;
function getHeaders() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
  };
}
let rol = document.getElementById("rol").value;
let urlLista = 'api/prepartido';
let urlEnv = 'api/regResultado';
if (rol == 1) {
  urlLista = '../api/prepartido';
  urlEnv = '../api/regResultado';
}
async function cargarformPartidos() {
  const request = await fetch(urlLista+'/'+rol, {
    method: 'GET',
    headers: getHeaders()
  });
  const equipos = await request.json();
  let listado = '';
  let indiceIdPartido=0;
  for (let partidoList of equipos) {
    let equipo = '<form class="d-flex flex-column align-items-center formu">'
      + '<input type="hidden" id="idpartido'+indiceIdPartido+'" value="' +partidoList.id+ '">'
      + '<label class="titulo">Ingresa el marcador</label>'
      + '<div class="col-md-12">'
      + '<label class="form-label">' + partidoList.equipo1.equipo.nombre + '</label>'
      + '<select id="equ-form1'+indiceIdPartido+'" class="form-select form-select-sm" aria-label=".form-select-sm example">'
      + '<option value="1">1</option>'
      + '<option value="2">2</option>'
      + '<option value="3">3</option>'
      + '<option value="4">4</option>'
      + '<option value="5">5</option>'
      + '<option value="6">6</option>'
      + '<option value="7">7</option>'
      + '<option value="8">8</option>'
      + '</select>'
      + '</div>'
      + '<div class="col-md-12">'
      + '<label " class="form-label">' + partidoList.equipo2.equipo.nombre + '</label>'
      + '<select id="equ-form2'+indiceIdPartido+'" class="form-select form-select-sm" aria-label=".form-select-sm example">'
      + '<option value="1">1</option>'
      + '<option value="2">2</option>'
      + '<option value="3">3</option>'
      + '<option value="4">4</option>'
      + '<option value="5">5</option>'
      + '<option value="6">6</option>'
      + '<option value="7">7</option>'
      + '<option value="8">8</option>'
      + '</select>'
      + '</div>'
      + '<div class="col-12">'
      + '<button type="submit" onclick="enviarMarcador(' + rol +','+ indiceIdPartido+ ')" class="btn btn-primary boton">Registrar</button>'
      + '</div>'
      + '<a href="#"></a>'
      + '</form>';
    indiceIdPartido++;  
    listado += equipo;
  }
  document.getElementById('form-partido').outerHTML = listado;
}

async function enviarMarcador(rol, indiceIdPartido) {
  let idpartido = 'idpartido'+indiceIdPartido;
  let idM1 = "equ-form1"+indiceIdPartido;
  let idM2 ="equ-form2"+indiceIdPartido;
  event.preventDefault();
  let datos = {};
  datos.idpartido = document.getElementById(idpartido).value;
  datos.marcador1 = document.getElementById(idM1).value;
  datos.marcador2 = document.getElementById(idM2).value;
  datos.idPersona = rol;
  console.log(rol);
  const request = await fetch(urlEnv, {
    method: 'POST',
    headers: getHeaders(),
    body: JSON.stringify(datos)
  });

  if (rol == 1) {
    if (!confirm("¿Seguro desea asignar este marcador?")) return;
    let id =document.getElementById(idpartido).value;
    const request2 = await fetch(urlEnv+'/'+id, {
      method: 'GET',
      headers: getHeaders()
    });
  }
}