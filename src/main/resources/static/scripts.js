// manejo de Odontólogos
function listarOdontologos() {
    const url = '/odontologos';
    const settings = {
        method: 'GET'
    };

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            const listaOdontologos = document.getElementById("odontologos-list");
            listaOdontologos.innerHTML = '';
            data.forEach(odontologo => {
                const li = document.createElement('li');
                li.innerHTML = `
                    <span>${odontologo.nombre} ${odontologo.apellido}</span>
                    <div>
                        <button class="editar-odontologo" data-id="${odontologo.id}">Editar</button>
                        <button class="eliminar-odontologo" data-id="${odontologo.id}">Eliminar</button>
                    </div>
                `;
               listaOdontologos.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Error al listar odontólogos:', error);
            alert('Hubo un error al listar odontólogos');
        });
}

window.addEventListener('load', function () {
    // solo si estamos en odontólogos, corregir parámetro
    if (document.getElementById("odontologos-list")) {
        listarOdontologos();
    }

    const formularioAgregarOdontologo = document.querySelector('#agregar_odontologo');
    formularioAgregarOdontologo.addEventListener('submit', function (event) {
        event.preventDefault();
        agregarOdontologo();
    });

    document.addEventListener('click', function (event) {
        if (event.target.matches('.eliminar-odontologo')) {
            const id = event.target.dataset.id;
            eliminarOdontologo(id);
        } else if (event.target.matches('.editar-odontologo')) {
            const id = event.target.dataset.id;
            mostrarFormularioEdicion(id, 'odontologo');
        } else if (event.target.matches('.guardar-cambios')) {
            const id = event.target.dataset.id;
            editarOdontologo(id);
        } else if (event.target.matches('.cancelar-edicion')) {
            const id = event.target.dataset.id;
            ocultarFormularioEdicion(id);
        }
    });

     function agregarOdontologo() {
            const formData = {
                nombre: document.querySelector('#nombre').value,
                apellido: document.querySelector('#apellido').value,
                numeroMatricula: document.querySelector('#matricula').value
            };

            const url = '/odontologos/agregar';
            const settings = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            };

            fetch(url, settings)
                .then(response => {
                    if (response.ok) {
                        console.log('Odontólogo agregado correctamente');
                        listarOdontologos();
                        resetUploadForm();
                    } else {
                        throw new Error('Error al agregar odontólogo');
                    }
                })
                .catch(error => {
                    console.error('Error al agregar odontólogo:', error);
                    alert('Hubo un error al agregar el odontólogo');
                    resetUploadForm();
                });
        }

        function resetUploadForm() {
            document.querySelector('#nombre').value = "";
            document.querySelector('#apellido').value = "";
            document.querySelector('#matricula').value = "";
        }

        function eliminarOdontologo(id) {
            const url = `/odontologos/eliminar/${id}`;
            const settings = {
                method: 'DELETE'
            };

            fetch(url, settings)
                .then(response => {
                    if (response.ok) {
                        console.log('Odontólogo eliminado con éxito');
                        listarOdontologos();
                    } else {
                        throw new Error('Error al eliminar el odontólogo');
                    }
                })
                .catch(error => {
                    console.error('Error al eliminar el odontólogo:', error);
                    alert('Hubo un error al eliminar el odontólogo');
                });
        }

    function mostrarFormularioEdicion(id, tipo) {
        if (tipo === 'odontologo') {
            const formulario = document.getElementById('editar-odontologo');
            if (formulario) {
                formulario.style.display = 'block';
                fetch('/odontologos/' + id)
                    .then(response => response.json())
                    .then(data => {
                        document.getElementById('odontologo-id').value = data.id;
                        document.getElementById('nombre-editar').value = data.nombre;
                        document.getElementById('apellido-editar').value = data.apellido;
                        document.getElementById('numeroMatricula-editar').value = data.numeroMatricula;
                    })
                    .catch(error => {
                        console.error('Error al cargar los datos del odontólogo para editar:', error);
                        alert('Hubo un error al cargar los datos del odontólogo');
                    });
            }
        } else if (tipo === 'paciente') {
            const formularioPaciente = document.getElementById('editar-paciente');
            if (formularioPaciente) {
                formularioPaciente.style.display = 'block';
                fetch('/pacientes/' + id)
                    .then(response => response.json())
                    .then(data => {
                        document.getElementById('paciente-id').value = data.id;
                        document.getElementById('nombre-editar').value = data.nombre;
                        document.getElementById('apellido-editar').value = data.apellido;
                        document.getElementById('domicilio-editar').value = data.domicilio;
                        document.getElementById('dni-editar').value = data.dni;
                        document.getElementById('fechaDeAlta-editar').value = data.fechaDeAlta;
                    })
                    .catch(error => {
                        console.error('Error al cargar los datos del paciente para editar:', error);
                        alert('Hubo un error al cargar los datos del paciente');
                    });
            }
        }
    }

    document.addEventListener('click', function (event) {
        if (event.target.matches('.editar-odontologo')) {
            const id = event.target.dataset.id;
            mostrarFormularioEdicion(id, 'odontologo');
        }
    });

    // manejo de Pacientes
    function listarPacientes() {
        const url = '/pacientes';
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                const listaPacientes = document.getElementById("pacientes-list");
                listaPacientes.innerHTML = '';
                data.forEach(paciente => {
                    const li = document.createElement('li');
                    li.innerHTML = `
                        <span>${paciente.nombre} ${paciente.apellido}</span>
                        <div>
                            <button class="editar-paciente" data-id="${paciente.id}">Editar</button>
                            <button class="eliminar-paciente" data-id="${paciente.id}">Eliminar</button>
                        </div>
                    `;
                    listaPacientes.appendChild(li);
                });
            })
            .catch(error => {
                console.error('Error al listar pacientes:', error);
                alert('Hubo un error al listar pacientes');
            });

    }

    window.addEventListener('load', function () {
        // solo si estamos en pacientes, corregir parámetro
        if (document.getElementById("pacientes-list")) {
            listarPacientes();
        }


    function agregarPaciente() {
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            domicilio: document.querySelector('#domicilio').value,
            dni: document.querySelector('#dni').value,
            fechaDeAlta: document.querySelector('#fechaDeAlta').value
        };

        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                console.log('Paciente agregado:', data);
                listarPacientes();
                resetUploadForm();
            })
            .catch(error => {
                console.error('Error al agregar paciente:', error);
                alert('Hubo un error al agregar el paciente');
                resetUploadForm();
            });
    }

    const formularioAgregarPaciente = document.querySelector('#pacienteForm');
    formularioAgregarPaciente.addEventListener('submit', function (event) {
        event.preventDefault();
        agregarPaciente();
    });

    // manejo de Reservas
    function agregarReserva(event) {
        event.preventDefault();

        const pacienteId = document.getElementById('paciente').value;
        const fecha = document.getElementById('fecha').value;
        const hora = document.getElementById('hora').value;
        const odontologoId = document.getElementById('odontologo').value;

        const formData = {
            pacienteId: pacienteId,
            fecha: fecha,
            hora: hora,
            odontologoId: odontologoId
        };

        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                console.log('Reserva agregada correctamente:', data);
                document.getElementById('paciente').value = '';
                document.getElementById('fecha').value = '';
                document.getElementById('hora').value = '';
                document.getElementById('odontologo').value = '';
                actualizarListaReservas();
            })
            .catch(error => {
                console.error('Error al agregar reserva:', error);
                alert('Hubo un error al agregar la reserva');
            });
    }

    const formularioReserva = document.querySelector('#formulario-reserva');
    formularioReserva.addEventListener('submit', agregarReserva);

    function actualizarListaReservas() {
        const url = '/turnos';
        fetch(url)
            .then(response => response.json())
            .then(data => {
                const listaReservas = document.getElementById('reservas-lista');
                listaReservas.innerHTML = '';
                data.forEach(reserva => {
                    const li = document.createElement('li');
                    li.textContent = `Paciente: ${reserva.paciente}, Odontólogo: ${reserva.odontologo}, Fecha: ${reserva.fecha}, Hora: ${reserva.hora}`;
                    listaReservas.appendChild(li);
                });
            })
            .catch(error => {
                console.error('Error al obtener la lista de reservas:', error);
                alert('Hubo un error al obtener la lista de reservas');
            });
    }

    window.addEventListener('load', function () {
        // solo si estamos en reservas, corregir parámetro
        if (document.getElementById("reservas-lista")) {
            actualizarListaReservas();
        }
});