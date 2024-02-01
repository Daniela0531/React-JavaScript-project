import React from 'react';
import './MyButton.css';
import {useNavigate} from "react-router-dom";

export interface MandatoryButton {
    name: string,
    path: string,
    color?: string,
    backgroundColor?: string,
    backgroundImg?: string,
    handler?: any
}

function MyButton(props: MandatoryButton) {
    const navigate = useNavigate();
    return (
        <button
            className="button-style"
            style={{
                color: props.color,
                backgroundColor: props.backgroundColor,
                backgroundImage: props.backgroundImg
            }}
            onClick={() => {
                if (props.handler) {
                    props.handler()
                    return
                }
                navigate(`${props.path}`)
            }}
        >

            {props.name}

        </button>
    )
}
export default MyButton;