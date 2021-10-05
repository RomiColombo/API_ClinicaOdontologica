window.addEventListener('load', function () {

    /* --------------------------------- Tuppers -------------------------------- */

    let nombre = document.getElementById('fecha');
    let listaOdontologo = document.getElementById('odontologo');
    let listarPaciente = document.getElementById('paciente');
    let form = document.getElementById('formTurno');

    /* ------------------------------- Pedido API ------------------------------- */

    form.addEventListener('submit', (e) => {

        e.preventDefault();

        let data = {
            fecha: fecha.value,
            odontologo: nombre.value,
            paciente: atricula.value
        }

        let settings = {
            method: 'POST',
            headers: { 'Content-Type': "application/json" },
            body: JSON.stringify(data)
        }

        fetch('/odontologos/cargarOdontologo', settings)
            .catch(e => console.log(e))

        form.reset();
    })

    function odontologos() {
        const url = '/odontologos/listarOdontologos';
        const settings = {
            method: 'GET'
        }
        fetch(url, settings)
            .then(response => response.json())
            .then(odontologoList => {
                console.log(odontologoList)

                data = odontologoList.sort((a, b) => a.id - b.id)

                data.forEach(odontologo => {
                    listaOdontologo.innerHTML = `
                        <option value=${odontologo.id}>${odontologo.nombre}</option>                  
                    `
                })
            })
    }


    function paciente() {
        const url = '/pacientes/listarPacientes';
        const settings = {
            method: 'GET'
        }
        fetch(url, settings)
            .then(response => response.json())
            .then(pacientelist => {
                console.log(pacientelist)

                data = pacientelist.sort((a, b) => a.id - b.id)

                data.forEach(paciente => {
                    listarPaciente.innerHTML = `
                    <option value=${paciente.id}>${paciente.nombre}</option>                  
                `
                })
            })

    }

    odontologos()
    paciente()
})

{/* <select value={dentistId} placeholder="Odontologo" onChange={e => setDentistId(parseInt(e.target.value))}>
                        <option value="" selected disabled hidden>Seleccione un odontologo</option>
                        {dentistsData.length ? dentistsData.map((dentist, index) => (
                            <option key={index} value={dentist.id}>{dentist.nombre} {dentist.apellido}</option>
                        )) : <option>Aún no hay odontologos cargados, agrega un odontologo para verlo en la tabla.</option>}
                    </select> */}

