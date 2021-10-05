function deleteBy(id){
          const url = '/odontologos/eliminar/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
           .then(response => console.log(response))

          
          location.reload();

}