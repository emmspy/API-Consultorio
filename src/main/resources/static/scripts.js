function editarPaciente(id) {

}

function eliminarPaciente(id) {

}

function editarOdontologo(id) {

}

function eliminarOdontologo(id) {

}


const pacienteSelect = document.getElementById('paciente');
const odontologoSelect = document.getElementById('odontologo');

fetch('url_api/pacientes') //A CORREGIR CON URL Y VER QUE SALEEEEEEEEE
  .then(response => response.json())
  .then(data => {
    data.forEach(paciente => {
      const option = document.createElement('option');
      option.text = paciente.nombre+paciente.apellido;
      option.value = paciente.id;
      pacienteSelect.appendChild(option);
    });
  });

  fetch('url_api/odontologos')
    .then(response => response.json())
    .then(data => {
      data.forEach(odontologo => {
        const option = document.createElement('option');
        option.text = odontologo.nombre+odontologo.apellido;
        option.value = odontologo.matricula;
        odontologoSelect.appendChild(option);
      });
    });