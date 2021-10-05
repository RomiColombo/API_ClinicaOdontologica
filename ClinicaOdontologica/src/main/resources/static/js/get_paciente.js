window.addEventListener('load', function () {

    /* --------------------------------- Tuppers -------------------------------- */
    let tbody = document.querySelector('tbody');

    const url = '/pacientes/listarPacientes';
    const settings = {
        method: 'GET'
    }

    /* ------------------------------- Pedido API ------------------------------- */

    function showAdress(id) {
        let btnInfo = document.querySelectorAll('.info')
        let url = `/direccion/buscar/${id}`

        console.log(btnInfo);

        btnInfo.forEach(boton => {
            boton.addEventListener('click', function (e) {

                let settings = {
                    method: 'GET',
                    headers: { 'Content-Type': 'application/json' },
                }

                fetch(url, settings)
                    .then(response => response.json())
                    .then(data => {
                        console.log(data);
                        Swal.fire({
                            icon: 'info',
                            title: 'Dirección del paciente',
                            text: `${data.calle} ${data.numero} - ${data.localidad}, ${data.provincia}`
                        })
                    })
            })
        })
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(pacienteList => {

            data = pacienteList.sort((a, b) => a.id - b.id)

            data.forEach(paciente => {

                const deleteButton = `
                <button class="delete-btn" id="delete_${paciente.id}" onclick="deleteBy(${paciente.id})">
                    <span class="icon">
                        <span class="tapa"></span>
                        <span class="can"></span>
                        <span class="trash"></span>
                    </span>
                </button>`

                const updateButton = `<button class="edit" id="edit_${paciente.id}" onclick="modify(${paciente.id})"><i class="far fa-edit"></i></button>`

                const infoButton = `<button class="info" id=${paciente.id}><p>Ver Detalle</p></button>`

                const pacienteRow = document.createElement('tr');
                pacienteRow.innerHTML =
                    `<tr id='fila_' + ${paciente.id} > 
                        <td>  ${paciente.id}  </td> 
                        <td class=\td_apellido\>  ${paciente.apellido} </td> 
                        <td class=\td_nombre\>  ${paciente.nombre}  </td> 
                        <td>  ${paciente.dni}  </td> 
                        <td>  ${paciente.email}  </td> 
                        <td>  ${paciente.fechaAlta}  </td> 
                        <td class="domicilio">${infoButton} </td>
                        <td class="botonera"> ${deleteButton} ${updateButton}</td> 
                    </tr>`;

                tbody.append(pacienteRow);
                showAdress(paciente.id)

            })

        })
})