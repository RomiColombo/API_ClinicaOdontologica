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
        .then(odontologoList => {
        console.log(odontologoList)



            data = odontologoList.sort((a, b) => a.id - b.id)

            data.forEach(odontologo => {

                const deleteButton = `
                <button class="delete-btn" id="delete_${odontologo.id}" onclick="deleteBy(${odontologo.id})">
                    <span class="icon">
                        <span class="tapa"></span>
                        <span class="can"></span>
                        <span class="trash"></span>
                    </span>
                </button>`

                const updateButton = `<button class="edit" id="edit_${odontologo.id}" onclick="modify(${odontologo.id})"><i class="far fa-edit"></i></button>`

                const odontologoRow = document.createElement('tr');
                odontologoRow.innerHTML =
                    `<tr id='fila_' + ${odontologo.id} > 
                        <td>  ${odontologo.id}  </td> 
                        <td class=\td_apellido\>  ${odontologo.apellido}  </td> 
                        <td class=\td_nombre\>  ${odontologo.nombre} </td> 
                        <td>  ${odontologo.matricula}  </td> 
                        <td class="botonera">  ${deleteButton} ${updateButton}  </td> 
                    </tr>`;

                tbody.append(odontologoRow);

            })

        })

})
