window.addEventListener('load', function () {

    /* --------------------------------- Tuppers -------------------------------- */
    let tbody = document.querySelector('tbody');

    const url = '/odontologos/listarOdontologos';
    const settings = {
        method: 'GET'
    }


        /* --------------------------------- Pedido API -------------------------------- */



    fetch(url, settings)
        .then(response => response.json())
        .then(turnoList => {
            console.log(turnoList)

            data = turnoList.sort((a, b) => a.id - b.id)

            data.forEach(turno => {

                const deleteButton = `
                    <button class="delete-btn" id="delete_${turno.id}" onclick="deleteBy(${turno.id})">
                        <span class="icon">
                            <span class="tapa"></span>
                            <span class="can"></span>
                            <span class="trash"></span>
                        </span>
                    </button>`

                const updateButton = `<button class="edit" id="edit_${turno.id}" onclick="modify(${turno.id})"><i class="far fa-edit"></i></button>`

                const turnoRow = document.createElement('tr');
                turnoRow.innerHTML =
                    `<tr id='fila_' + ${turno.id} > 
                            <td>  ${turno.id}  </td> 
                            <td class=\td_odontologo\>  ${turno.odontologo.nombre}  </td> 
                            <td class=\td_paciente\>  ${turno.paciente.nombre} </td> 
                            <td class="botonera">  ${deleteButton} ${updateButton}  </td> 
                        </tr>`;

                tbody.append(turnoRow);
            })
        })
})