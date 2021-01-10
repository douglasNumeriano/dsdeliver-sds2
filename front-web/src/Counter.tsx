import { useState } from "react"

function Counter(){

// useState fornece o valor de uma variavel e um método para alterar esta variavel    
const [counter, setCounter] = useState(0);

const handleIncrease = () =>{
    setCounter(counter + 1);
}

const handleDecrease = () =>{
    setCounter(counter - 1);
}
    return(
      <div>
            <button onClick={handleIncrease}>Incrementar</button>
            <button onClick={handleDecrease}>Decrementar</button>
            <h1>Valor do Contador: {counter}</h1>
        </div>
    )
}

export default Counter;