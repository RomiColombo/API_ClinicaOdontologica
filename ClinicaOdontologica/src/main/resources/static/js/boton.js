window.addEventListener("load", function () {

    /* --------------------------- Tuppers --------------------------- */

    let btnDelete = document.querySelectorAll(".delete-btn");
    
    /* --------------------------- Funciones --------------------------- */
    
    btnDelete.forEach(button => {
        button.addEventListener("click", function(){
            let boton = this;
            boton.classList.toggle("tacho")
        })        
    });
})
