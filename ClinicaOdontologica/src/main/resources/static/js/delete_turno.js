function deleteBy(id){
    const url = `/turnos/eliminar/${id}`
    const settings = {
        method: 'DELETE'
    }
    fetch(url,settings)
     .then(response => console.log(response))

    
    location.reload();

}