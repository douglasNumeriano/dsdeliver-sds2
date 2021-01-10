import './styles.css'
// importante um svg
import {ReactComponent as Logo} from './logo.svg'
function Navbar(){
    return(
        // className no react é a mesma coisa que class em HTML
        <nav className="main-navbar">
            <Logo />
            <a href="home" className="logo-test">DS Delivery</a>
        </nav>           
    )
}

export default Navbar;