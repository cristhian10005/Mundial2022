

window.onload = cargarformPartidos;

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}
async function cargarformPartidos() {
    const request = await fetch('api/prepartido', {
        method: 'GET',
        headers: getHeaders()
    });
    const equipos = await request.json();
    let listado = '';
    for (let partidoList of equipos) {
        let equipo = '<form class="d-flex flex-column align-items-center formu">'
        +'<input type="hidden" id="idpartido" value="'+partidoList.id+'">'
        +'<label class="titulo">Ingresa el marcador</label>'
              +'<div class="col-md-12">'
                +'<label class="form-label">'+partidoList.equipo1.equipo.nombre+'</label>'
                +'<select id="equ-form1" class="form-select form-select-sm" aria-label=".form-select-sm example">'
                  +'<option value="1">1</option>'
                  +'<option value="2">2</option>'
                  +'<option value="3">3</option>'
                  +'<option value="4">4</option>'
                  +'<option value="5">5</option>'
                  +'<option value="6">6</option>'
                  +'<option value="7">7</option>'
                  +'<option value="8">8</option>'
                +'</select>'
              +'</div>'
              +'<div class="col-md-12">'
                +'<label " class="form-label">'+partidoList.equipo2.equipo.nombre+'</label>'
                +'<select id="equ-form2" class="form-select form-select-sm" aria-label=".form-select-sm example">'
                  +'<option value="1">1</option>'
                  +'<option value="2">2</option>'
                  +'<option value="3">3</option>'
                  +'<option value="4">4</option>'
                  +'<option value="5">5</option>'
                  +'<option value="6">6</option>'
                  +'<option value="7">7</option>'
                  +'<option value="8">8</option>'
                +'</select>'
              +'</div>'
            +'<div class="col-12">'
              +'<button type="submit" onclick="enviarMarcador()" class="btn btn-primary boton">Registrar</button>'
            +'</div>'
            +'<a href="#"></a>'
          +'</form>';
        listado += equipo;
    }
    document.getElementById('form-partido').outerHTML = listado;
}

async function enviarMarcador(){
    event.preventDefault();
    let datos={};
    datos.idpartido = document.getElementById("idpartido").value;
    datos.marcador1 = document.getElementById("equ-form1").value;
    datos.marcador2 = document.getElementById("equ-form2").value;
    datos.idPersona = 1;
    const request = await fetch('api/regResultado', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
      });
    }