import React, {useState} from 'react';
import "./InputField.css"

export interface MyInputField {
    name: string,
    backgroundColor?: string,
    params?: any
}

function MyInputField(props: MyInputField) {
    const [message, setMessage] = useState('');

    const [updated, setUpdated] = useState('');

    const handleChange = (event: { target: { value: React.SetStateAction<string>; }; }) => {
        setMessage(event.target.value);
    };

    const handleKeyDown = (event: { key: string; }) => {
        if (event.key === 'Enter') {
            setUpdated(message);
            if (props.name === 'name') {
                props.params.name = message
            } else if (props.name === 'password') {
                props.params.password = message
            } else if (props.name === 'mail') {
                props.params.mail = message
            }
            console.log(message)
        }
    };
    return (
        <input
            className="input-field-style"
            style={{backgroundColor: props.backgroundColor}}
            placeholder={props.name}
            value={message}
            onChange={handleChange}
            onKeyDown={handleKeyDown}
        >
        </input>
    )
}

export default MyInputField;