/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 //var fomulario=document.form['forLoginId'];
 //var campoUser=fomulario['user'].value;
 let  usuario=document.getElementById('user');
 let password=document.getElementById('pass');
 var error=document.getElementById('error');
 error.style.color='red';
//function validarLogin () {
//    
//    var mensajeError=[];
//    /*
//    if (usuario.value === null || usuario.value === '') {
//        mensajeError.push('Ingresar Nombre');
//    }
//    if (password.value === null || password.value === '') {
//        mensajeError.push('Ingresar Password');
//    }*/
//    if (usuario.value === null || usuario.value === '') {
//       mensajeError.push('Ingresar Usuario');
//    }
//    
//    if (password.value === null || password.value === '') {
//       mensajeError.push('Ingresar Password');
//    }
//    
//    //console.log(`Usuario Ingresado ${usuario.value}`);
//    //swal(`Error, ${mensajeError.join('-')}`);
//    //error.innerHTML= mensajeError.join(',');
//    swal("Error", ""+mensajeError.join('-')+"", "error");
//    return false;
//}

let form = document.getElementById('forLoginId');
    form.addEventListener('submit',function (evt) {
    evt.preventDefault();
    
    var mensajeError=[];
    if (usuario.value === null || usuario.value === '') {
       mensajeError.push('Ingresar Usuario');
    }
    
    if (password.value === null || password.value === '') {
       mensajeError.push('Ingresar Password');
    }
    
    swal("Error", ""+mensajeError.join('-')+"", "error");
     
});