import './button.scss'

const Button = props => {
    return (
        <button className={`btn-component ${props.className}`} onClick={props.onClick}>
            {props.children}
        </button>
    )
}

export default Button
