import './styles.css'
// importante um svg
import {ReactComponent as Logo} from './logo.svg'
import { Link } from 'react-router-dom';

function Navbar(){
    return(
        // className no react é a mesma coisa que class em HTML
        <nav className="main-navbar">
            <Logo />
            <Link to="/" className="logo-test">DS Delivery</Link>
        </nav>           
    )
}

export default Navbar;