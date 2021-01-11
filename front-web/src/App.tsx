import { ToastContainer} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import './App.css';
import Routes from './Routes';

// import Counter from "./Counter";

// O Componente App está recebendo o componente Hello
function App() {
  return (
    <div>
      <>
        <Routes /> 
        <ToastContainer/>   
      </>  
    </div>
  );
}

export default App;
