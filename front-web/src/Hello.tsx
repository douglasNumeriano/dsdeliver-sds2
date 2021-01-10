import { useEffect } from "react";

// Criação de um tipo de parametro chamado "Props"
type Props = {
    message: string;
}


/*Este é um componente react*/
//useEffect: é uma funcão que recebe dois parametros usada para testar a execução de um componente
//parametro 1: é uma arrow function
// parametro 2: lista de dependencias  
function Hello({message}: Props){

    useEffect(() =>{
        console.log("Componente iniciou");
    }, []);

    return(
        <h1>Hello {message}!</h1>
    )
}

export default Hello;