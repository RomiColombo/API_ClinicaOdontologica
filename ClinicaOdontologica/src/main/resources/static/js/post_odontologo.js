window.addEventListener('load', function () {

    /* --------------------------------- Tuppers -------------------------------- */

    let nombre = document.getElementById('nombre');
    let apellido = document.getElementById('apellido');
    let matricula = document.getElementById('matricula');
    let form = document.getElementById('formOdontologo');

    /* ------------------------------- Pedido API ------------------------------- */

    form.addEventListener('submit', (e) => {

        e.preventDefault();

        let data = {
            apellido: apellido.value,
            nombre: nombre.value,
            matricula: matricula.value
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

})
